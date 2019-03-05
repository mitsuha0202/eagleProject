<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<!-- jquery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	
	<!-- Semantic UI -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
	<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
	<!-- bootstrap -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	 



<style>
 	.cateRoute{
 		color:#1e90ff;
 	}
 	.line{
 		border:solid black 0.5px;
 	}
 	#priceName{
 		font-size:30px;
 		font-weight:550;
 	}
 	#won{
 		font-size:30px;
 		color:#1b5ac2;
 	}
 	#won2{
 		font-size:20px;
 	}
 	.tableHeader{
 		width:127px;
 	}
 	#bidBtn{
 		text-align:center;
 		background:#1b5ac2;
 		color:white;
 		width:220px;
 		height:45px;
 		font-size:20px;
 	}
 	#wishBtn{
 		text-align:center;
 		background:#8f784b;
 		color:white;
 		width:220px;
 		height:45px;
 		font-size:20px;
 	}
 	#qaBtn{
 		text-align:center;
 		background:#86899d;
 		color:white;
 		width:220px;
 		height:45px;
 		font-size:20px;
 	}
 	#reTime{
 		text-align:center;
 		background:#1b5ac2;
 		color:white;
 		width:220px;
 		height:auto;
 		font-size:15px;
 	}
 	a.step:hover{
 		text-decoration:none !important;
 	}
 	#qaBtn1{
 		margin-left:1290px;
 	}
 	#question{
 		height:35px;
 		width:130px;
 	}
 	#dImage{
 		text-align:center;
 	}
 	.boardTr:hover{
 		cursor:pointer;
 		background:#FAFAFA;
 	}
 	.boardDiv{
 		height:150px;
 	}
 	.boardP{
 		font-size:15px;
 		margin-left:30px;
 		padding-top:20px;
 	}
</style>

