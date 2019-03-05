<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<!-- jquery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	
	<!-- Semantic UI -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
	<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
	<!-- bootstrap -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<style>
 	.column{
     	height: 100%;
     }

</style>

</head>
<body>
	<!-- navigation - header.jsp -->
	<jsp:include page="../common/header.jsp"/>
	<!-- 해당 페이지를 view_template파일과 다른 경로에 만들었다면 include path를 수정해야합니 -->
    <div class="ui grid">
        <div class = "two wide column"></div>
        <div class = "twelve wide column" style="margin-top:50px;">
        <div class="DetailArea" align="center" style="margin-top: 150px;">
	        <table class="ui black table" style="width:1200px;">
			  <thead>
			    <tr>
			    <th colspan="4"><h1 class="ui header" style="font-size:3rem; margin-top: 40px;">${b.bTitle}</h1></th>
			  </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <td style="border-left: 1px solid white; border-right: 1px solid #dee2e6; width: 15%;"><h2 class="ui header" style="height: 40px; margin-top:5px;">작성자</h2></td>
			      <td style="border-right: 1px solid #dee2e6; width: 40%;"><h2 class="ui header" style="height: 40px; margin-top:5px;">${b.userName}</h2></td>
			      <td style="border-right: 1px solid #dee2e6; width: 15%;"><h2 class="ui header" style="height: 40px; margin-top:5px;"><i class="eye icon"></i>${b.bCount}</h2></td>
			      <td style="border-right: 1px solid white; width: 30%;"><h2 class="ui header" style="height: 40px; margin-top:5px;"><i class="calendar alternate icon"></i>${b.writeDay}</h2></td>
			    </tr>
			    <tr>
			      <td colspan="4" style="border-right: 1px solid white; border-left: 1px solid white; height: 500px;"><h3>${b.bContent}</h3></td>
			    </tr>
			  </tbody>
			</table>
			
			<table class="ui inverted table" align="center" style="width:1200px; background:gray;">
			  <thead>
			    <tr>
			      <th colspan="6" style="font-size:2rem;" id="replyC"></th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach var="r" items="${ b.replyList }">
			    <tr>
			       <td colspan="2"style="width:30%" align="center"><h3>${r.rUserName}</h3></td>
			      <td colspan="3"><h3>${r.rContent}</h3></td>
			      <td><h3>${r.writeDay}</h3></td>
			    </tr>
			  </c:forEach>
			  </tbody>
			  <tfoot>
			    <tr>
				    <th colspan="5">
						 <div class="field">
						    <textarea style="width:95%; height:150px;" name="rContent" id="rContent" placeholder="댓글을 등록해주세요. 30자이내"></textarea>
						    
	  					</div>
					</th>
					<th style="width:170px;" align="center">
						<button class="ui inverted black button" style="color:white; width:100%; height:100%;" onclick="insertReply();"><h3>등록하기</h3></button>
					</th>
			    </tr>
			  </tfoot>
			</table>
			<div class="btnArea" align="right" style="margin-right:150px;">
				<c:if test="${ sessionScope.loginUser.mid eq b.bMid }">
				<button class="ui black basic button" style="width:100px; height:50px;" onclick="updateBoard();">글 수정</button>
				<button class="ui black basic button" style="width:100px; height:50px;" onclick ="deleteBoard();">글 삭제</button>
				<button class="ui black basic button" style="width:100px; height:50px;" onclick="location.href='goBoard.bo'">목록으로</button>
				</c:if>
				<c:if test="${ sessionScope.loginUser.mid ne b.bMid }">
				<button class="ui black basic button" style="width:100px; height:50px;" onclick="location.href='goBoard.bo'">목록으로</button>
				</c:if>
			</div>
        </div>
          <!-- 내용 넣기 -->
        </div>
        <div class = "two wide column"></div>
   	</div>
   	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   	<script>
   		function insertReply() {
   		 var rContent = $("#rContent").val();
   		 var loginUser = '${sessionScope.loginUser}';
   		 var bid = '${b.bid}';
   		 console.log(bid);
		  if(loginUser == ""){
			 alert("회원만 이용가능합니다.")
		 }else{
			 location.href = "insertReply.bo?bid="+bid+"&rContent="+rContent;
		 } 
		}
   		
   		
   		/*게시물 삭제  */
   		function deleteBoard() {
			var bid= '${b.bid}';
			var bMid = '${b.bMid}';
			var userId = '${sessionScope.loginUser.mid}';
			console.log(bid);
			console.log(bMid);
			console.log(userId);
			if(window.confirm("게시물을 삭제하시겠습니까?")){
				location.href="deleteBoard.bo?bid="+bid;
			}else{
				
			}
		}
   		
   		/*게시물 수정*/
   		function updateBoard() {
			var bid = '${b.bid}';
			if(window.confirm("게시물을 수정하시겠습니까?")){
				location.href="updateBoardView.bo?bid="+bid;
			}else{
				
			}
		}
   	</script>
  	
  	<script>
  		$(function() {
  			var bid='${b.bid}';
			$.ajax({
				url:"replyCount.bo",
				type:"get",
				data:{bid:bid},
				success:function(data){
					console.log(data);
					$("#replyC").text("댓글 "+data.result);
				},
				error:function(data){
					console.log("에러!!");
				}
			});
			
		});
  	</script>
   	<!-- footer -->

</body>
</html>