package com.sjq.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("t_sys_user_info")
public class UserEntity_db2 {
    @TableId
    private String id;
    private String glid;
    private int age;
    private String job;
}
