package com.djl.controller;

import com.djl.service.TestJdbcTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Controller
public class Test2Controller {

    @RequestMapping("/indexTest")
    public String indexTest(Map<String,Object> resultMap){
        resultMap.put("name", "董锦龙");
        resultMap.put("sex", 1);
        List<String> list = new ArrayList<String>();
        list.add("list add 001");
        list.add("list add 002");
        resultMap.put("userList", list);
        return "aaa";
    }
}
