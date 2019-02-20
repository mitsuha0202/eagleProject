<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<!-- jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<!-- Semantic UI -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
<!-- bootstrap -->

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>

<style>
.column {
	height: 100%;
}

.pre {
	display: inline-block;
}

}
.more-div {
	position: absolute;
	margin-top: -50px;
	right: 10%;
	cursor: pointer;
}

#more-icon {
	font-size: 18px;
}

#more-txt {
	color: rgb(50, 50, 50);
	font-family: 'Nanum Gothic', sans-serif;
	font-weight: 800;
}

#tour-price {
	color: #ee685a;
	font-weight: 800;
	font-size: 15px;
}

table {
	width: 300px;
	height: 50px;
	border: 1px solid black;
}
.tr {
	border:1px solid black;

}
td {
	border: 1px solid black;
}
.may {
	height:200px;
	border:1px solid black;
}
</style>


</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<!-- 해당 페이지를 view_template파일과 다른 경로에 만들었다면 include path를 수정해야합니 -->
	<div class="ui grid">
		<div class="two wide column"></div>
		<div class="twelve wide column" style="margin-top: 50px;">

			<!-- 내용 넣기 -->
			<br> <br> <br>
			<div class="chu">
				<h1 class="pre">Eagle's Auction 추천경매</h1>
				<div class="more-div" style="display: inline-block; float: right">
					<i class="chevron circle right icon" id="more-icon"></i> <font
						id="more-txt">더보기 </font>
				</div>
				<hr>
				<div class="may" style=width:300px;>
				
				</div>

				<table>
					<tr class="tr">
						<td colspan="2">입찰  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  건</td>
						<td>조회 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   회</td>
						

					</tr>
					<tr class="tr">
						<td colspan="2">판매자 아이디</td>
						<td >${userId}</td>
					</tr>
					<tr class="tr">
						<td colspan="2">남은 시간</td>
						<td >00</td>
						
					</tr>

				</table>
			</div>
			<br>
			<div class="chu">
				<h1 class="pre">Eagle's Auction 인기경매</h1>

				<div class="more-div" style="display: inline-block; float: right">
					<i class="chevron circle right icon" id="more-icon"></i> <font
						id="more-txt">더보기 </font>

				</div>
				<hr>
				<table>
					<tr class="tr">
						<td colspan="2">입찰  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  건</td>
						<td>조회 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   회</td>
						

					</tr>
					<tr class="tr">
						<td colspan="2">판매자 아이디</td>
						<td >${userId }</td>
					</tr>
					<tr class="tr">
						<td colspan="2">남은 시간</td>
						<td >00</td>
						
					</tr>

				</table>
			</div>

			<div class="chu">
				<h1 class="pre">Eagle's Auction 스페셜 상품</h1>
				<div class="more-div" style="display: inline-block; float: right">
					<i class="chevron circle right icon" id="more-icon"></i> <font
						id="more-txt">더보기 </font> <br>


				</div>
				<hr>
				<table>
					<tr class="tr">
						<td colspan="2">입찰  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;건</td>
						<td>조회 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   회</td>
						

					</tr>
					<tr class="tr">
						<td colspan="2">판매자 아이디</td>
						<td >${userId}</td>
					</tr>
					<tr class="tr">
						<td colspan="2">남은 시간</td>
						<td >00</td>
						
					</tr>

				</table>
			</div>

			<div class="two wide column"></div>
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script>
		    /* 네이버 callBack 이후  */
			 var naver_id_login = new naver_id_login("4gAxam1u5RbIDQFeajAF", "http://localhost:8003/eg/goMain.me");
			  // 접근 토큰 값 출력
			  alert(naver_id_login.oauthParams.access_token);
			  // 네이버 사용자 프로필 조회
			  naver_id_login.get_naver_userprofile("naverSignInCallback()");
			  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
			  function naverSignInCallback() {
			    alert(naver_id_login.getProfileData('email'));
			    alert(naver_id_login.getProfileData('name'));
		
			    
			   var naverId = naver_id_login.getProfileData('email');
			   var naverName = naver_id_login.getProfileData('name');
			  }
    </script>
</body>
</html>