 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jQuery 설치 -->
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		
		//id 중복 체크
		$("#idDupulicatedcheck").on("click", function(){
			 //jQuery Ajax
			   $.ajax({
                   method:"get",
                   url:"idCheck",   // MemberIdCheckServlet
                   dataType:'text', // 응답되는 데이터타입, 반환값(사용가능|사용불가)
                   data:{
                	   userid:$("#userid").val()
                   },
                   success:function(data, status, xhr){
                       console.log("data:", data);
                       console.log("status:", status);
                       alert(data);
                   },
                   error:function(xhr, status, error){
                       console.log("error:", error);
                   }

               });
		}); //end id 중복 체크
		
		//비밀번호 확인
		$("#passwd2").on("keyup", function(){
			var passwd=$("#passwd").val();
			var passwd2=$("#passwd2").val();
			var mesg="비밀번호가 일치합니다.";
			if(passwd!=passwd2){
				mesg="비밀번호가 일치하지 않습니다.";
			}
			$("#pwdcheck").text(mesg);
		}); //end 비밀번호 확인
		
		//회원가입 서브밋
		/*
		$("form").on("submit", function(){
			alert("memberForm submit");
			this.action="MemberAddServlet"; //MemberAddServlet의 매핑값
			this.method="post"; //정보를 저장하는 것이므로 post 사용
		});
		*/
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
</style>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
    <form:form class="row g-3 m-4" modelAttribute="memberDTO" method="post">
		  <div class="row mb-3">
		    <label for="userid" class="col-sm-2 col-form-label">*아이디</label>
		    <div class="col-auto">
		      <form:input type="text" class="form-control" path="emp_id"/>
		    </div>
		    <div class="col-auto">
			    <button type="button" class="btn btn-primary mb-3" id="idDupulicatedcheck">아이디중복</button>
  			</div>
  			<div class="col-sm-3">
		         <span id="idcheck" class="fs-5"></span>
		        </div>
		  </div>
		 <div class="row mb-3">
		    <label for="password" class="col-sm-2 col-form-label">*비밀번호</label>
		    <div class="col-auto">
		      <form:input type="password" class="form-control" path="passwd"/>
		      <form:errors path="passwd"></form:errors>
		    </div>
		  </div>
		  <div class="row mb-3">
		    <label for="passwd2" class="col-sm-2 col-form-label">비밀번호확인</label>
		    <div class="col-sm-5">
		      <input type="password" class="form-control" name="passwd2" id="passwd2">
		    </div>
		    <div class="col-sm-3">
		      <span id="pwdcheck" class="fs-5"></span>
		    </div>
		  <br><br><br>  
		  <hr>
		  </div>
		  <div class="row mb-3">
		    <label for="username" class="col-sm-2 col-form-label">*이름</label>
		    <div class="col-auto">
		      <input type="text" class="form-control" name="name" id="name">
		    </div>
		  </div>
		  <div class="row mb-3">
		    <label for="username" class="col-sm-2 col-form-label">*생년월일</label>
		    <div class="col-auto">
		      <input type="date" class="form-control" name="birth" id="birth">
		    </div>
		  </div>
		  <div class="row mb-3">
		      <label for="phone1" class="col-sm-2 col-form-label">*전화번호</label>
		     <div class="col-auto">
		     <input type="text" class="form-control" name="phone" id="phone" placeholder="010">
			   </div>	
		  </div>
		  <div class="row mb-3">
		    <label for="username" class="col-sm-2 col-form-label">*계좌번호</label>
		    <div class="col-auto">
		      <select name="account1" class="form-control" id="account1">
				 <option value="선택">선택</option>
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
		      <input type="text" class="form-control" name="account2" id="account2">
		    </div>
		  </div>
		  <hr>
		  
		  <div class="col-12">
		    <button type="submit" class="btn btn-primary">회원가입</button>
		  </div>
 </form:form>
	
</div>
