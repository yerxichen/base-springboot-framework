package com.sjq.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "fms_file")
public class FmsFile {
    @TableId
    private Long id;
    private String name;
    private String description;
}
