//package com.exam.controller;
//
//import javax.validation.Valid;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.exam.dto.EmpDTO;
//import com.exam.service.EmpService;
//
//@Controller
//public class AdminController {
//	Logger logger=LoggerFactory.getLogger(getClass());
//	
//	EmpService empService;
//	
//	public AdminController(EmpService empService) {
//		this.empService=empService;
//	}
//	
//	
//	@GetMapping("/signup")
//	public String signup(ModelMap m) {
//		EmpDTO dto=new EmpDTO();
//		m.addAttribute("empDTO", dto);
//		
//		return "empForm";
//	}
//	
//	@PostMapping("/signup")
//	public String signup(@Valid EmpDTO dto, BindingResult result) {
//		if(result.hasErrors()) {
//			return "empForm";
//		}
//		
//		logger.info("logger:signup:{}", dto);
//		int n=empService.empAdd(dto);
//		return "redirect:main";
//	}
//}