</head>
<body>
	<!-- navigation - header.jsp -->
	<jsp:include page="../common/header.jsp"/>
	<!-- 해당 페이지를 view_template파일과 다른 경로에 만들었다면 include path를 수정해야합니 -->
    <div class="ui grid">
        <div class = "two wide column"></div>
        <div class = "twelve wide column" style="margin-top:50px;">
        
        <div id="cateRoute" class="cateRoute">홈>의류>한정판</div>
        <br>
        <div id="pName" class="pName">
        	<h3>
        		<b id="productName"></b>
        	</h3>
        </div>
        <br>
        <hr class="line">
        <br>
        <div class="ui grid" style="clear:both;">
  			<div id="thumbNail" class="eight wide column">
  				
  			</div>
		  	<div class="eight wide column">
		  		<div class="ui equal width grid">
				  <div id="priceName" class="column">
				  	현재가
				  </div>
				  <div id="won" class="column">
				  	<a id="cPrice"></a><a id="won2">원</a>
				  </div>
				  <div class="column">
				  	<div id="reTime" class="ui massive label">
				  		<i id="remainTime" class="clock outline icon"></i> 
					</div>
				  </div>
				</div>
				
				<table class="ui definition table">
				  <tbody>
				    <tr>
				      <td class="tableHeader">
				      	물품번호<br>
				      	경매방식<br>
				      	<a id="auctionStime">경매기간</a><br>
				      	<a id="minPrice">시작가</a><br>
				      	<a id="maxPrice">입찰단위</a><br>
				      	
				      </td>
				      <td>
				      	<a id="itemNo"></a><br>
				      	<a id="auctionName"></a><br>
				     	<!-- 2019.02.12 11:00 ~ 2019.02.15 11:00 -->
				     	<a id="auctionStartTime"><a id="startDay"></a> ~ <a id="endDay"></a><a>
				     	<br>
				      	<a id="startPrice"></a>원<br>
				      	<a id="upPrice"></a>원</td>
				    </tr>
				    <tr>
				      <td class="tableHeader">
				      	배송방법<br>
				      	배송비용
				      </td>
				      <td>
				      	<a id="deliveryPay"></a><br>
				      	<a id="deliveryPrice"></a>원
				      </td>
				    </tr>
				    <tr>
				    	<td>원산지</td>
				    	<td><a id="origin"></a></td>
				    </tr>
				</tbody>
			</table>
			<br>
			<table class="ui definition table">
			  <tbody>
			    <tr>
			      <td class="tableHeader">
			      	판매자ID<br>
			      	판매자 등급<br>
			      </td>
			      <td>
			      	<a id="mId"></a><br>
			      	<a id="rating"></a><br>
			      </td>
			    </tr>
			</tbody>
		</table>
		<br>
		
		<div class="ui equal width grid">
			 <div class="column">
			  	<div id="bidBtn" class="ui massive label">
				  입찰하기
				</div>
			</div>
			<div class="column">
				<div id="wishBtn" class="ui massive label">
				  관심물품
				</div>
			</div>
			<div class="column">
				<div id="qaBtn" class="ui massive label">
				  문의하기
				</div>
			</div>
		</div>
				
		  	</div>
		</div>
		  				<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		
		<!-- 물품정보 -->
		
		<div id="productDetail" class="ui steps">
		  <a class="active step">
		    <div class="content">
		      <div class="title">물품정보</div>
		    </div>
		  </a>
		  <a href="#productQa" class="step">
		    <div class="content">
		      <div class="title">물품문의</div>
		    </div>
		  </a>
		  <a href="#delivery" class="step">
		    <div class="content">
		      <div class="title">배송/반품</div>
		    </div>
		  </a>
		</div>
		<br>
		<br>
		<!-- 물품정보 내용 -->
		
		
		<div id="dContent">
		
		</div>
		<br><br><br>
		
		<div id="dImage">
			
		</div>
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		
		
		<br>
        <!-- 물품문의 -->
        
        <div id="productQa" class="ui steps">
		  <a href="#productDetail" class="step">
		    <div class="content">
		      <div class="title">물품정보</div>
		    </div>
		  </a>
		  <a class="active step">
		    <div class="content">
		      <div class="title">물품문의</div>
		    </div>
		  </a>
		  <a href="#delivery" class="step">
		    <div class="content">
		      <div class="title">배송/반품</div>
		    </div>
		  </a>
		</div>
		<br>
		<!-- 물품문의 내용 -->
		
		<table class="ui fixed table">
		  <thead>
		    <tr>
			    <th>번호</th>
			    <th>제목</th>
			    <th>등록자</th>
			    <th>등록일</th>
		  	</tr>
		  </thead>
		  <tbody id="qaTable">
		    
		  </tbody>
		</table>
		
		<div id="qaBtn1">
			<button id="question" class="positive ui button">문의하기&nbsp;&nbsp;	
			<i class="pencil alternate icon"></i>
			</button>
		</div>
		
		
		<br>
		<!-- 배송/반품 -->
		
		<div id="delivery" class="ui steps">
		  <a href="#productDetail" class="step">
		    <div class="content">
		      <div class="title">물품정보</div>
		    </div>
		  </a>
		  <a href="#productQa" class="step">
		    <div class="content">
		      <div class="title">물품문의</div>
		    </div>
		  </a>
		  <a class="active step">
		    <div class="content">
		      <div class="title">배송/반품</div>
		    </div>
		  </a>
		</div>
		<br>
		<!-- 배송/반품 내용 -->
		
		<div class="ui blue segment" style="width:730px; height:50px;">
			<i class="volume up icon" style="color:#1b5ac2;"></i>
			전자상거래등에서 소비자보호에 관한 법률에 의한 반품규정이 판매자가 지정한 반품 조건보다 우선합니다.
		</div>
		<br>
		
		<table class="ui celled table">
		  <thead>
		    <tr>
			    <th>배송지역</th>
			    <td>전국※제주권 및 도서산간 지역은 배송비가 추가될 수 있습니다.</td>
		  	</tr>
		  	<tr>
			    <th>배송방법</th>
			    <td>택배, 선불/착불 [선/착불5,000원]</td>
		  	</tr>
		  	<tr>
			    <th>반품기간</th>
			    <td>수령일로 부터 7일 이내에 반품을 신청 하실 수 있습니다.</td>
		  	</tr>
		  	<tr>
			    <th>반품비용</th>
			    <td>원인제공자 부담을 원칙으로 합니다.</td>
		  	</tr>
		  </thead>
		</table>
		<br>
		<i class="check circle icon" style="color:#1b5ac2;"></i>
		<b>반품시 주의사항</b>
		<br><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;아래 각호의 경우에는 반품이 되지 않습니다.<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1) 소비자의 책임있는 사유로 상품등이 멸실 / 훼손된 경우(단지 확인을 위한 포장 훼손 제외)<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2) 소비자의 사용 / 소비에 의해 상품 등의 가치가 현저히 감소한 경우<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3) 시간의 경과에 의해 재판매가 곤란할 정도로 상품 등의 가치가 현저히 감소한 경우<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4) 복제가 가능한 상품 등의 포장을 훼손한 경우<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5) 판매 / 생산방식의 특성상, 반품 시 판매자 에게 회복할 수 없는 손해가 발생하는 경우(주문접수 후 개별생산, 맞춤 제작 등)<br>
		
		<br><br>
		<i class="check circle icon" style="color:#1b5ac2;"></i>
		<b>파손물품 반품시 주의사항</b>
		<br><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;물품 수령시 택배기사와 함께 물품의 파손여부를 확인하신 후,<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;반품 신청시 파손이미지를 등록해 주시면 안전하고 신속하게 환불처리를 해드리고 있습니다.
		
		<br><br>
		
		
		
		<br>
        
        
        
        
        <br>
          <!-- 내용 넣기 -->
        </div>
        <div class = "two wide column"></div>
   	</div>
   	
   	<c:if test="${(sessionScope.loginUser.mid ne '') and !(empty sessionScope.loginUser.mid)}">
	   	<input id="chat_id" type="hidden" value='${sessionScope.loginUser.userId }'>
   	</c:if>
   	
   	<!-- footer -->
