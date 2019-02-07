<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		top: 200px;
		left: 70px;
	}
	/* 검색부분 div */
	.searchArea{
		position: absolute;
		background-color: lightgray;
		top: 260px;
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
		top: 55%;
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
		top: 600px;
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
		top: 70px;
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
</style>
</head>
<body>
	
	<!-- 헤더바 -->
	<jsp:include page="../common/header.jsp"/>
	
	<!-- 헤더바 밑 선 -->
	<hr class="firstLine">
	
	<!-- 페이지 제목 -->
	<div class="title"><h1>쪽지보관함</h1></div>
	
	<!-- 검색부분 div -->
	<div class="searchArea">
		<div class="selectSize">
			<select class="form-control">
	  		<option>쪽지내용</option>
	  		<option>보낸사람</option>
			</select>
		</div>
		<div class="inputSize">
			<input class="form-control" id="searchContent" placeholder="내용을 입력해주세요.">
		</div>
		<button class="searchBtn">검색</button>
	</div>
	
	<!-- 검색결과 테이블 -->
	<div class="messageTableArea">
		<table class="messageTable">
			<tr>
				<td class="firstTd"><h5>번호</h5></td>
				<td class="firstTd"><h5 class="content">제목</h5></td>
				<td class="firstTd"><h5 class="content">보낸날짜</h5></td>
				<td class="firstTd"><h5 class="content">답변여부</h5></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>
	
	<!-- 버튼 div -->
	<div class="btnArea">
		<button class="deleteBtn">삭제</button>
		<button class="queryBtn" onclick="location.href='onebyone.mp'">문의하기</button>
		<button class="closeBtn" onclick="location.href='myPageMain.mp'">닫기</button>
	</div>
</body>
</html>