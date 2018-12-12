package com.djl;

import com.djl.dto.DJLDto;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
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
//启动的时候加载属性配置文件到类中
//通过与@ConfigurationProperties(prefix="djl.param")配合使用
@EnableConfigurationProperties(value={DJLDto.class})
@EnableCaching
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
