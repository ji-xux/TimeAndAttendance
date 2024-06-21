package com.exam.service;


import org.springframework.stereotype.Service;

import com.exam.dto.AttendanceDTO;
import com.exam.mapper.AttendanceMapper;



@Service
public class AttendanceServiceImpl implements AttendanceService{
   
   AttendanceMapper attendanceMapper;
   

   public AttendanceServiceImpl(AttendanceMapper attendanceMapper) {
      this.attendanceMapper = attendanceMapper;
   }


   @Override
   public int goInsert(AttendanceDTO attdto) {
      return attendanceMapper.goInsert(attdto);
   }





}
