package com.exam.dto;


import org.apache.ibatis.type.Alias;

@Alias("AttendanceDTO")
public class AttendanceDTO {
   
   int no;
   String emp_id;
   String date;
   String gowork;
   String outwork;

   public AttendanceDTO() {}

   public AttendanceDTO(int no, String emp_id, String date, String gowork, String outwork) {
      this.no = no;
      this.emp_id = emp_id;
      this.date = date;
      this.gowork = gowork;
      this.outwork = outwork;
   }

   public int getNo() {
      return no;
   }

   public void setNo(int no) {
      this.no = no;
   }

   public String getEmp_id() {
      return emp_id;
   }

   public void setEmp_id(String emp_id) {
      this.emp_id = emp_id;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public String getGowork() {
      return gowork;
   }

   public void setGowork(String gowork) {
      this.gowork = gowork;
   }

   public String getOutwork() {
      return outwork;
   }

   public void setOutwork(String outwork) {
      this.outwork = outwork;
   }

   @Override
   public String toString() {
      return "AttendanceDTO [no=" + no + ", emp_id=" + emp_id + ", date=" + date + ", gowork=" + gowork + ", outwork="
            + outwork + "]";
   }
      
}
