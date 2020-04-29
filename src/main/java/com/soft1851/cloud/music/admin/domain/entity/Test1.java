package com.soft1851.cloud.music.admin.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.soft1851.cloud.music.admin.annotation.ExcelVoAttribute;
import lombok.*;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/28
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("test")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Test1 {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @ExcelVoAttribute(name="姓名", column = 0)
    private String name;

    @ExcelVoAttribute(name = "年龄", column = 1)
    private Integer age;

    @ExcelVoAttribute(name = "班级", column = 2)
    private String grade;

    @ExcelVoAttribute(name = "创建时间", column = 3)
    private LocalDateTime createTime;
}
