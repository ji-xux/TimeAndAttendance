package com.exam.service;

import com.exam.dto.WageDTO;

public interface WageService {
   
   public WageDTO paycheck(String emp_id); //emp_id로 wage 테이블 정보 조회
   public int updateWage(WageDTO dto); //기존 직원 급여 수정
   public int insertWage(WageDTO dto); //신규 직원 급여 삽입
   
}