package com.sjq.demo.serviceImpl;

import com.sjq.demo.entity.RoleEntity;
import com.sjq.demo.mapper.RoleMapper;
import com.sjq.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int insertRole() {
        RoleEntity entity=new RoleEntity();
        entity.setId("123");
        entity.setBz("啊哈");
        roleMapper.insert(entity);
        return 0;
    }

    @Override
    public int updateRole() {
        RoleEntity entity=new RoleEntity();
        entity.setId("123");
        entity.setBz("企鹅企鹅鹅鹅鹅");

        return  roleMapper.updateById(entity);
    }

    @Override
    public List<RoleEntity> selectRoles() {

        return roleMapper.selectList(null);
    }
}
