package com.sjq.demo.mapper;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjq.demo.entity.CpuEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@DS("master_1")
public interface CpuMapper extends BaseMapper<CpuEntity> {

    @Select("SELECT cpdws,title FROM pc_cpu WHERE jklx like '%${jklx}%'")
    List<JSONObject> getCpuBySql(@Param("jklx") String param);

    @Insert("insert into pc_cpu(title) values('${title}')")
    int insertCpu(@Param("title") String param);
}
