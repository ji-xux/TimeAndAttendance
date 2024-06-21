package com.exam.controller;


import java.time.LocalDate;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.exam.dto.AttendanceDTO;
import com.exam.dto.EmpDTO;
import com.exam.dto.WageDTO;
import com.exam.service.AttendanceService;
import com.exam.service.EmpService;
import com.exam.service.WageService;

@Controller
@SessionAttributes(names = {"login"})  //login 정보저장
public class MenuController {
   
   Logger logger=LoggerFactory.getLogger(getClass());
   
   @Autowired
   EmpService empService;
   @Autowired
   WageService wageService;
   
   @Autowired
   AttendanceService attendanceService;
   
   @GetMapping("/menu")
   public String menu() {
      return "menu";
   }
   
   @GetMapping("/attendance")
   public String attendance() {
      return "attendance";
   }
   
   @PostMapping("/attendance_go")
   public @ResponseBody String attendanceform(@RequestParam LocalDate godate, @RequestParam LocalTime gotime, ModelMap m) {
      
      System.out.println(godate);
      System.out.println(gotime);
      
      AttendanceDTO attdto = new AttendanceDTO();
      
      attdto.setDate(godate);
      attdto.setGowork(gotime);
      
      EmpDTO dto = (EmpDTO)m.getAttribute("login"); //로그인한 정보를 저장한 dto 객체생성
      attdto.setEmp_id(dto.getEmp_id());
      
      int n = attendanceService.goInsert(attdto);          
       logger.info("logger:insert:{}", n);
      
      
      return "attendance";
   }
   
   
   @GetMapping("/paycheck")
   public String paycheck(ModelMap m) {
      
      EmpDTO dto = (EmpDTO)m.getAttribute("login");   //로그인한 정보를 저장한 dto 객체생성
      logger.info("logger:mypage:{}", dto);
      String userid = dto.getEmp_id();         //로그인한 정보의 id
      
      WageDTO searchDTO = wageService.paycheck(userid);    
      logger.info("logger:Wagedto:{}", searchDTO);
      m.addAttribute("wageDTO", searchDTO);
      return "paycheck";
   }
   
   
}
