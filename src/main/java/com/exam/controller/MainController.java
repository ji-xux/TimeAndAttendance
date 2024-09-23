package com.exam.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@SessionAttributes(names = {"login","empDTO","wageDTO","allAttList", "mypageDTO"})  //login 정보저장
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
	
	//로그인 처리
	@PostMapping("/main")
	public String login(@RequestParam Map<String, String> m, ModelMap model) {
	    String emp_id = m.get("emp_id");
	    String emp_pw = m.get("emp_pw");

	    EmpDTO dtoFromDB = empService.searchEmpById(emp_id); // DB에서 조회된 DTO
	    EmpDTO mypageDTO=new EmpDTO();
	    mypageDTO.setEmp_id(emp_id);
	    mypageDTO.setEmp_pw(emp_pw);
	    if (dtoFromDB != null && verifyPassword(emp_pw, dtoFromDB.getEmp_pw())) {
	    	model.addAttribute("mypageDTO", mypageDTO);
	        if ("admin".equals(dtoFromDB.getEmp_id())) {
	        	
	            model.addAttribute("login", dtoFromDB); // session scope에 저장
	            logger.info("model", model.getAttribute(emp_pw));
	            return "adminMenu";
	        } else {
	            model.addAttribute("login", dtoFromDB); // session scope에 저장
	            return "menu";
	        }
	    }
//		EmpDTO dto=empService.login(m);
//
//		if(dto!=null && "admin".equals(dto.getEmp_id())) {
//			model.addAttribute("login", dto); //session scope에 저장
//
//			return "adminMenu";
//		}
//		
//		else if(dto!=null && !"admin".equals(dto.getEmp_id())) {
//			//session 저장
//			model.addAttribute("login", dto); //session scope에 저장
//			return "menu";
//		}
		
		model.addAttribute("errorMessage", "아이디 또는 비밀번호가 일치하지 않습니다."); //request scope에 저장
		return "main";
	}
	
	// 비밀번호 검증 메서드
	public boolean verifyPassword(String inputPassword, String encryptedPasswordFromDB) {
	    // 여기서는 BCryptPasswordEncoder를 사용하여 검증한다고 가정하겠습니다.
	    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	    return encoder.matches(inputPassword, encryptedPasswordFromDB);
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:main";
	}
	
}
