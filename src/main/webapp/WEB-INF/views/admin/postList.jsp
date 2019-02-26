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

		<div class="tit">&bull; 문의 관리</div>

		<div class="contBox mt30"><!-- contBox S -->
				
			<div class="topsearch mt30 mb30"><!-- topsearch S -->
				<span class="font20 bold">날짜 검색</span>
				<span>
					<label for="Keyword"></label><input id="Keyword" name="Keyword" class="wth240" type="text">
					<a class="sch" href="#"><img src="resources/images/icoSearch.png" alt="검색" title="검색"></a> 
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
						<th scope="col">제목</th>
						<th scope="col">상세보기</th>
					</tr>
				</thead>
				<tbody>
					<!-- <tr>
						<td colspan="7">등록된 정보가 없습니다.</td>
					</tr> -->
					<tr>
							<c:forEach var="b" items="${ list }">
					<tr>
						<td>
							<input name="check"value="${ b.writeDay }" type="checkbox">
						</td>
						<td>${ b.memberId }</td>
						<td>${ b.writeDay }</td>
						<td>${ b.phone }</td>
						<td>${ b.reply }</td>
						<td>${ b.title }</td>
						<td><a class="mbtn bl" onclick="">상세보기</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>

			<!-- 페이징 버튼 영역 -->
      	<div id="pagingArea" class="numbox mt50">
         <c:if test="${ pi.currentPage <= 1 }">
            <span class="prevnc">이전</span>
         </c:if>
         <c:if test="${ pi.currentPage > 1 }">
            <c:url var="blistBack" value="/postList.ad">
               <c:param name="currentPage" value="${ pi.currentPage - 1}"/>
            </c:url>
            <span><a class="prev" href="${ blistBack }">이전</a></span>
         </c:if>
         
         <c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
            <c:if test="${ p eq pi.currentPage }">
               <span><a class="num on" href="${ blistCheck }">${p}</a></span>
            </c:if>
            <c:if test="${ p ne pi.currentPage }">
               <c:url var="blistCheck" value="postList.ad">
                  <c:param name="currentPage" value="${p}"/>
               </c:url>
               <span><a class="num" href="${ blistCheck }">${ p }</a></span>
            </c:if>
         </c:forEach>
         
         <c:if test="${ pi.currentPage >= pi.maxPage }">
            <span class="nextnc">다음</span>
         </c:if>
         <c:if test="${ pi.currentPage < pi.maxPage }">
            <c:url var="blistEnd" value="postList.ad">
               <c:param name="currentPage" value="${ pi.currentPage + 1}"/>
            </c:url>
            <span><a class="next" href="${ blistEnd }">다음</a></span>
         </c:if>
      </div>
			
			
		</div><!--// contBox E-->

	</div><!--// container E-->

	<%@ include file="include/footer.jsp" %>


</div><!--// Wrap E-->	
	
	<!-- 	<script>
				function detail(){
					
					location.href = "boardSelectOne.bo?;
					
				}
				
		</script> -->



</body>
</html>