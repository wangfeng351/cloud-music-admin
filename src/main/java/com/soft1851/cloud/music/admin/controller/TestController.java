package com.soft1851.cloud.music.admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.cloud.music.admin.domain.dto.SignDto;
import com.soft1851.cloud.music.admin.domain.entity.GitHubUser;
import com.soft1851.cloud.music.admin.service.SysAdminService;
import com.soft1851.cloud.music.admin.util.GitHubProvider;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
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
    private Map<String, Object> map1;

    @GetMapping(value = "/login/oauth2/code/github")
    public void callBack(@RequestParam(name = "code") String code,
                         @RequestParam(name = "state") String state) {
        try {
            log.info("进入callback接口");
            log.info("code" + code + "state值：" + state);
            String accessToken = gitHubProvider.getAccessToken(code, state);
            log.info("accessToken: " + accessToken);
            GitHubUser user = (GitHubUser) gitHubProvider.getUser(accessToken).get("user");
            log.info("user:" + user);
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
            String object = JSONObject.toJSONString(map);
            response.sendRedirect(response.encodeRedirectURL("http://localhost:8088/#/githubLogin?user=" + object));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/allInfo")
    public Map<String, Object> getGithub(@Param("username") String username) {
        return gitHubProvider.getGithubInfo(username);
    }

    @GetMapping(value = "/value")
    public Map<String, Object> getInfo() {
        return map1;
    }
    /*@GetMapping(value = "/login/oauth2/code/github")
    public void getUser(@RequestParam("code") String code, @RequestParam(name = "state") String state) {
        String token = "";
        String user = "";
        try {
            //创建一个HttpClient对象
            HttpClient client = HttpClients.createDefault();
            //创建一个Post对象
            HttpPost post = new HttpPost("https://github.com/login/oauth/access_token");
            //创建一个entity模拟一个表单
            List<BasicNameValuePair> list = new ArrayList<>();
            list.add(new BasicNameValuePair("client_id", "7db13c356933fea303d7"));
            list.add(new BasicNameValuePair("client_secret", "0fa928fcd1bcc6fd47fc1ca309c4a1c8dc0bc56a"));
            list.add(new BasicNameValuePair("code", code));
            list.add(new BasicNameValuePair("state", state));
            //包装成一个entity对象
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");
            //设置请求内容
            post.setEntity(urlEncodedFormEntity);
            post.addHeader("accept", "application/json");
            post.addHeader("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.129 Mobile Safari/537.36");
            //执行请求内容
            HttpResponse httpResponse = client.execute(post);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            log.info(String.valueOf(statusCode));
            HttpEntity contentEntity = httpResponse.getEntity();
            String content = EntityUtils.toString(contentEntity);
            log.info(content);
            token = JSONObject.parseObject(content).getString("access_token");
            log.info("token>>>>>>>>>>>>>>>>" + token);

            //取user
            RequestConfig requestConfig = RequestConfig.custom()
                    .setExpectContinueEnabled(true)
                    .setSocketTimeout(10000)
                    .setConnectTimeout(10000)
                    .setConnectionRequestTimeout(10000)
                    .build();
            HttpGet get = new HttpGet("https://api.github.com/user?access_token=" + token);
            get.setConfig(requestConfig);
            get.setHeader("Authorization", "token " + token);
            get.setHeader("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.129 Mobile Safari/537.36");

            httpResponse = client.execute(get);
            contentEntity = httpResponse.getEntity();
            user = EntityUtils.toString(contentEntity);
            GitHubUser gitHubUser = JSON.parseObject(user, GitHubUser.class);
            sysAdminService.signUp(gitHubUser);
            log.info("user>>>>>>>>>>>>" + user);
            EntityUtils.consume(contentEntity);
            //重定向跳回客户端
            ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            assert sra != null;
            HttpServletResponse response = sra.getResponse();
            response.sendRedirect("http://localhost:8088/#/githubLogin?user=" + JSONObject.parseObject(user).getString("id"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
