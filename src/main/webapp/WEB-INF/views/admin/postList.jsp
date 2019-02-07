<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<%@ include file="../admin/include/common.jsp" %>


<title>Eagle 관리자페이지</title>
</head>
<body>
<div id="Wrap"><!-- Wrap S -->

	<%@ include file="include/header.jsp" %>

	<div id="container"><!-- container S -->

		<div class="tit">&bull; 문의 관리</div>

		<div class="contBox mt30"><!-- contBox S -->
				
			<div class="topsearch mt30 mb30"><!-- topsearch S -->
				<span class="font20 bold">날짜 검색</span>
				<span>
					<label for="Keyword"></label><input id="Keyword" name="Keyword" class="wth240" type="text">
					<a class="sch" href="#"><img src="../admin/common/images/icoSearch.png" alt="검색" title="검색"></a> 
				</span>
			</div>			
			
			<div class="flo_left mt30 mb30">
				<span><a class="mbtn rd" href="#">선택 삭제</a></span>
			</div>

			<table class="boardList mt20">
				<caption>문의내역 리스트입니다.</caption>
				<colgroup>
					<col style="width:7%;"><!-- No -->
					<col style="width:12%;"><!--  -->
					<col style="width:12%;"><!--  -->
					<col style="width:12%;"><!--  -->
					<col style="width:10%;"><!--  -->
					<col style="width:%;"><!--  -->
					<col style="width:10%;"><!--  -->
				</colgroup>
				<thead>
					<tr>
						<th scope="col">선택</th>
						<th scope="col">회원 아이디</th>
						<th scope="col">날짜</th>
						<th scope="col">연락처</th>
						<th scope="col">상태</th>
						<th scope="col">상세보기</th>
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
						<td>2019-02-10</td>
						<td>010-1234-5678</td>
						<td>답변 대기중</td>
						<td>버튼</td>
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