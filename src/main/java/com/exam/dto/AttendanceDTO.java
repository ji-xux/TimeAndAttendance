package com.exam.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.ibatis.type.Alias;

@Alias("AttendanceDTO")
public class AttendanceDTO {
	
	int no;
	String emp_id;
	LocalDate date;
	LocalTime gowork;
	LocalTime outwork;

	public AttendanceDTO(int no, String emp_id, LocalDate date, LocalTime gowork, LocalTime outwork) {
		this.no = no;
		this.emp_id = emp_id;
		this.date = date;
		this.gowork = gowork;
		this.outwork = outwork;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getGowork() {
		return gowork;
	}

	public void setGowork(LocalTime gowork) {
		this.gowork = gowork;
	}

	public LocalTime getOutwork() {
		return outwork;
	}

	public void setOutwork(LocalTime outwork) {
		this.outwork = outwork;
	}

	@Override
	public String toString() {
		return "AttendanceDTO [no=" + no + ", emp_id=" + emp_id + ", date=" + date + ", gowork=" + gowork + ", outwork="
				+ outwork + "]";
	}
		
}
