package com.sjq.demo;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class, SecurityAutoConfiguration.class})
@MapperScan("com.sjq.demo.mapper")
public class BaseSpringbootFrameworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseSpringbootFrameworkApplication.class, args);
    }

}
