package com.soft1851.cloud.music.admin.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/25
 * @Version 1.0
 */
@SpringBootTest
class SysMenuServiceTest {
    @Resource
    private SysMenuService sysMenuService;

    @Test
    void selectAll() {
        System.out.println(sysMenuService.selectAll());
    }

    @Test
    void insertSingle() {
    }

    @Test
    void deleteSingle() {
    }
}