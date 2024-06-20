package com.exam.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.exam.dto.EmpDTO;
import com.exam.service.EmpService;

@Controller
@SessionAttributes(names = {"login"})  //login 정보저장
public class MainController {
	
	Logger logger=LoggerFactory.getLogger(getClass());
	
	EmpService empService;
	
	public MainController(EmpService empService) {
		this.empService = empService;
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	//로그인 처리
	@PostMapping("/main")
	public String login(@RequestParam Map<String, String> m, ModelMap model) {
		
		EmpDTO dto=empService.login(m);

		if(dto!=null && "admin".equals(dto.getEmp_id())) {
			//session 저장
			model.addAttribute("login", dto); //session scope에 저장

			return "adminMenu";
		}
		else if(dto!=null && !"admin".equals(dto.getEmp_id())) {
			//session 저장
			model.addAttribute("login", dto); //session scope에 저장
			return "menu";
		}
		
		model.addAttribute("errorMessage", "아이디 또는 비밀번호가 일치하지 않습니다."); //request scope에 저장
		return "main";
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:main";
	}
	
}
