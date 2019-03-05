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
     tr{
     	padding-bottom: 10px;
     }
    .freeBoard{
    	background: #205181;
    	width:100%;
    	height: 200px;
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
        
        <div class="insertArea ui form">
	     		<form action="insertBoard.bo" method="post">
	     			<table>
		     			<tr>
		     					<td colspan="2" align="left"><h2 class="ui header" style="font-size:2rem; margin-top: 50px;">자유게시판</h2>
		     					</td>
		     					
		     			</tr>
	     				<tr>
		     				<td colspan="2"> <div class="field">
							    <input type="text" name="bTitle" placeholder="제목을 입력해주세요. 20자이내" maxlength="20" style="height:60px; width:1600px;">
							  </div>
							</td>
						</tr>
						<tr style="height: 10px;">

						</tr>
						<tr>
		     				<td colspan="2">  	
		     					<div class="field">
							    <textarea placeholder="내용을 입력해주세요. 300자 이내"  maxlength="300" name="bContent" style="height: 500px;"></textarea>
							  </div>
							</td>

	     			</table>
	     			<br>
	     			<div class="btnArea" align="center"">
	     				<button class="ui black basic button"  type="submit" style="width:100px; height:50px;" >등록하기</button>
						<button class="ui black basic button" type="button" style="width:100px; height:50px;" onclick="return set();">취소하기</button>
					</div>
	     		</form>
	     	</div>
        
        
        
        
        
        
        
        
          <!-- 내용 넣기 -->
        </div>
        <div class = "two wide column"></div>
   	</div>
   	
   	<!-- footer -->
   	<script>
   		 function set() {
   			if(window.confirm("목록으로 돌아가시겠습니까?")){
   				location.href="goBoard.bo";
   				return false;
   			}else{
   				return false;
   			}
			
			
		} 
   	</script>
</body>
</html>