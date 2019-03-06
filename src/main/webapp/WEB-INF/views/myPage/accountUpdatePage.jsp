<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 계좌변경</title>
<style>

	/* 페이지 제목 */
	.title{
		padding-top: 50px;
		padding-left: 80px;
		padding-bottom: 60px;
	}
	
	.accountUpdateInfo{
		padding-left: 80px;
		padding-bottom: 50px;
	}

	#updateBtn{
		height: 35px;
		width: 105px;
		position: absolute;
		left: 500px;
	}
	#closeBtn{
		height: 35px;
		width: 105px;
		position: absolute;
		left: 700px;
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
	
		<form action="updateAccount.mp" method="post">
		<table class="table" style="width: 1200px; margin-left: auto; margin-right: auto;">
			<tr>
				<td>은행명</td>
				<td><select class="form-control" name="bankName" style="width: 600px;">
					<option>국민</option>
					<option>농협</option>
					<option>신한</option>
					<option>우리</option>
					<option>카카오</option>
				</select></td>			
			</tr>
			<tr>
				<td>계좌번호</td>
				<td><input type="text" id="accountNo" class="form-control" name="accountNo" placeholder="-을 붙여서 입력해주세요." style="width: 600px;"><input type="hidden" name="mid" value="${ sessionScope.loginUser.mid }"></td>
			</tr>
			<tr>
				<td>예금주</td>
				<td><input type="text" class="form-control" name="memberName" value="${ sessionScope.loginUser.userName }" style="width: 600px; background-color: #FFFFFF" readonly="readonly"></td>
			</tr>
		</table>
		<button id="updateBtn" class="ui orange basic button" type="submit" onclick="return accountUpdate();">등록</button>
		<button id="closeBtn" class="ui black basic button" type="reset" onclick="location.href='userAccount.mp'">닫기</button>
		</form>

	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		function accountUpdate() {
	
			var accountNo = $("#accountNo").val();
			
			if(accountNo == ""){
				alert("계좌번호를 입력해주세요.");
				return false;
			}else if(window.confirm("계좌를 변경하시겠습니까?")){
				return true;
			}else {
				return false;
			}
		}
	</script>
</body>
</html>