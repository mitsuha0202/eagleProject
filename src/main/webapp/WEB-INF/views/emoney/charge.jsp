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
			<%-- <td id="tdHaveMoney"><%= nowCash%></td> --%>
			
		</div>
		<br>
		<div class="payChargeArea">
			<table class="chargeTable">
					<tr>
						<div class="btn-group btn-group-toggle" data-toggle="buttons" >
							
							<td>
							<label class="btn btn-secondary" style="margin: 2px;">
							<input type="radio" name="amount" value="1000">1000원</label>
							</td>
							
				            <td>
							<label class="btn btn-secondary" style="margin: 2px;">
							<input type="radio" name="amount" value="5000">5000원</label>
							</td>
							
							<td>
							<label class="btn btn-secondary" style="margin: 2px;">
							<input type="radio" name="amount" value="10000">10000원</label>
							</td>
							
							<td>
							<label class="btn btn-secondary" style="margin: 2px;">
							<input type="radio" name="amount" value="50000">50000원</label>
							</td>
							
							<td>
							<label class="btn btn-secondary" style="margin: 2px;">
							<input type="radio" name="amount" value="100000">100000원</label>
							</td>
							
							</label>
						</div>
					</tr>
					
					
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
	$("input[type = radio]").click(function(){
		$("#amount").text($(this).val());	
			chargeMoney = $(this).val();
			
			console.log(chargeMoeny);
			
			var haveMoney = Number($("#tdHaveMoney").text());
			
			<%--  $.ajax({
				url : "saveCharge.em",
				data : {chargeMoney : chargeMoney},
				type : "post",
				success : function(data){
					$("#tdChargeCashMoney").text(data*(0.9));
					$("#tdResultMoney").text(data);
					$("#afterChargeCash").text(<%= nowCash%> + (data*(0.9))); //50000원 부분을 db에서 현재 내가 보유하고 있는 캐시를 뽑아와서 넣기
					//$("#afterChargeCash").text(Number($("#afterChargeCash").text()) + data);
					//$("#tdResultMoney").text(data+haveMoney);
				},
				error : function(){
					console.log("실패!");
				} --%>
			}); 
		});
		function chargeAPI(){
			location.href="chargeAPI.em";
			
			
		}
	</script>
 	
 	
 
	
</body>
</html>