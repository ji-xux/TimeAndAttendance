package com.exam.service;

import java.util.List;

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

	@Override
	public int outUpdate(AttendanceDTO dto) {
		return attendanceMapper.outUpdate(dto);
	}

	@Override
	public List<AttendanceDTO> allAtt(String userid) {
		return attendanceMapper.allAtt(userid);
	}

}
