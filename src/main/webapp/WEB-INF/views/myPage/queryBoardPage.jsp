<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의게시판</title>
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
	.queryInfo{
		position: absolute;
		left: 70px;
		top: 350px;
		background-color: lightgray;
		width: 1350px;
		height: 130px;
	}
	/* 테이블밖 div */
	.queryTableArea{
		position: absolute;
		left: 70px;
		top: 550px;
	}
	/* 테이블, tr, td */
	.queryTable, tr, td{
		border: 1px solid black;
		text-align: center;
	}
	/* 테이블 */
	.queryTable{
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
	}
	/* 검색부분 div */
	/* 검색 select태그부분 영역 */
	.selectSize{
		position: absolute;
		top: 180px;
		left: 25%;
		width: 9%;
	}
	/* 검색 input태그부분 */
	.inputSize{
		position: absolute;
		top: 180px;
		left: 35%;
		width: 30%;
	}
	/* 검색버튼 */
	.searchBtn{
		position: absolute;
		left: 65%;
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
	<div class="title"><h1>문의게시판</h1></div>
	
	<!-- 문의게시판 설명div -->	
	<div class="queryInfo">
		<h3>문의 게시판 안내</h3>
		<br>
		<p>&nbsp; &bull; 경매진행중에 문의한 게시판에서는 진행중인 물품에 문의한 모든 내용을 이곳에서 판매자의 답변을 확인 하실 수 있습니다.<br>&nbsp; &bull; 경매종료 후에 문의한 게시판에서는 낙찰받은 물품에 대해서 문의/협의(반품)사항에 대해 질문후 답변내용 확인 하실 수 있습니다.</p>
	</div>
	
	<div class="queryTableArea">
		<table class="queryTable">
			<tr>
				<td class="td1">번호</td>
				<td class="td1">물품번호</td>
				<td class="td1">제목</td>
				<td class="td1">답변</td>
				<td class="td1">판매자</td>
				<td class="td1">등록일</td>			
			</tr>
			<tr>
				<td colspan="6"><h5>검색된 내용이 없습니다.</h5></td>
			</tr>
		</table>
		<!-- 검색부분 div -->
			<div class="selectSize">
				<select class="form-control">
		  		<option>물품번호</option>
		  		<option>제목</option>
		  		<option>판매자</option>
				</select>
			</div>
			<div class="inputSize">
				<input class="form-control" id="searchContent" placeholder="내용을 입력해주세요.">
			</div>
			<button class="searchBtn">검색</button>
	</div>
	
	<button class="closeBtn" onclick="location.href='myPageMain.mp'">닫기</button>
</body>
</html>