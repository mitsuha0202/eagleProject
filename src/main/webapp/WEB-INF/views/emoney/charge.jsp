<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<button ></button>
		<div>
			<td><h5>사용 가능 금액 : 0원</h5></td>
			<td></td>
			
		</div>
		<br>
		<div class="payChargeArea">
			<table class="chargeTable">
					<tr>
						<div class="btn-group btn-group-toggle" data-toggle="buttons">
							<label class="btn btn-secondary active" style="margin: 2px;"> 
							<input type="radio" name="options" id="option1" autocomplete="off" checked>1000원
							</label> 
												
							<label class="btn btn-secondary" style="margin: 2px;">						
							<input type="radio" name="options" id="option2" autocomplete="off">5000원
							</label>
							 
							<label class="btn btn-secondary" style="margin: 2px;"> 
							<input type="radio" name="options" id="option3" autocomplete="off">10000원
							</label>
						
							<label class="btn btn-secondary" style="margin: 2px;"> 
							<input type="radio"name="options" id="option3" autocomplete="off">50000원
							</label>
							 
							<label class="btn btn-secondary" style="margin: 2px;"> 
							<input type="radio" name="options" id="option3" autocomplete="off">100000원
							</label>
						</div>
					</tr>	
					<br>
					<td>충전금액 :</td>
					<tr>
						<br>						
						
						<td>결제
						
						<td>
							<button class="btn btn-warning" name="kakaopay" id="kakaopayBtn" onclick="chargeAPI.em">카카오페이</button>
					</tr>

			</table>
		</div>
	</div>


</body>
</html>