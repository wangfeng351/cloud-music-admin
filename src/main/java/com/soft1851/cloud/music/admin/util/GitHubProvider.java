package com.soft1851.cloud.music.admin.util;

import cn.hutool.http.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.html.*;
import com.soft1851.cloud.music.admin.domain.entity.GitHubUser;
import com.soft1851.cloud.music.admin.domain.vo.Reposity;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import com.gargoylesoftware.htmlunit.WebClient;
import org.w3c.dom.html.HTMLDivElement;

import java.io.IOException;
import java.util.*;

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
    private static final String USER_INFO_URL1 = "https://api.github.com/users/";

    /*public String getAccessToken(String code, String state) {
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
    }*/

    public String getAccessToken(String code, String state) {
        Map<String, Object> params = new HashMap<>();
        params.put("code", code);
        params.put("client_id", "c2f8b53b0c224ec46643");
        params.put("client_secret", "688c160e7609c091b9a221dfa7799f652abd968f");
        params.put("state", state);
        HttpRequest post = HttpRequest.post(TOKEN_URL);
        post.body(JSON.toJSONString(params)).contentType("application/json").header(Header.ACCEPT, "application/json");
        JSONObject object = JSONObject.parseObject(post.execute().body());
        String result = object.getString("access_token");
        log.debug("github -> getAccessToken -> result -> {}", result);
        return result;
    }
    public Map<String, Object> getUser(String AccessToken){
        HttpRequest request = HttpRequest.get(USER_INFO_URL + AccessToken);
        request.header(Header.ACCEPT, "application/json");
        String result = request.execute().body();
        GitHubUser gitHubUser = JSON.parseObject(result, GitHubUser.class);
        String repositry = "https://api.github.com/users/wangfeng351/repos";
        List repositryList = getFollowers(repositry, Reposity.class);
        String following = "https://api.github.com/users/wangfeng351/following";
        List followingList = getFollowers(following, GitHubUser.class);
        String followers =  "https://api.github.com/users/wangfeng351/followers";
        List followersList = getFollowers(followers, GitHubUser.class);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("user", gitHubUser);
        map.put("followers", followersList);
        map.put("following", followingList);
        map.put("repositry", repositryList);
        return map;
    }

    public List getFollowers(String url, Class<?> clazz) {

        //实例化client对象
        HttpClient client = HttpClients.createDefault();
        //创建get方法
        HttpGet get = new HttpGet(url);
        HttpPost post = new HttpPost(url);
        //创建响应体，接收响应数据
        HttpResponse response;
        List data = null;
        try {
            //发送get请求获取数据
             response = client.execute(get);
             //转成实体类对象（仅是一个地址）
             HttpEntity entity = response.getEntity();
             // 使用工具类方法，将对象转成字符串
            String follower = EntityUtils.toString(entity);
            /*System.out.println(follower.substring(1, follower.length()-1));*/
            data = JSONObject.parseArray(follower, clazz);
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    //获取github用户、粉丝、关注的人、仓库信息
    public Map<String, Object> getGithubInfo(String username) {
        //实例化client对象
        HttpClient client = HttpClients.createDefault();
        String client_id = "7db13c356933fea303d7";
        String client_secret = "0fa928fcd1bcc6fd47fc1ca309c4a1c8dc0bc56a";
        String url = USER_INFO_URL1 + username + "?client_id=" + client_id + "&client_secret=" + client_secret;

        HttpRequest request = HttpRequest.get(url);
        request.header(Header.ACCEPT, "application/json");
        String result = request.execute().body();
        GitHubUser gitHubUser = JSON.parseObject(result, GitHubUser.class);
        JSONObject object = JSONObject.parseObject(result);
        List repositryList = getFollowers(object.get("repos_url").toString(), Reposity.class);
        String following = object.getString("following_url");
        String following_url = following.substring(0, following.indexOf("{"));
        System.out.println(following_url);
        List followingList = getFollowers(following_url, GitHubUser.class);
        List followersList = getFollowers(object.get("followers_url").toString(), GitHubUser.class);
        Map<String, Object> map = new LinkedHashMap<>();
        System.out.println(gitHubUser);
        map.put("user", gitHubUser);
        map.put("followers", followersList);
        map.put("following", followingList);
        map.put("repositry", repositryList);
        return map;
    }
}
