package com.exam.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.exam.dto.EmpDTO;
import com.exam.service.EmpService;

@Controller
@SessionAttributes(names = {"login"})  //login 정보저장
public class EmpController {
	Logger logger=LoggerFactory.getLogger(getClass());
	
	EmpService empService;
	
	public EmpController(EmpService empService) {
		this.empService=empService;
	}
	
	//@ResponseBody는 스프링 컨트롤러 메서드가 반환하는 데이터를 HTTP 응답 본문에 직접 쓰도록 지정하는 역할
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
		m.addAttribute("empDTO", dto);
		
		return "empForm";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid EmpDTO dto, BindingResult result) {
		if(result.hasErrors()) {
			return "empForm";
		}
		
		logger.info("logger:signup:{}", dto);
		int n=empService.empAdd(dto);
		return "redirect:main";
	}
	
	@GetMapping("/mypage")
	   public String mypage(ModelMap m) {
	      
	      // 세션에 저장된 EmpDTO 얻기
	      EmpDTO dto = (EmpDTO)m.getAttribute("login");   //로그인한 정보를 저장한 dto 객체생성
	      logger.info("logger:mypage:{}", dto);
	      String userid = dto.getEmp_id();         //로그인한 정보의 id
	      
	      EmpDTO searchDTO = empService.mypage(userid);     //로그인한 정보의 id를 이용하여 마이페이지에 보여줄 정보 객체에 저장
	      m.addAttribute("login", searchDTO);               //정보를 저장 login 객체에 넣기
	      
	      EmpDTO empdto=new EmpDTO();                       //갱신한 정보를 저장하기 위한 새로운 객체 생성
	      m.addAttribute("empDTO", empdto);
	      
	      return "mypage";
	   }
	   
	   @PostMapping("/EmpUpdate")
	   public String EmpUpdate(@ModelAttribute("empDTO") EmpDTO empDTO, ModelMap m) {
	      
	      logger.info("logger:update:{}", empDTO);
	      
	      EmpDTO dto = (EmpDTO)m.getAttribute("login"); 
	      empDTO.setEmp_id(dto.getEmp_id());
	      
	      int n=empService.update(empDTO);          //update한 정보 데이터베이스에 갱신
	      logger.info("logger:update:{}", n);
	      
	      String userid = empDTO.getEmp_id();        //갱신한 정보의 아이디를 이용하여
	      EmpDTO updatedDTO = empService.mypage(userid); //갱신한 정보를 다시 login객체 정보에 넣기위한 객체 생성
	      m.addAttribute("login",updatedDTO);
	      
	      return "mypage";
	   }
}
