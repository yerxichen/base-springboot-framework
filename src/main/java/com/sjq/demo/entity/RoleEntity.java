package com.sjq.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("role")
public class RoleEntity {
    @TableId
    private String id; // 信息主键编号
    private String rolename; // 标题
    private String bz;
    private Object pdf;


}
