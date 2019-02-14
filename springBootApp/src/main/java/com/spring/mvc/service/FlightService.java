package com.spring.mvc.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mvc.entities.TblFlight;

public interface FlightService extends JpaRepository<TblFlight, Integer>{

}
