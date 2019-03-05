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
<title>구매결정대기</title>
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
    
    .btnArea{
    	padding-left: 100px;
  
    } 
	  
    #dealBtn{
    	text-align: center;
     	height: 50px;
    }
    
    #noPayBtn{
    	text-align: center;
    	height: 50px;
    }
</style>
<body>

	<!-- 헤더바 -->
	<jsp:include page="../../common/header.jsp"/>
	
	<div class="tabBigBox btab_2ea mt40" style="margin-left: auto; margin-right: auto; width: 1500px; padding-top: 100px; padding-bottom: 50px;">
				<ul style="padding-bottom: 100px;">
					<li style="width:25%;"><a href="purchasestatus.mp">입찰중물품</a></li>
					<li style="width:25%"><a href="purchaseend.mp">구매종료</a></li>
					<li class="on" style="width:25%"><a href="purchaseitemdeal.mp">구매 물품 거래 진행중</a></li>
					<li style="width:25%"><a href="purchaseother.mp">구매거부/반품/미입금/판매거부/미수령신고</a></li>
				</ul>
				<ul>
					<li style="width:20%"><a href="purchaseitemdeal.mp">입금요청</a></li>
					<li style="width:20%"><a href="requestdelivery.mp">배송요청</a></li>
					<li style="width:20%"><a href="shipping.mp">배송중</a></li>
					<li class="on" style="width:20%"><a href="purchasedecisionwaiting.mp">구매결정대기</a></li>
					<li style="width:20%"><a href="afterreceipt.mp">거래완료</a></li>
				</ul>
	</div>
		
	     <h5 class="content">구매결정대기 물품에 대해서 모두 ${ fn:length(list) }개가 검색되었습니다.</h5>
	     
	     <table class="table" style="width: 1500px;">
      
      <thead>
        <tr>
          <th scope="col">선택</th>	
          <th scope="col">물품번호</th>
          <th scope="col">물품명</th>
          <th scope="col">구매가격</th>
          <th scope="col">낙찰/구매일</th>
          <th scope="col">판매자</th>
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
	            </tr>
	         </c:forEach>
        </c:if>
        <c:if test="${ empty list }">
        	 <tr>
	          <td colspan="6"><h5>검색된 내용이 없습니다.</h5></td>	      
        	</tr>
        </c:if>        
        
      </tbody>
     
    </table>
    	<div class="btnArea">
			<button id="dealBtn" class="ui black basic button" data-toggle="modal" data-target="#exampleModal">구매확정</button>
			<button id="noPayBtn" class="ui orange basic button" data-toggle="modal" data-target="#noPay">반품</button>
		</div>
	
	<div id="pagingArea" class="numbox mt50">
         <c:if test="${ pi.currentPage <= 1 }">
            <span class="prevnc">이전</span>
         </c:if>
         <c:if test="${ pi.currentPage > 1 }">
            <c:url var="blistBack" value="purchasedecisionwaiting.mp">
               <c:param name="currentPage" value="${ pi.currentPage - 1}"/>
            </c:url>
            <span><a class="prev" href="${ blistBack }">이전</a></span>
         </c:if>
         
         <c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
            <c:if test="${ p eq pi.currentPage }">
               <span><a class="num on" href="${ blistCheck }" style="background-color: #168;">${p}</a></span>
            </c:if>
            <c:if test="${ p ne pi.currentPage }">
               <c:url var="blistCheck" value="purchasedecisionwaiting.mp">
                  <c:param name="currentPage" value="${p}"/>
               </c:url>
               <span><a class="num" href="${ blistCheck }">${ p }</a></span>
            </c:if>
         </c:forEach>
         
         <c:if test="${ pi.currentPage >= pi.maxPage }">
            <span class="nextnc">다음</span>
         </c:if>
         <c:if test="${ pi.currentPage < pi.maxPage }">
            <c:url var="blistEnd" value="purchasedecisionwaiting.mp">
               <c:param name="currentPage" value="${ pi.currentPage + 1}"/>
            </c:url>
            <span><a class="next" href="${ blistEnd }">다음</a></span>
         </c:if>
      </div>
	
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">구매확정하시겠습니까?</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
	        <button type="button" class="btn btn-primary" onclick="finish();">구매확정</button>
	      </div>
	    </div>
	  </div>
	</div>

	<div class="modal fade" id="noPay" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">반품 신청 하시겠습니까?</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
	        <button type="button" class="btn btn-primary" onclick="back();">반품하기</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		function finish() {
			if(!$(".checkChild:checked").val()){
				alert("물품을 선택해주세요.");
				location.reload();
			}else{
				var sendArr = new Array();
	   			var checkbox = $(".checkChild:checked");
	   	        /* alert("구매확정 되었습니다."); */
	   		 	checkbox.each(function(i){
	   		 		var tr = checkbox.parent().parent().eq(i);
	   		 		var td = tr.children();
	   	            var docNum = td.eq(1).text();
	   	            sendArr.push(docNum);
	 				location.href="afterreceipt.mp?itemNo=" + sendArr +",";
	   		 	}); 		
			}
		}
		
		function back() {
			var sendArr = new Array();
   			var checkbox = $(".checkChild:checked");
   	        /* alert("반품신청 되었습니다."); */
   		 	checkbox.each(function(i){
   		 		var tr = checkbox.parent().parent().eq(i);
   		 		var td = tr.children();
   	            var docNum = td.eq(1).text();
   	            sendArr.push(docNum);
 				location.href="return.mp?itemNo=" + sendArr;
   		 });
		}
	</script>
</body>
</html>