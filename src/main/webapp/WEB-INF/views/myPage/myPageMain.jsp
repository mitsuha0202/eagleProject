<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myPageMain</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
	.title{
		position: absolute;
		left: 30px;
		top: 200px;
	}
	.firstLine{
		border: 1px solid navy;
	}
	.mpTable{
		border: 1px solid black;
		position: absolute;
		top: 250px;
		left: 30px;
	}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<hr class="firstLine">
	<div class="title"><h1>마이페이지</h1></div>
	
		<table class="mpTable">
			<tr>
				<td class="mpName"><h5>OOO님</h5></td>
				<td class="mpMessage"><h5>쪽지 0건</h5></td>
				<td class="mpMoney"><h5>사이버머니</h5></td>
				<td class="mpBalance"><h5>0원</h5></td>
				<td><i class="fas fa-user-alt"></i></td>
				<td></td>
			</tr>
		</table>
</body>
</html>