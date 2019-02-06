<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<link href="http://vincentlamanna.com/BootstrapFormHelpers/assets/css/bootstrap.css" rel="stylesheet">
<link href="http://vincentlamanna.com/BootstrapFormHelpers/assets/css/bootstrap-responsive.css" rel="stylesheet">
<link href="http://vincentlamanna.com/BootstrapFormHelpers/assets/css/bootstrap-formhelpers.css" rel="stylesheet">

<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://vincentlamanna.com/BootstrapFormHelpers/assets/js/bootstrap.js"></script>
<script src="http://vincentlamanna.com/BootstrapFormHelpers/assets/js/bootstrap-formhelpers-phone.format.js"></script>
<script src="http://vincentlamanna.com/BootstrapFormHelpers/assets/js/bootstrap-formhelpers-phone.js"></script>

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
	/* 설명 */
	.userInfoGuide{
		position: absolute;
		top: 280px;
		left: 70px;
	}
	/* 테이블div */
	.userInfoArea{
		position: absolute;
		top: 350px;
		left: 70px;
	}
	/* 테이블 */
	.userInfoTable, tr, td{
		border: 1px solid black;
		text-align: center;
	}
	/* 테이블equalBtn */
	.userInfoTable{
		width: 1300px;
		height: 300px;
	}
	/* 비밀번호 확인 버튼 */
	.equalBtn{
		position: absolute;
		top: 60px;
		left: 1170px;
		text-align: center;
		background-color: #205181;
		border: 1px solid white;
		color:white;
		border-radius: 10px;
		width: 100px;
		height: 40px;
	    font-size: 16px;
	}
	/* 회원탈퇴 버튼 */
	.deleteBtn{
		position: absolute;
		top: 263px;
		left: 450px;
		text-align: center;
		background-color: #205181;
		border: 1px solid white;
		color:white;
		border-radius: 10px;
		width: 90px;
		height: 33px;
	    font-size: 16px;
	}
	/* 닫기버튼 */
	.closeBtn{
		position: absolute;
		top: 700px;
		left: 700px;
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
	<div class="title"><h1>회원정보수정</h1></div>
	<p class="userInfoGuide">- 기본정보는 필수입력사항입니다. 빠짐없이 채워넣어 주시기 바랍니다.<br>- 정확한 전화번호 및 주소 (이메일 포함)를 입력하셔야 정상적인 거래가 가능하며, 부정확한 개인정보로 인한 책임과 불이익은 회원 본인이 감수하게 되오니 개인정보 입력시 유의하시기 바랍니다.</p>
	<div class="userInfoArea">
		<table class="userInfoTable">
			<tr>
				<td>비밀번호 변경</td>
				<td style="width: 850px;"><input type="password" class="form-control" style="width: 700px;" name="password" placeholder="변경할 비밀번호를 입력해주세요."></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" class="form-control" style="width: 700px;" name="password2" placeholder="변경할 비밀번호 확인"><button class="equalBtn">확인</button></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" class="form-control" style="width: 700px;" name="email" placeholder="변경할 이메일을 입력해주세요."></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" class="form-control" style="width: 700px;" name="address" placeholder="변경할 주소를 입력해주세요."></td>
			</tr>
			<tr>
				<td>핸드폰</td>
				<td><input type="tel" class="form-control onlyNumber" data-rule-required="true" style="width: 700px;" name="phone" placeholder="-를 제외하고 숫자만 입력해주세요."></td>
			</tr>
			<tr>
				<td>회원탈퇴</td>
				<td><button class="deleteBtn" onclick="location.href='userDelete.mp'">탈퇴하기</button></td>
			</tr>
		</table>
	</div>   
	<button class="closeBtn" onclick="location.href='myPageMain.mp'">닫기</button>
</body>
</html>