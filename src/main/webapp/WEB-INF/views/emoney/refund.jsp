<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<!-- 메뉴바 -->
	<jsp:include page="../common/header.jsp" />

	<!-- /////////////////////////////////////////////////// -->
	<br>
	<br>
	<div class="container">
		<div class="title">
			<h1>환전</h1>
		</div>
		<br><br>

		<div>
			<td><h4>보유 이머니 : <c:out value="${ sessionScope.loginUser.emoney } 원"/></h4></td>
			
			<%-- <td>${  }</td> --%>
			
		</div> 
		<br>
		<div class="payChargeArea">
			<table class="chargeTable">
					<tr>
						<div class="btn-group btn-group-toggle" data-toggle="buttons" >							
							<td>
							<label class="btn btn-secondary" style="margin: 2px;">
							<input type="radio" name="amount" id="r1" value="1000" onclick="p1">1000원</label>
							</td>							
				            <td>
							<label class="btn btn-secondary" style="margin: 2px;">
							<input type="radio" name="amount" id="r2" value="5000" onclick="p2">5000원</label>
							</td>							
							<td>
							<label class="btn btn-secondary" style="margin: 2px;">
							<input type="radio" name="amount" id="r3" value="10000" onclick="p3">10000원</label>
							</td>							
							<td>
							<label class="btn btn-secondary" style="margin: 2px;">
							<input type="radio" name="amount" id="r4" value="50000" onclick="p4">50000원</label>
							</td>							
							<td>
							<label class="btn btn-secondary" style="margin: 2px;">
							<input type="radio" name="amount" id="r5" value="100000" onclick="p5">100000원</label>
							</td>							
							</label>
						</div>
					</tr>
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
						
					
					
					
					</script>
					<br>					
					<td>환급금액  </td>
					<td id="tdChargeCashMoney"><label id="amount">0</label>원</td>					
					<tr>
						<br>						
							<button class="btn btn-secondary" id="refundFunction" type="button" >환급신청</button>
							<br><br>
					</tr>
				</table>
			</div>
		</div>

	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script>
		memberNo = '${sessionScope.loginUser.mid}';
		emoney = '${sessionScope.loginUser.emoney}';
		
		$("input[type = radio]").click(function(){
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