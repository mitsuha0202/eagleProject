<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의받은 게시판</title>
<style>
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
	/* 문의게시판 설명div */
	.answerInfo{
		position: absolute;
		left: 70px;
		top: 350px;
		background-color: lightgray;
		width: 1350px;
		height: 130px;
	}
	/* 테이블밖 div */
	.answerTableArea{
		position: absolute;
		left: 70px;
		top: 550px;
	}
	/* 테이블, tr, td */
	.answerTable, tr, td{
		border: 1px solid black;
		text-align: center;
	}
	/* 테이블 */
	.answerTable{
		width: 1350px;
		height: 150px;
	}
	/* 첫번째 td */
	.td1{
		border-top: 2.5px solid black;
	}
	.closeBtn{
		position: absolute;
		top: 800px;
		left: 670px;
		text-align: center;
		background-color: #205181;
		border: 1px solid white;
		color:white;
		border-radius: 10px;
		width: 150px;
		height: 40px;
	    font-size: 16px;
	    cursor: pointer;
	}
	/* 검색부분 div */
	/* 검색 select태그부분 영역 */
	.selectSize{
		position: absolute;
		top: 180px;
		left: 25%;
		width: 10%;
	}
	/* 검색 input태그부분 */
	.inputSize{
		position: absolute;
		top: 180px;
		left: 36%;
		width: 30%;
	}
	/* 검색버튼 */
	.searchBtn{
		position: absolute;
		left: 67%;
		top: 180px;
		text-align: center;
		background-color: #205181;
		border: 1px solid white;
		color:white;
		border-radius: 10px;
		width: 80px;
		height: 35px;
	    font-size: 16px;
	}
</style>
</head>
<body>
	<!-- 헤더바 -->
	<jsp:include page="../common/header.jsp"/>
	
	<!-- 헤더바 밑 선 -->
	<hr class="firstLine">
	
	<!-- 마이페이지 제목 -->
	<div class="title"><h1>문의받은 게시판</h1></div>
	
	<!-- 문의게시판 설명div -->	
	<div class="answerInfo">
		<h3>문의 받은 게시판 안내</h3>
		<br>
		<p>&nbsp; &bull;진행중인 물품에 구매자가 문의한 내용입니다. 성실한 답변을 부탁드립니다.</p>
	</div>
	
	<div class="answerTableArea">
		<table class="answerTable">
			<tr>
				<td class="td1">번호</td>
				<td class="td1">물품번호</td>
				<td class="td1">제목</td>
				<td class="td1">답변여부</td>
				<td class="td1">아이디</td>
				<td class="td1">등록일</td>			
			</tr>
			<c:forEach var="a" items="${list }">
			<tr >
				<td name="boardresult" onclick="answerTableDetail();">${a.boardNo }</td>
				<td>${a.itemNo }</td>
				<td>${a.title }</td>
				<td>${a.replystatus }</td>
				<td>${a.memberId }</td>
				<td>${a.writeDay }</td>
			</tr>
			</c:forEach>
		</table>
		<!-- 검색부분 div -->
		
			<div class="selectSize">
				<select id="searchCondition" name="searchCondition">
		  			
		  		<option value="title">제목</option>
		  		<option value="writer">등록자아이디</option>
				</select>
			</div>
			<div class="inputSize">
				<input class="form-control" id="search" type="search" placeholder="내용을 입력해주세요.">
			</div>
			<button class="searchBtn" onclick="searchBoard();">검색</button>
	</div>
	
	<button class="closeBtn" onclick="location.href='myPageMain.mp'">닫기</button>
	
</body>
		
		 <!-- 페이징 버튼 영역 -->
		<%-- <div id="pagingArea" align="center">
			<c:if test="${ pi.currentPage <= 1 }">
				[이전]&nbsp;
			</c:if>
			<c:if test="${ pi.currentPage > 1 }">
				<c:url var="blistBack" value="/searchreanswer.mp">
					<c:param name="currentPage" value="${pi.currentPage - 1}"/>
				</c:url>
				<a href = "${ blistBack }">[이전]</a> &nbsp;
			</c:if>
			
			<c:forEach var="p" begin="${ pi.startPage  }" end = "${pi.endPage}">
				<c:if test="${ p eq pi.currentPage }">
					<font color="red" size="4"><b>[${p}]</b></font>
				</c:if>
				<c:if test="${ p ne pi.currentPage }">
					<c:url var="blistCheck" value = "searchreanswer.mp">
						<c:param name="currentPage" value="${p}"/>
					</c:url>
					<a href="${blistCheck}">${p}</a>
				</c:if>
			
			</c:forEach>
			
			
			<c:if test="${ pi.currentPage >= pi.maxPage }">
				&nbsp; [다음]
			</c:if>
			<c:if test="${pi.currentPage < pi.maxPage }">
				<c:url var="blistEnd" value="searchreanswer.mp">
					<c:param name="currentPage" value="${ pi.currentPage + 1 }"></c:param>
				</c:url>
				<a href="${blistEnd}">&nbsp;[다음]</a>
			</c:if>
		</div> --%>
		<script>
		
		
			$("td[name=boardresult]").click(function(){
				
				answerboardno = $(this).parent().children().eq(0).text();
				location.href='answerPageDetail.mp?answerboardno='+answerboardno;
			});
			
			function searchBoard(){
				var searchCondition = $("#searchCondition").val();
				var searchValue = $("#search").val();
				console.log(searchCondition);
				console.log(searchValue);
				location.href ="searchreanswer.mp?searchCondition="+searchCondition+"&searchValue="+searchValue;
				
			}
		
		
		</script>


</html>