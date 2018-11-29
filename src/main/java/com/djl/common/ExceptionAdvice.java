package com.djl.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice//控制切面，通过AOP的异常通知进行拦截
public class ExceptionAdvice {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> resultError(Exception e){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("errorCode", 500);
        map.put("errorMsg", "系统错误");
        e.printStackTrace();
        return map;
    }

    @ExceptionHandler(MyException.class)
    public String testExe(){
        return "/html/1.html";
    }
}
