package com.soft1851.cloud.music.admin.service.impl;

import com.soft1851.cloud.music.admin.service.TimerTaskService;
import com.soft1851.cloud.music.admin.util.WebSocketProcess;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/4
 * @Version 1.0
 */
@Service
public class TimerTaskServiceImpl implements TimerTaskService {
    @Resource
    private WebSocketProcess webSocketProcess;

    @Override
    @Scheduled(cron = "00 12 14 * * ?")
//    @Scheduled(fixedDelay = 2000)
    public void signIn() {
        webSocketProcess.sendAllMessage("signIn");
    }

    @Override
//    @Scheduled(cron = "0 05 14 * * ?")
    public void finishSignIn() {
        webSocketProcess.sendAllMessage("finishSignIn");
    }
}
