<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- jquery -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
   
   <!-- Semantic UI -->
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
   <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
   <!-- bootstrap -->
   
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
   <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<style>

	.ui {
	height:80px;
	}
	.h1 {
		display: inline-block;
	}
	
	#in {
		height:50px;
		width:400px;
		border:1px solid black;
		background:#ffffff;
	
	}
	#searchItem {
		font-size :16px;
		width:325px;
		padding:10px;
		border:0px;
		outline:none;
		float:left;
		
	}
	#searchBtn {
		width:50px;
		height:100%;
		border:0px;
		background:#1b5ac2;
		outline:none;
		float:right;
		color:#ffffff
	
	}
	input:-ms-input-placeholder {color:#a8a8a8;}
	
	.Board{
		cursor: pointer;
	}
	
	
	</style>

</head>

<body>
<div class="ui inverted menu">
  <a class="active item">
 	현재시간
  </a>
  <div style="width:100px"></div>
  <a class="item">
    	로그인을 하시면 다양한 정보를 보실 수 있습니다
  </a>
	<div class="right" style="width:800px"></div>
  <a class="item" href="loginView.me">
    	로그인
  </a>
  	
   <a class="item" href="memberJoinView.me" >
    	회원가입
  </a>
   <a class="item" href="myPageMain.mp">
    	마이페이지
  </a>
  <a class="item" href="blackList.ad">
    	관리자
  </a>
</div>
<h1 class="h1">Eagle's Auction </h1>
<div class="btn-group" role="group" aria-label="...">


	<div style=width:180px></div>
	
 	<div style=cursor:pointer;width:150px;font-size:20px onclick="location.href='auctionCategory.au'">경매하기</div>
 	
 	<div style=cursor:pointer;width:150px;font-size:20px onclick="location.href='itemRegist.it'">물품등록</div>
 	
  	<div style=width:150px;font-size:20px >자유게시판</div>
  	<div style=width:150px;font-size:20px onclick="location.href='emoney.em'">사이버머니 결제</div>

  	<div style=width:100px></div>
	<div id="in">
		<input type="text" placeholder="검색어를 입력해주세요" id="searchItem">
		<button id="searchBtn">검색</button>
	</div>
</div>
<script>
	function goBoard() {
		location.href="goBoard.bo";
	}
</script>



</body>
</html>