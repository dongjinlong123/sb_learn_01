package com.djl.service;

import com.djl.common.StudentBean;
import com.djl.dao.BusinessDao;
import com.djl.entity.Business;
import com.djl.mapper.BusinessMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service("testJdbcTemplateService")
public class TestJdbcTemplateService {
    private static Logger logger = LoggerFactory.getLogger(TestJdbcTemplateService.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BusinessDao businessDao;

    @Autowired
    private BusinessMapper businessMapper;

    public String insertBook(String name , String price,String num){
        int i = jdbcTemplate.update("insert into business(NAME,price,num) values(?,?,?)", name,price,num);
        if(i>0){
            return "添加数据成功";
        }
        return "添加数据失败";
    }
    /**
     * 查询所有的信息
     * @return
     */
    public List<Business> queryBook(){
        List<Business> list = businessDao.findAll();
        return list;
    }
    /**
     * 通过名字查询信息
     * @return
     */
    //@Cacheable(value="djlvalue", key="'djlkey'")
    public Business findByName(String name){
        Business b = businessMapper.findByName(name);
        return b;
    }

    public Business queryPriceByName(String name){

        return businessMapper.queryPriceByName(name);

    }
    @Transactional(isolation= Isolation.READ_COMMITTED,propagation= Propagation.REQUIRED)
    public void insertBook(){
        logger.info("11111111111111111111111111111111111");
        Business business = new Business();
        business.setName("djl123456");
        business.setPrice("1");
        business.setNum("1");
        businessMapper.insertBook(business);
        int i=  1/0;
    }
    //@CacheEvict(value = "djlvalue", key = "'djlkey'")
    public void deleteCache(){
        //businessMapper.delete(name);
        System.out.println("刪除緩存");
    }
}