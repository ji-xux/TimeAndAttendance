<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
   
   $(document).ready(function(){
      
      function updateClock(){
         
         var now = new Date();
         
         var date = now.getFullYear()+"-"+(now.getMonth()+1)+"-"+now.getDate();
         var time = now.getHours()+":"+now.getMinutes()+":"+now.getSeconds();
         
         $("#date").text(date);
         $('#time').text(time);
      }
      updateClock(); //처음에 한번 호출
      setInterval(updateClock, 1000); //1초마다 호출
      
      $("#gowork").click(function() {
           var now = new Date();
           var date = now.getFullYear()+"-"+(now.getMonth()+1)+"-"+now.getDate();
           var time = now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds();
           $("#gotime").text("출근 시간: " + time);
           
           $.ajax({
               method:"post",
               url:"attendance_go",
               data:{
                  godate:date,
                  gotime:time
               }
            });    
       });
      
      $("#outwork").click(function() {
           var now = new Date();
           var time = now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds();
           $("#outtime").text("퇴근 시간: " + time);
           
          
       });
      
      
      
   });// ready()

</script>
<style>
    .flex-container {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
     }
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
 <form:form id="attendanceForm" class="row g-3 m-4" modelAttribute="attendanceDTO" method="post">
   <div class="flex-container">
      <a class="nav-link" href="paycheck">
         <div class="set">
            <img src="images/clock.jpg" class="set" style="width: 650px; height: 600px;">
            
         </div>
       </a>
           <div id="date"></div>
           <div id="time"></div>
           <hd>
           <div class="col-12">
          <button type="button" class="btn btn-primary" id="gowork">출근</button>
          <div id="gotime"></div>
          <button type="button" class="btn btn-primary" id="outwork">퇴근</button>
          <div id="outtime"></div>
        </div>
           
   </div>
  </form:form>
</div> 