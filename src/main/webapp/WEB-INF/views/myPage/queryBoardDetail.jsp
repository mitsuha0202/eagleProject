<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지함 상세보기</title>
<style>
	.tableArea{
		padding-top: 200px;
	}
	
	.btnArea{
		padding-left: 45%;
	}
	
	#closeBtn{
		height: 35px;
		width: 105px;
	}
</style>
</head>
<body>
	<!-- 헤더바 -->
	<jsp:include page="../common/header.jsp"/>

	<div class="tableArea">
		<table class="table" style="margin-left: auto; margin-right: auto; width: 1100px;">
			<tr>
				<td>글번호</td>
				<td><input class="form-control" value="${ myBoard.boardNo }" readonly="readonly" style="background-color: #FFFFFF"></td>
				<td>작성시간</td>
				<td><input class="form-control" value="${ myBoard.writeDay }" readonly="readonly" style="background-color: #FFFFFF"></td>				
			</tr>
			<tr>
				<td>작성자</td>
				<td><input class="form-control" value="${ sessionScope.loginUser.userName }" readonly style="background-color: #FFFFFF"></td>
				<td>판매자</td>
				<td><input class="form-control" value="${ myBoard.saleMemberName }" readonly="readonly" style="background-color: #FFFFFF"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3"><input class="form-control" value="${ myBoard.title }" readonly style="background-color: #FFFFFF"></td>	
			</tr>
			<tr>
				<td colspan="4"><textarea class="form-control" readonly="readonly" style="background-color: #FFFFFF; height: 200px;">${ myBoard.boardContents }</textarea></td>
			</tr>
			<c:if test="${myBoard.replyStatus eq 'Y'}">
				<tr>
					<td colspan="4"><textarea class="form-control" readonly="readonly" style="background-color: #FFFFFF; height: 200px;">${ myBoard.rContents }</textarea></td>
				</tr>
			</c:if>
		</table>
	</div>
		
	<div class="btnArea">
		<button id="closeBtn" class="ui black basic button" onclick="location.href='userMessage.mp'">닫기</button>
	</div>
</body>
</html>