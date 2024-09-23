package com.exam.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.WageDTO;

@Mapper
public interface WageMapper {
   
   public WageDTO paycheck(String emp_id); //직원 급여 정보
   public int updateWage(WageDTO dto); //기존 직원 급여 수정
   public int insertWage(WageDTO dto); //신규 직원 급여 삽입
   
}