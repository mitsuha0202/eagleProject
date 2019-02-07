<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<%@ include file="../admin/include/common.jsp" %>


<title>Eagle 관리자페이지</title>
</head>
<body>
<div id="Wrap"><!-- Wrap S -->

	<%@ include file="include/header.jsp" %>

	<div id="container"><!-- container S -->

		<div class="tit">&bull; 반품관리</div>

		<div class="contBox mt30"><!-- contBox S -->			
						
			
			<div class="flo_left mt30 mb30">
				<span><a class="mbtn db" href="#">승인</a></span>
				<span><a class="mbtn rd" href="#">거절</a></span>
			</div>

			<table class="boardList mt20">
				<caption>반품관리 리스트입니다.</caption>
				<colgroup>
					<col style="width:7%;"><!-- No -->
					<col style="width:12%;"><!--  -->
					<col style="width:12%;"><!--  -->
					<col style="width:12%;"><!--  -->
					<col style="width:%;"><!--  -->
					<col style="width:10%;"><!--  -->
					<col style="width:%;"><!--  -->
				</colgroup>
				<thead>
					<tr>
						<th scope="col">선택</th>
						<th scope="col">신청자 아이디</th>
						<th scope="col">수령인 아이디</th>
						<th scope="col">연락처</th>
						<th scope="col">배송주소</th>
						<th scope="col">경매물품</th>
						<th scope="col">반품내용</th>
					</tr>
				</thead>
				<tbody>
					<!-- <tr>
						<td colspan="7">등록된 정보가 없습니다.</td>
					</tr> -->
					<tr>
						<td>
							<label for=""> 체크</label>
							<input id="" name="" class="check" type="checkbox">
						</td>
						<td>test1234</td>
						<td>test5678</td>
						<td>010-1234-5678</td>
						<td>경기도 화성시 동탄반석로 231 111동 1104호</td>
						<td>책</td>
						<td>더러워요</td>
					</tr>
				</tbody>
			</table>

			
			<div class="numbox pt40 pb50"> 
				<span><a class="num" href="#">&lt;&lt;</a></span>
				<span><a class="num" href="#">&lt;</a></span>
				<span><a class="num on" href="#">1</a></span>
				<span><a class="num" href="#">2</a></span>
				<span><a class="num" href="#">3</a></span>
				<span><a class="num" href="#">&gt;</a></span>
				<span><a class="num" href="#">&gt;&gt;</a></span>
			</div>
		</div><!--// contBox E-->

	</div><!--// container E-->

	<%@ include file="include/footer.jsp" %>


</div><!--// Wrap E-->

</body>
</html>