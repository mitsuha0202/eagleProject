<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 계좌관리</title>
<style>

	/* 페이지 제목 */
	.title{
		padding-top: 50px;
		padding-left: 80px;
		padding-bottom: 60px;
	}
	
	.accountInfo{
		padding-left: 80px;
		padding-bottom: 50px;
	}
	
	.btnArea{
		padding-left: 700px;
	}
	
	#updateBtn{
		height: 35px;
		width: 105px;
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
	
	<!-- 헤더바 밑 선 -->
	<hr class="firstLine">
	
	<!-- 마이페이지 제목 -->
	<div class="title"><h1>계좌관리</h1></div>
	
	<div class="accountInfo">
		<p>본인 명의의 계좌를 등록하여 주시기 바랍니다 (아이디 실명에 한하여 송금이 가능합니다.)<br>처음 계좌를 등록하시는 경우 계좌변경을 클릭해 등록해주세요.<br>계좌를 입력하지 않은 경우 물품 배송정보 확인 및 반품신청을 하실 수 없습니다.</p>
	</div>
	
	
		<table class="table" style="width: 1000px; margin-left: auto; margin-right: auto;">
			<c:if test="${ !empty maccount }">
			<tr>
				<td>은행명</td>
				<td><input type="text" class="form-control" value="${ maccount.bankName }" readonly="readonly" style="background-color: #FFFFFF"></td>
			</tr>
			<tr>
				<td>계좌번호</td>
				<td><input type="text" class="form-control" value="${ maccount.accountNo }" readonly="readonly" style="background-color: #FFFFFF"></td>
			</tr>
			<tr>
				<td>예금주</td>
				<td><input type="text" class="form-control" value="${ maccount.memberName }" readonly="readonly" style="background-color: #FFFFFF"></td>
			</tr>
			<tr>
				<td>등록일</td>
				<td><input type="text" class="form-control" value="${ maccount.createDay }" readonly="readonly" style="background-color: #FFFFFF"></td>
			</tr>
			</c:if>
			<c:if test="${ empty maccount }">
				<tr>
         			<td colspan="2"><h5>등록된 계좌가 없습니다.</h5></td>
         		</tr>
			</c:if>
		</table>
	<div class="btnArea">
		<button class="ui orange basic button" id="updateBtn" onclick="location.href='accountUpdate.mp'">계좌변경</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button class="ui black basic button" id="closeBtn" onclick="location.href='myPageMain.mp'">닫기</button>
	</div>	
</body>
</html>