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
               },
               success:function(data, status, xhr){
                   console.log("data:", data);
                   alert(data);
               },
               error:function(xhr, status, error){
                   console.log("error:", error);
               }
            });    
       });
      
      $("#outwork").click(function() {
           var now = new Date();
           var date = now.getFullYear()+"-"+(now.getMonth()+1)+"-"+now.getDate();
           var time = now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds();
           
           
           $.ajax({
               method:"post",
               url:"attendance_out",
               data:{
                  godate:date,
                  gotime:time
               },
              success:function(data, status, xhr){
                   console.log("data:", data);
                   alert(data);
                   if(data === "퇴근 정보가 저장되었습니다."){
                      $("#outtime").text("퇴근 시간: " + time);
                   }
               },
               error:function(xhr, status, error){
                   console.log("error:", error);
               }
            });    
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
   <div class="flex-container">
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
</div> 