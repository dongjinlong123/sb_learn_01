package com.djl.common;

import com.djl.dto.DJLDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DJLDTOBean {
    @Bean
    public DJLDto djlDtoTest(DJLDto djlDTO){
        System.out.println("注入bean 的時候參數是有值的"+ djlDTO);
        return djlDTO;
    }
}
