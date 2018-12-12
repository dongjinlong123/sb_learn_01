package com.djl.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix="djl.param")
public class DJLDto {
    private String name;
    private int age;
    private String sex;

}
