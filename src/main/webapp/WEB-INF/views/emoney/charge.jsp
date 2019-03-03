<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
	int nowCash = (Integer)request.getAttribute("nowCash");
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
			<td><h5>보유 금액 : <c:out value="${ sessionScope.loginUser.emoney } 원"/></h5></td>
		</div>
		<br>
					<td style = "color : gray; "><h5>결제금액의 90%가 이머니로 충전됩니다.</h5></td>
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
					<br><br><br>					
					<td><h5><b>충전금액  </b></h5></td>
					<td id="tdChargeCashMoney"><label id="amount"><h5><b>0</label>원</b></h5></td>		
					<tr><td><button class="btn btn-warning"  id="chargeAPI" type="button" >카카오페이</button></td></tr>
			</table>
		</div>
	</div>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script>
			/* memberNo = '${SessionScope.loginUser.memberNo}'; */  
			memberNo = '${sessionScope.loginUser.mid}';
			emoney = '${sessionScope.loginUser.emoney}';
			
			$("input[type = radio]").click(function(){
				$("#amount").text($(this).val());				
				chargeMoney = $(this).val()*(0.9);
				 
			});
			
			$("#chargeAPI").click(function(){				
			var IMP = window.IMP;
			IMP.init('imp79355376');			
			IMP.request_pay({
				pg:'kakaopay',
				pay_method: 'card',
				merchant_uid: 'merchant_' + new Date().getTime(),
				name: 'eagle cash',
				amount: chargeMoney,
				buyer_code : memberNo
				
			}, function(rsp){
				console.log(rsp);
		    		if ( rsp.success ) {
		    			var ok = false;
		    			
		    			jQuery.ajax({
		    				url: "saveCharge.em",
		    	    		type: "POST",
		    	    		dataType: "json",
		    	    		data: {		    
		    	    			imp_uid : rsp.imp_uid,
		    		    		buyer_code : memberNo,
		    		    		amount : chargeMoney
		    	    		},
		    	    		success:function(data){
		    	    			console.log(data);
		    	    			if(data > 0){
		    	    				ok = true;
		    	    			}
		    	    		}
		    				
		    			}).done(function (data){
		    				if(ok){
			    				var msg = '결제가 완료되었습니다.';
				    			msg += '\n고유ID : ' + rsp.imp_uid;
				    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
				    			msg += '\결제 금액 : ' + rsp.paid_amount;
				    			msg += '카드 승인번호 : ' + rsp.apply_num;
				    			
				    			
				    			
				    			alert(msg);
		    				}else{
		    					
		    				}
		    			});
		    		}else{
		    			var msg = '결제 실패';
						msg += '에러내용 : ' + rsp.error_msg;	    			
					
						alert(msg);			
			}
		 }); 
		});
	
	</script>
 	
 	
 
	
</body>
</html>