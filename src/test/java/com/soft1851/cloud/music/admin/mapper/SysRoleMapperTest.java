package com.soft1851.cloud.music.admin.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/25
 * @Version 1.0
 */
@SpringBootTest
class SysRoleMapperTest {
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Test
    void selectAll() {
        System.out.println(sysRoleMapper.selectAll());
    }
}