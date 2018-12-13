package com.djl.Async;

import com.djl.common.StudentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component("asyncService")
public class AsyncService {
    @Autowired
    private StudentBean student;
    @Async
    public void test(){
        try {
            Thread.sleep(1000);
            System.out.println(123);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" 步骤2 ： 异步的服务方法开始 " + student.getName());
        for (int i = 0; i < 3; i++) {
            System.out.println("service 执行:"+i);
        }
        System.out.println(" 步骤3 ： 异步的服务方法结束 ");
    }

}
