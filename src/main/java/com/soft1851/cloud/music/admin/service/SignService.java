package com.soft1851.cloud.music.admin.service;

import com.soft1851.cloud.music.admin.domain.entity.SignIn;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/4
 * @Version 1.0
 */
public interface SignService {

    /**
     * 查询当天已签到的人
     * @return
     */
    List<Map<String, Object>> selectAll();

    /**
     * 新增签到记录
     * @param signIn
     */
    void update(SignIn signIn);

    /**
     * 获取某人签到信息
     * @return
     */
    Map<String, String> getSignInfo(String adminId);
}
