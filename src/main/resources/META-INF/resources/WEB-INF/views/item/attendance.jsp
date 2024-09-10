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
           $("#gotime").text(" : " + time);
           
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
                      $("#outtime").text(" : " + time);
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
	.time_area{
		width : 100%;	
	}
	.time_area > div {
		width : 100%;
	}
	.time_area .real_time{
		display : flex;
		gap : 5px;
		color: #FFB71C;
    	font-weight: 700;
    	justify-content: center;
    	font-size : 28px;
	}
	.row2{
		display: flex;
    	justify-content: center;
    	gap:5px;
    	margin : 10px 0px;
	}
    .flex-container {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
     }
     .btn{
      background : #FFFFFF;
      border : 1px solid #FFB71C;
      color:#FFB71C;
      font-weight : 700;
      font-size:14px;
      padding-left:10px;
      padding-right:10px;
      margin:5px;
      width : 140px;
   }
   table {
   		margin-top: 20px;
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
	<div class="time_area">
		<div class="row1">
			<div class="real_time">
				<div id="date"></div><div id="time"></div>
			</div>
		</div>	
	</div>
	<div class="row2">
		<div>
			<button type="button" class="btn btn-primary" id="gowork">
				출근<span id="gotime"></span>
			</button>
			
		</div>
		<div>
			<button type="button" class="btn btn-primary" id="outwork">
				퇴근<span id="outtime"></span>
			</button>
		</div>
	</div>
	<div class="row3"></div>
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
   </div>
</div> 