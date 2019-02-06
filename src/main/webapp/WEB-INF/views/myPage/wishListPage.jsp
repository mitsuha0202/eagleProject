<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>위시리스트</title>
<style>
	/* 페이지 제목 밑 선 */
	.firstLine{
		border: 1px solid #205181;
	}
	/* 페이지 제목 */
	.title{
		position: absolute;
		top: 200px;
		left: 70px;
	}
	.wishListInfo{
		position: absolute;
		top: 300px;
		left: 70px;
		width: 1350px;
		height: 100px;
		background-color: lightgray;
	}
	.wishTableArea{
		position: absolute;
		top: 450px;
		left: 70px;
	}
	.wishListTable, tr, td{
		border: 1px solid black;
		text-align: center;
	}
	.wishListTable{
		width: 1350px;
	}
	.wishDeleteBtn{
		position: absolute;
		top: 600px;
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
		top: 600px;
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
	
	<!-- 페이지 제목 -->
	<div class="title"><h1>위시리스트</h1></div>
	
	<div class="wishListInfo">
		<br>
		<p>회원님께서 관심물품으로 직접 등록하신 물품의 리스트입니다.<br>물품정보가 변경되었을 수 있으니 입찰하시기전에 반드시 경매정보 및 물품정보를 재확인하시기 바랍니다.<br>판매종료된 자료는 자동삭제됩니다.</p>
	</div>
	
	<div class="wishTableArea">
		<table class="wishListTable">
			<tr>
				<td><input type="checkbox" class="form-control" style="width: 17px; height: 17px; margin-left: auto; margin-right: auto;"></td>
				<td>번호</td>
				<td>카테고리</td>
				<td>물품번호</td>
				<td>물품명</td>
				<td>현재가</td>
				<td>입찰여부</td>
				<td>판매자</td>
				<td>마감일</td>				
			</tr>
			<tr>
				<td></td>
			</tr>
		</table>
	</div>
	<button class="wishDeleteBtn">삭제</button>
	<button class="closeBtn" onclick="location.href='myPageMain.mp'">닫기</button>
</body>
</html>