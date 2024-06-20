package com.exam.service;

import java.util.Map;

import com.exam.dto.EmpDTO;

public interface EmpService {
	public EmpDTO login(Map<String, String> map);
	
	public EmpDTO idCheck(String emp_id);
	public int empAdd(EmpDTO dto);

	public EmpDTO mypage(String userid);
	public int update(EmpDTO dto);

}

