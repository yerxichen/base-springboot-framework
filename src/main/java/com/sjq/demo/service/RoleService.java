package com.sjq.demo.service;

import com.sjq.demo.entity.RoleEntity;

import java.util.List;

public interface RoleService {

    int insertRole();

    int updateRole();

    List<RoleEntity> selectRoles();


}
