package com.djl.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 如何配置bean
 */
@Configuration
public class StudentBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Bean
    public StudentBean student(){
        StudentBean s =  new StudentBean();
        s.setName("与发圈");
        return s;
    }

}
