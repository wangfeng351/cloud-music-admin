package com.soft1851.cloud.music.admin.controller;

import com.soft1851.cloud.music.admin.util.WebSocketProcess;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/4
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/ws")
public class WebSocketController {

    @Resource
    private WebSocketProcess webSocketProcess;

    /**
     * 向指定客户端发送消息
     * @param id
     * @param text
     */
    @PostMapping(value = "/sendMsgToClientById")
    public void sendMsgToClientById(@RequestParam long id, @RequestParam String text) {
        webSocketProcess.sendMessage(id, text);
    }

    @PostMapping(value = "sendMsgToAllClient")
    public void sendMsgToAllClient(@RequestParam String text) {
        webSocketProcess.sendAllMessage(text);
    }
}
