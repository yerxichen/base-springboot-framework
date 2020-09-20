package com.sjq.demo.serviceImpl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.sjq.demo.entity.UserEntity_db2;
import com.sjq.demo.mapper.UserMapper_db1;
import com.sjq.demo.mapper.UserMapper_db2;
import com.sjq.demo.service.UserService_db2;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@DS("master_2")
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserServiceImpl_db2 implements UserService_db2 {

    @Autowired
    UserMapper_db2 userMapper_db2;

    @Override
    public void addUserDb2(String glid) {
        UserEntity_db2 user2=UserEntity_db2.builder()
                .id(UUID.randomUUID().toString())
                .age(12)
                .glid(glid)
                .job("学生").build();
        userMapper_db2.insert(user2);
    }
}
