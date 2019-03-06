<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

.h2 {
	display: inline-block;
}

h4 {
	display: inline-block;
}

.nay {
	float: right;
}

.may {
	height: 200px;
	border: 1px solid black;
}
</style>

</head>
<body>
	<!-- navigation - header.jsp -->
	<jsp:include page="../common/header.jsp" />
	<!-- 해당 페이지를 view_template파일과 다른 경로에 만들었다면 include path를 수정해야합니 -->
	<div id="grid" class="ui grid">
		<div class="two wide column"></div>
		<div class="twelve wide column" style="margin-top: 50px;">

			<h2 class="h2">경매하기</h2>
			<div class="ui category search" style="float: right">
				<div class="ui icon input">
				
				</div>
				<div class="results"></div>
			</div>
			<br> <br> <br> <br>

			<table class="ui basic table" style="width: 500px;">
				
				   <thead>
               <tr>

                  <th style="cursor: pointer;" class="thclass"><input type="hidden" value="8">전체보기</th>
                  <th style="cursor: pointer;" class="thclass"><input type="hidden" value="1">미술</th>
                  <th style="cursor: pointer;" class="thclass"><input type="hidden" value="2">음악앨범</th>
                  <th style="cursor: pointer;"class="thclass"><input type="hidden" value="3">의류</th>
               </tr>
            </thead>
            <tbody>
               <tr>
                  <th style="cursor: pointer;" class="thclass"><input type="hidden" value="4">생활가전</th>
                  <th style="cursor: pointer;" class="thclass"><input type="hidden" value="5">비디오게임</th>
                  <th style="cursor: pointer;" class="thclass"><input type="hidden" value="6">피규어</th>
                  <th style="cursor: pointer;" class="thclass"><input type="hidden" value="7">레고</th>
               </tr>
            </tbody>

					
			</table>

			<br> <br>
			  
			  <h4 class="countText"></h4>
			  
			
			<div class="nay">
				<div style="font-size: 20px;">
					<span style="cursor: pointer;"class="jung"> <input type="hidden" value="1">인기경매순
					</span>&nbsp;|&nbsp; <span style="cursor: pointer;" class="jung"> <input type="hidden"
						value="2">마감임박순
					</span >&nbsp;|&nbsp; <span style="cursor: pointer;" class="jung"> <input type="hidden"
						value="3">신규경매순
					</span>&nbsp;|&nbsp; <span style="cursor: pointer;" class="jung"> <input type="hidden"
						value="4">높은가격순
					</span>&nbsp;|&nbsp; <span style="cursor: pointer;" class="jung"> <input type="hidden"
						value="5">낮은가격순
					</span>&nbsp;|&nbsp; <span style="cursor: pointer;" class="jung"> <input type="hidden"
						value="6">조회많은순
					</span>&nbsp;|&nbsp; <span style="cursor: pointer;" class="jung"> <input type="hidden"
						value="7">입찰많은순
					</span>

				</div>

			</div>
			<br> <br>
			<hr>

			<!-- <div id="grid" class="ui grid" style="display:inline-block;"> -->
			<div id="firstColumn">
				<c:forEach var="i" items="${list1}">
				
					<div id="addDiv" class="four wide column"
						style="display: inline-block;">
						 <div  onclick="itemClick('${i.itemNo}','${i.auctionCode}')">
						 <input type="hidden" class="itemNo" name="itemNo" value="${i.itemNo}">
								<input type="hidden" class="auctionCode" name="auctionCode" value="${i.auctionCode}">
								<input type="hidden" name="deliveryPay" value="${i.deliveryPay}">
 								 
						<!-- <div class="itemClick"> -->
							<div class="may" style="width: 300px;">

								<img  src="resources/uploadFiles/${i.atta.changeName}"
									style="width: 300px; height: 200px;">
								
							</div>
							<table class="ui basic table" style="width: 250px;">
								<tr>
								</tr>
								<tr class="tr">
									<td colspan="2">입찰 &nbsp;&nbsp;&nbsp;&nbsp;${i.bidCount} 건</td>
									<td>조회 &nbsp;&nbsp;&nbsp;&nbsp;${i.itemcount} 회</td>
								</tr>

								<tr class="tr">
									<td colspan="2">판매자 아이디</td>
									<td>${i.memberName.userId}</td>
								</tr>
								
							</table>
									
						</div>
					</div>
												
				</c:forEach>
			</div>
			

		</div>


	</div>
	
	
	

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
	
	
	
	
	
	
		//카테고리 클릭 했을 때
		$(".thclass")
				.click(
						function() {

							var categoryLevel = $(this).children().val();
							console.log(categoryLevel);
							
							$
									.ajax({
										url : "searchCate.au",
										type : 'GET',
										data : {
											categoryLevel : categoryLevel
										},
										success : function(data) {
											$("#firstColumn").html("");
											for (var i = 0; i < data.length; i++) {
												console.log(i);
												var $div1 = $("<div class='may' style='width:300px;'>");
												var $img = $("<img style='width:300px;height:200px;' src='resources/uploadFiles/"+data[i].atta.changeName+"'>");
												var $table = $("<table class='ui basic table' style='width:250px;'>");
												var $tbody = $("<tbody>");
												var $tr1 = $("<tr>");
												var $tr2 = $("<tr class='tr'>");
												var $td1 = $("<td colspan='2'>");
												
												$td1.text("입찰    "+ data[i].bidCount+ " 건");
												var $td2 = $("<td>");
												$td2.text("조회   "+ data[i].itemcount+ "회");
												var $tr3 = $("<tr class='tr'>");
												var $td3 = $("<td colspan='2'>");
												$td3.text("판매자 아이디");
												var $td4 = $("<td>");
												$td4.text(data[i].memberName.userId);
												
												var $input1=$("<input type='hidden' class='itemNo' name='itemNo' value='"+data[i].itemNo+"'>");
												var $input2=$("<input type='hidden'  class='auctionCode' name='auctionCode' value='"+data[i].auctionCode+"'>"); 
											
												 var $div=$("<div id='itemClick1'>"); 
												
												var $addDiv = $("<div id='addDiv' class='four wide column' style='display:inline-block;'>");
											
												
												$tr2.append($td1);
												$tr2.append($td2);
												$tr3.append($td3);
												$tr3.append($td4);
												
												$tbody.append($tr1);
												$tbody.append($tr2);
												$tbody.append($tr3);
												
												$table.append($tbody);
												$div1.append($img);
												$div.append($div1);
												$div.append($table);
											  	$div.append($input1);
												$div.append($input2); 
												$addDiv.append($div);
												
											
												var $firstcolumn = $("#firstColumn");
												$firstcolumn.append($addDiv);
												//$("#addDiv").html(""); 			

												/* 	 var $grid=$("#grid");
													$grid.append($addDiv); */
												// $add.append($div1);
												//$add.append($table); 
												//$addDiv.append($add);   
												
												
											}

											
										},
										error : function(data) {
											alert("error:" + error);
										}

									});

						});

		//인기경매순------ 정렬 클릭했을 때

		$(".jung")
				.click(
						function() {
							alignName = $(this).children().val();
							console.log(alignName);
							

							$.ajax({
								url : "selectAlign.au",
								type : 'GET',
								data : {
									alignName : alignName
								},
								success : function(data) {

									console.log(data);
									$("#firstColumn").html("");
									for (var i = 0; i < data.length; i++) {
										console.log(i);
										var $div1 = $("<div class='may' style='width:300px;'>");
										var $img = $("<img style='width:300px;height:200px;' src='resources/uploadFiles/"+data[i].atta.changeName+"'>");
										var $table = $("<table class='ui basic table' style='width:250px;'>");
										var $tbody = $("<tbody>");
										var $tr1 = $("<tr>");
										var $tr2 = $("<tr class='tr'>");
										var $td1 = $("<td colspan='2'>");
										$td1.text("입찰    "+ data[i].bidCount+ " 건");
										var $td2 = $("<td>");
										$td2.text("조회   "+ data[i].itemcount+ "회");
										var $tr3 = $("<tr class='tr'>");
										var $td3 = $("<td colspan='2'>");
										$td3.text("판매자 아이디");
										var $td4 = $("<td>");
										$td4.text(data[i].memberName.userId);
										
									
										var $addDiv = $("<div id='addDiv' class='four wide column' style='display:inline-block;'>");
										var $input1=$("<input type='hidden' class='itemNo' name='itemNo' value='"+data[i].itemNo+"'>");
										var $input2=$("<input type='hidden'  class='auctionCode' name='auctionCode' value='"+data[i].auctionCode+"'>"); 
									
										 var $div=$("<div id='itemClick1'>"); 
										$tr2.append($td1);
										$tr2.append($td2);
										$tr3.append($td3);
										$tr3.append($td4);
										
										$tbody.append($tr1);
										$tbody.append($tr2);
										$tbody.append($tr3);
									
										$table.append($tbody);
										$div1.append($img);
										$div.append($div1);
										$div.append($table);
										$div.append($input1);
										$div.append($input2);
										$addDiv.append($div);
										
									
									
										var $firstcolumn = $("#firstColumn");
										$firstcolumn.append($addDiv);
										//$("#addDiv").html(""); 			

										/* 	 var $grid=$("#grid");
											$grid.append($addDiv); */
										// $add.append($div1);
										//$add.append($table); 
										//$addDiv.append($add);   
									}

									/* 					<div class="may" style=width:300px;>
									 <img src="../../../resources/uploadFiles/${i.atta.changeName}">
									 </div>
									 <table class="ui basic table" style="width:250px;">
									 <tr>
									 </tr>
									 <tr class="tr">
									 <td colspan="2">입찰 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${i.bidCount} 건</td>
									 <td>조회 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${i.itemcount} 회</td>
									 </tr>
									 <tr class="tr">
									 <td colspan="2">판매자 아이디</td>
									 <td>${i.mid}</td>
									 </tr>
									 <tr class="tr">
									 <td colspan="2">남은 시간</td>
									 <td>00</td>
									 </tr>
									 </table> */

								},
								error : function(error) {
									alert("error" + error);
								}

							});
						});
		

