<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 계좌관리</title>
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
	.accountInfo{
		position: absolute;
		left: 70px;
		top: 270px;
	}
	.accountTableArea{
		position: absolute;
		left: 70px;
		top: 500px;
	}
	.accountTable, tr, td{
		border: 1px solid black;
		text-align: center;
	}
	.accountTable{
		width: 1350px;	
		height: 300px;
	}
	.updateBtn{
		position: absolute;
		top: 900px;
		left: 550px;
		text-align: center;
		background-color: #205181;
		border: 1px solid white;
		color:white;
		border-radius: 10px;
		width: 150px;
		height: 40px;
	    font-size: 16px;
	}
	.closeBtn{
		position: absolute;
		top: 900px;
		left: 750px;
		text-align: center;
		background-color: #205181;
		border: 1px solid white;
		color:white;
		border-radius: 10px;
		width: 150px;
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
	
	<!-- 마이페이지 제목 -->
	<div class="title"><h1>계좌관리</h1></div>
	
	<div class="accountInfo">
		<p>본인 명의의 계좌를 등록하여 주시기 바랍니다 (아이디 실명에 한하여 송금이 가능합니다.)<br>환불 및 판매대금을 송금 받고자 하는 계좌번호를 등록해주세요.<br>계좌를 입력하지 않은 경우 물품 배송정보 확인 및 반품신청을 하실 수 없습니다.</p>
	</div>
	
	<div class="accountTableArea">
		<table class="accountTable">
			<tr>
				<td>은행명</td>
				<td>제주은행</td>
			</tr>
			<tr>
				<td>계좌번호</td>
				<td>000</td>
			</tr>
			<tr>
				<td>예금주</td>
				<td>OOO</td>
			</tr>
			<tr>
				<td>등록일</td>
				<td>2019-02-01</td>
			</tr>
		</table>
	</div>
	<button class="updateBtn" onclick="location.href='accountUpdate.mp'">계좌변경</button>
	<button class="closeBtn" onclick="location.href='myPageMain.mp'">닫기</button>
</body>
</html>