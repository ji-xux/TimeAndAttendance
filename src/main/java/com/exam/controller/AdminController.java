package com.exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exam.dto.EmpDTO;
import com.exam.service.EmpService;

@Controller
public class AdminController {
	Logger logger=LoggerFactory.getLogger(getClass());
	
	EmpService empService;
	
	public AdminController(EmpService empService) {
		this.empService=empService;
	}

	@GetMapping("/adminMenu")
	public String employeeInfoPage() {
		return "adminMenu";
	}
	
	@GetMapping("/searchEmp")
	public ModelAndView searchEmp(@RequestParam("name") String name) {
		ModelAndView mav = new ModelAndView();
		
		EmpDTO empDTO = empService.searchEmp(name);
		
		if (empDTO != null) {
			mav.addObject("empDTO", empDTO);
			mav.setViewName("adminMenu");
		} else {
			mav.addObject("errorMessage", "직원을 찾을 수 없습니다.");
			mav.setViewName("adminMenu");
		}
		
		return mav;
	}
	

    
	@PostMapping("/updateByAdmin")
    public String updateByAdmin(@ModelAttribute("empDTO") EmpDTO empDTO) {
    	logger.info("logger:updateByAdmin:{}", empDTO);
    	String emp_id=empDTO.getEmp_id();
    	EmpDTO updateDTO=empService.searchEmpById(emp_id);
    	updateDTO.setPosition(empDTO.getPosition());
    	updateDTO.setHourly_wage(empDTO.getHourly_wage());
    	updateDTO.setWeek_time(empDTO.getWeek_time());
    	
    	logger.info("logger:updateByAdmin:{}", updateDTO);
	    int n=empService.updateByAdmin(updateDTO);          //update한 정보 데이터베이스에 갱신
	    logger.info("logger:update:{}", n);
        
        return "redirect:adminMenu";
    }

    @PostMapping("/deleteByAdmin")
    public String deleteByAdmin(@ModelAttribute("empDTO") EmpDTO empDTO) {
    	logger.info("logger:deleteByAdmin:{}", empDTO);
    	String emp_id=empDTO.getEmp_id();
    	EmpDTO deleteDTO=empService.searchEmpById(emp_id);
    	logger.info("logger:deleteByAdmin:{}", deleteDTO);
        int n = empService.deleteByAdmin(deleteDTO.getEmp_id());
        return "redirect:adminMenu";
    }
    
}
