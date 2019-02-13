<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eagle's Join</title>
	<!-- jquery -->
   
   <!-- <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script> -->
   
   <!-- Semantic UI -->
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
   <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
   <!-- bootstrap -->
   
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
   <!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> -->
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
   <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e5d140ada9ab99588e987fbd8b384d3a&libraries=services"></script>
<style>
	h1 {
	  margin: 0;
	  font: bold 100px/1 "Helvetica Neue", Helvetica, Arial, sans-serif;
	  color: #fff;
	  text-shadow: 0 1px 0 #cccccc, 0 2px 0 #c9c9c9, 0 3px 0 #bbbbbb, 0 4px 0 #b9b9b9, 0 5px 0 #aaaaaa, 0 6px 1px rgba(0, 0, 0, 0.1), 0 0 5px rgba(0, 0, 0, 0.1), 0 1px 3px rgba(0, 0, 0, 0.3), 0 3px 5px rgba(0, 0, 0, 0.2), 0 5px 10px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.2), 0 20px 20px rgba(0, 0, 0, 0.15);
	  -webkit-transition: .2s all linear;
	  letter-spacing:-2px;
	}
	h1:hover {
	  cursor: text;
	}
	h1:focus {
	  outline: none;
	}
	h1.ui.header{
		font-size: 4rem;
	}
	.ui.form .field>label{
		font-size: 1.5em;
	}
	.field{
		width:500px;
	}
	.ui button {
		height: 45px;
	}
	.column{
     	height: 100%;
     }
/*      #emailCheck{
     	display:none;
     }
     #idCkNum{
     	display:none;
     }
     #emailCkNum{
     	display:none;
     } */
