package com.sjq.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("t_user")
public class UserEntity_db1 {

    @TableId
    private String id;
    private String name;
    private String sex;
    private int age;
    private String job;
    private String password;

}
