package com.soft1851.cloud.music.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@MapperScan("com.soft1851.cloud.music.admin.mapper")
public class CloudMusicAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMusicAdminApplication.class, args);
    }

}
