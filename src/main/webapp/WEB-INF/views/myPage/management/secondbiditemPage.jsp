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
<title>진행중인 차순위 입찰물품</title>
</head>
<style>
	
	.content{
		padding-top: 80px;
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
	
	<div class="tabBigBox btab_2ea mt40" style="margin-left: auto; margin-right: auto; width: 1500px; padding-top: 100px; padding-bottom: 50px;">
				<ul style="padding-bottom: 100px;">
					<li class="on" style="width:25%;"><a href="purchasestatus.mp">입찰중물품</a></li>
					<li style="width:25%"><a href="purchaseend.mp">구매종료</a></li>
					<li style="width:25%"><a href="purchaseitemdeal.mp">구매 물품 거래 진행중</a></li>
					<li style="width:25%"><a href="purchaseother.mp">구매거부/반품/미입금/판매거부/미수령신고</a></li>
				</ul>
				<ul>
					<li style="width:25%"><a href="highstbiditem.mp">진행중인 최고 입찰물품</a></li>
					<li class="on" style="width:25%"><a href="secondbiditem.mp">진행중인 차순위 입찰 물품</a></li>
				</ul>
	</div>
	
	<!-- 헤더바 밑 선 -->
	<!-- <hr class="firstLine">
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
				td태그 오른쪽 선 안보이게 하기 
				<td style="border-right: hidden;" onclick="location.href='highstbiditem.mp'"><h5>진행중인 최고 입찰물품</h5></td>
				<td style="border-right: hidden;" onclick="location.href='secondbiditem.mp'"><h5>진행중인 차순위 입찰 물품</h5></td>
				<td></td>											
			</tr>									
		</table> -->
	
	     <h5 class="content">진행중인 차순위 입찰 물품에 대해서 모두 ${ fn:length(list) }건이 검색되었습니다.</h5>
	     
	     <table class="table" style="width: 1500px;">
      
      <thead>
        <tr>
          <th scope="col">물품번호</th>
          <th scope="col">물품명</th>
          <th scope="col">현재가</th>
          <th scope="col">입찰 수</th>
          <th scope="col">판매자</th>
          <th scope="col">입찰 순위</th>
          <th scope="col">마감일</th>
          <th scope="col">마감상태</th>
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
	
	<div id="pagingArea" class="numbox mt50">
         <c:if test="${ pi.currentPage <= 1 }">
            <span class="prevnc">이전</span>
         </c:if>
         <c:if test="${ pi.currentPage > 1 }">
            <c:url var="blistBack" value="secondbiditem.mp">
               <c:param name="currentPage" value="${ pi.currentPage - 1}"/>
            </c:url>
            <span><a class="prev" href="${ blistBack }">이전</a></span>
         </c:if>
         
         <c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
            <c:if test="${ p eq pi.currentPage }">
               <span><a class="num on" href="${ blistCheck }" style="background-color: #168;">${p}</a></span>
            </c:if>
            <c:if test="${ p ne pi.currentPage }">
               <c:url var="blistCheck" value="secondbiditem.mp">
                  <c:param name="currentPage" value="${p}"/>
               </c:url>
               <span><a class="num" href="${ blistCheck }">${ p }</a></span>
            </c:if>
         </c:forEach>
         
         <c:if test="${ pi.currentPage >= pi.maxPage }">
            <span class="nextnc">다음</span>
         </c:if>
         <c:if test="${ pi.currentPage < pi.maxPage }">
            <c:url var="blistEnd" value="secondbiditem.mp">
               <c:param name="currentPage" value="${ pi.currentPage + 1}"/>
            </c:url>
            <span><a class="next" href="${ blistEnd }">다음</a></span>
         </c:if>
      </div>
		
</body>
</html>