</style>
</head>
<body>
	<!-- navigation - header.jsp -->
	<jsp:include page="../common/header.jsp"/>
	<!-- 해당 페이지를 view_template파일과 다른 경로에 만들었다면 include path를 수정해야합니 -->
    <div class="ui grid">
        <div class = "two wide column"></div>
        <div class = "twelve wide column" style="margin-top:50px;">
		 <h1 class="ui header" align="center" style="margin-top:100px">E a g l e ' s&nbsp;&nbsp;&nbsp;&nbsp;J O I N</h1>
		 <div class="memberJoin" align="center">
			 <form class="ui form" id="joinForm"  action="insert.me" method="post">
				 <table>
				 	<tr>
				 		<td colspan="2"><label align="left" style="font-size: 1.5em;">* 아이디</label></td>
				 	</tr>
				 	<tr>
			 		  <td>
						  <div class="field" style="display:inline-block;">	    
						    <input type="text" id="userId" name="userId" placeholder="아이디를 입력해주세요.(4~12글자. 영문,숫자만 가능)" style="height:45px">
						  </div>
					  </td>
	  				  <td><button class="ui button" id="idCheckBtn" type="button" onclick="return duplicationCheck();">ID중복확인</button></td>
					 </tr>
					 <tr>
					    <td colspan="2"><label align="left" style="font-size: 1.5em;">* 비밀번호</label></td>
					 </tr>
					 <tr>
					 	<td>
						  <div class="field">
						    <input type="password" name="userPwd" id="userPwd" placeholder="PASSWORD" style="height:45px">
						  </div>
					  	</td>
					  </tr>
					  <tr>
					    <td colspan="2"><label align="left" style="font-size: 1.5em;">* 비밀번호확인</label></td>
					 </tr>
					 <tr>
					 	<td colspan="2">
						  <div class="field">
						    <input type="password" name="userPwd2" id="userPwd2" placeholder="PASSWORD" style="height:45px">
						  </div>
					  	</td>
					  </tr>
					  <tr>
					    <td colspan="2"><label align="left" style="font-size: 1.5em;">* 이름</label></td>
					 </tr>
					 <tr>
					 	<td colspan="2">
						  <div class="field">
						    <input type="text" name="userName" id="userName" placeholder="회원 이름" style="height:45px">
						  </div>
					  	</td>
					  </tr>
					   <tr>
					    <td colspan="2"><label align="left" style="font-size: 1.5em;">* 연락처</label></td>
					 </tr>
					 <tr>
					 	<td colspan="2">
						  <div class="field">
						    <input type="text" name="phone" id="phone" placeholder="010-0000-0000" style="height:45px">
						  </div>
					  	</td>
					  </tr>
					  	   <tr>
					     <td colspan="2"><label align="left" style="font-size: 1.5em;">* 주소</label></td>
					    
					 </tr>
					 <tr>
					 	<!-- <td colspan="2">
						  <div class="field">
						    <input type="text" name="address" id="address" placeholder="OO시 OO구 OO동" style="height:45px">
						  </div>
					  	</td> -->
					  	<td><input type="text" id="sample5_address" placeholder="주소" name="address" style="height: 46px;"></td>
					    <td><button class="ui button" type="button" onclick="return sample5_execDaumPostcode()" value="주소 검색">주소 검색</button><br></td>
					    <tr>
					    	<td colspan="2"><div id="map" style="width:600px;height:300px;margin-top:10px;display:none"></div></td>
					    </tr> 
					  </tr>
					  <tr>
					    <td colspan="2"><label align="left" style="font-size: 1.5em;">* 이메일</label></td>
					 </tr>
					 <tr>
					 	<td>
						  <div class="field">
						    <input type="email" name="email" id="email" placeholder="EAMAIL@EAMAIL.COM" style="height:45px">
						  </div>
					  	</td>
					  	 <td><button class="ui button" type="button" onclick="return registerEmail();" id="emailCheckBtn">이메일 인증</button></td>
					  </tr>
					  <tr>
					    <td colspan="2"><label align="left" style="font-size: 1.5em;">* 인증번호 확인</label></td>
					 </tr>
					 <tr>
					 	<td>
						  <div class="field">
						    <input type="text" name="confirm" placeholder="인증번호를 입력해주세요." id="emailCode" style="height:45px">
						  </div>
					  	</td>
					  	 <td><button class="ui button" type="button" onclick="return emailConfirm();" id="emailConfirmBtn">확인</button></td>
					  	 
					  </tr>
				</table>


				<br>
				<div class="btnAtra" align="center">
					<button class="ui button" type="submit" onclick="return join();">가입하기</button>
					<button class="ui button" type="reset">취소하기</button>
				</div>
			</form>
		</div>
				<div id="emailCheck"><div>
				<div id="idCkNum"><div>
				<div id="emailCkNum"><div>
		<!-- 내용 넣기 -->
	        </div>
	        <div class = "two wide column"></div>
	   	</div>
   	
   	<!-- footer -->
   	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		function duplicationCheck() {
			var userId = $("#userId").val();
			var getCheck = /^[a-zA-Z0-9]{4,12}$/
			
			
			if(userId == ""){
				alert("아이디를 입력해주세요.");
				$("#userId").focus();
				return false;
			}else{
				if(!getCheck.test(userId)){
					alert("형식에 맞게 입력주세요");
					$("#userId").val("");
			        $("#userId").focus();
			        return false;
				}else{
					$.ajax({
			            async: true,
			            type : 'POST',
			            data : {userId:userId},
			            url : "duplicationCheck.me",
			            success : function(data) {
			                if (data.result > 0) {
			                    alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");     
			                } else {
			                	alert("사용가능한 아이디입니다.")
			                    var idCheckBtn = $("#idCheckBtn").text("확인완료").attr("disabled",true);
			                	var idCkNum =$("#idCkNum").text(1);        
			                }
			            },
			            error : function(error) {
			                
			                alert("error : " + error);
			            }
			        });
					return false;
				}
			}	
	}
	</script>
	<script>
		function registerEmail() {
			var userId = $("#userId").val();
			var email = $("#email").val();
			var emailConfirm = $("#emailConfirm").val();

			$.ajax({
				 async: true,
	            type : 'POST',
	            data : {email:email,
	            	    userId:userId},
	            url : "registerEmail.me",
	            success : function(data) {
					if(data.result > 0){
						alert("이미 인증된 이메일입니다. 다른 이메일을 입력해주세요.")
					}else{
						alert("인증 번호가 전송 되었습니다.메일을 확인해주세요.")
						var emailCheck = $("#emailCheck").text(data.key);
					}
				},
				error : function(error) {
					alert("error : "+ error)
				}
			});
			return false;
		}
	</script>
	<script>
		function emailConfirm(){
			var check = $("#emailCheck").text();
			var emailCode = $("#emailCode").val();
			if(check == emailCode ){
				alert("인증 완료!")
				var emailConfirmBtn =$("#emailConfirmBtn").text("인증완료").attr("disabled",true);
				var emailCkNum =$("#emailCkNum").text(1);
			}else{
				alert("인증번호가 올바르지 않습니다.");
			}
			return false;
		}
	</script>
	<script>
		function join(){
			var userId = $("#userId").val();
			var userPwd = $("#userPwd").val();
			var userPwd2 = $("#userPwd2").val();
			var userName = $("#userName").val();
			var phone = $("#phone").val();
			var sample5_address = $("#sample5_address").val();
			var email = $("#email").val();
			var idCkNum = $("#idCkNum").html();
			var emailCkNum = $("#emailCkNum").html();
			var idCheckBtn = $("#idCheckBtn").html();
			var emailConfirmBtn=$("#emailConfirmBtn").html();
			console.log(userId);
			console.log("userPwd : "+userPwd);
			console.log("userPwd2 : "+userPwd2);
			console.log(userName);
			console.log(phone);
			console.log(sample5_address);
			console.log(email);
			console.log(idCheckBtn);
			console.log(emailConfirmBtn);
			console.log(emailConfirmBtn == '확인');
			if(userId == ""){
				alert("아이디를 입력해주세요");
				$("#userId").focus();
				return false;
			}else if(idCheckBtn == 'ID중복확인' ){
				alert("아이디 중복확인을 완료해주세요.");
				$("#userId").focus();
				return false;
			}else if(userPwd == ""){
				alert("비밀번호를 입력해주세요");
				$("#userPwd").focus();
				return false;
			}else if(userPwd != userPwd2){
				alert("비밀번호가 일치하지 않습니다.");
				$("#userPwd").focus();
				return false;
			}else if(userName == ""){
				alert("이름을 입력해주세요.");
				$("#userName").focus();
				return false;
			}else if(phone == ""){
				alert("연락처를 입력해주세요.")
				$("#phone").focus();
				return false;
			}else if(sample5_address == ""){
				alert("주소를 입력해주세요");
				$("#address").focus();
				return false;
			}else if(email == ""){
				alert("이메일을 입력해주세요.")
				$("#email").focus();
				return false;
			}else if(emailConfirmBtn == '확인'){
				alert("이메일 인증을 완료해주세요.");
				$("#email").focus();
				return false;
			}else{
				alert("회원가입 성공!")
				$("#joinForm").submit();
				return true;
			}
			
			
		}
	</script>
	
	<script>
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
            level: 5 // 지도의 확대 레벨
        };

    //지도를 미리 생성
    var map = new daum.maps.Map(mapContainer, mapOption);
    //주소-좌표 변환 객체를 생성
    var geocoder = new daum.maps.services.Geocoder();
    //마커를 미리 생성
    var marker = new daum.maps.Marker({
        position: new daum.maps.LatLng(37.537187, 127.005476),
        map: map
    });


    function sample5_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = data.address; // 최종 주소 변수

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("sample5_address").value = addr;
                // 주소로 상세 정보를 검색
                geocoder.addressSearch(data.address, function(results, status) {
                    // 정상적으로 검색이 완료됐으면
                    if (status === daum.maps.services.Status.OK) {

                        var result = results[0]; //첫번째 결과의 값을 활용

                        // 해당 주소에 대한 좌표를 받아서
                        var coords = new daum.maps.LatLng(result.y, result.x);
                        // 지도를 보여준다.
                        mapContainer.style.display = "block";
                        map.relayout();
                        // 지도 중심을 변경한다.
                        map.setCenter(coords);
                        // 마커를 결과값으로 받은 위치로 옮긴다.
                        marker.setPosition(coords)
                    }
                });
            }
        }).open();
        return false;
    }
</script>
</body>
</html>