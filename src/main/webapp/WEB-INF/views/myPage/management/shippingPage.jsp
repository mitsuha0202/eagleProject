<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<%@ include file="../../admin/include/common.jsp" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../eg/css/jquery.jqplot.css"/>
<link rel="stylesheet" href="../eg/css/jquery-ui.css"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css"/>
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>배송중</title>
</head>
<style>
    
    /* 내용들 */
	.content{
		padding-top: 80px;
		padding-left: 100px;
	}
	
	.content2{
		padding-left: 100px;
	}
	
	.table{
		text-align: center;
		width: 500px;
		margin-left: auto;
		margin-right: auto;
	}
    
</style>
<body>

<!-- 헤더바 -->
	<jsp:include page="../../common/header.jsp"/>
	
	<!-- 헤더바 밑 선 -->
	<hr class="firstLine">
	<h1>구매관리(구매 물품 거래 진행중)</h1>
    <div class="buyStatus">
		<table class="buyStatusTable">
			<tr>
				<td class="firstTd" onclick="location.href='purchasestatus.mp'" colspan="2">입찰중물품</td>
				<td class="firstTd" onclick="location.href='purchaseend.mp'" colspan="2">구매 종료</td>
				<td class="firstTd" onclick="location.href='purchaseitemdeal.mp'" colspan="2">구매 물품 거래 진행중</td>
				<td class="firstTd" onclick="location.href='purchaseother.mp'" colspan="2">구매거부/반품/미입금/판매거부/미수령신고</td>
			</tr>			
			<tr>
				<td><h5>거래상태</h5></td>
				<!-- td태그 오른쪽 선 안보이게 하기  -->
				<td style="border-right: hidden;" onclick="location.href='purchaseitemdeal.mp'"><h5>입금요청</h5></td>
				<td style="border-right: hidden;" onclick="location.href='requestdelivery.mp'"><h5>배송요청</h5></td>
				<td style="border-right: hidden;" onclick="location.href='shipping.mp'"><h5>배송중</h5></td>
				<td style="border-right: hidden;" onclick="location.href='purchasedecisionwaiting.mp'"><h5>구매결정대기</h5></td>
				<td style="border-right: hidden;" onclick="location.href='afterreceipt.mp'"><h5>수령이후/송금예정</h5></td>
				<td onclick="location.href='transactioncomplete.mp'"><h5>거래완료 물품</h5></td>
											
			</tr>
									
		</table>
		
		 <h5>꼭 읽어주세요! </h5><br>
	     <h5>구매물품거래진행중인 페이지 입니다.</h5>
	     <br>
	     <h5>배송중 물품에 대해서 모두 ${ fn:length(list) }개가 검색되었습니다.</h5>
	     
	     <table class="buyStatusTable">
      
      <thead>
        <tr>
          <th class="firstTd">물품번호</th>
          <th class="firstTd">물품명</th>
          <th class="firstTd">구매가격</th>
          <th class="firstTd">낙찰/구매일</th>
          <th class="firstTd">판매자</th>
        </tr>
      </thead>
      <tbody>
        <c:if test="${ !empty list }">
	      <c:forEach var="b" items="${ list }">
	            <tr>
	               <td>${ b.itemNo }</td>
	               <td>${ b.itemName }</td>
	               <td>${ b.currentPrice }</td>
				   <td>${ b.endDay }</td>
	               <td>${ b.saleMemberName }</td>                            
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
    	<button onclick="deliveryCheck();"></button>
	     <button onclick="noDelivery();">미수령신고</button>
	</div>
	
	<div id="pagingArea" align="center">
			<c:if test="${ pi.currentPage <= 1 }">
				[이전] &nbsp;
			</c:if>
			<c:if test="${ pi.currentPage > 1 }">
				<c:url var="blistBack" value="shipping.mp">
					<c:param name="currentPage" value="${ pi.currentPage - 1 }"/>
				</c:url>
				<a href="${ blistBack }">[이전]</a> &nbsp;
			</c:if>
			
			<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
				<c:if test="${ p eq pi.currentPage }">
					<font color="red" size="4"><b>[${ p }]</b></font>
				</c:if>
				<c:if test="${ p ne pi.currentPage }">
					<c:url var="blistCheck" value="shipping.mp">
						<c:param name="currentPage" value="${ p }"/>
					</c:url>
					<a href="${ blistCheck }">${ p }</a>
				</c:if>
			</c:forEach>
			
			<c:if test="${ pi.currentPage >= pi.maxPage }">
				&nbsp; [다음]
			</c:if>
			<c:if test="${ pi.currentPage < pi.maxPage }">
				<c:url var="blistEnd" value="shipping.mp">
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
	
	<script>
		function deliveryCheck() {
			var sendArr = new Array();
				var sendCur = new Array();
				var checkbox = $(".checkChild:checked");
		        /* alert("배송완료 처리되었습니다."); */
		        if(window.confirm("배송완료로 처리하시겠습니까?")){
			 	checkbox.each(function(i){
			 		var tr = checkbox.parent().parent().eq(i);
			 		var td = tr.children();
		            var docNum = td.eq(1).text();
		            var current = td.eq(3).text();
		            sendArr.push(docNum);
		            sendCur.push(current);
					location.href="deliveryCheck.mp?itemNo=" + sendArr +"," + "&currentPrice=" + sendCur;
			 	}); 	
			 	else {
			 		}
			 	}
		}	
	
		function noDelivery() {
			var sendArr = new Array();
   			var sendCur = new Array();
   			var checkbox = $(".checkChild:checked");
   	        /* alert("미수령신고가 신청되었습니다."); */
   	        if(window.confirm("미수령 신고 하시겠습니까?")){
   		 	checkbox.each(function(i){
   		 		var tr = checkbox.parent().parent().eq(i);
   		 		var td = tr.children();
   	            var docNum = td.eq(1).text();
   	            var current = td.eq(3).text();
   	            sendArr.push(docNum);
   	            sendCur.push(current);
 				location.href="notreceving.mp?itemNo=" + sendArr +"," + "&currentPrice=" + sendCur;
   		 	}); 	
   	        }else {
   	        	
   	        }
		}
	</script>
</body>
</html>