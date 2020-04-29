package com.soft1851.cloud.music.admin.service;

import com.soft1851.cloud.music.admin.domain.entity.Test1;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/28
 * @Version 1.0
 */
@SpringBootTest
class Test1ServiceTest {
    private Test1Service test1Service;

    @Test
    public void test() {
        List<Test1> test1s = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Test1 test = Test1.builder()
                    .id(i)
                    .name("test" + i)
                    .age(22)
                    .grade("软件1851")
                    .createTime(LocalDateTime.now())
                    .build();
            test1s.add(test);
        }
        System.out.println(test1s.get(0));
        test1Service.saveBatch(test1s);
    }
}