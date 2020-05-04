package com.soft1851.cloud.music.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1851.cloud.music.admin.domain.entity.SignIn;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/4
 * @Version 1.0
 */
public interface SignMapper extends BaseMapper<SignIn> {

    /**
     * 查询当天签到信息
     * @return
     */
    List<Map<String, Object>> selectAll();

    /**
     * 查询指定用户当天签到信息
     * @param adminId
     * @return
     */
    Map<String, Object> getByAdminId(String adminId);
}
