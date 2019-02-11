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
 	.cateRoute{
 		color:#1e90ff;
 	}
 	.line{
 		border:solid black 0.5px;
 	}
 	#priceName{
 		font-size:30px;
 		font-weight:550;
 	}
 	#won{
 		font-size:30px;
 		color:#1b5ac2;
 	}
 	#won2{
 		font-size:20px;
 	}
 	.tableHeader{
 		width:127px;
 	}
 	#bidBtn{
 		text-align:center;
 		background:#1b5ac2;
 		color:white;
 		width:220px;
 		height:45px;
 		font-size:20px;
 	}
 	#wishBtn{
 		text-align:center;
 		background:#8f784b;
 		color:white;
 		width:220px;
 		height:45px;
 		font-size:20px;
 	}
 	#qaBtn{
 		text-align:center;
 		background:#86899d;
 		color:white;
 		width:220px;
 		height:45px;
 		font-size:20px;
 	}
 	#reTime{
 		text-align:center;
 		background:#1b5ac2;
 		color:white;
 		width:220px;
 		height:auto;
 		font-size:15px;
 	}
 	#remainTime{
 		color:white !important;
 	}
 	a.step:hover{
 		text-decoration:none !important;
 	}
 	#qaBtn1{
 		margin-right:0;
 		padding:auto;
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
        
        <div id="cateRoute" class="cateRoute">홈>의류>한정판</div>
        <br>
        <div id="pName" class="pName">
        	<h3>
        		<b>상품이름</b>
        	</h3>
        </div>
        <br>
        <hr class="line">
        <br>
        <div class="ui grid" style="clear:both;">
  			<div class="eight wide column">
  				<img src="../views/images/image1.jpg">
  			</div>
		  	<div class="eight wide column">
		  		<div class="ui equal width grid">
				  <div id="priceName" class="column">
				  	현재가
				  </div>
				  <div id="won" class="column">
				  	<a id="cPrice">10,000</a><a id="won2">원</a>
				  </div>
				  <div class="column">
				  	<div id="reTime" class="ui massive label">
				  		<i class="clock outline icon"></i>남은시간 <a id="remainTime">1일 2시간 16분 15초</a>
					</div>
				  </div>
				</div>
				
				<table class="ui definition table">
				  <tbody>
				    <tr>
				      <td class="tableHeader">
				      	물품번호<br>
				      	경매방식<br>
				      	경매기간<br>
				      	시작가<br>
				      	입찰단위<br>
				      	
				      </td>
				      <td>None</td>
				    </tr>
				    <tr>
				      <td class="tableHeader">
				      	배송방법<br>
				      	배송비용
				      </td>
				      <td>
				      	택배<br>
				      	착불
				      </td>
				    </tr>
				    <tr>
				    	<td>원산지</td>
				    	<td>한국</td>
				    </tr>
				</tbody>
			</table>
			<br>
			<table class="ui definition table">
			  <tbody>
			    <tr>
			      <td class="tableHeader">
			      	판매자ID<br>
			      	판매자 등급<br>
			      	판매자 다른물품<br>
			      	판매자 구매후기
			      </td>
			      <td>
			      	None
			      </td>
			    </tr>
			</tbody>
		</table>
		<br>
		
		<div class="ui equal width grid">
			 <div class="column">
			  	<div id="bidBtn" class="ui massive label">
				  입찰하기
				</div>
			</div>
			<div class="column">
				<div id="wishBtn" class="ui massive label">
				  관심물품
				</div>
			</div>
			<div class="column">
				<div id="qaBtn" class="ui massive label">
				  문의하기
				</div>
			</div>
		</div>
				
		  	</div>
		</div>
		  				<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		
		<!-- 물품정보 -->
		
		<div id="productDetail" class="ui steps">
		  <a class="active step">
		    <div class="content">
		      <div class="title">물품정보</div>
		    </div>
		  </a>
		  <a href="#productQa" class="step">
		    <div class="content">
		      <div class="title">물품문의</div>
		    </div>
		  </a>
		  <a href="#delivery" class="step">
		    <div class="content">
		      <div class="title">배송/반품</div>
		    </div>
		  </a>
		  <a href="#receipt" class="step">
		    <div class="content">
		      <div class="title">영수증 발행안내</div>
		    </div>
		  </a>
		</div>
		<br>
		<!-- 물품정보 내용 -->
		
		
		물품정보 내용 & 사진
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		
		
		<br>
        <!-- 물품문의 -->
        
        <div id="productQa" class="ui steps">
		  <a href="#productDetail" class="step">
		    <div class="content">
		      <div class="title">물품정보</div>
		    </div>
		  </a>
		  <a class="active step">
		    <div class="content">
		      <div class="title">물품문의</div>
		    </div>
		  </a>
		  <a href="#delivery" class="step">
		    <div class="content">
		      <div class="title">배송/반품</div>
		    </div>
		  </a>
		  <a href="#receipt" class="step">
		    <div class="content">
		      <div class="title">영수증 발행안내</div>
		    </div>
		  </a>
		</div>
		<br>
		<!-- 물품문의 내용 -->
		
		<table class="ui fixed table">
		  <thead>
		    <tr>
			    <th>번호</th>
			    <th>제목</th>
			    <th>등록자</th>
			    <th>등록일</th>
		  	</tr>
		  </thead>
		  <tbody>
		    <tr>
		      <td>1</td>
		      <td>문의요</td>
		      <td>황인용</td>
		      <td>2019 - 02 - 11</td>
		    </tr>
		  </tbody>
		</table>
		
		<div id="qaBtn1">
			<button class="positive ui button">문의하기&nbsp;&nbsp;
				<i class="pencil alternate icon"></i>
			</button>
		</div>
		
		
		<br>
		<!-- 배송/반품 -->
		
		<div id="delivery" class="ui steps">
		  <a href="#productDetail" class="step">
		    <div class="content">
		      <div class="title">물품정보</div>
		    </div>
		  </a>
		  <a href="#productQa" class="step">
		    <div class="content">
		      <div class="title">물품문의</div>
		    </div>
		  </a>
		  <a class="active step">
		    <div class="content">
		      <div class="title">배송/반품</div>
		    </div>
		  </a>
		  <a href="#receipt" class="step">
		    <div class="content">
		      <div class="title">영수증 발행안내</div>
		    </div>
		  </a>
		</div>
		<br>
		<!-- 배송/반품 내용 -->
		
		
		
		
		
		
		<br>
		<!-- 영수증 발행안내 -->
		
		<div id="receipt" class="ui steps">
		  <a href="#productDetail" class="step">
		    <div class="content">
		      <div class="title">물품정보</div>
		    </div>
		  </a>
		  <a href="#productQa" class="step">
		    <div class="content">
		      <div class="title">물품문의</div>
		    </div>
		  </a>
		  <a href="#delivery" class="step">
		    <div class="content">
		      <div class="title">배송/반품</div>
		    </div>
		  </a>
		  <a class="active step">
		    <div class="content">
		      <div class="title">영수증 발행안내</div>
		    </div>
		  </a>
		</div>
        <br>
        <!-- 영수증 발행안내 내용 -->
        
        
        
        
        
        
        <br>
          <!-- 내용 넣기 -->
        </div>
        <div class = "two wide column"></div>
   	</div>
   	
   	<!-- footer -->
</body>
</html>