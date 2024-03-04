package com.py.projectstructure.mod.ztest.model.service;

import com.py.projectstructure.mod.ztest.model.ZtestEntity;
import com.py.projectstructure.mod.ztest.model.repository.ZtestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ZtestEntityService {

  // ::: constructor
  //

  @Autowired
  private ZtestEntityRepository ztestEntityRepository;


  // ::: methods
  //

  public Page<ZtestEntity> findAll(Integer page, Integer size){
    Pageable pageable = PageRequest.of(page, size);
    return ztestEntityRepository.findAll(pageable);
  }

}
