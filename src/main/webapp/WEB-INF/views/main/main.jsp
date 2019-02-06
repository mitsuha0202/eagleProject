<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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


	.pre {
		display:inline-block;
	}
	
	}
	
	.more-div{
			position : absolute;
			margin-top: -50px;
  			right: 10%;
  			cursor : pointer;
		}
		#more-icon {
			font-size : 18px;
		}
		#more-txt {
			color : rgb(50,50,50);
	        font-family: 'Nanum Gothic', sans-serif;
        		font-weight : 800;
		}
		
		#tour-price{
			color :  #ee685a;
			font-weight : 800;
			font-size : 15px;
		}
		
	

</style>


</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<!-- 해당 페이지를 view_template파일과 다른 경로에 만들었다면 include path를 수정해야합니 -->
    <div class="ui grid">
        <div class = "two wide column"></div>
        <div class = "twelve wide column" style="margin-top:50px;">
  
          <!-- 내용 넣기 -->
          <br>
	<br>
	<br>
	<h1 class="pre">Eagle's Auction 추천경매</h1>
	<div class = "more-div" style=display:inline-block;float:right>
	                <i class="chevron circle right icon" id = "more-icon"></i>
	                <font id ="more-txt">더보기 </font>
	<hr>
        </div>
        <div class = "two wide column"></div>
   	</div>
	
	
	
	
	
</body>
</html>