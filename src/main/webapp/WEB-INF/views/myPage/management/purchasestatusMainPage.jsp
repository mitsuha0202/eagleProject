<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>구매관리</title>
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
	<h1>구매관리(입찰중물품)</h1>
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
				<td style="border-right: hidden;" onclick="location.href='highstbiditem.mp'"><h5>진행중인 최고 입찰물품</h5></td>
				<td style="border-right: hidden;" onclick="location.href='secondbiditem.mp'"><h5>진행중인 차순위 입찰 물품</h5></td>
				<td></td>
			
				
				
			</tr>
			
			
			
		</table>
		
		 <h5>꼭 읽어주세요! </h5><br>
	     <h5>현재 입찰하신 물품중 진행중인 물품 리스트입니다.</h5>
	      <h5>현재 입찰하신 물품에 대해서 모두 ${ fn:length(list) }건이 검색되었습니다.</h5>
	     <br>
	     <h5 id="countMainPayList"></h5>
	     
	     <table class="buyStatusTable">
      
      <thead>
        <tr>
          <th class="firstTd">물품번호</th>
          <th class="firstTd">물품명</th>
          <th class="firstTd">현재가</th>
          <th class="firstTd">입찰 수</th>
          <th class="firstTd">판매자</th>
          <th class="firstTd">입찰 순위</th>
          <th class="firstTd">마감일</th>
          <th class="firstTd">마감상태</th>
        </tr>
      </thead>
      <tbody>
      <c:if test="${ !empty list }">
	      <c:forEach var="b" items="${ list }">
	            <tr>
	               <td name="choice">${ b.itemNo }</td>
	               <td>${ b.itemName }</td>
	               <td>${ b.currentPrice }</td>
	               <td>${ b.bidCount }</td>
	               <td>${ b.saleMemberName }</td>
	               <td>${ b.rowBid }</td>
	               <td>${ b.endDay }</td>
	               <c:if test="${ b.endYn eq 'Y'}">
                  <td><h5>경매종료</h5></td>
               </c:if>
               <c:if test="${ b.endYn eq 'N' }">
                  <td><h5>경매중</h5></td>
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
	
	</script>
</body>
</html>