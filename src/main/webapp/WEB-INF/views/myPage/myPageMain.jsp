<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myPageMain</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	#footer{ position:fixed; 
     left:0px; 
     bottom:10px; 
     height:60px; 
     width:100%; 
     color: black;
   }
	/* 페이지 제목 */
	.title{
		position: absolute;
		left: 70px;
		top: 200px;
	}
	/* 페이지 제목 밑 선 */
	.firstLine{
		border: 1px solid #205181;
	}
	/* 이름부분 div */
	.mpUserDiv{
		background-color: white;
		text-align: center;
		border: 1px solid #ddd;
		position: absolute;
		left: 70px;
		top: 260px;
		width: 340px;
		height: 170px;
	}
	/* 이름부분 div 버튼 */
	.mpUserDivBtn {
		text-align: center;
		background-color: white;
		border: 1px solid #2185d0;
		color:#2185d0;
		border-radius: 10px;
		width: 150px;
		height: 40px;
	    font-size: 16px;
	    cursor: pointer;
	}
	/* 쪽지함 div */
	.mpMessageDiv{
		text-align: center;
		border: 1px solid #ddd;
		position: absolute;
		top: 260px;
		left: 409px;
		width: 340px;
		height: 170px;
	}
	/* 쪽지함 div 버튼 */
	.mpMessageDivBtn{
		text-align: center;
		background-color: white;
		border: 1px solid #2185d0;
		color:#2185d0;
		border-radius: 10px;
		width: 150px;
		height: 40px;
	    font-size: 16px;
	    cursor: pointer;
	}
	/* 사이버머니 div */
	.mpMoneyDiv{
		text-align: center;
		border: 1px solid #ddd;
		position: absolute;
		top: 260px;
		left: 748px;
		width: 340px;
		height: 170px;
	}
	/* 사이버머니 div 버튼 */
	.mpMoneyDivAccountBtn{
		text-align: center;
		background-color: white;
		border: 1px solid #2185d0;
		color:#2185d0;
		border-radius: 10px;
		width: 150px;
		height: 40px;
	    font-size: 16px;
	    cursor: pointer;
	}
	/* 사이버머니 div 버튼 */
	.mpMoneyDivSendBtn{
		text-align: center;
		background-color: white;
		border: 1px solid #2185d0;
		color:#2185d0;
		border-radius: 10px;
		width: 72px;
		height: 40px;
	    font-size: 16px;
	}
	/* 사이버머니 div 버튼 */
	.mpMoneyDivGiveBtn{
		text-align: center;
		background-color: white;
		border: 1px solid #2185d0;
		color:#2185d0;
		border-radius: 10px;
		width: 72px;
		height: 40px;
	    font-size: 16px;
	}
	/* 위시리스트 div */
	.mpWishListDiv{
		text-align: center;
		border: 1px solid #ddd;
		position: absolute;
		top: 260px;
		left: 1087px;
		width: 340px;
		height: 170px;
		
	}
	/* 위시리스트 div 버튼 */
	.mpWishListDivBtn{
		text-align: center;
		background-color: white;
		border: 1px solid #2185d0;
		color:#2185d0;
		border-radius: 10px;
		width: 150px;
		height: 40px;
	    font-size: 16px;
	    cursor: pointer;
	}
	/* 구매현황 제목 */
	.buyTitle{
		position: absolute;
		left: 70px;
		top: 460px;
	}
	/* 구매현황 테이블 div */
	/* .buyStatus{
		position: absolute;
		left: 70px;
		top: 515px;
	} */
	/* 구매현황 테이블, 판매현황 테이블 */
	/* .buyStatusTable, tr, td{
		border: 1px solid black;
		text-align: center;
		width: 1355px;
		height: 50px;
	} */
	
	.buyStatusTable {
	  border-collapse: collapse;
	  border-top: 3px solid #168;
	  position: absolute;
		left: 70px;
		top: 515px;
		
		text-align: center;
		width: 1355px;
		height: 50px;
	}  
	.buyStatusTable th {
	  color: #168;
	  background: #f0f6f9;
	  text-align: center;
		width: 1355px;
		height: 50px;
	}
	.buyStatusTable th, .buyStatusTable td {
	  padding: 10px;
	  border: 1px solid #ddd;
	  text-align: center;
		width: 1355px;
		height: 50px;
	}
	.buyStatusTable th:first-child, .buyStatusTable td:first-child {
	  border-left: 0;
	  text-align: center;
		width: 1355px;
		height: 50px;
	}
	.buyStatusTable th:last-child, .buyStatusTable td:last-child {
	  border-right: 0;
	  text-align: center;
		width: 1355px;
		height: 50px;
	}
	/* 테이블 맨윗줄 선 */
	.firstTd{
		border-top: 3.5px solid #205181;
	}
	/* 판매현황 제목 */
	.saleTitle{
		position: absolute;
		left: 70px;
		top: 720px;
	}
	/* 판매현황 테이블 div */
	.saleStatus{
		position: absolute;
		left: 5px;
		top: 280px;
	}
	/* 하단 div 영역 */
	.tutorialDiv{
		background-color: #F2F2F2;
		position: absolute;
		left: 70px;
		top: 1020px;
		width: 1355px;
		height: 40px;
	}
	.tutorialText1{
		position: absolute;
		top: 30px;
		left: 100px;
	}
	.tutorialText2{
		position: absolute;
		top: 70px;
		left: 100px;
	}
	.tutorialText3{
		position: absolute;
		left: 280px;
		
	}
	.tutorialText4{
		position: absolute;
		top: 120px;
		left: 100px;
	}
	.tutorialIcon1{
		position: absolute;
		top: 140px;
		left: 1030px;	
	}
	.tutorialIcon2{
		position: absolute;
		top: 140px;
		left: 1200px;	
	}
	#auctionInfo{
		position: absolute;
		top: 120px;
		left: 1100px;	
	}
	#accountInfo{
		position: absolute;
		top: 10px;
		left: 1210px;
	}
	/* 구매현황 버튼 */
	.purchasestatus{
		text-align: center;
		background-color: white;
		border: 1px solid #205181;
		color:#205181;
		border-radius: 10px;
		position: absolute;
		width: 150px;
		height: 60px;
	    font-size: 16px;
	    right: 600px;
	    top: 450px;
	    cursor: pointer;
	}
	
	/* 판매현황 버튼 */
	.salesstatus{
		text-align: center;
		background-color: white;
		border: 1px solid #205181;
		color:#205181;
		border-radius: 10px;
		position: absolute;
		width: 150px;
		height: 60px;
	    font-size: 16px;
	    right: 600px;
	    top: 710px;
	    cursor: pointer;
	}
	/* 문의게시판 아이콘 */
	#queryBoard{
		position: absolute;
		top: 121px;
		left: 760px;
		cursor: pointer;
	}
	/* 문의게시판 글씨 */
	.tutorialIcon3{	
		position: absolute;
		top: 140px;
		left: 720px;
	}
	/* 문의받은 게시판 아이콘 */
	#answerBoard{
		position: absolute;
		top: 121px;
		left: 920px;
		cursor: pointer;
	}
	/* 문의받은게시판 글씨 */
	.tutorialIcon4{
		position: absolute;
		top: 140px;
		left: 860px;
	}
	.ui.basic.button{
		border-radius: 10px;
		width: 150px;
		height: 40px;
	    font-size: 16px;
		
	}
	
