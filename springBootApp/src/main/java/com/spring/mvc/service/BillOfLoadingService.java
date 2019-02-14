package com.spring.mvc.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mvc.entities.TblBillofloading;

public interface BillOfLoadingService extends JpaRepository<TblBillofloading, Integer>{

}
