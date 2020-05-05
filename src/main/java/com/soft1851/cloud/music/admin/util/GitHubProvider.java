package com.soft1851.cloud.music.admin.util;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.cloud.music.admin.domain.dto.AccessTokenDto;
import com.soft1851.cloud.music.admin.domain.entity.GitHubUser;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/29
 * @Version 1.0
 */
@Component
@Slf4j
public class GitHubProvider {
    private static final String AUTH_URL = "https://github.com/login/oauth/authorize";
    private static final String TOKEN_URL = "https://github.com/login/oauth/access_token";
    private static final String USER_INFO_URL = "https://api.github.com/user?access_token=";

    public String getAccessToken(String code, String state) {
        Map<String, Object> params = new HashMap<>();
        params.put("code", code);
        params.put("client_id", "7db13c356933fea303d7");
        params.put("client_secret", "0fa928fcd1bcc6fd47fc1ca309c4a1c8dc0bc56a");
        params.put("state", state);
        HttpRequest post = HttpRequest.post(TOKEN_URL);
        post.body(JSON.toJSONString(params)).contentType("application/json").header(Header.ACCEPT, "application/json");
        JSONObject object = JSONObject.parseObject(post.execute().body());
        String result = object.getString("access_token");
        log.debug("github -> getAccessToken -> result -> {}", result);
        return result;
    }

    public GitHubUser getUser(String AccessToken){
        HttpRequest request = HttpRequest.get(USER_INFO_URL + AccessToken);
        request.header(Header.ACCEPT, "application/json");
        String result = request.execute().body();
        GitHubUser gitHubUser = JSON.parseObject(result, GitHubUser.class);
        return gitHubUser;
    }
}
