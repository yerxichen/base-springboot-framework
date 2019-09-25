package com.sjq.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjq.demo.entity.RoleEntity;
import org.springframework.stereotype.Repository;


@Repository
@DS("master_3")
public interface RoleMapper extends BaseMapper<RoleEntity> {

}
