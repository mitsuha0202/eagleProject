<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1대1 문의게시판</title>
<style>

	/* 1대1문의게시판 설명 div */
	.onebyoneInfo{
		padding-top: 80px;
		padding-left: 80px;
		width: 1350px;
		height: 130px;
	}
	/* 테이블 div 영역 */
	.writeFormDiv{
		padding-top: 110px;
		padding-left: 80px;
	}

	#form1{
		width: 800px;
		top: 20px;
	}
	#form2{
		width: 800px;
		top: 60px; 
	}
	#formTextArea{
		width: 800px;
		height: 140px;
		top: 100px;
	}
	#successBtn{
		height: 35px;
		width: 105px;
	}
	#cancelBtn{
		height: 35px;
		width: 105px;
	}
	.btnArea{
		padding-left: 35%;
	}
</style>
</head>
<body>
	<!-- 헤더바 -->
	<jsp:include page="../common/header.jsp"/>
	
	<div class="onebyoneInfo">
		<h3>1대1 문의 게시판 안내</h3>
		<br>
		<p>&nbsp; &bull;FAQ 검색에서 원하는 내용을 검색하시면 즉시 답변을 얻으실 수 있습니다.<br>&nbsp; &bull;물품문의는 판매자에게 해주시기바랍니다.<br>&nbsp; &bull;답변은 마이페이지 > 나의활동내역 > 1:1문의에서 확인 가능합니다.</p>
	</div>
	
	<div class="writeFormDiv">
		<form action="insertMessage.mp" method="post">
			<table class="table" style="width: 1000px; margin-left: auto; margin-right: auto;">
				<tr>
					<td>제목</td>
					<td><input class="form-control" id="form1" name="title" placeholder="제목을 입력해주세요."></td>
				</tr>
				<tr>
					<td>회원이름</td>
					<td><input class="form-control" value="${ sessionScope.loginUser.userName  }님" id="form2" name="name" readonly="readonly" style="background-color: #FAFAFA">
					<input type="hidden" name="memberNo" value="${ sessionScope.loginUser.mid  }"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea class="form-control" id="formTextArea" name="boardContents" placeholder="내용을 입력해주세요."></textarea></td>
				</tr>
				</table>
				
				<div class="btnArea">
					<button id="successBtn" class="ui black basic button" type="submit">등록</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button id="cancelBtn" class="ui black basic button" type="reset" onclick="location.href='userMessage.mp'">취소</button>
				</div>
		</form>
	</div>
</body>
</html>