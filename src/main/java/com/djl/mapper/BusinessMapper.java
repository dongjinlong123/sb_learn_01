package com.djl.mapper;

import com.djl.entity.Business;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

public interface BusinessMapper {
	/**
	 * 通过名称查询
	 * @param name
	 * @return
	 */
	@Select("select * from business where name =#{name}")
	Business findByName(@Param("name") String name);
	/**
	 * 查询书本的价格通过名称
	 * @param value
	 * @return
	 */
	Business queryPriceByName(String value);
	@Insert(value={"insert into business(NAME,price,num) values(#{name},#{price},#{num})"})
	void insertBook(@Param("business") Business business);
}
