<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 계좌변경</title>
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
	.accountUpdateInfo{
		position: absolute;
		top: 270px;
		left: 70px;
	}
	.accountUpdateTableArea{
		position: absolute;
		top: 370px;
		left: 70px;
	}
	.accountUpdateTable, tr, td{
		border: 1px solid black;
		text-align: center;
	}
	.accountUpdateTable{
		width: 1000px;
		height: 300px;
	}
	.updateBtn{
		position: absolute;
		top: 750px;
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
	.closeBtn{
		position: absolute;
		top: 750px;
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
	<div class="title"><h1>계좌등록/변경</h1></div>
	<div class="accountUpdateInfo">
		<p>본인 명의의 계좌를 등록하여 주시기 바랍니다 (아이디 실명에 한하여 송금이 가능합니다.)<br>환불 및 판매대금을 송금 받고자 하는 계좌번호를 등록해주세요.<br>계좌를 입력하지 않은 경우 물품 배송정보 확인 및 반품신청을 하실 수 없습니다.</p>
	</div>
	<div class="accountUpdateTableArea">
		<table class="accountUpdateTable">
			<tr>
				<td>은행명</td>
				<td><select class="form-control" name="accountName" style="width: 600px;">
					<option>국민</option>
					<option>농협</option>
					<option>신한</option>
					<option>우리</option>
					<option>카카오</option>
				</select></td>			
			</tr>
			<tr>
				<td>계좌번호</td>
				<td><input type="text" class="form-control" name="accountNumber" placeholder="-를 빼고 계좌번호를 입력해주세요." style="width: 600px;"></td>
			</tr>
			<tr>
				<td>예금주</td>
				<td><input type="text" class="form-control" name="accountUserName" placeholder="예금주를 입력해주세요." style="width: 600px;"></td>
			</tr>
		</table>
	</div>
	<button class="updateBtn" onclick="location.href='accountUpdate.mp'">등록</button>
	<button class="closeBtn" onclick="location.href='userAccount.mp'">닫기</button>
</body>
</html>