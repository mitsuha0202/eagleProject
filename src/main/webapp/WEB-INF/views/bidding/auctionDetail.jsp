<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	 <script src="moment.min.js"></script>



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
 	#remainTime{
 		color:white !important;
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
 	#bidBtn:hover , #wishBtn:hover , #qaBtn:hover{
 		cursor:pointer;
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
  			<div class="eight wide column">
  				<img src="../views/images/image1.jpg">
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
				  		<i class="clock outline icon"></i>남은시간 <a id="remainTime">1일 2시간 16분 15초</a>
					</div>
				  </div>
				</div>
				
				<table class="ui definition table">
				  <tbody>
				    <tr>
				      <td class="tableHeader">
				      	물품번호<br>
				      	경매방식<br>
				      	경매기간<br>
				      	시작가<br>
				      	입찰단위<br>
				      	
				      </td>
				      <td>
				      	<a id="itemNo"></a><br>
				      	<a id="auctionName"></a><br>
				     	<!-- 2019.02.12 11:00 ~ 2019.02.15 11:00 -->
				     	<a id="startDay"></a> ~ <a id="endDay"></a>
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
			      	판매자 다른물품<br>
			      </td>
			      <td>
			      	<a id="mId"></a><br>
			      	<a id="rating"></a><br>
			      	없 음<br>
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
		<!-- 물품정보 내용 -->
		
		
		물품정보 내용 & 사진
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
		  <tbody>
		    <tr>
		      <td>1</td>
		      <td>문의요</td>
		      <td>황인용</td>
		      <td>2019 - 02 - 11</td>
		    </tr>
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
   	
   	<!-- footer -->
</body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<script>
		function numComma(num){
	    	var numStr = String(num);
	    	return numStr.replace(/(\d)(?=(?:\d{3})+(?!\d))/g,"$1,");
	    }
	
		$(function(){
			var currentPrice = 0;
			var bidUnit = 0;
			var mid = '${sessionScope.loginUser.mid}';

			$.ajax({
				url:"auctionDetails.bi",
				type:"get",
				data:{itemNo : "6"},
				success:function(data){
					$("#itemNo").text(data.itemNo);
					$("#startPrice").text(numComma(data.startPrice));
					$("#auctionName").text(data.auctionName);
					$("#upPrice").text(numComma(data.bidUnit));
					/* $("#startDay").text(data.startDay);
					$("#endDay").text(data.endDay); */
					$("#deliveryPay").text(data.deliveryPay);
					$("#deliveryPrice").text(numComma(data.deliveryPrice));
					$("#origin").text(data.origin);
					$("#mId").text(data.mId);
					$("#rating").text(data.rating);
					$("#productName").text(data.itemName);
					
					bidUnit = data.bidUnit;
					var itemNo = $("#itemNo").text();
	
					$.ajax({
						url:"selectDate.bi",
						type:"get",
						data:{itemNo : itemNo},
						success:function(data){
							var date = new Date(data.startDay);
							
						 
							alert(date);
							alert(date);
							$("#startDay").text(date);
							$("#endDay").text(data.endDay);
							console.log("날짜조회 성공");
						},
						error:function(){
							console.log("날짜조회 실패");					
						}
					});
					
					$.ajax({
							url:"selectPrice.bi",
							type:"get",
							data:{itemNo : itemNo},
							success:function(data){
								console.log(data);
								if(data.currentPrice != 0){
									currentPrice = data.currentPrice + bidUnit;
									$("#cPrice").text(numComma(currentPrice));
								}else{
									currentPrice = data.startPrice;
									$("#cPrice").text(numComma(data.startPrice));
								}
								
								console.log("현재가 조회성공");
							},
							error:function(){
								console.log("현재가 조회실패");
							}
					});
					
					$("#bidBtn").click(function(){
						var itemNo = $("#itemNo").text();
						var maxMid = null;
						$.ajax({
							url:"compareMid.bi",
							type:"get",
							data:{itemNo : itemNo},
							success:function(data){
								maxMid = data.memberNo;

								if(mid != maxMid){
									var itemNo = $("#itemNo").text();
									var price = $("#cPrice").text();
									
									$.ajax({
										url:"insertBidding.bi",
										type:"get",
										data:{itemNo : itemNo , price : price , mid : mid},
										success:function(data){
											currentPrice = currentPrice + bidUnit;
											$("#cPrice").text(numComma(currentPrice));
											
											console.log("입찰성공");
										},
										error:function(){
											console.log("입찰실패");
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
					});
					
					console.log("성공");
				},
				error:function(){
					console.log("실패");
				}
			});
		});
		
		
		
		
		
	</script>
</html>