<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message</title>
<style>
	/* 페이지 제목 밑 선 */
	.firstLine{
		border: 1px solid #205181;
	}
	/* 페이지 제목 */
	.title{
		position: absolute;
		top: 260px;
		left: 70px;
	}
	/* 검색부분 div */
	.searchArea{
		position: absolute;
		background-color: lightgray;
		top: 340px;
		left: 70px;
		width: 90%;
		height: 100px;
	}
	/* 검색 select태그부분 영역 */
	.selectSize{
		position: absolute;
		top: 33%;
		left: 10%;
		width: 9%;
	}
	/* 검색 input태그부분 */
	.inputSize{
		position: absolute;
		top: 33%;
		left: 20%;
		width: 30%;
	}
	/* 검색버튼 */
	.searchBtn{
		position: absolute;
		left: 52%;
		top: 33%;
		text-align: center;
		background-color: #205181;
		border: 1px solid white;
		color:white;
		border-radius: 10px;
		width: 80px;
		height: 35px;
	    font-size: 16px;
	}
	/* 테이블 div */
	.messageTableArea{
		position: absolute;
		top: 67%;
		left: 70px;
	}
	/* 테이블 */
	.messageTable, tr, td{
		border: 1px solid black;
		text-align: center;
		width: 1350px;
		height: 70px;
	}
	/* 첫번째 td */
	.firstTd{
		background-color: #205181;
		color: white;
	}
	/* 버튼영역 */
	.btnArea{
		position: absolute;
		top: 800px;
		left: 70px;
	}
	/* 삭제, 문의버튼 */
	.deleteBtn, .queryBtn{
		position: absolute;
		text-align: center;
		background-color: #205181;
		border: 1px solid white;
		color:white;
		border-radius: 10px;
		width: 150px;
		height: 40px;
	    font-size: 16px;

	}
	.queryBtn{
		left: 1100px;
	}
	/* 닫기버튼 */
	.closeBtn{
		position: absolute;
		top: 100px;
		left: 1100px;
		text-align: center;
		background-color: #205181;
		border: 1px solid white;
		color:white;
		border-radius: 10px;
		width: 150px;
		height: 40px;
	    font-size: 16px;
	}
	#checkAll, .checkChild{
		width: 17px;
		height: 17px;	
	}
	#pagingArea{
		position: absolute;
		top: 1000px;
		left: 45%;
	}
</style>
</head>
<body>
	
	<!-- 헤더바 -->
	<jsp:include page="../common/header.jsp"/>
	
	<!-- 헤더바 밑 선 -->
	<hr class="firstLine">
	
	<!-- 페이지 제목 -->
	<div class="title"><h1>쪽지보관함</h1></div>
	<c:if test="${ !empty sessionScope.loginUser }">
	<!-- 검색부분 div -->
	<div class="searchArea">
		<div class="selectSize">
			<select class="form-control" id="searchId">
	  		<option>쪽지제목</option>
			</select>
		</div>
		<div class="inputSize">
			<input class="form-control" id="searchContent" placeholder="검색할 내용을 입력해주세요.">
		</div>
		<button class="searchBtn" onclick="search();">검색</button>
	</div>
	
	<!-- 검색결과 테이블 -->
   <div class="messageTableArea">
      <table class="messageTable">
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
               <td>${ b.title }</td>
               <td>${ b.writeDay }</td>
               <c:if test="${ b.replyStatus eq 'Y'}">
                  <td><h5>답변완료</h5></td>
               </c:if>
               <c:if test="${ b.replyStatus eq 'N' }">
                  <td><h5>답변대기</h5></td>
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
   </div>
	
	<!-- 버튼 div -->
	<div class="btnArea">
		<button class="deleteBtn" onclick="listDelete();">삭제</button>
		<button class="queryBtn" onclick="location.href='onebyone.mp'">문의하기</button>
		<button class="closeBtn" onclick="location.href='myPageMain.mp'">닫기</button>
	</div>
	</c:if>
   <c:if test="${ empty sessionScope.loginUser }">
      <c:set var="message" value="로그인이 필요한 서비스입니다." scope="request"/>
      <jsp:forward page="../common/errorPage.jsp"/>
   </c:if>
   
   <div id="pagingArea" align="center">
			<c:if test="${ pi.currentPage <= 1 }">
				[이전] &nbsp;
			</c:if>
			<c:if test="${ pi.currentPage > 1 }">
				<c:url var="blistBack" value="userMessage.mp">
					<c:param name="currentPage" value="${ pi.currentPage - 1 }"/>
				</c:url>
				<a href="${ blistBack }">[이전]</a> &nbsp;
			</c:if>
			
			<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
				<c:if test="${ p eq pi.currentPage }">
					<font color="red" size="4"><b>[${ p }]</b></font>
				</c:if>
				<c:if test="${ p ne pi.currentPage }">
					<c:url var="blistCheck" value="userMessage.mp">
						<c:param name="currentPage" value="${ p }"/>
					</c:url>
					<a href="${ blistCheck }">${ p }</a>
				</c:if>
			</c:forEach>
			
			<c:if test="${ pi.currentPage >= pi.maxPage }">
				&nbsp; [다음]
			</c:if>
			<c:if test="${ pi.currentPage < pi.maxPage }">
				<c:url var="blistEnd" value="userMessage.mp">
					<c:param name="currentPage" value="${ pi.currentPage + 1 }"/>
				</c:url>
				<a href="${ blistEnd }">&nbsp;[다음]</a>
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
   	            alert("1대1 문의글 삭제완료");
 				location.href="deleteMessage.mp?deleteNum=" + sendArr +",";
   		 	}); 		 	
		}
   		
   		/* 검색 */
   		function search() {
			var search = $("#searchId").val();
			var searchTitle = $("#searchContent").val();
			location.href = "searchMessage.mp?search="+search+"&searchTitle="+searchTitle;
		}
   		
   		/* 상세보기  */
   		$("td[name=choice]").mouseenter(function() {
			$(this).css({"cursor":"pointer"});
		}).mouseout(function() {
			/* $(this).parent().css({"background":"white"}); */
		}).click(function() {
			var docno = $(this).parent().children().eq(1).text();
			console.log(docno);
			location.href="detailMessage.mp?docno=" + docno; 
		}); 
   </script>
</body>
</html>