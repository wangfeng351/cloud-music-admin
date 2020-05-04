package com.soft1851.cloud.music.admin.service;

import com.soft1851.cloud.music.admin.domain.entity.SignIn;
import org.apache.commons.math3.analysis.function.Sin;
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
class SignServiceTest {
    @Resource
    private SignService signService;

    @Test
    void selectAll() {
        System.out.println(signService.selectAll());
    }

    @Test
    void insert() {
        SignIn signIn = SignIn.builder().id(1)
//                .adminId("DE35D7CC05AF96A21D7ADFC8651E6614")
                .status(1)
                .build();
        signService.update(signIn);
    }
}