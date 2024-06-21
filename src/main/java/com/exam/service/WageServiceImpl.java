package com.exam.service;

import org.springframework.stereotype.Service;

import com.exam.dto.WageDTO;
import com.exam.mapper.WageMapper;


@Service
public class WageServiceImpl implements WageService{

   WageMapper wageMapper;
   
   public WageServiceImpl(WageMapper wageMapper) {
      this.wageMapper = wageMapper;
   }

   @Override
   public WageDTO paycheck(String emp_id) {
      return wageMapper.paycheck(emp_id);
   }
}
