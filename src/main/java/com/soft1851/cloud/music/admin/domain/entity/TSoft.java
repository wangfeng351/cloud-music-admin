package com.soft1851.cloud.music.admin.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wf
 * @since 2020-05-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_soft")
public class TSoft extends Model<TSoft> {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("github_name")
    private String githubName;

    @TableField("nickname")
    private String nickname;

    @TableField("hometown")
    private String hometown;

    @TableField("birthday")
    private String birthday;

    @TableField("constellation")
    private String constellation;

    @TableField("mobile")
    private String mobile;

    @TableField("qq")
    private String qq;

    @TableField("email")
    private String email;

    @TableField("avatar")
    private String avatar;

    @TableField("github_url")
    private String githubUrl;

    @TableField("hobby")
    private String hobby;

    @TableField("signature")
    private String signature;

    @TableField("color")
    private String color;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
