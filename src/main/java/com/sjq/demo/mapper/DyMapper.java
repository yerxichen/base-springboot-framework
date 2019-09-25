package com.sjq.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjq.demo.entity.DyEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
@DS("master_1")
public interface DyMapper extends BaseMapper<DyEntity> {

    @Insert("insert into pc_dy(cc) values(#{cc})")
    int insertDy(@Param("cc")String param);
}
