package com.exam.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.AttendanceDTO;

@Mapper
public interface AttendanceMapper {
	
   public int goInsert(AttendanceDTO attdto);//출근시간 입력
   public int outUpdate(AttendanceDTO dto); //퇴근시간 입력
   public List<AttendanceDTO> allAtt(String userid); //모든 근무시간 출력
   
}