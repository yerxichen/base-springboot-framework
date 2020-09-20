package com.sjq.demo.serviceImpl;

import com.sjq.demo.service.SeataTestService;
import com.sjq.demo.service.UserService_db1;
import com.sjq.demo.service.UserService_db2;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeataTestServiceImpl implements SeataTestService {
    @Autowired
    UserService_db1 userService_db1;
    @Autowired
    UserService_db2 userService_db2;

    @Transactional
    @GlobalTransactional
    @Override
    public void testSuccess() {
        userService_db1.addUserDb1();
        System.out.println(2%0);
        userService_db2.addUserDb2("6666");
    }

    @Transactional
    @GlobalTransactional
    @Override
    public void testFail() {

        userService_db2.addUserDb2("6666");
        System.out.println(2%0);
        userService_db1.addUserDb1();
    }
}
