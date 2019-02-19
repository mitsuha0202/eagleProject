<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<!-- jquery -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
   
   <!-- Semantic UI -->
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
   <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
   <!-- bootstrap -->
   
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
   <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
   <style>
   .searchBoard{
   	display:inline-block;
   }
   .boardViewArea{
   	width:1200px;
   	margin-top: 100px;
   	margin-left: auto;
   	margin-right: auto;
   }
   .pagingAndBI{
   	display:inline-block;
   }
   .ui simple dropdown item{
   	width:130px;
   	height: 65px;
   }
   
   
   </style>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="boardViewArea" align="center">
		<div class="boardHeader">
		<h1 class="ui header" align="left">자유게시판</h1>
		</div>
		<div class="searchArea" align="right">
			<div class="ui compact menu" style="width:150px; height:50px; margin-bottom: 5px;" >
			  <select class="ui dropdown" id="searchCondition" name="searchCondition" style="width:150px; height:50px;  font-size:1.3em">
				  <option value="title">제목</option>
				  <option value="writer">작성자</option>
				  <option value="content">내용</option>
			  </select>
			</div>
			<div class="ui icon input" style="height: 50px;">
			  <input type="search" placeholder="검색할 내용을 입력하세요" id="search" style="width:300px; height: 50px; margin-right: 15px;">
			  <button class="ui black button" style="width:80px; height: 50px" onclick="searchBoard();">검색</button>
			</div>
		</div>
	
		<c:if test="${!empty list}">
		<table class="ui black table" align="center" id="listArea">
		  <thead>
		    <tr align="center">
			    <th style="border-left: 1px solid white;">번호</th>
			    <th align="center">제목</th>
			    <th >글쓴이</th>
			    <th >등록일</th>
			    <th style="border-right: 1px solid white;">조회수</th>
		  	</tr>
		  </thead>
		  <tbody>  
		  <c:forEach var="b" items="${ list }">
		    <tr align="center">
		      <td style="border-left: 1px solid white;">${b.bid}</td>
		      <td>${b.bTitle}</td>
		      <td>${b.userName}</td>
		      <td>${b.writeDay}</td>
		      <td style="border-right: 1px solid white;">${b.bCount}</td>
		    </tr>
		  </c:forEach>
		  </tbody>
		</table>
		</c:if>
		<c:if test="${empty list}">
		<table class="ui black table" align="center" id="listArea">
		  <thead>
		    <tr align="center">
			    <th style="border-left: 1px solid white;">번호</th>
			    <th align="center">제목</th>
			    <th >글쓴이</th>
			    <th >등록일</th>
			    <th style="border-right: 1px solid white;">조회수</th>
		  	</tr>
		  </thead>
		  <tbody>
			  <tr align="center" style="border-bottom: 1px solid #dee2e6;">
			  	<td colspan="5" style="border-right: 1px solid white; border-left: 1px solid white; font-size: 2.5em;" readonly>게시물이 존재하지 않습니다.</td>
			  </tr>
		  </tbody>
		 </table>
		</c:if>

		<br>
				<!-- 페이징 버튼 영역 -->
		<div id="pagingArea" align="center">
			<c:if test="${ pi.currentPage <= 1 }">
				[이전]&nbsp;
			</c:if>
			<c:if test="${ pi.currentPage > 1 }">
				<c:url var="blistBack" value="/searchBoard.bo">
					<c:param name="searchCondition" value="writer"/>
					<c:param name="searchValue" value="민병현"/>
					<c:param name="currentPage" value="${pi.currentPage - 1}"/>
				</c:url>
				<a href = "${ blistBack }">[이전]</a> &nbsp;
			</c:if>
			
			<c:forEach var="p" begin="${ pi.startPage  }" end = "${pi.endPage}">
				<c:if test="${ p eq pi.currentPage }">
					<font color="red" size="4"><b>[${p}]</b></font>
				</c:if>
				<c:if test="${ p ne pi.currentPage }">
					<c:url var="blistCheck" value = "searchBoard.bo">
						<c:param name="searchCondition" value="writer"/>
						<c:param name="searchValue" value="민병현"/>
						<c:param name="currentPage" value="${p}"/>
					</c:url>
					<a href="${blistCheck}">${p}</a>
				</c:if>
			
			</c:forEach>
			
			
			<c:if test="${ pi.currentPage >= pi.maxPage }">
				&nbsp; [다음]
			</c:if>
			<c:if test="${pi.currentPage < pi.maxPage }">
				<c:url var="blistEnd" value="searchBoard.bo">
					<c:param name="searchCondition" value="writer"/>
					<c:param name="searchValue" value="민병현"/>
					<c:param name="currentPage" value="${ pi.currentPage + 1 }"></c:param>
				</c:url>
				<a href="${blistEnd}">&nbsp;[다음]</a>
			</c:if>
		</div>
		<div class="btnArea" align="right">
			<button class="ui black button" style="width:200px; font-size: 1.5rem;" onclick="insertBoard();">글쓰기</button>
		</div>
	</div>
	<script>
		function insertBoard() {
			 var loginUser = '${sessionScope.loginUser}';
			  if(loginUser == ""){
				 alert("회원만 이용가능합니다.")
			 }else{
				 location.href = "insertBoardView.bo";
			 } 
				
		}
		
		
		function searchBoard() {
			var searchCondition = $("#searchCondition").val();
			
			var searchValue = $("#search").val();
			
			console.log(searchCondition);
			console.log(searchValue);
			
			location.href = "searchBoard.bo?searchCondition="+searchCondition+"&searchValue="+searchValue;
		}
		
		$(function(){
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({"background":"darkgray","cursor":"pointer"})
			}).mouseout(function(){
				$(this).parent().css({"background":"white"});
			}).click(function(){
				var bid=$(this).parent().children().eq(0).text();
				
				console.log(bid);
				
				location.href="boardSelectOne.bo?bid="+bid;
			});
			
		})
	
	</script>
</body>
</html>