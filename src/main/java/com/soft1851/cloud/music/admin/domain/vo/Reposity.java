package com.soft1851.cloud.music.admin.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/7
 * @Version 1.0
 */
@Data
public class Reposity {
    private String id;
    private String name;
    private String description;
    private String url;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime pushed_at;
    private String git_url;
    private String clone_url;
}
