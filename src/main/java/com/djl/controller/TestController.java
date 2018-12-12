package com.djl.controller;

import com.djl.Async.AsyncService;
import com.djl.common.MyException;
import com.djl.dto.DJLDto;
import com.djl.entity.Business;
import com.djl.service.RedisService;
import com.djl.service.TestJdbcTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private TestJdbcTemplateService testJdbcTemplateService;
    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/test.do")
    public String test(String flag) {
//        int i = 1/0;
//        return flag;
        throw new MyException("自定义异常");
    }

    @RequestMapping("/insert.do")
    public String test() {
        return testJdbcTemplateService.insertBook("aa", "123", "22");
    }

    @RequestMapping("/query.do")
    public List<Business> query() {
        return testJdbcTemplateService.queryBook();
    }

    @RequestMapping("/findByName.do")
    public Business findByName(String name) {
        return testJdbcTemplateService.findByName(name);
    }

    @RequestMapping("/queryPriceByName.do")
    public Business queryPriceByName(String name) {

        testJdbcTemplateService.insertBook();
        return testJdbcTemplateService.queryPriceByName(name);
    }

    @RequestMapping("/testAsync")
    public String testAsync() {
        System.out.println(" 步骤1 ： 异步测试开始 ");
        asyncService.test();
        System.out.println(" 步骤4 ： 异步测试结束 ");
        return "test Async success";
    }

    @Value("${djl.param.name}")
    private String param;

    @Autowired
    private DJLDto djlDtoTest;

    @RequestMapping("/readProperty")
    public String readProperty(DJLDto dto) {
        System.out.println(dto);
        System.out.println(new DJLDto());
        System.out.println(djlDtoTest);
        return param;
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/tetRedis")
    public String testRedis() {
        stringRedisTemplate.opsForValue().set("name", "2222222222222222222");
        String name = stringRedisTemplate.opsForValue().get("name");
        redisService.cachePut("user_id","与发券1","user");
        redisService.cachePut("product_info","与发券2","product");
        String str = redisService.cacheResult("user_id", "user");
       // redisService.cacheRemove("product_info", "product");
        return name + str;
    }

    @RequestMapping("/deleteRedis")
    public String deleteRedis() {
        testJdbcTemplateService.deleteCache();
        return "刪除成功";
    }
}
