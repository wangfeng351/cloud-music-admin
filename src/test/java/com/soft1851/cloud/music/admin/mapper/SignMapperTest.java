package com.soft1851.cloud.music.admin.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/4
 * @Version 1.0
 */
@SpringBootTest
class SignMapperTest {
    @Resource
    private SignMapper signMapper;

    @Test
    void selectAll() {
        System.out.println(signMapper.selectAll());
    }

    @Test
    void getById() {
        System.out.println(signMapper.getByAdminId("E10ADC3949BA59ABBE56E057F20F883E"));
    }
}