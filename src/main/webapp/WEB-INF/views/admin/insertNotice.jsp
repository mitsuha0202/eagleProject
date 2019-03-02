<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../admin/include/common.jsp" %>


<title>Eagle 관리자페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <!-- Semantic UI -->
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
   <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
</head>
<body>
<div id="Wrap"><!-- Wrap S -->

	<%@ include file="include/header.jsp" %>

	<div id="container"><!-- container S -->

		<div class="tit">&bull; 공지사항관리</div>

		<div class="contBox mt30"><!-- contBox S -->
				
			<div class="topsearch mt30 mb30"><!-- topsearch S -->
			</div>			


			<div class="insertArea ui form">
	     		<form action="insertNotice.bo" method="post">
	     			<table>
		     			<tr>
		     					<td colspan="2" align="left"><h1 class="ui header" style="font-size:3rem; margin-top: 50px; margin-bottom: 30px;" >글쓰기</h1>
		     					</td>
		     				
		     			</tr>
	     				<tr>
		     				<td colspan="2"> <div class="field">
							    <input type="text" name="bTitle" placeholder="제목을 입력해주세요. 20자이내" style="height:60px; width:1600px;">
							    </div>
							  </div>
							</td>
						</tr>
						<tr style="height: 10px;">

						</tr>
						<tr>
		     				<td colspan="2">  	
		     					<div class="field">
							    <textarea placeholder="내용을 입력해주세요. 300자 이내" name="bContent" style="height: 500px;"></textarea>
							  </div>
							</td>

	     			</table>
	     			<br>
	     			<div class="btnArea" align="center" style="margin-left: 300px;">
	     				<button class="ui black basic button"  type="submit" style="width:100px; height:50px;" >등록하기</button>
						<button class="ui black basic button" type="button" style="width:100px; height:50px;" onclick="return set();">취소하기</button>
					</div>
	     		</form>
	     	</div>

		</div><!--// contBox E-->

	</div><!--// container E-->

	<%@ include file="include/footer.jsp" %>


</div><!--// Wrap E-->
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