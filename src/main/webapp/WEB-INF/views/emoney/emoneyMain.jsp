<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
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
			<td><h3><b>보유 금액 : <c:out value="${ sessionScope.loginUser.emoney } 원"/><b></h3></td>
			
		</tr>
		<br><br>
		<tr>
			<button class="btn btn-secondary btn-lg active" onclick="location.href='charge.em'">충전하기</button>	
			<button class="btn btn-secondary btn-lg active" onclick="location.href='refundMain.em'">환급메인</button>		
		</tr>
		<br><br>
		<c:if test="${!empty list}">
		<table align="center" id="listArea" class="table table-striped"  border:1px; solid #dddddd">
		 		<thead>
		 			<tr>
						<th style="width: 20% background-color:#eeeeee; text-align: center;">결제번호</th>
						<th style="width: 5% background-color:#eeeeee; text-align: center;">결제날짜</th>
						<th style="width: 5% background-color:#eeeeee; text-align: center;">금액</th>
						<!-- <th style="width: 3% background-color:#eeeeee; text-align: center;">사용구분</th> -->
					</tr>
				</thead>
				<tbody>
					<c:forEach var="e" items="${ list }">
					<tr align="center">
						<td>${e.payNo }</td>
						<td>${e.useDay}</td>
						<td>${e.money}</td>
						<%-- <td>${e.useStatus}</td> --%>
					</tr>
					</c:forEach>
				</tbody>
		</table>
		</c:if>
		<br><br>
		<c:if test="${empty list}">
			<thead>
		 			<tr>
						<th style="width: 20% background-color:#eeeeee; text-align: center;">결제번호</th>
						<th style="width: 5% background-color:#eeeeee; text-align: center;">결제날짜</th>
						<th style="width: 5% background-color:#eeeeee; text-align: center;">금액</th>
						<!-- <th style="width: 3% background-color:#eeeeee; text-align: center;">사용구분</th> -->
					</tr>
				</thead>
				<tbody>
					 <tr align="center" style="border-bottom: 1px solid #dee2e6;">
			  	<td colspan="5" style="border-right: 1px solid white; border-left: 1px solid white; font-size: 2.5em;" readonly>결제 정보가 없습니다.</td>
				</tbody>
		</c:if>			
		<!-- <tr>
			<button onclick="location.href=''">환급하기</button>
		</tr> -->
	</div>




</body>
</html>