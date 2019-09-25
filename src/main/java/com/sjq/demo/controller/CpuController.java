package com.sjq.demo.controller;

import com.alibaba.druid.util.DruidWebUtils;
import com.sjq.demo.Utils.AjaxResult;
import com.sjq.demo.entity.CpuEntity;
import com.sjq.demo.service.CpuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/cpu")
@Api(tags = "CPU增删改查demo")
public class CpuController {

    Logger logger = LoggerFactory.getLogger(CpuController.class);

    @Autowired
    private CpuService cpuService;

    @ApiOperation(value = "查询全部CPU信息", notes = "查询全部CPU信息")
    @GetMapping("/getAllCpus")
    @ResponseBody
    public List<CpuEntity> getAllCpus() {
        return cpuService.getAllCpus();
    }

    @ApiOperation(value = "通过id查询单条信息", notes = "通过id查询单条信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "cpu主键", required = true, paramType = "query", dataType = "String"),
    })
    @GetMapping("/getCpuById")
    @ResponseBody
    public CpuEntity getCpuById(@RequestParam String id) {
        return cpuService.getCpuById(id);
    }


    @ApiOperation(value = "通过条件查询", notes = "mybatis自定义sql查询数据demo")
    @GetMapping("/getCpuBySql")
    @ResponseBody
    public Object getCpuBySql(String jklx) {
        try {
            logger.info("aaaaa", AjaxResult.ok.data(cpuService.getCpuBySql(jklx)).msg("成功"));
            return AjaxResult.ok.data(cpuService.getCpuBySql(jklx)).msg("成功");
        } catch (Exception e) {
            return AjaxResult.fail.code(0).msg("失败");
        }
    }

    @ApiOperation(value = "不带条件的分页查询", notes = "不带条件的分页查询")
    @GetMapping("/getCpuByPages")
    @ResponseBody
    public Object getCpuByPages(@RequestParam int pageNo, @RequestParam int pageSize, @RequestParam String jklx) {
        return cpuService.getCpuByPages(pageNo, pageSize, jklx);
    }

    @ApiOperation(value = "测试事务", notes = "测试事务")
    @PostMapping("/transactionInsert")
    @ResponseBody
    public Object transactionInsert() {
        return cpuService.transactionInsert();
    }

    @ApiOperation(value = "获取客户端ip", notes = "获取客户端ip")
    @GetMapping("/getRemoteAddr")
    @ResponseBody
    public Object socketDemo() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        logger.info(DruidWebUtils.getRemoteAddr(request));//获取客户端请求ip

        return null;
    }




}



