<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../admin/include/common.jsp" %>

<title>Eagle 관리자페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div id="Wrap"><!-- Wrap S -->

	<%@ include file="include/header.jsp" %>

	<div id="container"><!-- container S -->

		<div class="tit">&bull; 카테고리관리</div>

		<div class="contBox mt30"><!-- contBox S -->
			<div class="topsearch mt30 mb30" id=searchArea><!-- topsearch S -->
				<span>
					<span>
						<select id="size" name="size" class="wth140">
							<option value="" selected="selected">선택</option>
							<option value="0">대분류</option>
							<option value="1">중분류</option>
						</select> 
					</span>
					<span>
						<select id="division" name="division" class="wth140">
							<option value="1">미술</option>
							<option value="2">음악앨범</option>
							<option value="3">의류</option>
							<option value="4">생활가전</option>
							<option value="5">비디오게임</option>
							<option value="6">피규어</option>
							<option value="7">레고</option>
						</select> 
					</span>
					<label for="Keyword"></label><input id="search" name="search" class="wth240" type="text">
					<span><a class="bbtn bl" onclick="category();">추가</a></span>
					<span><a class="bbtn rd" href="#">삭제</a></span>
				</span>
			</div>
			<table class="boardList mt20">
				<caption>카테고리관리 리스트입니다.</caption>
				<colgroup>
					<col style="width:%;"><!--  -->
					<col style="width:%;"><!--  -->
				</colgroup>
				
					<thead>
					<tr>
						<th scope="col">카테고리 번호</th>
						<th scope="col">분류</th>
					</tr>
					<tbody>
					<c:forEach var="b" items="${ list }">
					<tr>
						<td>${ b.categoryNo }</td>
						<td>${ b.categoryName }</td>
					</tr>
					</c:forEach>
					</tbody>
			</table>
			<script>
				$("#size").change(function(){
					var state = $("#size option:selected").val();
					if ( state == '0' ) {
						$("#division").hide();
					} else {
						$("#division").show();
					}
				})
			
			
				function category(){
					var category = $("#search").val();
					var size = $("#size").val();
					var division = $("#division").val();
					
					location.href = "addcategory.ad?category=" + category + "&size=" + size + "&division=" + division;
				}
			</script>
			
			
		</div><!--// contBox E-->

	</div><!--// container E-->

	<%@ include file="include/footer.jsp" %>


</div><!--// Wrap E-->

</body>
</html>