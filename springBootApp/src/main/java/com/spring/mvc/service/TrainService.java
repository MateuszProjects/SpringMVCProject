package com.spring.mvc.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.mvc.entities.TblTrain;

public interface TrainService extends JpaRepository<TblTrain, Integer>{

}
