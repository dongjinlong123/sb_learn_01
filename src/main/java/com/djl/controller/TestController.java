package com.djl.controller;

import com.djl.Async.AsyncService;
import com.djl.common.MyException;
import com.djl.entity.Business;
import com.djl.service.TestJdbcTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TestController{
    @Autowired
    private TestJdbcTemplateService testJdbcTemplateService;
    @Autowired
    private AsyncService asyncService;
    @RequestMapping("/test.do")
    public String test(String flag){
//        int i = 1/0;
//        return flag;
        throw new MyException("自定义异常");
    }
    @RequestMapping("/insert.do")
    public String test(){
        return testJdbcTemplateService.insertBook("aa","123","22");
    }
    @RequestMapping("/query.do")
    public List<Business> query(){
        return testJdbcTemplateService.queryBook();
    }
    @RequestMapping("/findByName.do")
    public Business findByName(String name){
        return testJdbcTemplateService.findByName(name);
    }
    @RequestMapping("/queryPriceByName.do")
    public Business queryPriceByName(String name){

        testJdbcTemplateService.insertBook();
        return testJdbcTemplateService.queryPriceByName(name);
    }
    @RequestMapping("/testAsync")
    public String testAsync(){
        System.out.println(" 步骤1 ： 异步测试开始 ");
        asyncService.test();
        System.out.println(" 步骤4 ： 异步测试结束 ");
        return "test Async success";
    }
}
