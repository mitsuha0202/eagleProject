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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>거래완료</title>
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
					<li style="width:25%;"><a href="salesstatus.mp">판매진행중</a></li>
					<li style="width:25%"><a href="endofsale.mp">판매종료</a></li>
					<li class="on" style="width:25%"><a href="salesitemprogress.mp">판매 물품 거래 진행중</a></li>
					<li style="width:25%"><a href="salesother.mp">구매거부/반품/미입금/판매거부/미수령신고</a></li>
				</ul>
				<ul>
					<li style="width:20%"><a href="salesitemprogress.mp">입금요청</a></li>
					<li style="width:20%"><a href="requestdelivery2.mp">배송요청</a></li>
					<li style="width:20%"><a href="shipping2.mp">배송중</a></li>
					<li style="width:20%"><a href="purchasedecisionwaiting2.mp">구매결정대기</a></li>
					<li class="on" style="width:20%"><a href="transactioncomplete2.mp">거래완료 물품</a></li>
				</ul>
		</div>
		
	     <h5 class="content">거래완료 물품에 대해서 모두 ${ fn:length(list) }개가 검색되었습니다.</h5>
	     
	     <table class="table" style="width: 1500px;">
      
      <thead>
        <tr>
           <th scope="col">물품번호</th>
          <th scope="col">물품명</th>
          <th scope="col">현재가</th>
          <th scope="col">낙찰자</th>
          <th scope="col">마감일</th>                    
        </tr>
      </thead>
      <tbody>
       <c:if test="${ !empty list }">
	      <c:forEach var="b" items="${ list }">
	            <tr>
	               <td>${ b.itemNo }</td>
	               <td>${ b.itemName }</td>
	               <td>${ b.currentPrice }</td>
	               <td>${ b.memberName }</td>
				   <td>${ b.endDay }</td>	                                  
	            </tr>
	         </c:forEach>
        </c:if>
        <c:if test="${ empty list }">
        	 <tr>
	          <td colspan="5"><h5>검색된 내용이 없습니다.</h5></td>	      
        	</tr>
        </c:if>
      </tbody>
     
    </table>
    
    <div id="pagingArea" class="numbox mt50">
         <c:if test="${ pi.currentPage <= 1 }">
            <span class="prevnc">이전</span>
         </c:if>
         <c:if test="${ pi.currentPage > 1 }">
            <c:url var="blistBack" value="transactioncomplete2.mp">
               <c:param name="currentPage" value="${ pi.currentPage - 1}"/>
            </c:url>
            <span><a class="prev" href="${ blistBack }">이전</a></span>
         </c:if>
         
         <c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
            <c:if test="${ p eq pi.currentPage }">
               <span><a class="num on" href="${ blistCheck }" style="background-color: #168;">${p}</a></span>
            </c:if>
            <c:if test="${ p ne pi.currentPage }">
               <c:url var="blistCheck" value="transactioncomplete2.mp">
                  <c:param name="currentPage" value="${p}"/>
               </c:url>
               <span><a class="num" href="${ blistCheck }">${ p }</a></span>
            </c:if>
         </c:forEach>
         
         <c:if test="${ pi.currentPage >= pi.maxPage }">
            <span class="nextnc">다음</span>
         </c:if>
         <c:if test="${ pi.currentPage < pi.maxPage }">
            <c:url var="blistEnd" value="transactioncomplete2.mp">
               <c:param name="currentPage" value="${ pi.currentPage + 1}"/>
            </c:url>
            <span><a class="next" href="${ blistEnd }">다음</a></span>
         </c:if>
      </div>	    
	
</body>
</html>