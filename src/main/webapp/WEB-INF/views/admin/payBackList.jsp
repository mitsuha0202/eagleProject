<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../admin/include/common.jsp" %>


<title>Eagle 관리자페이지</title>
</head>
<body>
<div id="Wrap"><!-- Wrap S -->

	<%@ include file="include/header.jsp" %>

	<div id="container"><!-- container S -->

		<div class="tit">&bull; 환전신청내역</div>

		<div class="contBox mt30"><!-- contBox S -->
				
			<div class="topsearch mt30 mb30"><!-- topsearch S -->
				<span>
					<label for="col01"></label>
					<select id="col01" name="col01" class="wth140">
						<option value="">아이디</option>
						<option value="">이름</option>
						<option value="">휴대폰번호</option>
						<option value="">이메일주소</option>
					</select> 
				</span>
				<span>
					<label for="Keyword"></label><input id="Keyword" name="Keyword" class="wth240" type="text">
					<a class="sch" href="#"><img src="../admin/common/images/icoSearch.png" alt="검색" title="검색"></a> 
				</span>
			</div>			
			
			<div class="flo_left mt30 mb30">
				<!-- <span><a class="mbtn wh" href="#">전체선택</a></span> -->
				<span><a class="mbtn bk" href="#">인쇄하기</a></span>
				<span><a class="mbtn rd" href="#">삭제</a></span>
			</div>


			<table class="boardList mt20">
				<caption>환전신청내역 리스트입니다.</caption>
				<colgroup>
					<col style="width:7%;"><!-- No -->
					<col style="width:%;"><!--  -->
					<col style="width:%;"><!--  -->
					<col style="width:%;"><!--  -->
					<col style="width:%;"><!--  -->
					<col style="width:10%;"><!--  -->
					<col style="width:10%;"><!--  -->
					<col style="width:10%;"><!--  -->
					<col style="width:%;"><!--  -->
				</colgroup>
				<thead>
					<tr>
						<th scope="col">선택</th>
						<th scope="col">회원등급</th>
						<th scope="col">신청자 아이디</th>
						<th scope="col">보유금액</th>
						<th scope="col">신청금액</th>
						<th scope="col">수수료</th>
						<th scope="col">예금주</th>
						<th scope="col">은행</th>
						<th scope="col">계좌번호</th>
					</tr>
				</thead>
				<tbody>
					<!-- <tr>
						<td colspan="9">등록된 정보가 없습니다.</td>
					</tr> -->
					<tr>
						<td>
							<label for=""> 체크</label>
							<input id="" name="" class="check" type="checkbox">
						</td>
						<td>일반</td>
						<td>test1234</td>
						<td>10000</td>
						<td>35000</td>
						<td>20</td>
						<td>배수현</td>
						<td>농협</td>
						<td>123-456-789120</td>
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