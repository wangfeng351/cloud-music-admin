package com.soft1851.cloud.music.admin.service;

import com.soft1851.cloud.music.admin.domain.dto.SignDto;
import com.soft1851.cloud.music.admin.domain.entity.SysAdmin;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/21
 * @Version 1.0
 */
@SpringBootTest
@Slf4j
class SysAdminServiceTest {
    @Resource
    private SysAdminService sysAdminService;
    @Resource
    private RedisService redisService;

    @Test
    void sign() {
        SignDto signDto = SignDto.builder()
                .name("123456")
                .password("123456")
                .verifyCode("123456")
                .build();
//        System.out.println(sysAdminService.getAdminRoleByAdminName("mqxu"));;
//
        SysAdmin admin = SysAdmin.builder().id("test")
                        .avatar("1231")
                        .password("fsdfasd")
                        .name("hello")
                        .salt("22312")
                        .createTime(LocalDateTime.now())
                        .updateTime(LocalDateTime.now())
                        .build();
        sysAdminService.save(admin);
    }
}