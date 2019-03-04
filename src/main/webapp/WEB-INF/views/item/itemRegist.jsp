<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<!-- jquery -->

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
 .layer {
display :none;
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
			<form action="insertItem.it" method="post" encType="multipart/form-data" id="abcd">
			<input type="hidden" name="mid" value="${ sessionScope.loginUser.mid}">
			
			<h2>카테고리 선택</h2>
			<br> <br>
			 <%--  <div class="ui list" id="divList">
			 	<c:forEach var="c" items="hmap">
			 
			 	
			 	
			 	</c:forEach> --%>
			 
				<table class="ui striped table" id="selectCategory">
					<tbody>
					
					<tr>
					<td >선택한 카테고리 경로:</td>
					<td id="spath"></td>
					<td id="spath2"></td>
					</tr>
				</tbody>
				</table>
			<!-- </div> -->
			
			
			<br> <br>
			<div class="scroll">
				-선택하세요- 
				<table class="bigCate">
				<c:forEach var="c" items="${category}">
					<tr>
						<td class="cateName">
							${c.categoryName}
							<input type="hidden" value="${c.categoryNo}">
						</td>
					</tr>
				</c:forEach>
				
				</table>
				 <input type="hidden" name="categoryNo" id="categoryNo"> 
				
			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<div id="subCate" class="scroll">
				-선택하세요- 
			    
				<table class="middleCate">
				
				
 				<%-- 	<c:forEach var="c" items="${category}">  
					<tr>
						<td class="middleTd">
						<input type="hidden" value="${c.categoryNo}" >
						</td>
					</tr>
					</c:forEach> --%>
				</table>
				 <input type="hidden" name="categoryNo2" id="categoryNo2">
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
							
						</div><div class="fileDiv"><input  multiple="multiple" type="file"  id="imgInp" name="photo" placeholder="내용을 입력해주세요">
						<a href="this" id="delete" name="delete">삭제</a>
						<br>
						<a href="#this"  id="addFile">파일 추가</a>
						</td>
								</div>
						
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
						
  							<select name="auctionCode" id="selectBox">	
    						<option value="선택">선택해주세요</option>
    						<option value="AC003">다운경매</option>
    						<option value="AC001">최고가밀봉경매</option>
    						<option value="AC002">행운경매</option>
  								</select>
  								
					
					</td>
				</tr>
				<tr>
					<td >
					<span class="layer2">시작가</span> 
					<span class="layer">시작가 범위</span> 
					</td>
					
					<td>
					<input type="text" name="startPrice" class="layer2">
					<input type="text" name="luckyPrice1" class="layer">
					</td>
				
				</tr>
				<tr>
					<td>
					<span class="layer2">입찰단위</span>
					<span class="layer">최고가 범위</span>
					</td>
					<td>
					<input type="text" name="bidUnit" class="layer2">
					<input type="text" name="luckyPrice2" class="layer">
					</td>
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
		<div class="ui primary button" onclick="return create(); alert('등록되었습니다')">
 			 확인
		</div>
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
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
	function create(){
		$("#abcd").submit();
		
	}
	
	
	$("#addFile").on("click", function(e){ //파일 추가 버튼
        e.preventDefault();
        fn_addFile();
    });

	 function fn_addFile(){
         var str = "<p><input type='file' name='photo'><a href='#this' class='btn' name='delete'>삭제</a></p>";
         $(".fileDiv").append(str);
         $("a[name='delete']").on("click", function(e){ //삭제 버튼
             e.preventDefault();
             fn_deleteFile($(this));
         });
     }
	 $("a[name='delete']").on("click", function(e){ //삭제 버튼
         e.preventDefault();
         fn_deleteFile($(this));
     });

	 function fn_deleteFile(obj){
         obj.parent().remove();
     }



	
	
	
	$("#selectBox").change(function() {
		
		var state=$("#selectBox option:selected").val();
		if( state== 'AC002') {
			$('.layer').show();
			$('.layer2').hide();
		}else {
			$('.layer').hide();
			$('.layer2').show();
		}
	});
	
	
	
	
	

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
		
	});  */
	

	

	$(".cateName").click(function(){
		var cateCode = $(this).children().val();
		$("#spath").text($(this).text());
		var abc=$("#categoryNo").val(cateCode);
		console.log(cateCode);
		var cateNo= cateCode;
		 
	 	  $.ajax({
			url: "middleCategory.it",
			type: "GET",
			data:{cateNo:cateNo},
			success:function(data){
				console.log(data);
				$("#subCate").html(''); 
				for (var key in data) {
					
					var $div=$("#subCate");
					var $table =$("<table class='middleCate'>")
					var $tr1 =$("<tr>");
					var $td1 =$("<td class='middleTd'>");
					var $input = $("<input type='hidden' name='categoryNo2' value='"+ data[key].categoryNo +"'>");
				
					 if(cateNo==data[key].upperCategoryNo) {
					 	$td1.text(data[key].categoryName);
					 	$td1.append($input);
					 	
						$tr1.append($td1);
						
						$table.append($tr1);
						
						$div.append($table);
						$(".cateName").click(function() {
							$("#spath2").html('');
							
						});		
					 }		
				}
				$(".middleTd").click(function(){
					var middle=$("#spath2").text($(this).text());
				 	var cateCode2=$(this).children().val();
				 	var cateNo2=cateCode2;
				 	/* var abc=$("input[name='categoryNo2']").val(cateNo2);
				 	console.log("ddd"+abc); */
					console.log(cateNo2);
				 	var aaa=$('input[name=categoryNo2]').attr('value',cateNo2);
				 	console.log(aaa);
				 	var mcc = aaa.split(',');
				 	var n = mcc[0];
				 	console.log(n);
				 /* 	$("#categoryNo2").val()=cateNo2; */
				 
				 	/* location.href="insertItem.it?categoryNo2=" + cateNo2; */
				 	
				});
				
				
			},
			error:function(error){
				alert("에러"+error);
			}
		});  

	});
	

				
				
				 
				
	</script>
	
	<!-- footer -->
</body>
</html>