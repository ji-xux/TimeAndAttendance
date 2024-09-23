<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
   
   $(document).ready(function(){
		//로그인 서브밋
		$("form").on("submit", function(){
			this.action="main"; //LoginServlet의 매핑값
			this.method="post";
		});

	       // 회원가입 버튼 클릭 시
	       $("button[name='signup']").on("click", function(){
	           location.href = "signup"; // signup 페이지로 이동
	       });
   });// ready()

</script>
<style>
   .btn{
      background-color:#FFB71C;
      color:#646569;
      font-size:20px;
      border:none;
      border-radius:7px;
      padding-left:10px;
      padding-right:10px;
      margin:5px;
   }
   .pad{
      padding-left:20px;
      padding-right:20px;
    }
    .center{
       margin-right:20px;
    }
    .full-height {
      height: 100vh;
   }
   .box {
        border: 1px solid #ccc;
        border-radius: 10px;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        background-color: #f9f9f9;
        max-width: 800px;
        margin: 0 auto; 
        margin-top:40px;
    }
    .form-control{
       border:none;
      border-radius:7px;
      width:400px;
      margin-left:120px;
    }
    
</style>

<div class="container">
    <div class="box">
        <form class="row g-5 m-5 align-items-md-center">
            <div class="mb-3 row">
                <div>${errorMessage}</div>
            </div>  
            <div class="row mb-4">
                <div class="col-auto">
                    <input type="text"  class="form-control" id="emp_id" name="emp_id"  placeholder="아이디를 입력하세요.">
                </div>
            </div>
            <div class="row mb-8">
                <div class="col-auto">
                    <input type="password" class="form-control" name="emp_pw" id="emp_pw" placeholder="비밀번호를 입력하세요.">
                </div>
            </div>
            <div class="col-12">
                <button type="submit" class="btn pad" name="login">로그인</button>
                <button type="button" class="btn" name="signup">회원가입</button>
            </div>
        </form>
    </div>
</div> 