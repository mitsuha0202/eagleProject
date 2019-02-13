<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<!-- 메뉴바 -->
	<jsp:include page="../common/header.jsp"/>
	
	<!-- /////////////////////////////////////////////////// -->
	
	
	<br><br><br>
	<div class="container">
		
		<div class="title"><h1>사이버머니</h1></div>
		<br><br><br>
		<tr>
			<td>보유 금액 : </td>
			<td></td>
		</tr>
		<tr>
			<button onclick="location.href='charge.em'">충전하기</button>			
		</tr>
		<br><br><br>
		<table align="center" id="listArea" class="table table-striped"  border:1px; solid #dddddd">
		 		<thead>
		 			<tr>
						<th style="width: 20% background-color:#eeeeee; text-align: center;">결제번호</th>
						<th style="width: 5% background-color:#eeeeee; text-align: center;">금액</th>
						<th style="width: 5% background-color:#eeeeee; text-align: center;">결제날짜</th>
						<th style="width: 3% background-color:#eeeeee; text-align: center;">사용구분</th>
					</tr>
		<!-- <tr>
			<button onclick="location.href=''">환급하기</button>
		</tr> -->
	</div>




</body>
</html>