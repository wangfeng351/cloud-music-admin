package com.soft1851.cloud.music.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft1851.cloud.music.admin.domain.entity.Test1;
import com.soft1851.cloud.music.admin.mapper.TestMapper;
import com.soft1851.cloud.music.admin.service.Test1Service;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/28
 * @Version 1.0
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test1> implements Test1Service {
}
