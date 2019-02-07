<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			    <th colspan="4"><h1 class="ui header" style="font-size:3rem; margin-top: 40px;">노가다</h1></th>
			  </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <td style="border-left: 1px solid white; border-right: 1px solid #dee2e6; width: 15%;"><h2 class="ui header" style="height: 40px; margin-top:5px;">작성자</h2></td>
			      <td style="border-right: 1px solid #dee2e6; width: 40%;"><h2 class="ui header" style="height: 40px; margin-top:5px;">개놈</h2></td>
			      <td style="border-right: 1px solid #dee2e6; width: 15%;"><h2 class="ui header" style="height: 40px; margin-top:5px;"><i class="eye icon"></i>9</h2></td>
			      <td style="border-right: 1px solid white; width: 30%;"><h2 class="ui header" style="height: 40px; margin-top:5px;"><i class="calendar alternate icon"></i>0000-00-00</h2></td>
			    </tr>
			    <tr>
			      <td colspan="4" style="border-right: 1px solid white; border-left: 1px solid white; height: 500px;">와 노가다 개힘듬</td>
			    </tr>
			  </tbody>
			</table>
			
			<table class="ui inverted table" align="center" style="width:1200px; background:gray;">
			  <thead>
			    <tr>
			      <th colspan="6" style="font-size:2rem; ">댓글 3</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <td colspan="2"style="width:30%" align="center"><h3>작성자</h3></td>
			      <td colspan="4"><h3>내용</h3></td>
			    </tr>
			  </tbody>
			  <tfoot>
			    <tr>
				    <th colspan="5">
						 <div class="field">
						    <textarea style="width:95%; height:150px;" placeholder="댓글을 등록해주세요. 30자이내"></textarea>
						    
	  					</div>
					</th>
					<th style="width:170px;" align="center">
						<button class="ui inverted black button" style="color:white; width:100%; height:100%;"><h3>등록하기</h3></button>
					</th>
			    </tr>
			  </tfoot>
			</table>
			<div class="btnArea" align="right" style="margin-right:250px;">
				<button class="ui black basic button" style="width:100px; height:50px;" onclick="updateBoard();">수정</button>
				<button class="ui black basic button" style="width:100px; height:50px;">삭제</button>
				<button class="ui black basic button" style="width:100px; height:50px;">목록으로</button>
			</div>
        </div>
          <!-- 내용 넣기 -->
        </div>
        <div class = "two wide column"></div>
   	</div>
   	<script>
   		
   	</script>
  	
   	<!-- footer -->
</body>
</html>