<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<div class="container">
   <div class="flex-container">
      <a class="nav-link" href="main">
         <div class="set">
            <img src="images/clock.jpg" class="set" style="width: 650px; height: 600px;">
            <div class="text">출근 / 퇴근</div>
         </div>
       </a>
       <a class="nav-link" href="main">
          <div class="set">
            <img src="images/pay.png" class="set" style="width: 650px; height: 600px;">
            <div class="text">예상 급여</div>
         </div>
       </a>
   </div>
</div> 