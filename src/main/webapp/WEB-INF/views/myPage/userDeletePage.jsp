<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<style>

	.deleteInfo{
		text-align: center;
		padding-top: 100px;
		padding-bottom: 50px;
		margin-left: auto;
		margin-right: auto;
	}

	.radioArea{
		padding-left: 100px;
		text-align: center;
		margin-left: auto;
		margin-right: auto;
		background-color: #EFFBF8;
		width: 1500px;
		height: 100px;
	}
	#checkBtn{
		position: absolute;
		top: 643px;
		left: 765px;
		
	}
	
	.btnArea{
		padding-left: 630px;
	}
	
	#deleteBtn{
		height: 35px;
		width: 105px;
	}
	
	#closeBtn{
		height: 35px;
		width: 105px;
	}
</style>
</head>
<body>
	<!-- 헤더바 -->
	<jsp:include page="../common/header.jsp"/>
	
	<div class="deleteInfo">
		<br>
		<h3>Eagle's Auction 회원 탈퇴를 하시겠습니까?</h3>
		<br>
		<p>아래 약관 내용을 참조하신 후 신중하게 버튼을 클릭해 주세요.</p>
		<br>
		<h5>[사이버머니잔액 환불]</h5>
		<p>탈퇴신청 후 2일이내(공휴일제외) 고객님의 은행계좌로 송금됩니다.</p>
		<br>
		<h5>[탈퇴가 불가한 경우]</h5>
		<p>진행중인 물품(판매/구매)이 있는 경우 탈퇴신청이 불가합니다.</p>
	</div>
	
		<table class="table" style="width: 1300px; margin-left: auto; margin-right: auto;">
			<tr>
				<td>탈퇴신청사유</td>
				<td><select class="form-control" style="width: 300px;">
	  				<option>재가입</option>
	  				<option>미사용</option>
	  				<option>기타</option>
				</select></td>
			</tr>
		</table>
		<input type="hidden" id="memberNo" value="${ sessionScope.loginUser.mid }">
	
	<div class="radioArea">
		<input type="checkbox" id="checkBtn" class="form-control" name="checkbox" style="width: 20px;"><br><br><h5 class="checkContent">위 내용을 확인했습니다.</h5>
	</div>
	
	<div class="btnArea">
		<button id="deleteBtn" class="ui orange basic button" onclick="return deleteUser();">삭제</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button id="closeBtn" class="ui black basic button" onclick="location.href='userInfoUpdatePage.mp'">닫기</button>
	</div>	
	<script>
		function deleteUser() {
			if(checkBtn.checked == true){
				if(window.confirm("삭제하시겠습니까?")){
					var mid = $("#memberNo").val();				
					location.href="deleteUserInfo.mp?mid=" + mid + ",";
					return true;	
				}
			}else {
				alert("약관에 동의해주세요.");
				return false
			}
		}
	</script>
</body>
</html>