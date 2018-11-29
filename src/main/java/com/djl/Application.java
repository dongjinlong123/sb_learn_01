package com.djl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@ComponentScan(basePackages = {"com.djl.controller","com.djl.common","com.djl.service"})
//@EnableAutoConfiguration
//@EnableJpaRepositories("com.djl.dao")//将dao注入到JPA容器中
//@EntityScan("com.djl.entity")//扫描JPA 实现类
//@EnableJpaAuditing
@SpringBootApplication
@MapperScan(basePackages={"com.djl.mapper"})//扫描Mapper 包
@EnableTransactionManagement
@EnableScheduling
@EnableAsync
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
