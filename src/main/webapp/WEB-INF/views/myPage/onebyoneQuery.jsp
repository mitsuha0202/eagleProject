<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1대1 문의게시판</title>
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
	/* 1대1문의게시판 설명 div */
	.onebyoneInfo{
		position: absolute;
		left: 70px;
		top: 350px;
		background-color: lightgray;
		width: 1350px;
		height: 130px;
	}
	/* 테이블 div 영역 */
	.writeFormDiv{
		position: absolute;
		left: 70px;
		top: 500px;
	}
	/* 테이블 */
	.writeForm, tr, td{
		border: 1px solid black;
	}
	.writeForm{
		width: 1000px;
	}
	#form1{
		width: 800px;
		position: absolute;
		top: 20px;
	}
	#form2{
		width: 800px;
		position: absolute;
		top: 60px; 
	}
	#formTextArea{
		width: 800px;
		height: 140px;
		position: absolute;
		top: 100px;
	}
	.successBtn{
		position: absolute;
		top: 300px;
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
	.cancelBtn{
		position: absolute;
		top: 300px;
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
	<div class="title"><h1>1대1 문의게시판</h1></div>
	
	<!-- 문의게시판 설명div -->	
	<div class="onebyoneInfo">
		<h3>1대1 문의 게시판 안내</h3>
		<br>
		<p>&nbsp; &bull;FAQ 검색에서 원하는 내용을 검색하시면 즉시 답변을 얻으실 수 있습니다.<br>&nbsp; &bull;물품문의는 판매자에게 해주시기바랍니다.<br>&nbsp; &bull;답변은 마이페이지 > 나의활동내역 > 1:1문의에서 확인 가능합니다.</p>
	</div>
	
	<div class="writeFormDiv">
		<form action="insertMessage.mp" method="post">
				<input class="form-control" id="form1" name="title" placeholder="제목을 입력해주세요.">
				<input class="form-control" value="${ sessionScope.loginUser.userName  }님" id="form2" name="name" readonly="readonly">
				<input type="hidden" name="memberNo" value="${ sessionScope.loginUser.mid  }">
				<textarea class="form-control" id="formTextArea" name="boardContents" placeholder="내용을 입력해주세요."></textarea>
				<button class="successBtn" type="submit">등록</button>
				<button class="cancelBtn" type="reset" onclick="location.href='userMessage.mp'">취소</button>
		</form>
	</div>
</body>
</html>