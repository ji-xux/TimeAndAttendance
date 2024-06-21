<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jQuery 설치 -->
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>    
<script type="text/javascript">
$(document).ready(function(){
   
   //비밀번호 확인
   $("#emp_pw2").on("keyup", function(){
      var passwd=$("#emp_pw").val();
      var passwd2=$("#emp_pw2").val();
      var mesg="비밀번호가 일치합니다.";
      if(passwd!=passwd2){
         mesg="비밀번호가 일치하지 않습니다.";
      }
      $("#pwdcheck").text(mesg);
   }); //end 비밀번호 확인
   
   //비밀번호확인 미 입력시 넘어가지 않음
   $("form").on("submit", function(event){
      var passwd=$("#emp_pw").val();
      var passwd2=$("#emp_pw2").val();
      
      if(passwd2== ""){
         alert("비밀번호를 확인해주세요");
         event.preventDefault(); //폼 제출 막기          
          return false;          //함수종료
      }
      
      if(passwd != passwd2){
         alert("비밀번호가 일치하지 않습니다.");
         event.preventDefault();  //폼 제출 막기
         return false;            //함수종료
      }
      
      alert("수정 완료");
      this.action="EmpUpdate";  
      this.method="post";
   });
   
   //취소
   $("button[name='cancel']").on("click", function(){
      location.href="menu";
   });
   
   
});
</script>

<style>
   .btn{
      background-color:#FFB71C;
      color:#646569;
      font-size:14px;
      border:none;
      border-radius:7px;
      padding-left:10px;
      padding-right:10px;
      margin:5px;
   }
   .size {
      width: 250px; 
      height: 40px;
   }
   .text{
         color:red;
         font-size:17px !important;
   }
</style>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
   <form:form class="row g-3 m-4" modelAttribute="empDTO" method="post">
    <form class="row g-3 m-4">
        <div class="row mb-3">
          <label for="emp_id" class="col-sm-2 col-form-label">id</label>
          <div class="col-auto">
            <input type="text" class="form-control" id="emp_id" name="emp_id" 
             value="${login.emp_id}"
             disabled="disabled">
          </div>
        </div>
        
        <div class="row mb-3">
          <label for="emp_pw" class="col-sm-2 col-form-label">비밀번호</label>
          <div class="col-auto">
            <form:input type="password" class="form-control" path="emp_pw" value="${login.emp_pw}"/>
            <form:errors path="emp_pw"></form:errors>
          </div>
        </div>
        <div class="row mb-3">
          <label for="emp_pw2" class="col-sm-2 col-form-label">비밀번호확인</label>
          <div class="col-auto">
            <input type="password" class="form-control" name="emp_pw2" id="emp_pw2">
          </div>
          <div class="col-auto">
            <span id="pwdcheck" class="fs-5 text"></span>
          </div>
        </div>
        
        <hr>
        
        <div class="row mb-3">
          <label for="name" class="col-sm-2 col-form-label">이름</label>
          <div class="col-auto">
            <input type="text" class="form-control" name="name" 
            id="name"
             value="${login.name}"
             disabled="disabled">
          </div>
        </div>
        
        <div class="row mb-3">
          <label for="birth" class="col-sm-2 col-form-label">생년월일</label>
          <div class="col-auto">
            <input type="date" class="form-control" name="birth" id="birth"
             value="${login.birth}">
          </div>
        </div>
        <div class="row mb-3">
            <label for="phone" class="col-sm-2 col-form-label">전화번호</label>   
         <div class="col-auto">
           <input type="text" name="phone" 
                  value="${login.phone}" class="form-control size" id="phone"
                  placeholder="'-'를 포함하여 입력">
         </div>
        </div>
        <div class="row mb-3">
           <label for="Account1" class="col-sm-2 col-form-label">계좌번호</label>
          <div class="col-auto">
           <select name="account1" class="form-control" id="account1">
             <option value="${login.account1}">${login.account1}</option>
             <option value="NH농협">NH농협</option>
             <option value="KB">KB</option>
             <option value="신한">신한</option>
             <option value="우리">우리</option>
             <option value="하나">하나</option>
             <option value="IM뱅크">IM뱅크</option>
             <option value="부산">부산</option>
             <option value="우체국">우체국</option>
            </select>
         </div>
         <div class="col-auto">
           <input type="text" name="account2" 
                  value="${login.account2}"
            class="form-control" id="account2" placeholder="숫자만 입력">
         </div>
        </div>
        <div class="col-12">
          <button type="submit" class="btn btn-primary" id="update">수정</button>
          <button type="button" class="btn btn-primary" name="cancel">취소</button>
        </div>
 </form>
</form:form>
   
</div>