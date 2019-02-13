<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int nowCash = (Integer)request.getAttribute("nowCash");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pay charge</title>
</head>
<body>
	<!-- 메뉴바 -->
	<jsp:include page="../common/header.jsp" />

	<!-- /////////////////////////////////////////////////// -->
	<br>
	<br>
	<div class="container">
		<div class="title">
			<h1>충전</h1>
		</div>
		<br><br>

		<div>
			<td><h5>사용 가능 금액</h5></td>
			<td id="tdHaveMoney"><%= nowCash%></td>
			
		</div>
		<br>
		<div class="payChargeArea">
			<table class="chargeTable">
					<tr>
						<div class="btn-group btn-group-toggle" data-toggle="buttons" id="btnON">
							<label class="btn btn-secondary active" style="margin: 2px;"> 
							<input type="radio" name="options" id="r1" autocomplete="off" checked>
							<button onclick="p1()">1000원</button>
							</label> 
												
							<label class="btn btn-secondary" style="margin: 2px;">						
							<input type="radio" name="options" id="r2" autocomplete="off">
							<button onclick="p1()">5000원</button>
							</label>
							 
							<label class="btn btn-secondary" style="margin: 2px;"> 
							<input type="radio" name="options" id="r3" autocomplete="off">
							<button onclick="p1()">10000원</button>
							</label>
						
							<label class="btn btn-secondary" style="margin: 2px;"> 
							<input type="radio"name="options" id="r4" autocomplete="off">
							<button onclick="p1()">50000원</button>
							</label>
							 
							<label class="btn btn-secondary" style="margin: 2px;"> 
							<input type="radio" name="options" id="r5" autocomplete="off">
							<button onclick="p1()">100000원</button>
							</label>
						</div>
					</tr>
					<script>
					<script>
					/* ajax를 사용해서 버튼 누를때마다 결제 값이 바뀌도록 하기  */
				
					function minusBtn1() {
						var num = Number($("#r1").text());
						if (num > 0)
							$("#la1").text(num - 1);
						
					}
					function plusBtn1() {
						var num = Number($("#r2").text());
						$("#la1").text(num + 1);
					}
					function minusBtn2() {
						var num = Number($("#r3").text());
						if (num > 0)
							$("#la2").text(num - 1);
					}
					function plusBtn2() {
						var num = Number($("#r4").text());
						$("#la2").text(num + 1);
					}
					function minusBtn3() {
						var num = Number($("#r5").text());
						if (num > 0)
							$("#la3").text(num - 1);
					}
					
					
					
				</script>
					
					</script>
					
					<br>
					
					<td>충전금액  </td>
					<td id="tdChargeCashMoney"></td>
					
					<td>충전 후 금액 </td>
					<td id="afterChargeCash"><%= nowCash%></td>
					
					<tr>
						<br>						
						
						<td>결제</td>
							<button class="btn btn-warning"  id="radioButton" onclick="chargeAPI()">카카오페이</button>
					</tr>
					

			</table>
		</div>
	</div>
	<script>
	$(function(){
		$("#calcBtn").click(function(){
			var num1 = Number($("#la1").text());
			var num2 = Number($("#la2").text());
			var num3 = Number($("#la3").text());
			var num4 = Number($("#la4").text());
			chargeMoney = (num1*5000) + (num2*10000) + (num3*30000) + (num4*50000);
			console.log(chargeMoney); //합 결과 출력
			/* 숫자 받고 ajax하기  */
			
			var haveMoney = Number($("#tdHaveMoney").text());
			
			
			 $.ajax({
				url : "/dsm/charge.pa",
				data : {chargeMoney : chargeMoney},
				type : "post",
				success : function(data){
					$("#tdChargeCashMoney").text(data*(0.7));
					$("#tdResultMoney").text(data);
					$("#afterChargeCash").text(<%= nowCash%> + (data*(0.7))); //50000원 부분을 db에서 현재 내가 보유하고 있는 캐시를 뽑아와서 넣기
					//$("#afterChargeCash").text(Number($("#afterChargeCash").text()) + data);
					//$("#tdResultMoney").text(data+haveMoney);
				},
				error : function(){
					console.log("실패!");
				}
			}); 
		});
	});
		function chargeAPI(){
			location.href="chargeAPI.em";
			
			
		}
	</script>
 	
 	
 
	
</body>
</html>