<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attendance System</title>

<style type="text/css">
   
   @import url('https://fonts.googleapis.com/css2?family=Blinker:wght@100;200;300;400;600;700;800;900&family=Pridi:wght@200;300;400;500;600;700&family=Viga&display=swap');
   
    .App {
     text-align: center;
     font-size: 16px;
   }
   
    label, input, button {
    margin: 10px;
    padding: 5px;
    }

   footer {
       bottom: 0;
       position: absolute;
       width: 90%;
       height: 40px;
   }
   .a{
      text-align:center;
      color:#646569;
      font-size:45px;
      font-family: "Blinker", sans-serif;
   }
   
 </style>
    <link rel="stylesheet"  href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" >
   <script src="webjars/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
 
 <div class="App">
   <jsp:include page="common/top.jsp" flush="true" /><br>
   <p class="a">Attendance System</p>   
   <jsp:include page="item/loginForm.jsp" flush="true" />
 </div>

</body>
</html>