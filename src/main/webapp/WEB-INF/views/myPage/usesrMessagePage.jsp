<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../admin/include/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../eg/css/jquery.jqplot.css"/>
<link rel="stylesheet" href="../eg/css/jquery-ui.css"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css"/>
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
<meta charset="UTF-8">
<title>Message</title>
<style>
	.title{
		padding-top: 50px;
		padding-bottom: 50px;
		padding-left: 80px;
	}
	
	.searchArea{
		padding-left: 500px;
		padding-bottom: 80px;
	}
	
	#searchCondition{
		width: 100px;
	}
	
	#searchValue{
		position: absolute;
		top: 300px;
		left: 600px;
		width: 300px;
	}
	
	#searchBtn{
		position: absolute;
		text-align: center;
		top: 300px;
		left: 905px;
	}
	
	.btnArea{
		padding-left: 80px;
	}
</style>
</head>
<body>
	
	<!-- 헤더바 -->
	<jsp:include page="../common/header.jsp"/>
	
	<!-- 헤더바 밑 선 -->
	<hr class="firstLine">
	
	<!-- 페이지 제목 -->
	<div class="title"><h1>1대1 문의게시판</h1></div>
	<c:if test="${ !empty sessionScope.loginUser }">
	
	<!-- 검색부분 div -->
	<div class="searchArea">
		<div class="selectSize">
			<select class="form-control" id="searchCondition">
	  		<option>쪽지제목</option>	  		
			</select>
		</div>
		<div class="inputSize">
			<input class="form-control" id="searchValue" placeholder="검색할 내용을 입력해주세요.">
			<button class="ui black basic button" onclick="search();" id="searchBtn" style="height: 35px; width: 80px;">검색</button>
		</div>
	</div>
	
	<!-- 검색결과 테이블 -->
	
      <table class="table" style="width: 1500px; margin-left: auto; margin-right: auto;">
         <tr>
            <td class="firstTd"><input type="checkbox" id="checkAll" onclick="check();"></td>
            <td class="firstTd"><h5>번호</h5></td>
            <td class="firstTd"><h5 class="content">제목</h5></td>
            <td class="firstTd"><h5 class="content">보낸날짜</h5></td>
            <td class="firstTd"><h5 class="content">답변여부</h5></td>
         </tr>
         <c:if test="${ !empty list }">
         <c:forEach var="b" items="${ list }">
            <tr>
               <td><input type="checkbox" class="checkChild"></td> 
               <td name="choice">${ b.boardNo }</td>
               <td name="choice">${ b.title }</td>
               <td name="choice">${ b.writeDay }</td>
               <c:if test="${ b.replyStatus eq 'Y'}">
                  <td name="choice"><h5>답변완료</h5></td>
               </c:if>
               <c:if test="${ b.replyStatus eq 'N' }">
                  <td name="choice"><h5>답변대기</h5></td>
               </c:if>                  
            </tr>
         </c:forEach>
         </c:if>
         <c:if test="${ empty list }">
         	<tr>
         		<td colspan="5"><h5>검색된 내용이 없습니다.</h5></td>
         	</tr>
         </c:if>
      </table>

	
	<!-- 버튼 div -->
	<div class="btnArea">
		<button class="ui orange basic button"  data-toggle="modal" data-target="#exampleModal" style="height: 35px; width: 80px;">삭제</button>
		<button class="ui black basic button" data-target="#oneByOne" style="height: 35px; width: 105px;" onclick="location.href='onebyone.mp'">문의하기</button>
		<button class="ui black basic button"  data-target="#closeMessage" style="height: 35px; width: 80px;"onclick="location.href='myPageMain.mp'">닫기</button>
	</div>
	</c:if>
   <c:if test="${ empty sessionScope.loginUser }">
      <c:set var="message" value="로그인이 필요한 서비스입니다." scope="request"/>
      <jsp:forward page="../common/errorPage.jsp"/>
   </c:if>
   
   <!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">삭제하시겠습니까?</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
	        <button type="button" class="btn btn-primary" onclick="listDelete();">삭제하기</button>
	      </div>
	    </div>
	  </div>
	</div>
	
   <div id="pagingArea" class="numbox mt50">
         <c:if test="${ pi.currentPage <= 1 }">
            <span class="prevnc">이전</span>
         </c:if>
         <c:if test="${ pi.currentPage > 1 }">
            <c:url var="blistBack" value="userMessage.mp">
               <c:param name="currentPage" value="${ pi.currentPage - 1}"/>
            </c:url>
            <span><a class="prev" href="${ blistBack }">이전</a></span>
         </c:if>
         
         <c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
            <c:if test="${ p eq pi.currentPage }">
               <span><a class="num on" href="${ blistCheck }" style="background-color: #168;">${p}</a></span>
            </c:if>
            <c:if test="${ p ne pi.currentPage }">
               <c:url var="blistCheck" value="userMessage.mp">
                  <c:param name="currentPage" value="${p}"/>
               </c:url>
               <span><a class="num" href="${ blistCheck }">${ p }</a></span>
            </c:if>
         </c:forEach>
         
         <c:if test="${ pi.currentPage >= pi.maxPage }">
            <span class="nextnc">다음</span>
         </c:if>
         <c:if test="${ pi.currentPage < pi.maxPage }">
            <c:url var="blistEnd" value="userMessage.mp">
               <c:param name="currentPage" value="${ pi.currentPage + 1}"/>
            </c:url>
            <span><a class="next" href="${ blistEnd }">다음</a></span>
         </c:if>
      </div>
   
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script>
   		/* 체크박스 */
   		function check() {
	   		if( $("#checkAll").is(':checked') ){
	       		$(".checkChild").prop("checked", true);
	     	}else{
	       		$(".checkChild").prop("checked", false);
	     	}
   		}
   		
   		/* 삭제 리스트 */
   		function listDelete() {
   			var sendArr = new Array();
   			var checkbox = $(".checkChild:checked");
   		 	checkbox.each(function(i){
   		 		var tr = checkbox.parent().parent().eq(i);
   		 		var td = tr.children();
   	            var docNum = td.eq(1).text();
   	            sendArr.push(docNum);
 				location.href="deleteMessage.mp?deleteNum=" + sendArr +",";
   		 	}); 		 	
		}
   		
   		/* 검색 */
   		function search() {
			var searchCondition = $("#searchCondition").val();
			var searchValue = $("#searchValue").val();			
			console.log(searchCondition);
			console.log(searchValue);	
			location.href = "searchMessage.mp?searchCondition="+searchCondition+"&searchValue="+searchValue;
		}
   		
   		/* 상세보기  */
   		$("td[name=choice]").mouseenter(function() {
			$(this).css({"cursor":"pointer","background-color":"#EFFBFB"});
		}).mouseout(function() {
			$(this).css({"background":"white"});
		}).click(function() {
			var docno = $(this).parent().children().eq(1).text();
			location.href="detailMessage.mp?docNo=" + docno; 
		}); 
   </script>
</body>
</html>