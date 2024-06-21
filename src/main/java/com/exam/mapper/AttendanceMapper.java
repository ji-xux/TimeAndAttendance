package com.exam.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.AttendanceDTO;

@Mapper
public interface AttendanceMapper {

   public int goInsert(AttendanceDTO attdto);//출근시간 입력
}