</body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		function numComma(num){
	    	var numStr = String(num);
	    	return numStr.replace(/(\d)(?=(?:\d{3})+(?!\d))/g,"$1,");
	    }
		var time;
		var remainTime;
		var webSocket = new WebSocket('ws://localhost:8001/eg/broadcasting');
		$(function(){
			var currentPrice = 0;
			var bidUnit = 0;
			var mid = '${sessionScope.loginUser.mid}';
			var aCode = 'AC001';
			var itemNo;
			var minPrice;
			var maxPrice;
			var nowPrice;
			
			/* 경매정보 리스트 조회  */
			$.ajax({
				url:"auctionDetails.bi",
				type:"get",
				async:false,
				data:{itemNo : "6"},
				success:function(data){
					$("#itemNo").text(data.itemNo);
					$("#startPrice").text(numComma(data.startPrice));
					$("#auctionName").text(data.auctionName);
					$("#upPrice").text(numComma(data.bidUnit));
					$("#deliveryPay").text(data.deliveryPay);
					$("#deliveryPrice").text(numComma(data.deliveryPrice));
					$("#origin").text(data.origin);
					$("#mId").text(data.mId);
					$("#rating").text(data.rating);
					$("#productName").text(data.itemName);
					$("#dContent").text(data.detail);
					
					itemNo = data.itemNo;
					minPrice = data.startPrice;
					maxPrice = data.bidUnit;
					
					if(aCode == 'AC002'){
						$("#minPrice").text("최저가 범위");
						$("#maxPrice").text("최고가 범위");
					}
					if(aCode == 'AC003'){
						$("#auctionStime").text("경매 시작시간");
						var memberId;
						
						$.ajax({
							url:"compareMid.bi",
							type:"get",
							async:false,
							data:{itemNo : itemNo},
							success:function(data){
								memberId = data.memberId;
								console.log("최고가 회원아이디 조회 성공");
							},
							error:function(){
								console.log("최고가 회원아이디 조회 실패");	
							}
						});
						
						$.ajax({
							url:"selectPrice.bi",
							type:"get",
							async:false,
							data:{itemNo : itemNo},
							success:function(data){
								if(data.currentPrice != 0){
									currentPrice = data.currentPrice;
									$("#cPrice").text(memberId + " : " + numComma(currentPrice));
									nowPrice = currentPrice;
								}else{
									currentPrice = data.startPrice;
									$("#cPrice").text(numComma(data.startPrice));
									nowPrice = currentPrice;
								}
								
								console.log("현재가 조회 성공");
							},
							error:function(){
								console.log("현재가 조회 실패");
							}
						});
					}
					
					
					bidUnit = data.bidUnit;
					var itemNo = $("#itemNo").text();
					
					
					/* 썸네일 이미지 조회 */
					$.ajax({
						url:"selectThumbnail.bi",
						type:"get",
						data:{itemNo : itemNo},
						success:function(data){
							var $img = $("<img src='"+ data.root + data.changeName +"' style='width:650px; height:525px;'>");
							$("#thumbNail").append($img);
							console.log("썸네일 조회 성공");
						},
						error:function(){
							console.log("썸네일 조회 실패");
						}
					});
					
					
					/* 상세이미지 조회 */
					$.ajax({
						url:"selectDetailImage.bi",
						type:"get",
						data:{itemNo : itemNo},
						success:function(data){
							for(var key in data){
								var $img = $("<img src='"+ data[key].root + data[key].changeName +"' style='width:1200px; height:1000px;'>");
								$("#dImage").append($img);
								
							}
							console.log("상세이미지 조회 성공");
						},
						error:function(){
							console.log("상세이미지 조회 실패");
						}
					});
					
					/* 경매날짜 조회 */
					$.ajax({
						url:"selectDate.bi",
						type:"get",
						data:{itemNo : itemNo},
						success:function(data){
						 	if(aCode == 'AC003'){
						 		$("#auctionStartTime").text(data.startDay);
						 	}
						 	else{
								$("#startDay").text(data.startDay);
								$("#endDay").text(data.endDay);
						 	}
							
							console.log("날짜 조회 성공");
						},
						error:function(){
							console.log("날짜 조회 실패");					
						}
					});
					
					var sPrice;
					if(aCode == 'AC001'){
						
						/* 현재가 조회 */
						$.ajax({
								url:"selectPrice.bi",
								type:"get",
								async:false,
								data:{itemNo : itemNo},
								success:function(data){
									if(data.currentPrice != 0){
										currentPrice = data.currentPrice + bidUnit;
										$("#cPrice").text(numComma(currentPrice));
										sPrice = currentPrice;
									}else{
										currentPrice = data.startPrice;
										$("#cPrice").text(numComma(data.startPrice));
										sPrice = currentPrice;
									}
									
									console.log("현재가 조회 성공");
								},
								error:function(){
									console.log("현재가 조회 실패");
								}
						});
					}else if(aCode == 'AC002'){
						$("#won2").text('');
						$("#cPrice").text('미공개');
					}
					
					
					/* 문의게시판 조회 */
					$.ajax({
						url:"selectQa.bi",
						type:"get",
						data:{itemNo : itemNo},
						success:function(data){
							var count = 1;
							for(var key in data){
								var $qaTable = $("#qaTable");
								var $tr = $("<tr class='boardTr'>");
								var $td1 = $("<td>");
								var $td2 = $("<td>");
								var $td3 = $("<td>");
								var $td4 = $("<td>");
								var $div = $("<div class='boardDiv'>");
								var $p = $("<p class='boardP'>");
								
								$p.text(data[key].boardContent);
								$div.append($p);
								$td1.text(count);
								$td2.text(data[key].title);
								$td3.text(data[key].mName);
								$td4.text(data[key].writeDay);
								$tr.append($td1);
								$tr.append($td2);
								$tr.append($td3);
								$tr.append($td4);
								$qaTable.append($tr);
								$qaTable.append($div);
								count++;
								
								$(".boardDiv").hide();
							}
							var cnt = 0;
							
							$(".boardTr").click(function(){
								if(cnt == 0){
									$(this).next().show();
									cnt = 1;
								}
								else{
									$(this).next().hide();
									cnt = 0;
								}
							});
							
							console.log("문의게시판 조회 성공");
						},
						error:function(){
							console.log("문의게시판 조회 실패");	
						}
					});
					
					/* 남은시간 조회 */
					if(aCode != 'AC003'){
						$.ajax({
							url:"selectTime.bi",
							type:"get",
							async:false,
							data:{itemNo : itemNo},
							success:function(data){
								console.log(data.endDay);
								time = data.endDay;
								
								console.log("남은시간 조회 성공");
							},
							error:function(){
								console.log("남은시간 조회 실패");
							}
						});
					}
					else{
						$.ajax({
							url:"selectRealTime.bi",
							type:"get",
							async:false,
							data:{itemNo : itemNo},
							success:function(data){
								console.log(data.startDay);
								time = data.startDay;
								
								console.log("남은시간 조회 성공");
							},
							error:function(){
								console.log("남은시간 조회 실패");
							}
						});
						
						$.ajax({
							url:"selectTime.bi",
							type:"get",
							async:false,
							data:{itemNo : itemNo},
							success:function(data){
								remainTime = data.endDay;
								console.log("경매종료 남은시간 조회 성공");
								console.log("경매 종료까지 " + remainTime);
							},
							error:function(){
								console.log("경매종료 남은시간 조회 실패");
							}
						});
					}
					
					
					
					
					
					
					
					if(time > 0){
						/* 최고가 밀봉경매 입찰 */
						if(aCode == 'AC001'){
							$("#bidBtn").hover($("#bidBtn").css('cursor','pointer'),$("#bidBtn").css('cursor','cursor'));
							$("#bidBtn").click(function(){
								var itemNo = $("#itemNo").text();
								var maxMid = null;
								if(mid == ''){
									alert("로그인 후 이용하실 수 있습니다.");
								}
								else{
									$.ajax({
										url:"compareMid.bi",
										type:"get",
										async:false,
										data:{itemNo : itemNo},
										success:function(data){
											maxMid = data.memberNo;
		
											if(mid != maxMid){
												var itemNo = $("#itemNo").text();
												var price = sPrice;
												
												$.ajax({
													url:"insertBidding.bi",
													type:"get",
													async:false,
													data:{itemNo : itemNo , price : price , mid : mid},
													success:function(data){
														currentPrice = currentPrice + bidUnit;
														$("#cPrice").text(numComma(currentPrice));
														sPrice = currentPrice;
														
														alert("입찰이 완료되었습니다.");
														console.log("입찰 성공");
													},
													error:function(){
														console.log("입찰 실패");
													}
												});
											}else{
												alert("이미 최고가 입찰자입니다.");
											}
										},
										error:function(){
											console.log("비교실패");
										}
									});
								}
							});
							$("#wishBtn").hover($("#wishBtn").css('cursor','pointer'),$("#wishBtn").css('cursor','cursor'));
							
							/* 위시리스트 등록 */
							$("#wishBtn").click(function(){
								var itemNo = $("#itemNo").text();
								var mid = '${sessionScope.loginUser.mid}';
								
								$.ajax({
									url:"compareWish.bi",
									type:"get",
									data:{itemNo : itemNo , mNo : mid},
									success:function(data){
										console.log("위시리스트 비교 성공");
										if(data.mNo == "0"){
											$.ajax({
												url:"insertWishList.bi",
												type:"get",
												data:{itemNo : itemNo , mNo : mid},
												success:function(data){
													alert("위시리스트에 등록되었습니다.");
													console.log("위시리스트 등록성공");
												},
												error:function(){
													console.log("위시리스트 등록실패");
												}
											});
										}
										else{
											alert("이미 위시리스트에 등록된 경매물품 입니다.");
										}
									},
									error:function(){
										console.log("위시리스트 비교 실패");
									}
								});
							});
							
							
							/* 문의 게시판 등록 */
							$("#qaBtn").hover($("#qaBtn").css('cursor','pointer'),$("#qaBtn").css('cursor','cursor'));
							/* $("#qaBtn").click(function)(){
								
							} */
						}
						
						/* 행운경매 입찰 */
						else if(aCode == 'AC002'){
							$("#bidBtn").hover($("#bidBtn").css('cursor','pointer'),$("#bidBtn").css('cursor','cursor'));
							var startPrice = $("#startPrice").text();
							var upPrice = $("#upPrice").text();
							var msg = "입찰할 금액을 입력하세요. ( " + startPrice + " ~ " + upPrice + " 사이 가격을 입력하세요.) ";
							$("#bidBtn").click(function(){
								if(mid == ''){
									alert("로그인 후 이용하실 수 있습니다.");
								}else{
									/* 행운경매 입찰정보 비교 */
									$.ajax({
										url:"compareLuckyMno.bi",
										type:"get",
										data:{itemNo : itemNo , mNo : mid},
										success:function(data){
											if(mid == data.memberNo){
												var message = confirm("입찰정보가 있습니다. 다시 입력하시겠습니까?");
												if(message == true){
													var price = prompt(msg,"");
													if(price >= minPrice && price <= maxPrice && price != null){
														/* 행운경매 같은 가격 유무 비교 */
														$.ajax({
															url:"compareLuckyPrice.bi",
															type:"get",
															data:{itemNo : itemNo , price : price},
															success:function(data){
																console.log("가격 비교 성공");
																
																if(price == data.currentPrice){
																	alert("이미 등록된 입찰가 입니다.");
																}
																else{
																	/* 행운경매 입찰 업데이트 */
																	$.ajax({
																		url:"updateLuckyBid.bi",
																		type:"get",
																		data:{itemNo : itemNo , mNo : mid , price : price},
																		success:function(data){
																			alert("입찰가 수정이 완료되었습니다.");
																			console.log("행운경매 입찰수정 성공");
																		},
																		error:function(){
																			alert("입찰가 수정에 실패하셨습니다.");
																			console.log("행운경매 입찰수정 실패");
																		}
																	});
																}
															},
															error:function(){
																console.log("가격 비교 실패");
															}
														});
													}
													else{
														alert("입찰 범위에 맞는 가격을 입력해주세요.");
													}
												}
											}
											else{
												var price = prompt(msg,"");
												console.log(price);
												
												if(price >= minPrice && price <= maxPrice && price != null){
													/* 행운경매 같은 가격 유무 비교 */
													$.ajax({
														url:"compareLuckyPrice.bi",
														type:"get",
														data:{itemNo : itemNo , price : price},
														success:function(data){
															console.log("가격 비교 성공");
															
															if(price == data.currentPrice){
																alert("이미 등록된 입찰가 입니다.");
															}else{
																/* 행운경매 입찰 */
																$.ajax({
																	url:"insertLuckyBid.bi",
																	type:"get",
																	data:{itemNo : itemNo , mNo : mid , price : price},
																	success:function(data){
																		alert("입찰에 성공하셨습니다.");
																		console.log("행운경매 입찰에 성공하셨습니다.");
																	},
																	error:function(){
																		console.log("행운경매 입찰에 실패하셨습니다.");
																	}
																});	
															}
														},
														error:function(){
															console.log("가격 비교 실패");
														}
													});
													
												}else{
													alert("입찰 범위에 맞는 가격을 입력해주세요.");
												}
											}
											console.log("행운경매 입찰정보 비교 성공");
										},
										error:function(){
											console.log("행운경매 입찰정보 비교 실패");
										}
									});
								}
							});
							$("#wishBtn").hover($("#wishBtn").css('cursor','pointer'),$("#wishBtn").css('cursor','cursor'));
							
							/* 위시리스트 등록 */
							$("#wishBtn").click(function(){
								var itemNo = $("#itemNo").text();
								var mid = '${sessionScope.loginUser.mid}';
								
								$.ajax({
									url:"compareWish.bi",
									type:"get",
									data:{itemNo : itemNo , mNo : mid},
									success:function(data){
										console.log("위시리스트 비교 성공");
										if(data.mNo == "0"){
											$.ajax({
												url:"insertWishList.bi",
												type:"get",
												data:{itemNo : itemNo , mNo : mid},
												success:function(data){
													alert("위시리스트에 등록되었습니다.");
													console.log("위시리스트 등록성공");
												},
												error:function(){
													console.log("위시르스트 등록실패");
												}
											});
										}
										else{
											alert("이미 위시리스트에 등록된 경매물품 입니다.");
										}
									},
									error:function(){
										console.log("위시리스트 비교 실패");
									}
								});
							});
							
							
							/* 문의 게시판 등록 */
							$("#qaBtn").hover($("#qaBtn").css('cursor','pointer'),$("#qaBtn").css('cursor','cursor'));
							/* $("#qaBtn").click(function)(){
								
							} */
						}
						
						else if(aCode == 'AC003'){
							$("#bidBtn").css('background','gray');
							$("#wishBtn").css('background','gray');
							$("#qaBtn").css('background','gray');
							$("#bidBtn").hover($("#bidBtn").css('cursor','cursor'),$("#bidBtn").css('cursor','cursor'));
							$("#wishBtn").hover($("#wishBtn").css('cursor','cursor'),$("#wishBtn").css('cursor','cursor'));
							$("#qaBtn").hover($("#qaBtn").css('cursor','cursor'),$("#qaBtn").css('cursor','cursor'));
						}
						
						
						
					}
					else{
						if(aCode != 'AC003'){
							$("#bidBtn").css('background','gray');
							$("#wishBtn").css('background','gray');
							$("#qaBtn").css('background','gray');
							$("#reTime").css('background','gray');
							$("#bidBtn").hover($("#bidBtn").css('cursor','cursor'),$("#bidBtn").css('cursor','cursor'));
							$("#wishBtn").hover($("#wishBtn").css('cursor','cursor'),$("#wishBtn").css('cursor','cursor'));
							$("#qaBtn").hover($("#qaBtn").css('cursor','cursor'),$("#qaBtn").css('cursor','cursor'));
						}
						
						/* 실시간 경매  입찰 */
						else if(aCode == 'AC003'){
							if(remainTime > 0){
								/* 위시리스트 등록 */
								$("#wishBtn").click(function(){
									var itemNo = $("#itemNo").text();
									var mid = '${sessionScope.loginUser.mid}';
									
									if(mid == ''){
										alert("로그인 후 이용해주세요.");
									}
									else{
										$.ajax({
											url:"compareWish.bi",
											type:"get",
											data:{itemNo : itemNo , mNo : mid},
											success:function(data){
												console.log("위시리스트 비교 성공");
												if(data.mNo == "0"){
													$.ajax({
														url:"insertWishList.bi",
														type:"get",
														data:{itemNo : itemNo , mNo : mid},
														success:function(data){
															alert("위시리스트에 등록되었습니다.");
															console.log("위시리스트 등록성공");
														},
														error:function(){
															console.log("위시르스트 등록실패");
														}
													});
												}
												else{
													alert("이미 위시리스트에 등록된 경매물품 입니다.");
												}
											},
											error:function(){
												console.log("위시리스트 비교 실패");
											}
										});
									}
								});
								
								
								/* 문의 게시판 등록 */
								$("#qaBtn").hover($("#qaBtn").css('cursor','pointer'),$("#qaBtn").css('cursor','cursor'));
								/* $("#qaBtn").click(function)(){
									
								} */
								
								/* var webSocket = new WebSocket('ws://localhost:8001/eg/broadcasting'); */
								var inputPrice = "";
								var msg = "입찰할 금액을 입력하세요.";
								
								webSocket.onerror = function(event) {
							        onError(event)
							    };
							    webSocket.onopen = function(event) {
							        onOpen(event)
							    };
							    webSocket.onmessage = function(event) {
							        onMessage(event)
							    };	
								function onMessage(event){
									var message = event.data.split("|");
									var sender = message[0];
									var content = message[1];
									var reTime = message[2];
									
									console.log(message);
									if(content == ""){
										
									} else{
										$("#cPrice").html(sender + " : " + content);
										remainTime = reTime;
									}
								}
								function onOpen(event){
									console.log($("#chat_id").val());
								}
								function onError(event){
									alert(event.data);
								}
								$("#bidBtn").click(function(){
									if(mid == ''){
										alert('로그인 후 경매에 참여하실 수 있습니다.');
									}
									else{
										
										/* 실시간 경매 최고입찰자 비교 */
										$.ajax({
											url:"compareMid.bi",
											type:"get",
											async:false,
											data:{itemNo : itemNo},
											success:function(data){
												maxMid = data.memberNo;
												
												if(mid != maxMid){
													inputPrice = prompt(msg,"");
													
													if(inputPrice <= nowPrice && inputPrice != null){
														alert("현재가 보다 큰 가격을 입력해주세요.");
													} else {
														
														/* 실시간 경매 입찰 */
														$.ajax({
															url:"realTimeBid.bi",
															type:"get",
															async:false,
															data:{itemNo : itemNo , mNo : mid , price : inputPrice},
															success:function(data){
																nowPrice = inputPrice;
																
																alert("입찰가격이 등록되었습니다.");
																
																var nowTime;
																/* 현재 서버시간 조회 */
																$.ajax({
																	url:"selectTime.bi",
																	type:"get",
																	async:false,
																	data:{itemNo : itemNo},
																	success:function(data){
																		nowTime = data.startDay;
																		nowTime *= 1;
																		nowTime += 15000;
																		console.log("ㅇㅇㅇㅇㅇㅇ"+nowTime);
																		console.log("현재 서버시간 조회 성공");
																		
																		/* 실시간 경매 종료시간 증가 */
																		$.ajax({
																			url:"updateRealTime.bi",
																			type:"get",
																			async:false,
																			data:{itemNo : itemNo , nowTime : nowTime},
																			success:function(data){
																				/* 실시간 경매 남은시간 조회 */
																				$.ajax({
																					url:"selectTime.bi",
																					type:"get",
																					async:false,
																					data:{itemNo : itemNo},
																					success:function(data){
																						remainTime = data.endDay;
																						$("#cPrice").html($("#chat_id").val() + " : " + numComma(inputPrice));
																						webSocket.send($("#chat_id").val() + "|" + numComma(inputPrice) + "|" + remainTime);
																						inputPrice = "";
																						console.log("경매종료 남은시간 조회 성공");
																						console.log("경매 종료까지 " + remainTime);
																					},
																					error:function(){
																						console.log("경매종료 남은시간 조회 실패");
																					}
																				});
																				console.log("종료시간 증가 성공");
																			},
																			error:function(){
																				console.log("종료시간 증가 실패");
																			}
																		});
																	},
																	error:function(){
																		console.log("현재 서버시간 조회 실패");
																	}
																});
															},
															error:function(){
																console.log("실시간 입찰 실패");
															}
														});
													}
												}
												else{
													alert("현재 최고가 입찰자입니다.");
												}
											},
											error:function(){
												console.log("비교 실패");
											}
										});
									}
								});
								
							}
							else{
								$("#remainTime").text("경매종료");
								$("#bidBtn").css('background','gray');
								$("#wishBtn").css('background','gray');
								$("#qaBtn").css('background','gray');
								$("#reTime").css('background','gray');
								$("#bidBtn").hover($("#bidBtn").css('cursor','cursor'),$("#bidBtn").css('cursor','cursor'));
								$("#wishBtn").hover($("#wishBtn").css('cursor','cursor'),$("#wishBtn").css('cursor','cursor'));
								$("#qaBtn").hover($("#qaBtn").css('cursor','cursor'),$("#qaBtn").css('cursor','cursor'));
							}
						}
					}
					console.log("리스트 조회 성공");
				},
				error:function(){
					console.log("리스트 조회 실패");
				}
			});
			
			
			if(aCode != 'AC003'){
				/* 남은시간 스레드 */
				$(function(){
					function printTime(){
						time = time - 1000;								
						var ms = time / 1000;
						var day = Math.floor(ms / 86400);
						var hour = Math.floor((ms % 86400) / 3600);
						var min = Math.floor((ms % 3600) / 60);
						var sec = ms % 60;
						
						$("#remainTime").text("남은시간 " + day + "일 " + hour + "시간 " + min + "분 " + sec + "초");
					}
					
					var timeId;
					var itemNo = $("#itemNo").text();
						timeId = setInterval(function(){
							if(time > 0){
								printTime();
							}
							else{
								clearInterval(timeId);
								$("#remainTime").text("종료");
								$("#bidBtn").css('background','gray');
								$("#wishBtn").css('background','gray');
								$("#qaBtn").css('background','gray');
								$("#bidBtn").hover($("#bidBtn").css('cursor','cursor'),$("#bidBtn").css('cursor','cursor'));
								$("#wishBtn").hover($("#wishBtn").css('cursor','cursor'),$("#wishBtn").css('cursor','cursor'));
								$("#qaBtn").hover($("#qaBtn").css('cursor','cursor'),$("#qaBtn").css('cursor','cursor'));
								$("#reTime").css('background','gray');
								location.reload();
								
								
								/* 입찰종료 */
								$.ajax({
									url:"auctionFinish.bi",
									type:"get",
									data:{itemNo : itemNo},
									success:function(data){
										console.log("마감종료 성공");
									},
									error:function(){
										console.log("마감종료 실패");
									}
								});
							}
						},1000);
				});
			}
			else{
				/* 남은시간 스레드 */
				$(function(){
					var itemNo = $("#itemNo").text();
					
					/* 실시간 경매 남은시간 조회 */
					$.ajax({
						url:"selectTime.bi",
						type:"get",
						async:false,
						data:{itemNo : itemNo},
						success:function(data){
							remainTime = data.endDay;
							console.log("경매종료 남은시간 조회 성공");
							console.log("경매 종료까지 " + remainTime);
						},
						error:function(){
							console.log("경매종료 남은시간 조회 실패");
						}
					});
					
					if(remainTime > 0 && time < 0){
						$("#reTime").css('background','#1b5ac2');
						$("#bidBtn").css('background','#1b5ac2');
						$("#wishBtn").css('background','#8f784b');
						$("#qaBtn").css('background','#86899d');
						$("#bidBtn").hover($("#bidBtn").css('cursor','pointer'),$("#bidBtn").css('cursor','cursor'));
						$("#wishBtn").hover($("#wishBtn").css('cursor','pointer'),$("#wishBtn").css('cursor','cursor'));
						$("#qaBtn").hover($("#qaBtn").css('cursor','pointer'),$("#qaBtn").css('cursor','cursor'));
					}
					
					function printRemainTime(){
						remainTime = remainTime - 1000;								
						var ms = remainTime / 1000;
						var day = Math.floor(ms / 86400);
						var hour = Math.floor((ms % 86400) / 3600);
						var min = Math.floor((ms % 3600) / 60);
						var sec = ms % 60;
						
						$("#remainTime").text("경매종료 " + day + "일 " + hour + "시간 " + min + "분 " + sec + "초 전");
					}
					
					function printTime(){
						time = time - 1000;								
						var ms = time / 1000;
						var day = Math.floor(ms / 86400);
						var hour = Math.floor((ms % 86400) / 3600);
						var min = Math.floor((ms % 3600) / 60);
						var sec = ms % 60;
						
						$("#remainTime").text("경매시작 " + day + "일 " + hour + "시간 " + min + "분 " + sec + "초 전");
					}
					
					var timeId = null;
					var itemNo = $("#itemNo").text();
							timeId = setInterval(function(){
								if(time > 0){
									printTime();
								}
								else if(time == 0){
									time = time - 1;
									$("#bidBtn").css('background','#1b5ac2');
									$("#wishBtn").css('background','#8f784b');
									$("#qaBtn").css('background','#86899d');
									$("#bidBtn").hover($("#bidBtn").css('cursor','pointer'),$("#bidBtn").css('cursor','cursor'));
									$("#wishBtn").hover($("#wishBtn").css('cursor','pointer'),$("#wishBtn").css('cursor','cursor'));
									$("#qaBtn").hover($("#qaBtn").css('cursor','pointer'),$("#qaBtn").css('cursor','cursor'));
									alert("경매가 시작되었습니다.");
									location.reload();
									console.log(time);
								}
								else{
									if(remainTime > 0){
										printRemainTime();
									}
									else if(remainTime == 0){
										clearInterval(timeId);
										timeId = null;
										$("#remainTime").text("경매종료");
										$("#bidBtn").css('background','gray');
										$("#wishBtn").css('background','gray');
										$("#qaBtn").css('background','gray');
										$("#reTime").css('background','gray');
										$("#bidBtn").hover($("#bidBtn").css('cursor','cursor'),$("#bidBtn").css('cursor','cursor'));
										$("#wishBtn").hover($("#wishBtn").css('cursor','cursor'),$("#wishBtn").css('cursor','cursor'));
										$("#qaBtn").hover($("#qaBtn").css('cursor','cursor'),$("#qaBtn").css('cursor','cursor'));
										
										/* 실시간 경매 최고가 비교 */
										$.ajax({
											url:"compareMid.bi",
											type:"get",
											async:false,
											data:{itemNo : itemNo},
											success:function(data){
												if('${sessionScope.loginUser.mid}' == data.memberNo){
													alert("낙찰 되었습니다.");
												}
												else{
													alert("유찰 되었습니다.");
												}
											},
											error:function(){
												console.log("경매 종료");
											}
										});
										
										/* 실시간 경매 입찰종료 */
										$.ajax({
											url:"auctionFinish.bi",
											type:"get",
											data:{itemNo : itemNo},
											success:function(data){
												console.log("마감종료 성공");
											},
											error:function(){
												console.log("마감종료 실패");
											}
										});
										location.reload();
									}
								}
							},1000);
							
				});	
			}
		});
		
		
		
		
		
	</script>
</html>