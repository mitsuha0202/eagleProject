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
<style>
	
</style>
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

			
			<td><h5>보유 금액 : <c:out value="${ sessionScope.loginUser.emoney } 원" /></h5></td>
			<%-- <td><h5>보유 금액 : <c:out value="${ emoney } 원" /></h5></td> --%>
			
			
		<br>
			<table class="chargeTable" >
						<h4><b>충전금액 : </b></h4>

						<div class="btn-group btn-group-toggle" data-toggle="buttons">
							<tr>
								 <td>
									<label  >
									<input type="button" class="btn btn-secondary btn-lg" name="amount" id="r1" value="1100" onclick="p1" ></label>
								</td>							
					            <td>
									<label  >
									<input type="button" class="btn btn-secondary btn-lg" name="amount" id="r2" value="5500" onclick="p2" ></label>
								</td>							
								<td>
									<label >
									<input type="button" class="btn btn-secondary btn-lg" name="amount" id="r3" value="11000" onclick="p3" ></label>
								</td>							
								<td>
									<label  >
									<input type="button" class="btn btn-secondary btn-lg" name="amount" id="r4" value="55000" onclick="p4" ></label>
								</td>							
								<td>
									<label >
									<input type="button" class="btn btn-secondary btn-lg" name="amount" id="r5" value="110000" onclick="p5" ></label>
								</td>
							</tr>								
							</div>				

			</table>	
							<tr>
								<td id="tdChargeCashMoney"><h3><b>선택한 금액 : <label id="amount">0</label>원 </b></h3></td>
								<td style = "color : gray; "><h5>선택한 충전 금액중 10%가 카드 수수료로 빠집니다.</h5></td>
							</tr>
											
					<br>		
					<td><button class="btn btn-warning"  id="chargeAPI" type="button" >카카오페이</button></td>

		
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
			/* memberNo = '${SessionScope.loginUser.memberNo}'; */  
			memberNo = '${sessionScope.loginUser.mid}';
		/* 	emoney = '${sessionScope.loginUser.emoney}'; 
			emoney = '$(m.setEmoney(emoney))'; */
			
			
			$("input[type = button]").click(function(){
				 $("#amount").text($(this).val()); 
				/* $('input[name=amount]').text($(this).val()); */
				/* chargeMoney = $(this).val()*(0.9); */
				chargeMoney = $(this).val();
				
				 
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
					    		    		amount : chargeMoney,
					    		    		
					    	    		},
					    	    		success:function(data){
					    	    			
					    	    			console.log(data);
					    	    			if(data > 0){
					    	    				ok = true;
					    	    				/* page = "charge.em";
					    	    				location.href= page; */
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