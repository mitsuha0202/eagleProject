<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>위시리스트</title>
<style>

	/* 페이지 제목 */
	.title{
		padding-left: 80px;
		padding-top: 80px;
		top: 200px;
		left: 70px;
	}
	
	.wishListInfo{
		padding-top: 50px;
		padding-left: 80px;
		top: 300px;
		left: 70px;
		width: 1350px;
		height: 100px;
	}
	.wishTableArea{
		padding-left: 50px;
		padding-top: 100px;
	}
	
	.btnArea{
		padding-left: 40%;
		padding-top: 200px;
	}
	
	#wishDeleteBtn{
		height: 35px;
		width: 105px;
	}
	#closeBtn{	
		height: 35px;
		width: 105px;
	}
	
	.selected{
	background-color: gray;
	}
</style>
</head>
	<body>
			<!-- 헤더바 -->
			<jsp:include page="../common/header.jsp"/>
		
		<!-- 페이지 제목 -->
		<div class="title"><h1>위시리스트</h1></div>
		
		<div class="wishListInfo">
			<br>
			<p>회원님께서 관심물품으로 직접 등록하신 물품의 리스트입니다.<br>물품정보가 변경되었을 수 있으니 입찰하시기전에 반드시 경매정보 및 물품정보를 재확인하시기 바랍니다.<br>판매종료된 자료는 자동삭제됩니다.</p>
		</div>
		<div class="wishTableArea">
			<table class="table" style="width: 1300px; margin-left: auto; margin-right: auto;">
				<thead>
				<tr>
					<th><input type="checkbox" name="All" id="checkAlltr" onclick="checkAll();" style="width: 17px; height: 17px; margin-left: auto; margin-right: auto;"></th>
					<th>번호</th>
					<th>카테고리</th>
					<th>물품번호</th>
					<th>물품명</th>
					<th>시작가</th>
					<th>판매자</th>
					<th>마감일</th>				
				</tr>
				</thead>
				
				
				<tbody>
				<c:forEach var="w" items="${ list }">
				<tr>
					<td><input type="checkbox" name="checkTd" style="width: 17px; height: 17px; margin-left: auto; margin-right: auto;"></td>
					<td>${w.wishlistno}</td>
					<td>${w.categoryname }</td>
					<td>${w.itemno }</td>
					<td>${w.itemname }</td>
					<td>${w.startprice }</td>
					<td>${w.membername }</td>
					<td>${w.endday }</td>	
				</tr>
				</c:forEach>
				</tbody>
				
			</table>
		</div>
		<div class="btnArea">			
			<button class="ui orange basic button" id="wishDeleteBtn" onclick="deletewishList()">삭제</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="ui black basic button" id="closeBtn" onclick="location.href='myPageMain.mp'">닫기</button>
		</div>
	</body>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script>
			var tdArr = new Array();
			function checkAll() {
				if ($("#checkAlltr").is(':checked')) {
					$("input[name=checkTd]").prop("checked", true);
					$("input[name=checkTd]").parent().parent().addClass("selected");
				
				} else {
					$("input[name=checkTd]").prop("checked", false);
					$("input[name=checkTd]").parent().parent().removeClass("selected");
				}
			}
		
			$("input:checkbox").on('click', function() { 
				if ( $(this).prop('checked') ) { 
				$(this).parent().parent().addClass("selected"); 
				}else { 
					$(this).parent().parent().removeClass("selected"); 
				} 
			 }); 
		 
			function deletewishList(){
			 	var rowData = new Array();
			 	
			 	var checkbox = $("input[name=checkTd]:checked");
			 	checkbox.each(function(i){
			 	var tr = checkbox.parent().parent().eq(i);
			 	var td = tr.children();
			 		
			    wishlistno = td.eq(1).text();
			    tdArr.push(wishlistno);
			    console.log(wishlistno);
			       
			    location.href='delete.mp?wishlistno='+tdArr+",";
			 	});
			} 
		</script>
</html>	