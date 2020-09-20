package com.sjq.demo;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.sjq.demo.service.SeataTestService;
import com.sjq.demo.service.UserService_db1;
import com.sjq.demo.service.UserService_db2;
import io.seata.spring.annotation.GlobalTransactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SeataTest {

    @Autowired
    SeataTestService seataTestService;

    @Test
    public void testSuccess() {

    }

    @Test
    public void testFail() {
        seataTestService.testFail();
    }
}