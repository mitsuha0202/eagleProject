<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>구매종료</title>
</head>
<style>
      /* 구매현황 테이블 div */
	.buyStatus{
		position: absolute;
		left: 70px;
		top: 515px;
	}
	/* 구매현황 테이블, 판매현황 테이블 */
	.buyStatusTable, tr, td{
		border: 1px solid black;
		text-align: center;
		width: 1355px;
		height: 50px;
		cursor: pointer;
	}
	/* 테이블 맨윗줄 선 */
	.firstTd{
		border-top: 3.5px solid #205181;
		cursor: pointer;
	}
	
	/* 물품검색 조회리스트 */
	.resultitemlist{
		border: 1px solid #bcbcbc;
	}
	.tutorialDiv{
		background-color: lightgray;
		position: absolute;
		left: 70px;
		top: 1020px;
		width: 1355px;
		height: 200px;
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
		left: 850px;	
	}
	.tutorialIcon2{
		position: absolute;
		top: 140px;
		left: 1100px;	
	}
</style>
<body>
	<!-- 헤더바 -->
	<jsp:include page="../../common/header.jsp"/>
	
	<!-- 헤더바 밑 선 -->
	<hr class="firstLine">
	<h1>구매관리(구매종료)</h1>
    <div class="buyStatus">
		<table class="buyStatusTable">
			<tr>
				<td class="firstTd" onclick="location.href='purchasestatus.mp'">입찰중물품</td>
				<td class="firstTd" onclick="location.href='purchaseend.mp'">구매 종료</td>
				<td class="firstTd" onclick="location.href='purchaseitemdeal.mp'">구매 물품 거래 진행중</td>
				<td class="firstTd" onclick="location.href='purchaseother.mp'">구매거부/반품/미입금/판매거부/미수령신고</td>
			</tr>			
			<tr>
				<td><h5>경매상황</h5></td>
				<!-- td태그 오른쪽 선 안보이게 하기  -->
				<td style="border-right: hidden;" onclick="location.href='purchaseend.mp'"><h5>낙찰받은 물품</h5></td>
				<td style="border-right: hidden;" onclick="location.href='unsuccessbid.mp'"><h5>낙찰 받지 못한 물품</h5></td>
				<td></td>
			
				
				
			</tr>
			
			
			
		</table>
		
		 <h5>꼭 읽어주세요! </h5><br>
	     <h5>현재 입찰하신 물품중 낙찰받은 물품 리스트입니다.</h5>
	     <h5>거래하기 선택시 해당 판매자에게 신청되며 판매자가 거래하기 선택시 거래가 진행됩니다.</h5>
	     <h5>판매자가 거래거부시 판매자에게 패널티가 부여되며 거래가 종료됩니다.</h5>
	     <h5>구매거부하기 선택시 패널티가 부여되며 물품가격의 수수료를 제외한 나머지 금액을 돌려받게 됩니다.</h5>
	     <br>
	     <h5>낙찰된 물품에 대해서 모두 ${ fn:length(list) }건이 검색되었습니다.</h5>
	     
	     <table class="buyStatusTable">
      
      <thead>
        <tr>
     		<th class="firstTd">선택</th>	
		  <th class="firstTd">물품번호</th>
          <th class="firstTd">물품명</th>     
          <th class="firstTd">낙찰가</th>
          <th class="firstTd">마감일</th>
          <th class="firstTd">판매자</th>    
          <c:forEach var="b" items="${ list }">
          <c:if test="${ '거래신청' eq b.orderM }">
          	<th class="firstTd">거래신청유무</th>
          </c:if>
          </c:forEach>
          
        </tr>
      </thead>
      <tbody>
      
        <c:if test="${ !empty list }">
	      <c:forEach var="b" items="${ list }">
	            <tr>
	               <td><input type="radio" class="checkChild" name="gender"></td> 
	               <td>${ b.itemNo }</td>
	               <td>${ b.itemName }</td>
	               <td>${ b.currentPrice }</td>
				   <td>${ b.endDay }</td>
	               <td>${ b.saleMemberName }</td>      
	               <c:if test="${  b.orderM eq '거래신청' }">
	               	<td>Y</td>
	               </c:if>                      
	            </tr>
	         </c:forEach>
        </c:if>
        <c:if test="${ empty list }">
        	 <tr>
	          <td colspan="8"><h5>검색된 내용이 없습니다.</h5></td>	      
        	</tr>
        </c:if>
        
      </tbody>
     
    </table>
	     <button onclick="itemNo();">거래하기</button>
	     <button class="noPay">구매거부</button>
	</div>
	
		
	<div id="pagingArea" align="center">
			<c:if test="${ pi.currentPage <= 1 }">
				[이전] &nbsp;
			</c:if>
			<c:if test="${ pi.currentPage > 1 }">
				<c:url var="blistBack" value="purchasestatus.mp">
					<c:param name="currentPage" value="${ pi.currentPage - 1 }"/>
				</c:url>
				<a href="${ blistBack }">[이전]</a> &nbsp;
			</c:if>
			
			<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
				<c:if test="${ p eq pi.currentPage }">
					<font color="red" size="4"><b>[${ p }]</b></font>
				</c:if>
				<c:if test="${ p ne pi.currentPage }">
					<c:url var="blistCheck" value="purchasestatus.mp">
						<c:param name="currentPage" value="${ p }"/>
					</c:url>
					<a href="${ blistCheck }">${ p }</a>
				</c:if>
			</c:forEach>
			
			<c:if test="${ pi.currentPage >= pi.maxPage }">
				&nbsp; [다음]
			</c:if>
			<c:if test="${ pi.currentPage < pi.maxPage }">
				<c:url var="blistEnd" value="purchasestatus.mp">
					<c:param name="currentPage" value="${ pi.currentPage + 1 }"/>
				</c:url>
				<a href="${ blistEnd }">&nbsp;[다음]</a>
			</c:if>
		</div>
	
	<!-- 하단 div영역 -->
	<div class="tutorialDiv">
		<br>
		<h4 class="tutorialText1">고객센터 상담전화</h4>
		<br><br>
		<h4 class="tutorialText2">02-000-0000</h4>
		<h4 class="tutorialText3">평일 09:00~18:00</h4>&nbsp;<h4 class="tutorialText3">점심 12:00~13:00</h4>
		<h4 class="tutorialText4">토 일 공휴일 휴무</h4>
		<i class="clipboard icon" id="auctionInfo" onclick="location.href='egAuctionInfo.mp'"></i>
		<h4 class="tutorialIcon1" onclick="egAuctionInfo.mp">사이트이용안내</h4>
		<i class="dollar sign icon" id="accountInfo"></i>
		<h4 class="tutorialIcon2">자주묻는 질문</h4>		
	</div> 
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		function itemNo() {
   			var sendArr = new Array();
   			var sendCur = new Array();
   			var checkbox = $(".checkChild:checked");
   	        alert("거래가 신청되었습니다.");
   		 	checkbox.each(function(i){
   		 		var tr = checkbox.parent().parent().eq(i);
   		 		var td = tr.children();
   	            var docNum = td.eq(1).text();
   	            var current = td.eq(3).text();
   	            sendArr.push(docNum);
   	            sendCur.push(current);
 				location.href="insertDeal.mp?itemNo=" + sendArr +"," + "&currentPrice=" + sendCur;
   		 	}); 		 	
		}
		
		$(".noPay").click(function () {
			var answer = confirm("구매거부하시겠습니까?");
			if(answer == true){
				noPay();
			}
		});
		
		function noPay() {
			var sendArr = new Array();
   			var sendCur = new Array();
   			var checkbox = $(".checkChild:checked");
   	        alert("구매거부가 신청되었습니다.");
   		 	checkbox.each(function(i){
   		 		var tr = checkbox.parent().parent().eq(i);
   		 		var td = tr.children();
   	            var docNum = td.eq(1).text();
   	            var current = td.eq(3).text();
   	            sendArr.push(docNum);
   	            sendCur.push(current);
 				location.href="purchaseother.mp?itemNo=" + sendArr +"," + "&currentPrice=" + sendCur;
   		 	}); 	
		}
		
	</script>	
</body>
</html>