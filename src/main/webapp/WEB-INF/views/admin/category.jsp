<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../admin/include/common.jsp" %>


<title>Eagle 관리자페이지</title>
</head>
<body>
<div id="Wrap"><!-- Wrap S -->

	<%@ include file="include/header.jsp" %>

	<div id="container"><!-- container S -->

		<div class="tit">&bull; 카테고리관리</div>

		<div class="contBox mt30"><!-- contBox S -->

			<table class="boardWrite mt50">
				<caption>카테고리관리 리스트입니다.</caption>
				<colgroup>
					<col style="width:%;"><!--  -->
					<col style="width:%;"><!--  -->
				</colgroup>
				<tbody>
					<tr>
						<th scope="row">의류</th>
						<td class="tcen">
							<label for=""> 체크</label>
							<input id="" name="" class="check" type="checkbox">
						</td>
					</tr>
				</tbody>
			</table>

			<div class="tcen mt30 mb30">
				<span><a class="bbtn bk" href="#">변경</a></span>
				<span><a class="bbtn bl" href="#">추가</a></span>
				<span><a class="bbtn rd" href="#">삭제</a></span>
			</div>

		</div><!--// contBox E-->

	</div><!--// container E-->

	<%@ include file="include/footer.jsp" %>


</div><!--// Wrap E-->

</body>
</html>