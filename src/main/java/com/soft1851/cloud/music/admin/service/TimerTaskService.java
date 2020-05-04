package com.soft1851.cloud.music.admin.service;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/4
 * @Version 1.0
 */
public interface TimerTaskService {

    /**
     * 定时签到
     */
    void signIn();

    /**
     * 结束签到
     */
    void finishSignIn();
}
