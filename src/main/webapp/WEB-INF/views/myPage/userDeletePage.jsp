<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
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
	.deleteInfo{
		text-align: center;
		position: absolute;
		top: 300px;
		left: 70px;
		background-color: lightgray;
		width: 1350px;
		height: 280px;
	}
	.tableArea{
		position: absolute;
		left: 70px;
		top: 650px;
	}
	.deleteTable, tr, td{
		border: 1px solid black;
	}
	.deleteTable{
		text-align: center;
		width: 1350px;
		height: 100px;
	}
	.radioArea{
		position: absolute;
		text-align: center;
		top: 900px;
		left: 70px;
		width: 1350px;
		height: 100px;
		background-color: lightgray;
	}
	#checkBtn{
		position: absolute;
		top: 35px;
		left: 535px;
		
	}
	.checkContent{
		position: absolute;
		top: 40px;
		left: 580px;
	}
	.closeBtn{
		position: absolute;
		top: 1040px;
		left: 700px;
		text-align: center;
		background-color: #205181;
		border: 1px solid white;
		color:white;
		border-radius: 10px;
		width: 100px;
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
	<div class="title"><h1>회원탈퇴</h1></div>
	
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
	
	<div class="tableArea">
		<table class="deleteTable">
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
	</div>
	
	<div class="radioArea">
		<input type="checkbox" id="checkBtn" class="form-control" name="checkbox" style="width: 50px;"><h5 class="checkContent">위 내용을 확인했습니다.</h5>
	</div>
		<button class="deleteBtn" onclick="return deleteUser();">삭제</button>
		<button class="closeBtn" onclick="location.href='userInfoUpdate.mp'">닫기</button>
		
	<script>
		function deleteUser() {
			if(checkBtn.checked == true){
				var mid = $("#memberNo").val();
				location.href="deleteUserInfo.mp?mid=" + mid + ",";
				return true;
			}else {
				alert("약관에 동의해주세요.");
				return false
			}
		}
	</script>
</body>
</html>