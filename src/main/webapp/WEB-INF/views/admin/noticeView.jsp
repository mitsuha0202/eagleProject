<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../admin/include/common.jsp" %>


<title>Eagle 관리자페이지</title>
</head>
<body>
<div id="Wrap"><!-- Wrap S -->

	<%@ include file="include/header.jsp" %>

	<div id="container"><!-- container S -->

		<div class="tit">&bull; 공지사항관리</div>

		<div class="contBox mt30"><!-- contBox S -->
				
			<table class="boardWrite mt30"><!-- boardWrite S-->
			<caption>공지사항관리 리스트입니다.</caption>
			<colgroup>
				<col style="width:20%;">
				<col style="width:%;">
			</colgroup>
			<tbody>
			<tr>
				<th scope="row">제목</th>
				<td>공지사항입니다~~!!!!!!!!!!!!!!!</td>
			</tr>
			<tr>
				<th scope="row">문의 내용</th>
				<td class="minh100 clfix">
					공지사항 테스트 내용<br>
					공지사항 테스트 내용<br>
					공지사항 테스트 내용<br>
					공지사항 테스트 내용<br>
				</td>
			</tr>
			</tbody>
		</table><!--// boardWrite E-->

		<div class="tcen mt30">
			<span><a class="bbtn or" href="#">작성완료<a></span>
			<span><a class="bbtn bk" href="#">취소<a></span>
		</div>

		</div><!--// contBox E-->

	</div><!--// container E-->

	<%@ include file="include/footer.jsp" %>


</div><!--// Wrap E-->

</body>
</html>