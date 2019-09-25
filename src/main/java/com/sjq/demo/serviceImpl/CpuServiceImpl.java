package com.sjq.demo.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sjq.demo.Utils.AjaxResult;
import com.sjq.demo.entity.CpuEntity;
import com.sjq.demo.mapper.CpuMapper;
import com.sjq.demo.mapper.DyMapper;
import com.sjq.demo.service.CpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Transactional(rollbackFor = {Exception.class})
@Service
public class CpuServiceImpl implements CpuService {

    @Autowired
    private CpuMapper cpuMapper;

    @Autowired
    private DyMapper dyMapper;


    /**
     * 全部查询demo
     *
     * @return
     */
    @Override
    public List<CpuEntity> getAllCpus() {
        return cpuMapper.selectList(null);

    }

    /**
     * 通过id查询单标数据
     *
     * @param id
     * @return
     */
    @Override
    public CpuEntity getCpuById(String id) {
        return cpuMapper.selectById(id);
    }

    /**
     * 自己写sql语句查询
     *
     * @param jklx
     * @return
     */
    @Override
    public List<JSONObject> getCpuBySql(String jklx) {
        return cpuMapper.getCpuBySql(jklx);
    }

    /**
     * 带条件的分页查询（单表）
     *
     * @param pageNo
     * @param pageSize
     * @param jklx
     * @return
     */
    @Override
    public IPage<CpuEntity> getCpuByPages(int pageNo, int pageSize, String jklx) {
        Page<CpuEntity> page = new Page<>(pageNo, pageSize);
        QueryWrapper<CpuEntity> wrapper = new QueryWrapper<>();
        wrapper.like("jklx", jklx);
        return cpuMapper.selectPage(page, wrapper);
    }


    @Override
    public AjaxResult transactionInsert() {
        try {
            //插入cpu表
            cpuMapper.insertCpu("i5cpu");
            dyMapper.insertDy("cc");
            return AjaxResult.ok.msg("成功");
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//事务回滚
            return AjaxResult.fail.msg("失败");
        }

    }


}
