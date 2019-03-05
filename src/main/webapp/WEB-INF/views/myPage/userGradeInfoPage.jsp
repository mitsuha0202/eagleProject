<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
		top: 260px;
		left: 70px;
	}
	/* 등급 표시 div */
	.grade1, .grade2, .grade3{
		position: absolute;
		border: 1px solid black;
		top: 340px;
		left: 70px;
		width: 20%;
		height: 150px;
		cursor: pointer;
	}
	/* gold 등급 div */
	.grade2{
		top: 340px;
		left: 519px;
	}
	/* 일반 등급 div */
	.grade3{
		top: 340px;
		left: 1024.5px;
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
		top: 75%;
		width: 90%;
	}
	/* 등급에 대한 설명부분 div */
	.gradeExplan{
		position: absolute;
		left: 70px;
		top: 80%;
		width: 50%;
	}
	/* 등급에 대한 설명p태그 */	
	.vipReview{
		font-size: 20px;
		font-weight: bold;
	}
	.thirdLine{
		
		position: absolute;
		border: 1px solid #205181;
		top: 76%;
		width: 100%;
	}
	/* 닫기버튼 */
	.closeBtn{
		position: absolute;
		left: 45%;
		top: 830px;
		text-align: center;
		background-color: white;
		border: 1px solid #205181;
		color:#205181;
		border-radius: 10px;
		width: 150px;
		height: 40px;
	    font-size: 16px;
	    cursor: pointer;
	}
	
</style>
</head>
<body>

	<!-- 헤더바 -->
	<jsp:include page="../common/header.jsp"/>
	
	<!-- 헤더바 밑 선 -->
	<hr class="firstLine">
	
	<!-- 등급판단 input -->
	<input type="hidden" value="<c:out value="${ sessionScope.loginUser.rating }"/>" id="grade">
	
	<!-- 페이지 제목 -->
	<div class="title"><h1>회원등급 혜택안내</h1></div>
	
	<table class="ui single line table" style="margin-top: 250px; width: 1200px; height: 250px; position: absolute; left: 250px;">
  <thead>
    <tr>
      <th style="text-align: center;">등 급</th>
      <th style="text-align: center;">구 매 금 액</th>
      <th style="text-align: center;">구 매 횟 수</th>
      <th style="text-align: center;">수수료 혜택</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align: center;">일 반</td>
      <td style="text-align: center;">-</td>
      <td style="text-align: center;">-</td>
      <td style="text-align: center;">수수료 10%</td>
    </tr>
    <tr>
      <td style="text-align: center;">G O L D</td>
      <td style="text-align: center;">50만원 이상 100만원 미만</td>
      <td style="text-align: center;">4회 이상</td>
      <td style="text-align: center;">수수료7%</td>
    </tr>
    <tr>
      <td style="text-align: center;">V I P</td>
      <td style="text-align: center;">100만원 이상</td>
      <td style="text-align: center;">6회 이상</td>
      <td style="text-align: center;">수수료3%</td>
    </tr>
  </tbody>
</table>
	
	<!-- 등급 설명div 밑 선 -->
	<hr class="thirdLine">
	
	<!-- 닫기버튼 -->
	<button class="closeBtn" onclick="location.href='myPageMain.mp'">닫기</button>
	
	<script>
		$(function() {
			console.log($("#grade").val());
			if($("#grade").val() == "vip"){
				$(".grade1").css({"background":"lightgray"});	
				$("#userGradeGuide").html("<p>VIP<br>100만원 이상, 6회 이상 구매<br><br>수수료 3%</p>");
			}else if($("#grade").val() == "BRONZE"){
				$(".grade2").css({"background":"lightgray"});
				$("#userGradeGuide").html("<p>GOLD<br>50만원 이상, 4회 이상 구매<br><br>수수료 7%</p>");
			}else{
				$(".grade3").css({"background":"lightgray"});
				$("#userGradeGuide").html("<p>일반<br>수수료 10%</p>");
			}
			
		});
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