<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

.h2 {
	display: inline-block;
}

h4 {
	display: inline-block;
}

.nay {
	float: right;
}
.may {
	height:200px;
	border:1px solid black;
}
</style>

</head>
<body>
	<!-- navigation - header.jsp -->
	<jsp:include page="../common/header.jsp" />
	<!-- 해당 페이지를 view_template파일과 다른 경로에 만들었다면 include path를 수정해야합니 -->
	<div class="ui grid">
		<div class="two wide column"></div>
		<div class="twelve wide column" style="margin-top: 50px;">

			<h2 class="h2">경매하기</h2>
			<div class="ui category search" style="float: right">
				<div class="ui icon input">
					<div class="ui action input" style="height: 50px">
						<input type="text" placeholder="Search...">
						<button class="ui icon button" style="height: 50px">
							<i class="search icon" style="height: 50px"></i>
						</button>
					</div>
				</div>
				<div class="results"></div>
			</div>
			<br> <br> <br> <br>
			<table class="ui basic table" style="width: 500px;">
				<thead>
					<tr>
						<th>전체보기</th>
						<th>미술</th>
						<th>음악앨범</th>
						<th>의류</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>생활가전</th>
						<th>비디오게임</th>
						<th>피규어</th>
						<th>레고</th>
					</tr>
				</tbody>
			</table>
			<br> <br>
			<h4>모두 0000000개의 물품이 검색되었습니다</h4>
			<div class="nay">
				<div style="font-size: 20px;">인기경매순&nbsp;|&nbsp;마감임박순&nbsp;|&nbsp;신규경매순&nbsp;
					|&nbsp;높은가격순&nbsp;|&nbsp;낮은가격순&nbsp;| &nbsp;조회많은순&nbsp;|&nbsp;입찰많은순
				</div>
				
			</div>
			<br>
			<br>
			<hr>
			
			<div class="ui grid">
  			<div class="four wide column">
  			<c:forEach var="i" items="${list1}">
			<div class="may" style=width:300px;>

				 <img src="resources/uploadFiles/${i.atta.changeName}" style="width: 300px;height:200px;">
				</div>
			<table class="ui basic table" style="width:250px;">
			 <tr>
			</tr>
			<tr class="tr">
				<td colspan="2">입찰 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${i.bidCount} 건</td>
				<td>조회 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${i.itemcount} 회</td>
			</tr>
			
			<tr class="tr">
				<td colspan="2">판매자 아이디</td>
				<td>${i.mid}</td>
			</tr>
			<tr class="tr">
				<td colspan="2">남은 시간</td>
				<td>00</td>

			</tr>
		</table>
			</c:forEach>
		</div>
  			
  			<div class="four wide column">
  				<c:forEach var="i" items="${list1}">
			<div class="may" style=width:300px;>

				 <img src="../../../resources/uploadFiles/${i.atta.changeName}">
				</div>
			<table class="ui basic table" style="width:250px;">
			 <tr>
			</tr>
			<tr class="tr">
				<td colspan="2">입찰 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${i.bidCount} 건</td>
				<td>조회 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${i.itemcount} 회</td>
			</tr>
			
			<tr class="tr">
				<td colspan="2">판매자 아이디</td>
				<td>${i.mid}</td>
			</tr>
			<tr class="tr">
				<td colspan="2">남은 시간</td>
				<td>00</td>

			</tr>
		</table>
			</c:forEach>
  			
  			</div>
  			<div class="four wide column">
  				<c:forEach var="i" items="${list1}">
			<div class="may" style=width:300px;>

				 <img src="../../../resources/uploadFiles/${i.atta.changeName}">
				</div>
			<table class="ui basic table" style="width:250px;">
			 <tr>
			</tr>
			<tr class="tr">
				<td colspan="2">입찰 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${i.bidCount} 건</td>
				<td>조회 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${i.itemcount} 회</td>
			</tr>
			
			<tr class="tr">
				<td colspan="2">판매자 아이디</td>
				<td>${i.mid}</td>
			</tr>
			<tr class="tr">
				<td colspan="2">남은 시간</td>
				<td>00</td>

			</tr>
		</table>
			</c:forEach></div>
  			<div class="four wide column">
  				<c:forEach var="i" items="${list1}">
			<div class="may" style=width:300px;>

				 <img src="../../../resources/uploadFiles/${i.atta.changeName}">
				</div>
			<table class="ui basic table" style="width:250px;">
			 <tr>
			</tr>
			<tr class="tr">
				<td colspan="2">입찰 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${i.bidCount} 건</td>
				<td>조회 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${i.itemcount} 회</td>
			</tr>
			
			<tr class="tr">
				<td colspan="2">판매자 아이디</td>
				<td>${i.mid}</td>
			</tr>
			<tr class="tr">
				<td colspan="2">남은 시간</td>
				<td>00</td>

			</tr>
		</table>
			</c:forEach></div>
			</div>
			
		
		</div>


		<!-- 내용 넣기 -->
	</div>
	<div class="two wide column"></div>


	<!-- footer -->
</body>
</html>