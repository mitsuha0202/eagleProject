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

		<div class="tit">&bull; 공지사항관리</div>

		<div class="contBox mt30"><!-- contBox S -->
				
			<div class="topsearch mt30 mb30"><!-- topsearch S -->
			</div>			
			
			<div class="flo_left mt30 mb30">
				<span><a class="mbtn bk" href="insertNoticeView.bo">작성하기</a></span>
				<span><a class="mbtn rd" onclick="deleteNotice();">삭제</a></span>
			</div>


			<table class="boardList mt20">
				<caption>공지사항관리 리스트입니다.</caption>
				<colgroup>
					<col style="width:7%;"><!-- No -->
					<col style="width:%;"><!--  -->
					<col style="width:%;"><!--  -->
					<col style="width:10%;"><!--  -->
				</colgroup>
				<thead>
					<tr>
						<th scope="col">선택</th>
						<th scope="col">등록일자</th>
						<th scope="col">작성자</th>
						<th scope="col">제목</th>
						<th scope="col">내용</th>
					</tr>
				</thead>
				<tbody>
					<!-- <tr>
						<td colspan="9">등록된 정보가 없습니다.</td>
					</tr> -->
					<c:forEach var="b" items="${ list }">
					<tr>
						<td>
							<input name="check" value="${ b.bid }" type="checkbox">
						</td>
						<td>${ b.writeDay }</td>
						<td>${ b.memberId }</td>
						<td>${ b.title }</td>
						<td>${ b.content }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>

		</div><!--// contBox E-->

	</div><!--// container E-->

	<%@ include file="include/footer.jsp" %>


</div><!--// Wrap E-->
<script>
	function deleteNotice() {
		var bidArr = [];
		$("input[name=check]:checked").each(function(){
			bidArr.push($(this).val());
		});
		if(bidArr.length == 0){
			alert("삭제할 목록을 선택해주세요.")
		}else{
			if(window.confirm("선택한 목록을 삭제하시겠습니까?")){
				location.href="deleteNotice.bo?bidArr="+bidArr;
			}else{
				
			}
		}
		
		
		
		
	}
</script>
</body>
</html>