/* 		
	$(".itemClick").click(function(itemNo){
			
		
			var itemNo=$("input[name=itemNo]").val(); 
			var auctionCode=$("input[name=auctionCode]").val();
		
		
			console.log(itemNo);
			console.log(auctionCode);
			
			location.href="auctionDetail.bi?itemNo="+itemNo+"&auctionCode="+auctionCode;
			
		}); */
		function itemClick(itemNo,auctionCode) {
			
			/*  var auctionCode=$("input[name=auctionCode]").val();    */
			
			console.log(itemNo);
			console.log(auctionCode);
			
			location.href="auctionDetail.bi?itemNo="+itemNo+"&auctionCode="+auctionCode;
			
		}
		
	 	$(document).on("click","#itemClick1",function(event){
			
			var itemNo=$(this).children(".itemNo").val()
			var auctionCode=$(this).children(".auctionCode").val();
		
			console.log(itemNo);
			console.log(auctionCode);
			location.href="auctionDetail.bi?itemNo="+itemNo+"&auctionCode="+auctionCode;
		}); 
		
	 	
	 	$.ajax({
	 	url:"selectCount.au",
			type:"get",
			dataType:"text",
			success:function(data) {
			
				$(".countText").text("총 물품이 "+data+"개가 검색되었습니다.");
				
			},error:function(error){
				console.log("에러" + error);
			}
			
		});
	 	
	 	
	 	
	 	
		
		
	</script>


	<!-- 내용 넣기 -->

	<div class="two wide column"></div>


	<!-- footer -->
	
	
	
	
	
	
</body>

</html>