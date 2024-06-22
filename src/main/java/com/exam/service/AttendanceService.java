package com.exam.service;


import java.util.List;

import com.exam.dto.AttendanceDTO;

public interface AttendanceService {
   
   public int goInsert(AttendanceDTO attdto);
   public int outUpdate(AttendanceDTO dto);
   public List<AttendanceDTO> allAtt(String userid);

}