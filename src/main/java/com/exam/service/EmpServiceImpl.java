package com.exam.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.exam.dto.EmpDTO;
import com.exam.mapper.EmpMapper;


@Service
public class EmpServiceImpl implements EmpService{

	EmpMapper empMapper;
	
	public EmpServiceImpl(EmpMapper empMapper) {
		this.empMapper = empMapper;
	}

	@Override
	public EmpDTO login(Map<String,String> map) {
		return empMapper.login(map);
	}

	@Override
	public int empAdd(EmpDTO dto) {
		return empMapper.empAdd(dto);
	}

	@Override
	public EmpDTO idCheck(String emp_id) {
		return empMapper.idCheck(emp_id);
	}
	
	@Override
	   public EmpDTO mypage(String userid) {
	      return empMapper.mypage(userid);
	 }

	   @Override
	   public int update(EmpDTO dto) {
	      return empMapper.update(dto);
	   }





}
