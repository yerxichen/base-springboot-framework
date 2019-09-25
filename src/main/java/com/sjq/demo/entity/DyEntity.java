package com.sjq.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("pc_dy")
public class DyEntity {
    @TableId
    private int xxzjbh; // 信息主键编号
    private String cc; // 标题

    
}
