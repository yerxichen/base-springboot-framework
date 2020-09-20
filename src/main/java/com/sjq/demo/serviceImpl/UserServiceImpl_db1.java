package com.sjq.demo.serviceImpl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.sjq.demo.entity.UserEntity_db1;
import com.sjq.demo.mapper.UserMapper_db1;
import com.sjq.demo.mapper.UserMapper_db2;
import com.sjq.demo.service.UserService_db1;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@DS("master_1")
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserServiceImpl_db1 implements UserService_db1 {

    @Autowired
    UserMapper_db1 userMapper_db1;

    @Override
    public void addUserDb1() {
        UserEntity_db1 user1= UserEntity_db1.builder()
                .id(UUID.randomUUID().toString())
                .age(12)
                .job("学生")
                .name("宋微微")
                .sex("女")
                .password("123456789").build();
        userMapper_db1.insert(user1);
    }
}
