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

		<div class="tit">&bull; 신고 관리</div>

		<div class="contBox mt30"><!-- contBox S -->
				
			<div class="topsearch mt30 mb30"><!-- topsearch S -->
				<span>
					<label for="col01"></label>
					<select id="searchCondition" name="searchCondition" class="wth140">
						<option value="userId">아이디</option>
						<option value="title">제목</option>
						<option value="itemNo">경매번호</option>
					</select> 
				</span>
				<span>
					<label for="Keyword"></label><input id="search" name="search" class="wth240" type="search">
					<a class="sch" onclick="searchBoard();"><img src="resources/images/icoSearch.png" alt="검색" title="검색"></a> 
				</span>
			</div>	
			<div class="flo_left mt30 mb30">
				<span><a class="mbtn rd" onclick="auctionDel();">게시글 삭제</a></span>
			</div>
			
					
			<script>
				function searchBoard(){
					var searchCondition = $("#searchCondition").val();
					var searchValue = $("#search").val();
					
					location.href = "searchReportList.ad?searchCondition=" + searchCondition + "&searchValue=" + searchValue;
				}
				
			</script>
			

			<table id="test" class="boardList mt20">
				<caption>신고 관리 리스트입니다.</caption>
				<colgroup>
					<col style="width:7%;"><!-- No -->
					<col style="width:%;"><!--  -->
					<col style="width:%;"><!--  -->
					<col style="width:%;"><!--  -->
					<col style="width:%;"><!--  -->
					<col style="width:10%;"><!--  -->
					<col style="width:10%;"><!--  -->
				</colgroup>
				<thead>
					<tr>
						<th scope="col">선택</th>
						<th scope="col">경매 번호</th>
						<th scope="col">신고 횟수</th>
						<th scope="col">신고물 제목</th>
						<th scope="col">신고자</th>
						<th scope="col">상태</th>
						<th scope="col">상세보기</th>
					</tr>
				</thead>
				<tbody>
					<!-- <tr>
						<td colspan="7">등록된 정보가 없습니다.</td>
					</tr> -->
					<c:forEach var="a" items="${ reportlist }">
					<tr>
						<td>
							<input name="check"value="${ a.itemNo }" type="checkbox">
						</td>
						<td>${ a.itemNo }</td>
						<td>${ a.reportCount }</td>
						<td>${ a.title }</td>
						<td>${ a.memberId }</td>
						<td>${ a.status }</td>
						<td><a class="mbtn bl" onclick="detail('${ a.itemNo }');">상세보기</a></td>
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
            <c:url var="blistBack" value="/reportList.ad">
               <c:param name="currentPage" value="${ pi.currentPage - 1}"/>
            </c:url>
            <span><a class="prev" href="${ blistBack }">이전</a></span>
         </c:if>
         
         <c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
            <c:if test="${ p eq pi.currentPage }">
               <span><a class="num on" href="${ blistCheck }">${p}</a></span>
            </c:if>
            <c:if test="${ p ne pi.currentPage }">
               <c:url var="blistCheck" value="reportList.ad">
                  <c:param name="currentPage" value="${p}"/>
               </c:url>
               <span><a class="num" href="${ blistCheck }">${ p }</a></span>
            </c:if>
         </c:forEach>
         
         <c:if test="${ pi.currentPage >= pi.maxPage }">
            <span class="nextnc">다음</span>
         </c:if>
         <c:if test="${ pi.currentPage < pi.maxPage }">
            <c:url var="blistEnd" value="reportList.ad">
               <c:param name="currentPage" value="${ pi.currentPage + 1}"/>
            </c:url>
            <span><a class="next" href="${ blistEnd }">다음</a></span>
         </c:if>
      </div>
		
			
		</div><!--// contBox E-->

	</div><!--// container E-->

	<%@ include file="include/footer.jsp" %>
	
</div><!--// Wrap E-->
		<script>
				function detail(itemNo){
					
					location.href = "auctionDetail.bi?itemNo=" + itemNo;
					
				}
				
				function auctionDel(){
					var check = $("input[name=check]:checked");
					var checkAuction = "";
					for(var i = 0; i < check.length; i++){
						checkAuction+="check="+check[i].value;
						if(i<check.length-1){
							checkAuction+="&";
						}
					}
					if(check.length==0){
			               alert("게시글을 선택해주세요.")
			            }else{
			            	location.href = "auctionDel.ad?" + checkAuction;
			            }
					
				}
		</script>




</body>
</html>