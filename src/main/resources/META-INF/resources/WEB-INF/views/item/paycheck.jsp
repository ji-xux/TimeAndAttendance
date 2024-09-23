<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">

   function formatNumber(num) {
       return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
   }
   
   $(document).ready(function() {
       $("#hourly_wage").val(formatNumber($("#hourly_wage").val()));
       $("#holiday_pay").val(formatNumber($("#holiday_pay").val()));
       $("#all_wage").text(formatNumber($("#all_wage").text()));
   });

</script>
<style>
    .box {
        border: 1px solid #ccc;
        border-radius: 10px;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        background-color: #f9f9f9;
        max-width: 800px;
        margin: 20px auto; 
    }
    .b{
       text-align: center;
        color: #646569;
        font-size: 40px;
        font-family: "Blinker", sans-serif;
        margin-left: 10px;
        
    }
    .a {
        text-align: center;
        color: #646569;
        font-size: 45px;
        font-family: "Blinker", sans-serif;
        margin-left: 10px;
        margin-bottom: 1px;
    }
    .red{
       color:red;
    }
    
</style>

<div class="container">
    <p class="a">예상 급여</p>
    <form class="row g-3 m-5 align-items-md-center">
        <div class="box mt-1">
            <div class="row mb-4 mt-4">
                <label for="hourly_wage" class="col-sm-2 col-form-label">시급</label>
                <div class="col-auto">
                    <input type="text" class="form-control" name="hourly_wage" 
                    id="hourly_wage" value="${login.hourly_wage}" disabled="disabled">
                </div>
            </div>
            <div class="row mb-4">
                <label for="week_time" class="col-sm-2 col-form-label">주 근무시간</label>
                <div class="col-auto">
                    <input type="text" class="form-control" name="week_time" 
                    id="week_time" value="${login.week_time}" disabled="disabled">
                </div>
            </div>
            <div class="row mb-4">
                <label for="holiday_pay" class="col-sm-2 col-form-label">주휴수당</label>
                <div class="col-auto">
                    <input type="text" name="holiday_pay" value="${wageDTO.holiday_pay}" 
                    class="form-control size" id="holiday_pay" disabled="disabled">
                </div>
            </div>
        </div>
        <div class="b">"${login.name}"님의 한달 예상 급여는 
               <span id="all_wage" class="red" >${wageDTO.all_wage}원</span> 입니다.
        </div>
    </form>
</div>
