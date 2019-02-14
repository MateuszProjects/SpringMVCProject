package com.spring.mvc.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mvc.entities.TblAddress;

public interface AddressService extends JpaRepository<TblAddress, Integer>{

}
