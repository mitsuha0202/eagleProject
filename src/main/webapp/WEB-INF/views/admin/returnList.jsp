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

		<div class="tit">&bull; 반품관리</div>

		<div class="contBox mt30"><!-- contBox S -->			
						
			
			<div class="flo_left mt30 mb30">
				<span><a class="mbtn db" onclick="returnOk();">승인</a></span>
				<span><a class="mbtn rd" onclick="refuse();">거절</a></span>
			</div>
			
			<script>
				function refuse(){
					var payNum = $("input[name=check]:checked");
					var payNumcheck = "";
					for(var i = 0; i < payNum.length; i++){
						payNumcheck+="payNum="+payNum[i].value;
						if(i<payNum.length-1){
							payNumcheck+="&";
						}
					}
					if(payNum.length==0){
			               alert("회원을 선택해주세요.")
			            }else{
			            	location.href = "returnRefuse.ad?" + payNumcheck;
			            }
					
				}
				
				function returnOk(){
					var payNum = $("input[name=check]:checked");
					var payNumcheck = "";
					for(var i = 0; i < payNum.length; i++){
						payNumcheck+="payNum="+payNum[i].value;
						if(i<payNum.length-1){
							payNumcheck+="&";
						}
					}
					if(payNum.length==0){
			               alert("회원을 선택해주세요.")
			            }else{
			            	location.href = "returnOk.ad?" + payNumcheck;   
			            }
					
				}
				
			</script>
			
			

			<table class="boardList mt20">
				<caption>반품관리 리스트입니다.</caption>
				<colgroup>
					<col style="width:10%;"><!-- No -->
					<col style="width:10%;"><!--  -->
					<col style="width:12%;"><!--  -->
					<col style="width:12%;"><!--  -->
					<col style="width:12%;"><!--  -->
					<col style="width:30%;"><!--  -->
					<col style="width:8%;"><!--  -->
					<col style="width:8%;"><!--  -->
				</colgroup>
				<thead>
					<tr>
						<th scope="col">선택</th>
						<th scope="col">구매번호</th>
						<th scope="col">구매자 아이디</th>
						<th scope="col">연락처</th>
						<th scope="col">배송상태</th>
						<th scope="col">주소</th>
						<th scope="col">경매 물품</th>
						<th scope="col">낙찰가격</th>
					</tr>
				</thead>
				<tbody>
					<!-- <tr>
						<td colspan="7">등록된 정보가 없습니다.</td>
					</tr> -->
					<c:forEach var="b" items="${ list }">
					<tr>
						<td>
							<input name="check"value="${ b.payNo }!${ b.price }" type="checkbox">
						</td>
						<td>${ b.payNo }</td>
						<td>${ b.memberId }</td>
						<td>${ b.phone }</td>
						<td>${ b.orderm }</td>
						<td>${ b.address }</td>
						<td>${ b.itemName }</td>
						<td>${ b.price }</td>
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
            <c:url var="blistBack" value="/returnList.ad">
               <c:param name="currentPage" value="${ pi.currentPage - 1}"/>
            </c:url>
            <span><a class="prev" href="${ blistBack }">이전</a></span>
         </c:if>
         
         <c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
            <c:if test="${ p eq pi.currentPage }">
               <span><a class="num on" href="${ blistCheck }">${p}</a></span>
            </c:if>
            <c:if test="${ p ne pi.currentPage }">
               <c:url var="blistCheck" value="returnList.ad">
                  <c:param name="currentPage" value="${p}"/>
               </c:url>
               <span><a class="num" href="${ blistCheck }">${ p }</a></span>
            </c:if>
         </c:forEach>
         
         <c:if test="${ pi.currentPage >= pi.maxPage }">
            <span class="nextnc">다음</span>
         </c:if>
         <c:if test="${ pi.currentPage < pi.maxPage }">
            <c:url var="blistEnd" value="returnList.ad">
               <c:param name="currentPage" value="${ pi.currentPage + 1}"/>
            </c:url>
            <span><a class="next" href="${ blistEnd }">다음</a></span>
         </c:if>
      </div>
		</div><!--// contBox E-->

	</div><!--// container E-->

	<%@ include file="include/footer.jsp" %>


</div><!--// Wrap E-->

</body>
</html>