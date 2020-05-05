package com.soft1851.cloud.music.admin.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.api.R;
import com.soft1851.cloud.music.admin.domain.dto.AccessTokenDto;
import com.soft1851.cloud.music.admin.domain.dto.SignDto;
import com.soft1851.cloud.music.admin.domain.entity.GitHubUser;
import com.soft1851.cloud.music.admin.service.SysAdminService;
import com.soft1851.cloud.music.admin.util.GitHubProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/22
 * @Version 1.0
 */
@RestController
@RequestMapping
@Slf4j
public class TestController {
    @Resource
    private GitHubProvider gitHubProvider;
    @Resource
    private SysAdminService sysAdminService;

    @GetMapping(value = "/login/oauth2/code/github")
    public void callBack( @RequestParam(name = "code")String code,
                          @RequestParam(name = "state") String state){
        try {
        log.info("进入callback接口");
        log.info("code" + code + "state值：" + state);
        String accessToken = gitHubProvider.getAccessToken(code, state);
        log.info("accessToken: " + accessToken);
        GitHubUser user = gitHubProvider.getUser(accessToken);
        sysAdminService.signUp(user);
            SignDto signDto = SignDto.builder()
                    .name(user.getLogin())
                    .password("123456")
                    .build();
        Map<String, Object> map = sysAdminService.sign(signDto);
        //重定向
            ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            assert sra != null;
            HttpServletResponse response = sra.getResponse();
            assert response != null;
            map.put("id", 11);
            System.out.println(map);
            String object = JSONObject.toJSONString(map);
            log.info(object);
            response.sendRedirect("http://localhost:8088/#/githubLogin?user=" + object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/github/login")
    public void githubLogin(){

    }
}
