package com.soft1851.cloud.music.admin.domain.dto;

import lombok.Data;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/29
 * @Version 1.0
 */
@Data
public class AccessTokenDto {
    private String clientId;
    private String clientSecret;
    private String code;
    private String redirectUrl;
    private String state;
}
