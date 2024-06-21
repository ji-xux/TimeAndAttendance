package com.exam.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.WageDTO;

@Mapper
public interface WageMapper {
   
   public WageDTO paycheck(String emp_id);//직원의 급여
}