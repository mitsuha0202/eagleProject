<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<title>Eagle 문의게시판</title>
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
	 
</head>

<style>
	#text1{
		font-size:15px;
	}
	#text2{
		color:#1b5ac2;
	}
	#insertBtn{
 		text-align:center;
 		background:#1b5ac2;
 		color:white;
 		width:150px;
 		height:48px;
 		font-size:20px;
 	}
 	#insertBtn , #cancelBtn{
 		cursor:pointer;
 	}
 	#cancelBtn{
 		text-align:center;
 		background:white;
 		color:black;
 		width:150px;
 		height:48px;
 		font-size:20px;
 		border:1px solid black;
 	}
 	#text3{
 		font-size:20px;
 	}
 	#div1{
 		height:600px;
 	}
 	#text4{
 		font-size:15px;
 	}
 	.text5{
 		font-size:20px;
 	}
 	#div2{
 		font-size:30px;
 	}
 	#footer{ position:fixed; 
	  left:0px; 
	  bottom:10px; 
	  height:60px; 
	  width:100%; 
   }
</style>
<body>

	<jsp:include page="../common/header.jsp"/>

	<div class="ui grid">
        <div class = "two wide column"></div>
        <div class = "twelve wide column" style="margin-top:50px;">
			<div id="text1" class="tit"><b>Home > 경매하기 > <a id="text2">문의게시판</b></a></div>
			
		     <br>
		     <br>
		     <br>
		     <div id="div2" align="center"><b>문의게시판 작성</b></div>
		     <br>
		     <br>
		     <br>
		     
			  <div class="column">
			    <div id="div1" class="ui raised segment">
			      <a id="text3" class="ui blue ribbon label">문의하기</a>
			      <a id="text4">
			      	<i class="comment alternate outline icon"></i>&nbsp;<b>답변은 마이페이지 > 문의게시판에서 확인 가능합니다.</b>
			      </a>
			      <br><br><br>
			      <a class="text5"><b>제목</b></a><br>
			      <input id="title" type="text" class="form-control" placeholder="제목을 입력해주세요. (50자 내외)">
			      <br><br>
			      <a class="text5"><b>내용</b></a><br>
			      <textarea id="content" class="form-control" rows="14" placeholder="내용을 입력해주세요. (300자 내외)"></textarea>
			    </div>
			  </div>
		     <br>
		     <br>
		     <div class="btnArea" align="center">
				<div id="insertBtn" class="ui massive label">등록</div>
				<div id="cancelBtn" class="ui massive label">취소</div>
			</div>
			<br><br><br>
		</div>
	</div>
	<div id="footer">
      <div style="width:200px"></div>
      <jsp:include page="../common/footer.jsp" />
      </div>
      
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>

	$(function(){
		var itemNo = '${itemNo}';
		var aCode = '${aCode}';
		$("#insertBtn").click(function(){
			var memberNo = '${memberNo}';
			var sMemberNo = '${sMemberNo}';
			var title = $("#title").val();
			var content = $("#content").val();
			
			$.ajax({
				url:"insertQuestion.bi",
				type:"get",
				data:{itemNo : itemNo , memberNo : memberNo , sMemberNo : sMemberNo , title : title , boardContent : content},
				success:function(data){
					alert("문의게시판 작성이 완료되었습니다.");
					location.href="auctionDetail.bi?itemNo=" + itemNo + "&auctionCode=" + aCode;
					console.log("문의게시판 작성 성공");
				},
				error:function(){
					console.log("문의게시판 작성 실패");
				}
			});
		});
		
		$("#cancelBtn").click(function(){
			swal("Hello world!").then((value) => {
				location.href="auctionDetail.bi?itemNo=" + itemNo + "&auctionCode=" + aCode;
			});	
		});
	});

</script>
</body>
</html>