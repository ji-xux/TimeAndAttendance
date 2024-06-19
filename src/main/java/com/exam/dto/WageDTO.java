package com.exam.dto;

import org.apache.ibatis.type.Alias;

@Alias("WageDTO")
public class WageDTO {
	
	String emp_id;
	int month_wage;
	int holiday_pay;
	int all_wage;
	
	public WageDTO(String emp_id, int month_wage, int holiday_pay, int all_wage) {
		this.emp_id = emp_id;
		this.month_wage = month_wage;
		this.holiday_pay = holiday_pay;
		this.all_wage = all_wage;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public int getMonth_wage() {
		return month_wage;
	}

	public void setMonth_wage(int month_wage) {
		this.month_wage = month_wage;
	}

	public int getHoliday_pay() {
		return holiday_pay;
	}

	public void setHoliday_pay(int holiday_pay) {
		this.holiday_pay = holiday_pay;
	}

	public int getAll_wage() {
		return all_wage;
	}

	public void setAll_wage(int all_wage) {
		this.all_wage = all_wage;
	}

	@Override
	public String toString() {
		return "WageDTO [emp_id=" + emp_id + ", month_wage=" + month_wage + ", holiday_pay=" + holiday_pay
				+ ", all_wage=" + all_wage + "]";
	}
	
}
