package com.sjq.demo;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@MapperScan("com.sjq.demo.mapper")
public class BaseSpringbootFrameworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseSpringbootFrameworkApplication.class, args);
    }

}
