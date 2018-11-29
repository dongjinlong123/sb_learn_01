package com.djl.dao;

import com.djl.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface BusinessDao extends JpaRepository<Business, Serializable> {

}