package com.soft1851.cloud.music.admin.controller;


import com.soft1851.cloud.music.admin.domain.entity.TSoft;
import com.soft1851.cloud.music.admin.service.TSoftService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wf
 * @since 2020-05-04
 */
@RestController
@RequestMapping(value = "/soft")
public class TSoftController {
    @Resource
    private TSoftService tSoftService;

    @GetMapping(value = "/list")
    public List<TSoft> selectAll() {
        return tSoftService.list();
    }
}
