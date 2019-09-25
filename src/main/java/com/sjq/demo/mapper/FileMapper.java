package com.sjq.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjq.demo.entity.FmsFile;
import org.springframework.stereotype.Repository;

@Repository
@DS("master_2")
public interface FileMapper extends BaseMapper<FmsFile> {

}
