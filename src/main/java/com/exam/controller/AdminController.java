package com.exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exam.dto.EmpDTO;
import com.exam.dto.WageDTO;
import com.exam.service.EmpService;
import com.exam.service.WageService;

@Controller
public class AdminController {
	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	EmpService empService;
	@Autowired
	WageService wageService;

	@GetMapping("/adminMenu")
	public String employeeInfoPage() {
		return "adminMenu";
	}
	
	//이름으로 직원 조회
	@GetMapping("/searchEmp")
	public ModelAndView searchEmp(@RequestParam("name") String name) {
		
		ModelAndView mav = new ModelAndView();
		
		EmpDTO empDTO = empService.searchEmp(name); //조회할 이름과 동일한 직원의 정보를 empDTO에 저장
		WageDTO wageDTO = null; //존재하지 않는 직원을 조회했을 때는 wageDTO를 null로 설정
		
		if (empDTO != null) { //조회한 직원이 존재하는 경우
			wageDTO=wageService.paycheck(name); //조회할 이름과 동일한 직원의 정보를 wageDTO에 저장
			mav.addObject("empDTO", empDTO); //empDTO 모델 추가
			mav.addObject("wageDTO", wageDTO); //wageDTO 모델 추가
			mav.setViewName("adminMenu"); //adminMenu를 뷰로 설정
		} 
		else { //조회한 직원이 존재하지 않는 경우
			mav.addObject("errorMessage", "직원을 찾을 수 없습니다."); //모델에 errorMessage 저장
			mav.setViewName("adminMenu");
		}
		
		return mav;
	}
	
    //관리자가 직원 정보(직급, 시급, 주 근무 시간) 수정
	@PostMapping("/updateByAdmin")
    public String updateByAdmin(@ModelAttribute("empDTO") EmpDTO empDTO, ModelMap m) {

    	String emp_id=empDTO.getEmp_id(); //조회한 직원의 emp_id
    	EmpDTO updateDTO=empService.searchEmpById(emp_id); //조회한 직원의 정보를 담는 updateDTO
    	updateDTO.setPosition(empDTO.getPosition()); //updateDTO에 수정한 직급 저장
    	updateDTO.setHourly_wage(empDTO.getHourly_wage()); //updateDTO에 수정한 시급 저장
    	updateDTO.setWeek_time(empDTO.getWeek_time()); //updateDTO에 수정한 주 근무 시간 저장
    	
    	logger.info("logger:updateByAdmin:{}", updateDTO);
    	
	    int n=empService.updateByAdmin(updateDTO); //update한 정보 DB에 갱신
	    logger.info("logger:updateByAdmin:{}", n);
        
	    WageDTO wageDTO=new WageDTO(); //조회한 직원의 급여 정보를 저장할 wageDTO
	    wageDTO.setEmp_id(emp_id);
	    wageDTO.setMonth_wage(updateDTO.getHourly_wage()*updateDTO.getWeek_time()*4); //한 달 급여
	    
	    if(updateDTO.getWeek_time()<15) { //15시간 미만 주휴수당 미지급
	    	wageDTO.setHoliday_pay(0);
	    	logger.info("logger:WageDTO.getHoliday_pay():{}", wageDTO.getHoliday_pay());
	    	wageDTO.setAll_wage(wageDTO.getMonth_wage()+wageDTO.getHoliday_pay()); //총 급여: 한 달 급여 + 주휴수당
	    }
	    else if(updateDTO.getWeek_time()>=15 && updateDTO.getWeek_time()<40){ //15시간 이상 40시간 미만 주휴수당 계산: (주 시간 / 40) * 8 *시급
	    	double a=updateDTO.getWeek_time()/40.0*8*updateDTO.getHourly_wage(); //40.0으로 나눠줘야 함. updateDTO.getWeek_time이 int이기 때문에 40으로 나누면 0이 됨.
	    	int holiday_pay=(int)a;
	    	wageDTO.setHoliday_pay(holiday_pay); //wageDTO에 주휴수당 저장
	    	logger.info("logger:WageDTO.getHoliday_pay():{}", wageDTO.getHoliday_pay());
	    	wageDTO.setAll_wage(wageDTO.getMonth_wage()+wageDTO.getHoliday_pay()); //총 급여: 한 달 급여 + 주휴수당
	    }
	    else if(updateDTO.getWeek_time()>=40){ //40시간 이상 주휴수당 계산: 8 * 시급
	    	int holiday_pay=8*updateDTO.getHourly_wage();
	    	wageDTO.setHoliday_pay(holiday_pay);
	    	logger.info("logger:WageDTO.getHoliday_pay():{}", wageDTO.getHoliday_pay());
	    	wageDTO.setAll_wage(wageDTO.getMonth_wage()+wageDTO.getHoliday_pay()); //총 급여: 한 달 급여 + 주휴수당
	    }
	    
	    logger.info("logger:Wage:{}", wageDTO);
	    
	    int n2;
	    if(wageService.paycheck(emp_id)!=null) { //기존 직원인 경우. wage 테이블에 해당 직원의 정보가 저장된 경우
	    	n2=wageService.updateWage(wageDTO); //wage 테이블 업데이트
		    logger.info("logger:updateWage:{}", n);
	    }
	    else if(wageService.paycheck(emp_id)==null){ //신규 직원인 경우. wage 테이블에 해당 직원의 정보가 저장되지 않은 경우
	    	n2=wageService.insertWage(wageDTO); //wage 테이블에 삽입
	    	logger.info("logger:insertWage:{}", n);
	    }
	    
	    m.addAttribute("wageDTO", wageDTO); //wageDTO를 모델에 저장
	    logger.info("logger:model:{}", m);
	    

	    return "redirect:/searchEmp?name="+updateDTO.getName();

    }

	//직원 삭제
    @PostMapping("/deleteByAdmin")
    public String deleteByAdmin(@ModelAttribute("empDTO") EmpDTO empDTO) {
    	
    	String emp_id=empDTO.getEmp_id(); //삭제할 직원의 emp_id
    	EmpDTO deleteDTO=empService.searchEmpById(emp_id); //삭제할 직원의 정보를 담는 deleteDTO
    	logger.info("logger:deleteByAdmin:{}", deleteDTO);
    	
        int n = empService.deleteByAdmin(deleteDTO.getEmp_id()); //직원 정보 삭제
        
        return "redirect:adminMenu";
        
    }
    
}
