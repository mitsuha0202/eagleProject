<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> 
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
	/* 설명 */
	.userInfoGuide{
		position: absolute;
		top: 280px;
		left: 70px;
	}
	/* 테이블div */
	.userInfoArea{
		position: absolute;
		top: 350px;
		left: 70px;
	}
	/* 테이블 */
	/* .userInfoTable, tr, td{
		border: 1px solid black;
		text-align: center;
	} */
	/* 테이블equalBtn */
	.userInfoTable{
		width: 1300px;
		height: 300px;
	}
	#detailAdd{
		position: absolute;
		top: 155px;
		left: 850px;
	}
	/* 주소 버튼 */
	.addBtn{
		position: absolute;
		top: 150px;
		left: 1170px;
		text-align: center;
		background-color: #205181;
		border: 1px solid white;
		color:white;
		border-radius: 10px;
		width: 100px;
		height: 40px;
	    font-size: 16px;
	}
	/* 회원탈퇴 버튼 */
	.deleteBtn{
		position: absolute;
		top: 263px;
		left: 450px;
		text-align: center;
		background-color: #205181;
		border: 1px solid white;
		color:white;
		border-radius: 10px;
		width: 90px;
		height: 33px;
	    font-size: 16px;
	}
	/* 저장버튼 */
	.saveBtn{
		position: absolute;
		top: 700px;
		left: 515px;
		text-align: center;
		background-color: #205181;
		border: 1px solid white;
		color:white;
		border-radius: 10px;
		width: 100px;
		height: 40px;
	    font-size: 16px;
	}
	/* 닫기버튼 */
	.closeBtn{
		position: absolute;
		top: 700px;
		left: 800px;
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
	<div class="title"><h1>회원정보수정</h1></div>
	<p class="userInfoGuide">- 기본정보는 필수입력사항입니다. 빠짐없이 채워넣어 주시기 바랍니다.<br>- 정확한 전화번호 및 주소 (이메일 포함)를 입력하셔야 정상적인 거래가 가능하며, 부정확한 개인정보로 인한 책임과 불이익은 회원 본인이 감수하게 되오니 개인정보 입력시 유의하시기 바랍니다.</p>
	<form action="userInfoUpate.mp" method="post" onsubmit="return check();">
		<div class="userInfoArea">
			<table class="userInfoTable">
				<tr>
					<td>비밀번호 변경</td>
					<td style="width: 850px;"><input type="password" id="pw1" class="form-control" style="width: 700px;" name="userPwd" placeholder="변경할 비밀번호를 숫자로 입력해주세요."><input type="hidden" name="mid" value="${ sessionScope.loginUser.mid }"></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" id="pw2" class="form-control" style="width: 700px;" name="password2" placeholder="변경할 비밀번호 확인"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" class="form-control" style="width: 700px;" name="email" value="${ sessionScope.loginUser.email }" readonly="readonly"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" id="add" class="form-control" style="width: 380px;" name="address" value="${ m.address }" readonly="readonly"><button type="button" class="addBtn" onclick="return addressModal()">주소검색</button></td>
				</tr>
				<tr>
					<td><input type="text" id="detailAdd" class="form-control" style="width: 300px" name="detailAddress" placeholder="상세주소를 입력해주세요."></td>
				</tr>
				<tr>
					<td>핸드폰</td>
					<td><input type="tel" id="ph" class="form-control" data-rule-required="true" style="width: 700px;" name="phone" value="${ m.phone }"></td>
				</tr>
				<tr>
					<td>회원탈퇴</td>
					<td><button type="reset" class="deleteBtn" onclick="location.href='userDelete.mp'">탈퇴하기</button></td>
				</tr>
			</table>
		</div>   
		<button type="submit" class="saveBtn">저장</button>
	</form>
	<button class="closeBtn" onclick="location.href='myPageMain.mp'">닫기</button>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		function addressModal() {
			new daum.Postcode({
	            oncomplete: function(data) {
	                var addr = data.address; // 최종 주소 변수

	                // 주소 정보를 해당 필드에 넣는다.
	                document.getElementById("add").value = addr;	          
	            }
	        }).open();
			return false;
		}
	</script>
	
	<script>
			/* 비밀번호 하이픈 자동입력 */
			var cellPhone = document.getElementById('ph');
			cellPhone.onkeyup = function(event){
			        event = event || window.event;
			        var _val = this.value.trim();
			        this.value = autoHypenPhone(_val);
			}	
			/* 하이픈 함수 */
			function autoHypenPhone(str){
	            str = str.replace(/[^0-9]/g, '');
	            var tmp = '';
	            if( str.length < 4){
	                return str;
	            }else if(str.length < 7){
	                tmp += str.substr(0, 3);
	                tmp += '-';
	                tmp += str.substr(3);
	                return tmp;
	            }else if(str.length < 11){
	                tmp += str.substr(0, 3);
	                tmp += '-';
	                tmp += str.substr(3, 3);
	                tmp += '-';
	                tmp += str.substr(6);
	                return tmp;
	            }else{              
	                tmp += str.substr(0, 3);
	                tmp += '-';
	                tmp += str.substr(3, 4);
	                tmp += '-';
	                tmp += str.substr(7);
	                return tmp;
	            }
	            return str;
	        }
			
			/* 유효성 검사 */
			function check() {
				var pass1 = $("#pw1").val();
				var pass2 = $("#pw2").val();
				var address = $("#add").val();
				var phone = $("#ph").val();
				
				/* 영문과 숫자 혼합해 6~20자 이내 비밀번호 */
				/* var reg_pwd = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/; */
				
				/* 숫자만 입력 */
				var reg_pwd = /^[0-9]*$/;
				
				if(pass1 == ""){
					alert("비밀번호를 입력해주세요.");
					$("#pw1").focus();
					return false;
				}else if(!reg_pwd.test(pass1)){
					alert("숫자만 입력해주세요.");
					return false;
				}else if(pass1 != pass2){
					alert("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
					$("#pw2").focus();
					return false;
				}else if(address == ""){
					alert("주소를 입력해주세요.");
					$("#add").focus();
					return false;
				}else if(phone == ""){
					alert("전화번호를 입력해주세요.");
					$("#ph").focus();
					return false;
				}else {
					alert("정보 수정 완료");
					return true;
				}
			} 
	</script>
</body>
</html>