/* -------------------------------------------------------------------- */

	
	
</style>
</head>
<body>
	<!-- 헤더바 -->
	<jsp:include page="../common/header.jsp"/>
	
	<!-- 헤더바 밑 선 -->
	<hr class="firstLine">
	
	<!-- 마이페이지 제목 -->
	<div class="title"><h1>마이페이지</h1></div>
	
	<!-- 마이페이지 첫번째네비바 -->
	<div class="mpUserDiv">
		<br>
		<h5 style="color: black"><c:out value="${ sessionScope.loginUser.userName }님"/></h5>
		<h5 style="color: black">회원등급 <c:out value="${ rating }"/></h5>
		<h5 style="color: black">사이버머니 <c:out value="${ sessionScope.loginUser.emoney }원"/></h5>
		<!-- <button class="mpUserDivBtn" onclick="location.href='userGradeInfo.mp'">회원등급 혜택안내</button> -->
		<button class="ui basic button" onclick="location.href='userGradeInfo.mp'">회원등급 혜택</button>
	</div>
	
	<div class="mpMessageDiv">
		<br>
		
		<h5 id="messageCount">쪽지 0건</h5>
		<!-- <button class="mpMessageDivBtn" onclick="location.href='userMessage.mp'">나의 쪽지함</button> -->
		<button class="ui basic button" onclick="location.href='userMessage.mp'">나의 쪽지함</button><br><br>
		<input type="hidden" id="userMid" value="${ sessionScope.loginUser.mid }">
		<!-- <button class="mpMessageDivBtn" onclick="location.href='userInfoUpdatePage.mp'">나의정보수정</button> -->
		<button class="ui basic button" onclick="location.href='userInfoUpdatePage.mp'">나의정보수정</button><br>
	</div>
	<div class="mpMoneyDiv">
		<br>
		<h5>사이버머니</h5>
		<!-- <button class="mpMoneyDivAccountBtn" onclick="location.href='userAccount.mp'">계좌관리</button><br> -->
		<button class="ui basic button" onclick="location.href='userAccount.mp'">계좌관리</button><br><br>
		<!-- <button class="mpMoneyDivSendBtn">충전</button> -->
		<button class="ui basic button send" >충전</button>
		<!-- <button class="mpMoneyDivGiveBtn">환전</button> -->
		<button class="ui basic button give" >환전</button>
	</div>
	<div class="mpWishListDiv">
		<br>
		<h5>위시리스트</h5>
		<br>
		<!-- <button class="mpWishListDivBtn" onclick="location.href='wishList.mp'">위시리스트 보기</button> -->
		<button class="ui basic button" onclick="location.href='wishList.mp'">위시리스트</button><br>
	</div>
	
	<!-- 구매현황 제목 -->
	<div class="buyTitle"><h2>구매현황</h2></div>
	<button class="purchasestatus" onclick="location.href='purchasestatus.mp'">구매현황+</button>
	
	
	
	<!-- 구매현황 테이블 -->
	<div class="buyStatus">
		<table class="buyStatusTable">
			<tr>
				<td colspan="5" class="firstTd">주문/배송조회</td>
				<td colspan="5" class="firstTd">취소/반품/미수령</td>
			</tr>			
			<tr>
				<td><h5>입금요청</h5></td>
				<td><h5>배송요청</h5></td>
				<td><h5>배송중</h5></td>
				<td><h5>구매결정대기</h5></td>
				<td><h5>구매거부</h5></td>
				<td><h5>반품</h5></td>
				<td><h5>미수령</h5></td>
				<td><h5>미입금</h5></td>
				<td><h5>판매거부</h5></td>
			</tr>
			<tr id="one">
				<!-- <td class="one"></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td> -->
			</tr>
		</table>
	</div>
	
	<!-- 판매현황 제목 -->
	<div class="saleTitle"><h2>판매현황</h2></div>
	<button class="salesstatus" onclick="location.href='salesstatus.mp'">판매현황+</button>
	
	<!-- 판매현황 테이블 -->
	<div class="saleStatus">
		<table class="buyStatusTable">
			<tr>
				<td colspan="5" class="firstTd">주문/배송조회</td>
				<td colspan="5" class="firstTd">취소/반품/미수령</td>
			</tr>			
			<tr>
				<td><h5>입금요청</h5></td>
				<td><h5>배송요청</h5></td>
				<td><h5>배송중</h5></td>
				<td><h5>구매결정대기</h5></td>
				<td><h5>구매거부</h5></td>
				<td><h5>반품</h5></td>
				<td><h5>미수령</h5></td>
				<td><h5>미입금</h5></td>
				<td><h5>판매거부</h5></td>
			</tr>
			<tr>
				<td><h5 class="two"></h5></td>
				<td><h5></h5></td>
				<td><h5></h5></td>
				<td><h5></h5></td>
				<td><h5></h5></td>
				<td><h5></h5></td>
				<td><h5></h5></td>
				<td><h5></h5></td>
				<td><h5></h5></td>
			</tr>
		</table>
	</div>
	
	<!-- 하단 div영역 -->
	<div class="tutorialDiv">
		<br>
		<!-- <h4 class="tutorialText1">고객센터 상담전화</h4>
		<br><br>
		<h4 class="tutorialText2">02-000-0000</h4>
		<h4 class="tutorialText3">평일 09:00~18:00</h4>&nbsp;<h4 class="tutorialText3">점심 12:00~13:00</h4>
		<h4 class="tutorialText4">토 일 공휴일 휴무</h4>
		<i class="clipboard icon" id="auctionInfo" onclick="location.href='egAuctionInfo.mp'"></i>
		<h4 class="tutorialIcon1" onclick="egAuctionInfo.mp">사이트이용안내</h4>
		<i class="dollar sign icon" id="accountInfo" style="font-size: 90px;"></i>
		<h4 class="tutorialIcon2">자주묻는 질문</h4>		
		문의게시판
		<i class="clipboard icon" id="queryBoard" onclick="location.href='queryBoard.mp'"></i>
		<h4 class="tutorialIcon3" onclick="location.href='queryBoard.mp'">문의게시판</h4>
		문의받은 게시판
		<i class="clipboard icon" id="answerBoard" onclick="location.href='answerBoard.mp'"></i>
		<h4 class="tutorialIcon4" onclick="location.href='answerBoard.mp'" >문의받은게시판</h4> -->
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(function() {			
			var userId = $("#userMid").val();
			$.ajax({
				url:"countMessage.mp",
				type:"get",
				data:{userId:userId},
				success:function(data){
					$("#messageCount").text("쪽지 " + data + "건");
				},
				/* status는 에러의 상태를 나타냄 */
				error:function(status){
					$("#messageCount").text("쪽지 0건");
				}
			});
		});
		
		$(function() {
			var userId = $("#userMid").val();
			$.ajax({
				url:"getList.mp",
				type:"get",
				data:{userId:userId},
				success:function(data){
					var $tr = $("#one");
					for(var i = 0; i < 9; i++){
						var $td = $("<td>");
						$tr.append($td);
					}
					$.each(data, function(i, val) {
						if(userId == val.payNo){
							console.log("dd");
							if(val.orderM == "입금요청"){
								$tr.children().eq(0).text("1");
							}else if(val.orderM == "배송요청"){
								$tr.children().eq(1).text("1");
							}else if(val.orderM == "배송중"){
								$tr.children().eq(2).text("1");
							}else if(val.orderM == "배송완료"){
								$tr.children().eq(3).text("1");
							}else if(val.orderM == "구매거부"){
								$tr.children().eq(4).text("1");
							}else if(val.orderM == "반품"){
								$tr.children().eq(5).text("1");
							}else if(val.orderM == "미수령"){
								$tr.children().eq(6).text("1");
							}else if(val.orderM == "미입금"){
								$tr.children().eq(7).text("1");
							}else if(val.orderM == "판매거부"){
								$tr.children().eq(8).text("1");
							}
						}else {
							var $tr = $("#two");
							for(var i = 0; i < 9; i++){
								var $td = $("<td>");
								$tr.append($td);
							}
							if(val.orderM == "입금요청"){
								$tr.children().eq(0).text("1");
							}else if(val.orderM == "배송요청"){
								$tr.children().eq(1).text("1");
							}else if(val.orderM == "배송중"){
								$tr.children().eq(2).text("1");
							}else if(val.orderM == "구매결정대기"){
								$tr.children().eq(3).text("1");
							}else if(val.orderM == "구매거부"){
								$tr.children().eq(4).text("1");
							}else if(val.orderM == "반품"){
								$tr.children().eq(5).text("1");
							}else if(val.orderM == "미수령"){
								$tr.children().eq(6).text("1");
							}else if(val.orderM == "미입금"){
								$tr.children().eq(7).text("1");
							}else if(val.orderM == "판매거부"){
								$tr.children().eq(8).text("1");
							}
						}
					});
				},
				/* status는 에러의 상태를 나타냄 */
				error:function(status){
					alert("fu");
				}
			});
		});
	</script>
	<div id="footer">
      <div style="width:200px"></div>
      <jsp:include page="../myPage/common/myPageFooter.jsp" />
      </div>
</body>
</html>