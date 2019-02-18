<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문의받은게시판 답변페이지</title>
</head>
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
		top: 80px;
	}
	#form2{
		width: 800px;
		position: absolute;
		top: 40px; 
	}
	#form3{
		width: 800px;
		position: absolute;
		top: 0px; 
	}
	#formTextArea{
		width: 800px;
		height: 140px;
		position: absolute;
		top: 120px;
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
	<div class="title"><h1>답변 페이지</h1></div>
	<div class="onebyoneInfo">
		<h3>답변 페이지</h3>
		<br>
		<p>&nbsp; &bull;답변페이지 입니다.<br>&nbsp; &bull;보내기를 누르면 해당 아이디에 답변하실 수 있습니다.<br></p>
	</div>
	
	
	<div class="writeFormDiv">
		
				<input class="form-control" id="form1" name="title" placeholder="제목을 입력해주세요.">
				
				<input class="form-control" placeholder="문의한 구매자 이름" id="form2" name="name">
				<input class="form-control" placeholder="구매한 물품 번호" id="form3" name="itemno">
				<input type="hidden" name="memberNo" value="${ sessionScope.loginUser.mid  }">
				<textarea class="form-control" id="formTextArea" name="boardContents" placeholder="내용을 입력해주세요."></textarea>
				<button class="successBtn" >보내기</button>
				<button class="cancelBtn" type="reset" onclick="location.href='answerBoard.mp'">닫기</button>
		
	</div>
</body>
</html>