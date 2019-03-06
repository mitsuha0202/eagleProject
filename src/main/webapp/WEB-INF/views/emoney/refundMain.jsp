<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>환전</title>
</head>
<body>
	<!-- 메뉴바 -->
	<jsp:include page="../common/header.jsp"/>
	
	<!-- /////////////////////////////////////////////////// -->
	
	
	<br><br><br>
	<div class="container">
		
		<div class="title"><h1>환전</h1></div>
		<hr>
		<br>
		<%-- <tr>
			<td><h3><b>보유 금액 : <c:out value="${ sessionScope.loginUser.emoney } 원"/><b></h3></td>
		</tr> --%>
		<div class="payChargeArea">		
			<tr>
				<button class="btn btn-light  active" onclick="location.href='charge.em'">충전하기</button>	
				<button class="btn btn-dark  active" onclick="location.href='refundMain.em'">환전하기</button>		
			</tr>
			<hr>
			<table class="chargeTable">
					
						<div class="btn-group btn-group-toggle" data-toggle="buttons">
							<tr>
								 <td>
									<label  >
									<input type="button" class="btn btn-outline-success btn-lg" name="amount" id="r1" value="1100" onclick="p1" ></label>
								</td>							
					            <td>
									<label  >
									<input type="button" class="btn btn-outline-success btn-lg" name="amount" id="r2" value="5500" onclick="p2" ></label>
								</td>							
								<td>
									<label >
									<input type="button" class="btn btn-outline-success btn-lg" name="amount" id="r3" value="11000" onclick="p3" ></label>
								</td>							
								<td>
									<label  >
									<input type="button" class="btn btn-outline-success btn-lg" name="amount" id="r4" value="55000" onclick="p4" ></label>
								</td>							
								<td>
									<label >
									<input type="button" class="btn btn-outline-success btn-lg" name="amount" id="r5" value="110000" onclick="p5" ></label>
								</td>
							</tr>								
							</div>					
			</table>
					<tr>						
					<td id="tdChargeCashMoney"><h3><b>선택한 금액 : <label id="amount">0</label>원 </b></h3></td>
					<td><button class="btn btn-outline-success"  id="refundFunction" type="button" >결제하기</button></td>					
					</tr>				
			</div>

		<br>
		<br>
		<c:if test="${!empty list}">
		<table align="center" id="listArea" class="table table-striped"  border:1px; solid #dddddd">
		 		<thead>
		 			<tr>
						<th style="width: 20% background-color:#eeeeee; text-align: center;">환전번호</th>
						<th style="width: 5% background-color:#eeeeee; text-align: center;">환전날짜</th>
						<th style="width: 5% background-color:#eeeeee; text-align: center;">금액</th>
						<!-- <th style="width: 3% background-color:#eeeeee; text-align: center;">환전상태</th> -->
					</tr>
				</thead>
				<tbody>
					<c:forEach var="e" items="${ list }">
					<tr align="center">
						<td>${e.useNo }</td>
						<td>${e.useDay}</td>
						<td>${e.money}원</td>
						<%-- <td>${e.exchangeYn}</td> --%>
					</tr>
					</c:forEach>
				</tbody>
		</table>
		</c:if>
		<br><br>
		<c:if test="${empty list}">
			<thead>
		 			<tr>
						<th style="width: 20% background-color:#eeeeee; text-align: center;">환급번호</th>
						<th style="width: 5% background-color:#eeeeee; text-align: center;">환전날짜</th>
						<th style="width: 5% background-color:#eeeeee; text-align: center;">금액</th>
						<!-- <th style="width: 3% background-color:#eeeeee; text-align: center;">사용구분</th> -->
					</tr>
				</thead>
				<tbody>
					 <tr align="center" style="border-bottom: 1px solid #dee2e6;">
			  	<td colspan="5" style="border-right: 1px solid white; border-left: 1px solid white; font-size: 2.5em;" readonly>결제 정보가 없습니다.</td>
				</tbody>
		</c:if>
	
		</div>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script>
	function p1(){
		var num = Number($("#r1").text());
		$("#r1").text(num);
	}
	function p2(){
		var num = Number($("#r2").text());
		$("#r2").text(num);
	}
	function p3(){
		var num = Number($("#r3").text());
		$("#r3").text(num);
	}
	function p4(){
		var num = Number($("#r4").text());
		$("#r4").text(num);
	}
	function p5(){
		var num = Number($("#r5").text());
		$("#r5").text(num);
	}						
	
		memberNo = '${sessionScope.loginUser.mid}';
		emoney = '${sessionScope.loginUser.emoney}';
		
		$("input[type = button]").click(function(){
			$("#amount").text($(this).val());				
			refundEmoney = $(this).val();
			 
		});
		
		$("#refundFunction").click(function(){
				var ok = false;
				jQuery.ajax({
					url:"refundMemberEmoney.em",
					type: "POST",
					dataType: "json",
					data : {
						refundEmoney : refundEmoney  
					},
					success:function(data){
						console.log(data);
						if(data > 0){
							
							ok = true;
						}
					}
					
				}).done(function (data){
					if(ok){
						var msg = '환급신청되었습니다.';
						alert(msg);
						
					}else{
						var msg ='환급실패';
						
						alert(msg);
					}
		});
		});
		
		
		
		
		
	</script>		
</body>
</html>