package com.exam.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

@Alias("EmpDTO")
public class EmpDTO {

	@NotBlank(message = "아이디를 입력하세요")
	String emp_id;
	
	@Size(min=8, max = 20, message="8글자 이상 20글자 이하의 비밀번호를 입력하세요")
	String emp_pw;
	
	@NotBlank(message = "이름을 입력하세요")
	String name;
	
	@NotNull(message = "생년월일을 입력하세요")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate birth;
	
	@NotBlank(message = "휴대폰 번호를 입력하세요")
	String phone;
	
	@NotBlank(message = "은행명을 선택하세요")
	String account1;
	
	@NotBlank(message = "계좌번호를 입력하세요")
	String account2;
	
	String position;
	int hourly_wage;
	int week_time;
	
	public EmpDTO() {}

	public EmpDTO(String emp_id, String emp_pw, String name,
			LocalDate birth, String phone, String account1, String account2, String position, int hourly_wage,
			int week_time) {
		this.emp_id = emp_id;
		this.emp_pw = emp_pw;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		this.account1 = account1;
		this.account2 = account2;
		this.position = position;
		this.hourly_wage = hourly_wage;
		this.week_time = week_time;
	}



	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_pw() {
		return emp_pw;
	}

	public void setEmp_pw(String emp_pw) {
		this.emp_pw = emp_pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccount1() {
		return account1;
	}

	public void setAccount1(String account1) {
		this.account1 = account1;
	}

	public String getAccount2() {
		return account2;
	}

	public void setAccount2(String account2) {
		this.account2 = account2;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getHourly_wage() {
		return hourly_wage;
	}

	public void setHourly_wage(int hourly_wage) {
		this.hourly_wage = hourly_wage;
	}

	public int getWeek_time() {
		return week_time;
	}

	public void setWeek_time(int week_time) {
		this.week_time = week_time;
	}

	@Override
	public String toString() {
		return "EmpDTO [emp_id=" + emp_id + ", emp_pw=" + emp_pw + ", name=" + name
				+ ", birth=" + birth + ", phone=" + phone + ", account1=" + account1 + ", account2=" + account2
				+ ", position=" + position + ", hourly_wage=" + hourly_wage + ", week_time=" + week_time + "]";
	}
	
}
