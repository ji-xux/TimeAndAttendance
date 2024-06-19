package com.exam.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.EmpDTO;

@Mapper
public interface EmpMapper {
	public EmpDTO login(Map<String, String> map); //로그인
	
	public EmpDTO idCheck(String emp_id); //id 중복 확인
	public int empAdd(EmpDTO dto); //회원가입
}
