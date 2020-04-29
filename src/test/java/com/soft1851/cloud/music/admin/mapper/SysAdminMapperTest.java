package com.soft1851.cloud.music.admin.mapper;

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
class SysAdminMapperTest {
    @Resource
    private SysAdminMapper sysAdminMapper;

    @Test
    void selectByName() {
//        System.out.println(sysAdminMapper.getAdmin());
        System.out.println(sysAdminMapper.selectAll());
    }
}