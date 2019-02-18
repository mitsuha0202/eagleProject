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

.box {
	border: 1px solid black;
	padding: 30px;
}

.scroll {
	overflow: scroll;
	width: 200px;
	height: 150px;
	display: inline-block;
	border: 1px solid black;
	
}
.confirm {
	
	margin-left: auto;
	margin-right:auto;
}
</style>

</head>
<body>
	<br>
	
	<!-- navigation - header.jsp -->
	<!-- 해당 페이지를 view_template파일과 다른 경로에 만들었다면 include path를 수정해야합니 -->
	<div class="ui grid">
		<div class="two wide column"></div>
		<div class="twelve wide column" style="margin-top: 30px;">
	
		
			<c:if test="${!empty sessionScope.loginUser }">
			
			<h1>온라인 물품 등록</h1>
			<hr>
			<form action="insertItem.it" method="post" encType="multipart/form-data">
			<input type="hidden" name="mid" value="${ sessionScope.loginUser.mid}">
			
			<h2>카테고리 선택</h2>
			<br> <br>
			 <%--  <div class="ui list" id="divList">
			 	<c:forEach var="c" items="hmap">
			 
			 	
			 	
			 	</c:forEach> --%> --%>
			 
				<table class="ui striped table">
					<tbody>
					
					<tr>
					<td>선택한 카테고리 경로:</td>
					<td></td>
					</tr>
				</tbody>
				</table>
			<!-- </div> -->
			
			
			<br> <br>
			<div class="scroll">
				-선택하세요- 
				<br> 미술 
				<br> 음악앨범 
				<br> 의류 
				<br> 생활가전 
				<br> 비디오게임
				<br> 피규어
				<br> 레고

			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<div class="scroll">
				-선택하세요- <br> 미술 <br> 음악앨범 <br> 의류 <br> 생활가전 <br>
				비디오게임 <br> 피규어 <br> 레고

			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<div class="scroll">
				-선택하세요- <br> 미술 <br> 음악앨범 <br> 의류 <br> 생활가전 <br>
				비디오게임 <br> 피규어 <br> 레고

			</div>
			<hr>

			<h2>물품정보</h2>
			<table class="ui striped table">
					<tbody>
					<tr>
						<td>물품 제목</td>
						<td><input type="text" name="itemName" placeholder="내용을 입력해주세요"></td>
						
					</tr>
				
			
					<tr class="top aligned">
						<td>물품설명</td>
						<td><input type="text"  name="detail" placeholder="내용을 입력해주세요"></td>
						
						
					</tr>
					
					<tr>
						<td>원산지</td>
						<td><input type="text" name="origin" placeholder="내용을 입력해주세요"></td>
						
						
					</tr>
						<tr>
						<td>이미지등록</td>
						<td>이미지를 넣어주세요<div>
						<div class="imgs_wrap"> </div>        			
							<img id="foo"src="#" style=width:500px; />
						</div><input  multiple="multiple" type="file"  id="imgInp" name="photo" placeholder="내용을 입력해주세요"></td>
								
						
					</tr>
				</tbody>
			</table>

			<h2>경매설정</h2>
			<hr>
			<table class="ui striped table">
			<tbody>
				<tr>
					<td>경매 방법 선택</td>
					<td>
						
  							<select name="auctionCode">
    						<option value="선택">선택해주세요</option>
    						<option value="AC003">다운경매</option>
    						<option value="AC001">최고가밀봉경매</option>
    						<option value="AC002">행운경매</option>
  								</select>
					
					</td>
				</tr>
				<tr>
					<td>시작가</td>
					<td><input type="text" name="startPrice"></td>
				</tr>
				<tr>
					<td>입찰단위</td>
					<td><input type="text" name="bidUnit"></td>
				</tr>
				<tr>
					<td>경매 시작날짜</td>
					<td><input type="date" name="startDay"></td>
				</tr>
				<tr>
					<td>경매 종료날짜</td>
					<td><input type="date" name="endDay"></td>
				</tr>
			</tbody>
			
			
			</table>
		
		<h2>배송 설정</h2>
		<hr>
		<table class="ui striped table">
		<tbody>
			
			<tr>
				<td>비용부담</td>
				<td><input type="radio" name="deliveryPay" value="선결제" id="pre">선결제&nbsp;&nbsp;
				<input type="radio" name="deliveryPay" value="착불" id="after">착불
				&nbsp;&nbsp;<input type="radio" name="deliveryPay" id="free" value="무료">무료
				<br>
				 비용 <input type="text" id="preP" name="deliveryPrice">원 
				</td>
			</tr>
			
		
		</tbody>
		
		</table>
		
		<div class="confirm" align="center">
		<button type="submit"class="ui primary button" onclick="alert('등록되었습니다')">
 			 확인
		</button>
		<button class="ui button">
  		취소
		</button>
		</div >
	</form>
	</c:if>
			<!-- 내용 넣기 -->
		</div>
		<div class="two wide column"></div>
	</div>
	<script type="text/javascript">

    function readURL(input) {

      if (input.files && input.files[0]) {

        var reader = new FileReader();

        reader.onload = function(e) {
			
           $('#foo').attr('src', e.target.result); 
			
        }

        reader.readAsDataURL(input.files[0]);

      }

    }


    $("#imgInp").change(function() {

      readURL(this);

    });

/* 
	$("input:radio[name=deliveryPay]").change(function(){
		
		if($("#pre:checked").val()=="Y") {
			$("#afterP").prop("disabled",true);
			$("#preP").prop("disabled",false);
			
		}else if($("#after:checked").val()=='Y') {
			$("#preP").prop("disabled",true);
			$("#afterP").prop("disabled",false);
		}else if($("#free:checked").val()=='Y') {
			$("#preP").prop("disabled",true);
			$("#afterP").prop("disabled",true);
			
		}
		
	}); */
	
	
	
	</script>
	
	<!-- footer -->
</body>
</html>