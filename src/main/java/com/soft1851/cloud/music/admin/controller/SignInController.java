package com.soft1851.cloud.music.admin.controller;

import com.soft1851.cloud.music.admin.common.ResponseResult;
import com.soft1851.cloud.music.admin.domain.entity.SignIn;
import com.soft1851.cloud.music.admin.service.SignService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/4
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/sign")
public class SignInController {
    @Resource
    private SignService signService;

    @PutMapping(value = "/single")
    public ResponseResult insertSingle(@RequestBody SignIn signIn) {
        signService.update(signIn);
        return ResponseResult.success();
    };

    @GetMapping(value = "/list")
    public List<Map<String, Object>> selectAll() {
        return signService.selectAll();
    }
}
