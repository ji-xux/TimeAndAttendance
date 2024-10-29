package com.exam.controller;

import java.util.List;

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
@SessionAttributes(names = {"login", "attDTO", "mypageDTO"})  //login 정보저장
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
   public String attendance(ModelMap m) {
      
      EmpDTO dto = (EmpDTO)m.getAttribute("login");   //로그인한 정보를 저장한 dto 객체생성
       String userid = dto.getEmp_id();
       
       List<AttendanceDTO> allAttList = attendanceService.allAtt(userid);
       m.addAttribute("allAttList",allAttList);
       
      return "attendance";
   }
   
   @PostMapping("/attendance_go")
   public @ResponseBody String attendanceform(@RequestParam String godate, @RequestParam String gotime, ModelMap m) {
      
      AttendanceDTO attdto = new AttendanceDTO(); //날짜와 시간을 저장한 dto
      
      attdto.setDate(godate);  
      attdto.setGowork(gotime);  
      
      EmpDTO dto = (EmpDTO)m.getAttribute("login"); //로그인한 정보를 저장한 dto 객체생성
      attdto.setEmp_id(dto.getEmp_id());
      
      int n = attendanceService.goInsert(attdto);  //출근 시간과 날짜를 데이터에 저장
       logger.info("logger:insert:{}", n);
       
       m.addAttribute("attDTO", attdto);     //퇴근 함수에서 쓰기 위해 객체 생성
      
       String mesg = "출근 정보가 저장되었습니다.";
       
      //return "attendance";    ajax요청은 페이지가 아닌 데이터만 주고 받기 때문에
                               //페이지를 다시 불러올 필요가 없음. 필요시 화면 업데이트는 자바스크립트에서 진행해줌.
       return mesg;
   }
   
   @PostMapping("/attendance_out")
   public @ResponseBody String attendanceForm(@RequestParam String godate, @RequestParam String gotime, ModelMap m) {
      
      AttendanceDTO dto = (AttendanceDTO)m.getAttribute("attDTO");
      EmpDTO logindto = (EmpDTO)m.getAttribute("login");
      
      //logger.info("logger:출근정보:{}", dto); 
      //logger.info("logger:출근정보:{}", dto.getEmp_id()); 
      logger.info("logger:로그인정보:{}", logindto.getEmp_id()); 
      
      String mesg="퇴근 정보가 저장되었습니다.";
      
      if(dto != null  && dto.getEmp_id().equals(logindto.getEmp_id())) {  //출근 정보 존재
         dto.setOutwork(gotime);
         logger.info("logger:출/퇴근정보:{}", dto); //
         
         int n = attendanceService.outUpdate(dto);  //출근 시간과 날짜를 데이터에 저장
          logger.info("logger:update:{}", n);
      }
      else {  //출근 정보 없음
         mesg="출근 정보가 없습니다.";
      }
      
      //return "attendance";
      return mesg;
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