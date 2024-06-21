package com.exam.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.EmpDTO;

@Mapper
public interface EmpMapper {
	public EmpDTO login(Map<String, String> map); //로그인
	
	public EmpDTO idCheck(String emp_id); //id 중복 확인
	public int empAdd(EmpDTO dto); //회원가입
	
	public EmpDTO mypage(String userid); //마이페이지
	public int update(EmpDTO dto); //직원용 마이페이지 정보 수정
		
	public EmpDTO searchEmp(String name);
	public EmpDTO searchEmpById(String emp_id);
	public int updateByAdmin(EmpDTO dto); //관리자용 직원 정보 수정
	public int deleteByAdmin(String emp_id); //관리자용 직원 삭제
}
