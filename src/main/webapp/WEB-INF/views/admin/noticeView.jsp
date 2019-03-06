<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ include file="../admin/include/common.jsp" %>


<title>Eagle 관리자페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
	#mytextarea{
		width : 900;
		height: 900;
	}
</style>
</head>
<body>
<div id="Wrap"><!-- Wrap S -->

	<%@ include file="include/header.jsp" %>

	<div id="container"><!-- container S -->

		<div class="tit">&bull; 문의 관리</div>

		<div class="contBox mt30"><!-- contBox S -->
				
			<table class="boardWrite mt30"><!-- boardWrite S-->
			<caption>문의 답변 페이지 입니다.</caption>
			<colgroup>
				<col style="width:20%;">
				<col style="width:%;">
			</colgroup>
			<tbody>
			<tr>
				<th scope="row">글 번호</th>
				<td>${ myBoard.boardNo }</td>
			</tr>
			<tr>
				<th scope="row">제목</th>
				<td>${ myBoard.title }</td>
			</tr>
			<tr>
				<th scope="row">문의 내용</th>
				<td class="minh100 clfix">
					${ myBoard.boardContents }
				</td>
			</tr>
			</tbody>
		</table><!--// boardWrite E-->
		<div class="contBox mt30">
			<textarea id="mytextarea" style="margin: 0px; width: 1196px; height: 204px;">						
			</textarea>
		</div>
		
		
		<div class="tcen mt30">
			<span><a class="bbtn or" onclick="reply('${ myBoard.boardNo }');">작성완료</a></span>
			<span><a class="bbtn bk" href="postList.ad">취소</a></span>
		</div>
	
		</div><!--// contBox E-->

	</div><!--// container E-->

	<%@ include file="include/footer.jsp" %>
	

</div><!--// Wrap E-->
		<script>
			function reply(boardNo){
				var reply = $("#mytextarea").val();
				console.log(boardNo);
				location.href = "reply.ad?reply=" + reply +"&boardNo=" + boardNo;
			} 
		</script>
</body>
</html>