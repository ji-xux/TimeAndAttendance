package com.exam.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.dto.EmpDTO;
import com.exam.service.EmpService;

@Controller
public class EmpController {
	
	Logger logger=LoggerFactory.getLogger(getClass());
	
	EmpService empService;
	
	public EmpController(EmpService empService) {
		this.empService = empService;
	}
	
	@GetMapping("/idCheck")
	public @ResponseBody String idCheck(@RequestParam String emp_id) {
		EmpDTO dto=empService.idCheck(emp_id);
		String mesg="사용 가능한 아이디입니다.";
		if(dto!=null) {
			mesg="중복된 id가 존재합니다.";
		}
		return mesg;
	}
	
	@GetMapping("/signup")
	public String signup(ModelMap m) {
		
		EmpDTO dto=new EmpDTO();
		m.addAttribute("EmpDTO", dto);
		
		return "empForm";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid EmpDTO dto, BindingResult result) {
		if(result.hasErrors()) {
			return "empForm";
		}
		
		//DB 연동
		logger.info("logger:signup:{}", dto);

		int n=empService.empAdd(dto);
		
		return "redirect:main";
	}
}
