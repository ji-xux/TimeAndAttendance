<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jQuery 설치 -->
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>    
<script type="text/javascript">
   
   $(document).ready(function(){
   
      $("form").on("submit", function(){
         this.action="login";  
         this.method="post";
      });
      
   });// ready()

</script>
<style>
    .flex-container {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
     }
     .set{
        position: relative;
        border-radius: 15px;
        margin-right:5px;
     }
     .set:hover{
        opacity:0.5;
     }
     .text {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        color: black;
        font-size: 60px;
        font-weight: bold;
        text-align: center;
        opacity: 0;
        
    }
    .set:hover .text {
        opacity: 1;
    }
    
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
   <div class="flex-container">
   <form:form class="row g-3 m-4" modelAttribute="empDTO" method="post">
    <form class="row g-3 m-4">
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
             value="${login.birth}" disabled="disabled">
          </div>
        </div>
        <div class="row mb-3">
            <label for="phone" class="col-sm-2 col-form-label">전화번호</label>   
         <div class="col-auto">
           <input type="text" name="phone" 
                  value="${login.phone}" class="form-control size" id="phone"
                  placeholder="'-'를 포함하여 입력" disabled="disabled">
         </div>
        </div>
        <div class="row mb-3">
           <label for="Account1" class="col-sm-2 col-form-label">계좌번호</label>
          <div class="col-auto">
           <select name="account1" class="form-control" id="account1" disabled="disabled">
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
            class="form-control" id="account2" placeholder="숫자만 입력" disabled="disabled">
         </div>
        </div>
        
        <hr>

          <div class="row mb-3">
          <label for="emp_id" class="col-sm-2 col-form-label">직급</label>
          <div class="col-auto">
            <input type="text" class="form-control" id="emp_id" name="emp_id" 
             value="${login.emp_id}"
             disabled="disabled">
          </div>
        </div>
        <div class="row mb-3">
          <label for="emp_id" class="col-sm-2 col-form-label">생년월일</label>
          <div class="col-auto">
            <input type="text" class="form-control" id="emp_id" name="emp_id" 
             value="${login.emp_id}"
             disabled="disabled">
          </div>
        </div>

          <div class="col-12">
          	<button type="submit" class="btn btn-primary">삭제</button>
          	<button type="submit" class="btn btn-primary">저장</button>
          </div>
          

          </form>
         </form:form>

       <a class="nav-link" href="main">
          <div class="set">
            <img src="images/pay.png" class="set" style="width: 650px; height: 600px;">
            <div class="text">예상 급여</div>
         </div>
       </a>
   </div>
</div> 