<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">

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
      margin:3px;
   }
   
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

<div class="container">
          <h2>직원 정보 조회</h2>
    
    <form action="searchEmp" method="GET">
        <label for="name">직원 이름:</label>
        <input type="text" id="name" name="name" required>
        <button type="submit" class="btn">조회</button>
    </form>
    
    <c:if test="${not empty empDTO}">
        <hr>
        <form:form class="row g-3 m-4" modelAttribute="empDTO" action="updateByAdmin" method="post">
        <div class="row mb-3">
          <label for="name" class="col-sm-2 col-form-label">ID</label>
          <div class="col-auto">
            <input type="text" class="form-control" name="emp_id" 
            id="emp_id"
             value="${empDTO.getEmp_id()}"
             readonly>
          </div>
          </div>
          
		<div class="row mb-3">
          <label for="name" class="col-sm-2 col-form-label">이름</label>
          <div class="col-auto">
            <input type="text" class="form-control" name="name" 
            id="name"
             value="${empDTO.getName()}"
             disabled="disabled">
          </div>
          
        </div>
        
        <div class="row mb-3">
          <label for="birth" class="col-sm-2 col-form-label">생년월일</label>
          <div class="col-auto">
            <input type="date" class="form-control" name="birth" id="birth"
             value="${empDTO.getBirth()}" disabled="disabled">
          </div>
          </div>
          
         <div class="row mb-3">
            <label for="phone" class="col-sm-2 col-form-label">전화번호</label>
         <div class="col-auto">
           <input type="text" name="phone" 
                  value="${empDTO.getPhone()}" class="form-control size" id="phone"
                  disabled="disabled">
         </div>
         </div>
         
         <div class="row mb-3">
            <label for="account1" class="col-sm-2 col-form-label">계좌번호</label>   
         <div class="col-auto">
           <input type="text" name="account1" 
                  value="${empDTO.getAccount1()}" class="form-control size" id="phone"
                  disabled="disabled">
         </div>
                  <div class="col-auto">
           <input type="text" name="account2" 
                  value="${empDTO.getAccount2()}"
            class="form-control" id="account2" disabled="disabled">
         </div>
         </div>
      	<div class="row mb-3">
          <label for="position" class="col-sm-2 col-form-label">직급</label>
          <div class="col-auto">
            <input type="text" class="form-control" name="position" 
            id="name"
             value="${empDTO.getPosition()}">
          </div>
        </div>
          <div class="row mb-3">
          <label for="hourly_wage" class="col-sm-2 col-form-label">시급</label>
          <div class="col-auto">
            <input type="text" class="form-control" name="hourly_wage" 
            id="name"
             value="${empDTO.getHourly_wage()}">
          </div>
        </div>
        
         <div class="row mb-3">
          <label for="week_time" class="col-sm-2 col-form-label">주 근무시간</label>
          <div class="col-auto">
            <input type="text" class="form-control" name="week_time" 
            id="name"
             value="${empDTO.getWeek_time()}">
          </div>
        </div>
        <div class="col-12">
			<button type="submit" class="btn btn-primary" id="updateByAdmin">저장</button>
   	 </div>
    </form:form>
        <!-- 삭제 버튼 form -->
        <form action="${pageContext.request.contextPath}/deleteByAdmin" method="post">
            <input type="hidden" name="emp_id" value="${empDTO.getEmp_id()}">
            <button type="submit" class="btn btn-primary" id="deleteByAdmin">삭제</button>
        </form>
    </c:if>
    
    <c:if test="${empty empDTO && not empty errorMessage}">
        <p>존재하지 않는 직원입니다</p>
    </c:if>
    
    <hr>
   </div>