package com.sjq.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("pc_cpu")
public class CpuEntity {
    @TableId
    private int xxzjbh; // 信息主键编号
    private String title; // 标题
    private String price; // 价格
    private String pic; // 图片
    private String xh; // 型号
    private String cpdw; // 产品定位
    private String xpcf; // 芯片厂方
    private String hxsl; // 核心数量
    private String hxlx; // 核心类型
    private String scgy; // 生产工艺
    private String jklx; // 接口类型
    private String xcs; // 线程数
    private String hxdy; // 核心电压
    private String zp; // 主频
    private String dtjs; // 动态加速
    private String ejhc; // 二级缓存
    private String xshxxh; // 显示核心型号
    private String xshxpl; // 显示核心频率
    private String zctdms; // 支持通道模式
    private String zcncpl; // 支持内存频率
    private String lsswclq; // 64位处理器
    private String tdpjs; // TDP技术
    private String xnh; // Virtualization(虚拟化)
    private String gzgl; // 工作功率
    private String sxgjz; // 属性关键字
    private String localPic; // 本地图片地址

    
}
