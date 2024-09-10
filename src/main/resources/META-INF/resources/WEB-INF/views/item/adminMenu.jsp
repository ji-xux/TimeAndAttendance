<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">

</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Blinker:wght@100;200;300;400;600;700;800;900&family=Pridi:wght@200;300;400;500;600;700&family=Viga&display=swap');
	.container{
		min-width: 1280px;
	}  
   .info_wrap{
   		display : flex;
   		gap : 20px;
    	justify-content: space-between;	
   }
   .info_wrap > div {
   		width : 50%;
   }
   .info_wrap .right .row2{
   		height : 280px;
   		overflow: auto;
   }
   .save_btn_area, .del_btn_area{
   		position : relative;
   }
   .save_btn_area > button{
       	position: absolute;
    	right: 60px;
   }
   .del_btn_area > button{
       	position: absolute;
    	right: 120px;
   }
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
    
    h2 {
        font-weight: bold;
        text-align:center;
      color:#646569;
      font-size:40px;
      font-family: "Blinker", sans-serif;
    }
    table {
       width: 100%;
       border-collapse: collapse;
   }
   th, td {
       padding: 10px;
       text-align: left;
       border-bottom: 1px solid #ddd;
   }
   th {
       background-color: #f2f2f2;
   }
   tr:hover {
       background-color: #f5f5f5;
   }
    
</style>

<div class="container">
    <h2>직원 정보 조회</h2><br>
    <form action="searchEmp" method="GET">
        <label for="name">직원명:</label>
        <input type="text" id="name" name="name" required>
        <button type="submit" class="btn">조회</button>
    </form>
    <c:if test="${empty empDTO && not empty errorMessage}">
       	<p>직원명을 확인하세요</p>
    </c:if>
    <hr>
    <div class="info_wrap">
    	<div class="left">
		    <form:form class="row g-3" modelAttribute="empDTO" action="updateByAdmin" method="post">
		        <div class="row mb-3">
		          <div class="col-auto">
		            <input type="hidden" class="form-control" name="emp_id" 
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
		          <label for="week_time" style="width : 110px;" class="col-sm-2 col-form-label">주 근무시간</label>
		          <div class="col-auto">
		            <input type="text" class="form-control" name="week_time" 
		            id="name"
		             value="${empDTO.getWeek_time()}">
		          </div>
		        </div>
		        <div class="col-12 save_btn_area">
				<button type="submit" class="btn btn-primary" id="updateByAdmin">저장</button>
		   	 </div>
		    </form:form>
		    <!-- 삭제 버튼 form -->
	        <form action="deleteByAdmin" method="post">
	            <input type="hidden" name="emp_id" value="${empDTO.getEmp_id()}">
	            <div class="col-12 del_btn_area">
	              <button type="submit" class="btn btn-primary" id="deleteByAdmin">삭제</button>
	            </div>
	          
	        </form>
    	</div>
    	<div class="right">
    		<div class="row1">
    			<div class="pay_info">
		        	<div class="row mb-3">
			          <label for="month_wage" class="col-sm-2 col-form-label">월 기본급</label>
			          <div class="col-auto">
			            <input type="text" class="form-control" name="month_wage" 
			            id="month_wage" disabled="disabled"
			             value="${wageDTO.getMonth_wage()}"
			             >
			          </div>   
		        	</div>
		        	<div class="row mb-3">
			          <label for="holiday_pay" class="col-sm-2 col-form-label">주휴수당</label>
			          <div class="col-auto">
			            <input type="text" class="form-control" name="holiday_pay"
			            id="holiday_pay"
			             value="${wageDTO.getHoliday_pay()}"
			             disabled="disabled">
			          </div>   
			        </div>
			        <div class="row mb-3">
			          <label for="all_wage" class="col-sm-2 col-form-label">총 급여</label>
			          <div class="col-auto">
			            <input type="text" class="form-control" name="all_wage" 
			            id="all_wage"
			             value="${wageDTO.getAll_wage()}"
			             disabled="disabled">
			          </div>   
			        </div>
		        </div>
    		</div>
    		<div class="row2">
    			<table>
			        <thead>
			            <tr>
			                <th>날짜</th>
			                <th>출근 시간</th>
			                <th>퇴근 시간</th>
			            </tr>
			        </thead>
			        <tbody>
			            <c:forEach var="attendance" items="${allAttList}">
			                <tr>
			                    <td>${attendance.date}</td>
			                    <td>${attendance.gowork}</td>
			                    <td>${attendance.outwork}</td>
			                </tr>
			            </c:forEach>
			        </tbody>
		    	</table>
    		</div>
    	</div>
    </div>
</div>