package com.sjq.demo.controller;

import com.sjq.demo.entity.RoleEntity;
import com.sjq.demo.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/role")
@Api(tags = "oracle数据库增删改查例子")
public class RoleController {

    Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "查询全部信息", notes = "查询全部信息")
    @GetMapping("/selectRoles")
    @ResponseBody
    public List<RoleEntity> selectRoles() {
        return roleService.selectRoles();
    }

    @ApiOperation(value = "插入一条信息", notes = "插入一条信息")
    @PostMapping("/insertRole")
    @ResponseBody
    public Object insertRole() {
        return roleService.insertRole();
    }

    @ApiOperation(value = "更新一条信息", notes = "更新一条信息")
    @PutMapping("/updateRole")
    @ResponseBody
    public Object updateRole() {
        return roleService.updateRole();
    }
}
