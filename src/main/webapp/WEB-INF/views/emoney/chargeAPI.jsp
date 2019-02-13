<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<title>Insert title here</title>
</head>
<body>
	
	<script type="text/javascript">
		var chargeMoney = <%= request.getParameter("chargeMoney")%>; 
		var memberNo = <%= request.getParameter("memberNo")%>;
		
			var IMP = window.IMP;
			IMP.init('imp79355376');
			
			IMP.request_pay({
				pg:'kakaopay',
				pay_method: 'card',
				merchant_uid: 'merchant_' + new Date().getTime(),
				name: 'eagle cash',
				amount: chargeMoeny,
				buyer_code : memberNo	
				
			}, function(rsp){
				jQuery.ajax({
		    		url: "/eg/saveCharge.em",
		    		type: 'POST',
		    		dataType: 'json',
		    		data: {
		    			buyer_code : memberNo, 
		    			amount : chargeMoney,
			    		imp_uid : rsp.imp_uid
		    		},
		    		success : function(data){
		    			if(data > 0) {
							page = "/eg/index.jsp";
							swal("Charge is complete!", "when you click 'OK'button return to mainPage", "success").then((value) =>{
								if(value = "ok"){
									location.href = page;
								}
							});
							
							
						}else {
							page = "/eg/views/common/errorPage.jsp";
							location.href = page;
						}
		    		}
		    	}).done(function(data) {
		    		if ( everythings_fine ) {
		    			var msg = '결제가 완료되었습니다.';
		    			msg += '\n고유ID : ' + rsp.imp_uid;
		    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
		    			msg += '\결제 금액 : ' + rsp.paid_amount;
		    			msg += '카드 승인번호 : ' + rsp.apply_num;
		    			
		    			alert(msg);
		    		} else {
		    		}
		    	});
				}else{
					var msg = '결제 실패';
					msg += '에러내용 : ' + rsp.error_msg;
				}
				alert(msg);			
			});		
		
	
	
	</script>
</body>
</html>