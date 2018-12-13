package com.djl.common;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

public class MyMetaObjectHandler extends MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("插入的时候我被调用了。、。。。。。。。。。。");
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
