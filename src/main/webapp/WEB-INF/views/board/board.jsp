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
   .searchBoard{
   	display:inline-block;
   }
   .boardViewArea{
   	width:1200px;
   	margin-top: 100px;
   	margin-left: auto;
   	margin-right: auto;
   }
   .pagingAndBI{
   	display:inline-block;
   }
   .ui simple dropdown item{
   	width:130px;
   	height: 65px;
   }
   
   
   </style>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="boardViewArea" align="center">
		<div class="boardHeader">
		<h1 class="ui header" align="left">자유게시판</h1>
		</div>
		<div class="searchArea" align="right">
			<div class="ui compact menu" style="width:150px; height:50px; margin-bottom: 5px;" >
			  <div class="ui simple dropdown item" style="padding-bottom: 30px; padding-top: 0px;">
			    Dropdown
			    <i class="dropdown icon"></i>
			    <div class="menu">
			      <div class="item">Choice 1</div>
			      <div class="item">Choice 2</div>
			      <div class="item">Choice 3</div>
			    </div>
			  </div>
			</div>
			<div class="ui icon input" style="height: 50px;">
			  <input type="text" placeholder="검색할 내용을 입력하세요" name="searchBoard" style="width:300px; height: 50px; margin-right: 15px;">
			  <button class="ui black button" style="width:80px; height: 50px">검색</button>
			</div>
		</div>
	
	
		<table class="ui black table" align="center" id="listArea">
		  <thead>
		    <tr>
			    <th>번호</th>
			    <th>제목</th>
			    <th>글쓴이</th>
			    <th>등록일</th>
			    <th>조회수</th>
		  	</tr>
		  </thead>
		  <tbody>
		    <tr>
		      <td>1</td>
		      <td>경매물건 거지같네</td>
		      <td>김거지</td>
		      <td>02-03</td>
		      <td>1</td>
		    </tr>
		    <tr>
		      <td>2</td>
		      <td>경매물건 좋네</td>
		      <td>김좋네</td>
		      <td>02-03</td>
		      <td>1</td>
		    </tr>
		  </tbody>
		</table>

		<br>
		<div class="btnArea" align="right">
			<button class="ui black button" style="width:200px; font-size: 1.5rem;" onclick="insertBoard();">글쓰기</button>
		</div>
	</div>
	<script>
		function insertBoard() {
			location.href = "insertBoardView.bo";
		}
		
		$(function(){
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({"background":"darkgray","cursor":"pointer"})
			}).mouseout(function(){
				$(this).parent().css({"background":"white"});
			}).click(function(){
				var num=$(this).parent().children().eq(0).text();
				
				console.log(num);
				
				location.href="boardSelectOne.bo";
			});
			
		})
	
	</script>
</body>
</html>