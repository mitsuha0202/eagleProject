<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등급 혜택안내</title>
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
	/* 등급 표시 div */
	.grade1, .grade2, .grade3{
		position: absolute;
		border: 1px solid black;
		top: 270px;
		left: 70px;
		width: 30%;
		height: 150px;
		cursor: pointer;
	}
	/* gold 등급 div */
	.grade2{
		top: 270px;
		left: 519px;
	}
	/* 일반 등급 div */
	.grade3{
		top: 270px;
		left: 968px;
	}
	/* 등급 글 부분 */
	.vip{
		position: absolute;
		top: 38%;
		left: 43%;
	}
	/* 두번째 hr */	
	.secondLine{
		position: absolute;
		left: 70px;
		border: 1px solid #205181;
		top: 65%;
		width: 90%;
	}
	/* 등급에 대한 설명부분 div */
	.gradeExplan{
		position: absolute;
		left: 70px;
		top: 75%;
		width: 50%;
	}
	/* 등급에 대한 설명p태그 */	
	.vipReview{
		font-size: 20px;
		font-weight: bold;
	}
	.thirdLine{
		position: absolute;
		left: 70px;
		border: 1px solid #205181;
		top: 96%;
		width: 90%;
	}
	/* 닫기버튼 */
	.closeBtn{
		position: absolute;
		left: 45%;
		top: 800px;
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
	<div class="title"><h1>회원등급 혜택안내</h1></div>
	
	<!-- 등급 vip div -->
	<div class="grade1" onclick="vipClick();">
		<h3 class="vip">VIP</h3>
	</div>
	
	<!-- 등급 gold div -->
	<div class="grade2" onclick="goldClick();">
		<h3 class="vip">GOLD</h3>
	</div>	
	
	<!-- 등급 일반 div -->
	<div class="grade3" onclick="normalClick();">
		<h3 class="vip">일반</h3>
	</div>
	
	<!-- 등급div 밑 선 -->	
	<hr class="secondLine">
	
	<!-- 등급에 대한 설명부분 div -->
	<div class="gradeExplan">
		<p id="userGradeGuide" class="vipReview">VIP<br>100만원, 6회 이상 구매<br><br>수수료 3%</p>
	</div>
	
	<!-- 등급 설명div 밑 선 -->
	<hr class="thirdLine">
	
	<!-- 닫기버튼 -->
	<button class="closeBtn" onclick="location.href='myPageMain.mp'">닫기</button>
	
	<script>
		/* vip div 색과 내용 */
		function vipClick() {
			$("#userGradeGuide").html("<p>VIP<br>100만원 이상, 6회 이상 구매<br><br>수수료 3%</p>");
			$(".grade1").css({"background":"lightgray"});
			$(".grade2").css({"background":"white"});
			$(".grade3").css({"background":"white"});
		}
		/* gold div 색과 내용 */
		function goldClick() {
			$("#userGradeGuide").html("<p>GOLD<br>50만원 이상, 4회 이상 구매<br><br>수수료 7%</p>");
			$(".grade2").css({"background":"lightgray"});
			$(".grade1").css({"background":"white"});
			$(".grade3").css({"background":"white"});
		}
		/* 일반 div 색과 내용 */
		function normalClick() {
			$("#userGradeGuide").html("<p>일반<br>수수료 10%</p>");
			$(".grade3").css({"background":"lightgray"});
			$(".grade1").css({"background":"white"});
			$(".grade2").css({"background":"white"});
		}
	</script>
</body>
</html>