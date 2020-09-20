package com.sjq.demo.controller;

import com.alibaba.druid.util.DruidWebUtils;
import com.sjq.demo.Utils.AjaxResult;
import com.sjq.demo.Utils.ResponseMessage;
import com.sjq.demo.entity.CpuEntity;
import com.sjq.demo.service.CpuService;
import com.sjq.demo.service.SeataTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/test")
@Api(tags = "CPU增删改查demo")
public class TestController {


    @Autowired
    SeataTestService seataTestService;

    @ApiOperation(value = "查询全部CPU信息", notes = "查询全部CPU信息")
    @PostMapping("/testFail")
    @ResponseBody
    public ResponseMessage testFail() {
        try {
            seataTestService.testFail();
            return ResponseMessage.newOkInstance("成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseMessage.newOkInstance("失败");
        }

    }


}



