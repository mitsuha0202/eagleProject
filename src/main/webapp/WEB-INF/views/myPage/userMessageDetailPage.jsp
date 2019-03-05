<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지함 상세보기</title>
<style>
	.firstLine{
		border: 1px solid #205181;
	}
	/* 페이지 제목 */
	.title{
		position: absolute;
		top: 260px;
		left: 70px;
	}
	/* 테이블 밖 div */
	.tableArea{
		position: absolute;
		top: 350px;
		left: 70px;
	}
	/* 테이블, tr td 선추가 */
	.detailTable, tr, td{
		border-top: 1.5px solid black;
		border-bottom: 1px solid black;
	}
	tr, td{
		border-top: 1px solid gray;
		border-bottom: 1px solid gray;
	}
	/* 테이블 크기 */
	.detailTable{
		text-align: center;
		width: 1000px;
		height: 300px;
	}
	/* td에 색상주기 */
	.first{
		background-color: lightgray;
		width: 110px;
	}
	.form-control{
		width: 200px;
	}
	.closeBtn{
		position: absolute;
		top: 700px;
		left: 500px;
		text-align: center;
		background-color: #205181;
		border: 1px solid white;
		color:white;
		border-radius: 10px;
		width: 100px;
		height: 40px;
	    font-size: 16px;
	}
</style>
</head>
<body>
	<!-- 헤더바 -->
	<jsp:include page="../common/header.jsp"/>
	
	<!-- 헤더바 밑 선 -->
	<hr class="firstLine">
	
	<!-- 페이지 제목 -->
	<div class="title"><h1>상세보기</h1></div>
	<div class="tableArea">
		<table class="detailTable">
			<tr>
				<td class="first">글번호</td>
				<td><input class="form-control" value="${ myBoard.boardNo }" readonly></td>
				<td class="first">작성시간</td>
				<td><input class="form-control" value="${ myBoard.writeDay }" readonly></td>				
			</tr>
			<tr>
				<td  class="first">작성자</td>
				<td colspan="3"><input class="form-control" value="${ sessionScope.loginUser.userName }" readonly></td>	
			</tr>
			<tr>
				<td  class="first">제목</td>
				<td colspan="3"><input class="form-control" value="${ myBoard.title }" readonly></td>	
			</tr>
			<tr>
				<td colspan="4"><textarea class="form-control" readonly="readonly">${ myBoard.boardContents }</textarea></td>
			</tr>
			<c:if test="${myBoard.replyStatus eq 'Y'}">
				<tr>
					<td colspan="4"><textarea class="form-control" readonly="readonly">${ myBoard.rContents }</textarea></td>
				</tr>
			</c:if>
		</table>
	</div>
	<button class="closeBtn" onclick="location.href='userMessage.mp'">닫기</button>
</body>
</html>