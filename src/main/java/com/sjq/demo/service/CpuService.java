package com.sjq.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sjq.demo.entity.CpuEntity;

import java.util.List;

public interface CpuService {
     /**
      * 查询全表
      * @return
      */
     List<CpuEntity> getAllCpus();

     /**
      * 通过id查询
      * @param id
      * @return
      */
     CpuEntity getCpuById(String id);

     /**
      * 自定义sql语句查询（CURD接口实现不了的多表联查等复杂查询）
      * @param jklx
      * @return
      */
     List<JSONObject> getCpuBySql(String jklx);

     /**
      * 带条件的分页查询
      * @param page
      * @param size
      * @param jklx
      * @return
      */
     IPage<CpuEntity> getCpuByPages(int page , int size,String jklx);

     /**
      * 测试事务回滚
      * @return
      */
     Object transactionInsert();
}


