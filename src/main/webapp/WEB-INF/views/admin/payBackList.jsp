<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../admin/include/common.jsp" %>	

<title>Eagle 관리자페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div id="Wrap"><!-- Wrap S -->

	<%@ include file="include/header.jsp" %>

	<div id="container"><!-- container S -->

		<div class="tit">&bull; 환전신청내역</div>

			<div class="flo_left mt30 mb30">
				<!-- <span><a class="mbtn wh" href="#">전체선택</a></span> -->
				<span><a class="mbtn bk" onclick="info_print();">인쇄하기</a></span>
				<span><a class="mbtn rd" onclick="payBackY();">환전 완료</a></span>
				<span><a class="mbtn bl" onclick="payBackX();">거절</a></span>
			</div>
			
			<script>
				function payBackY(){
					var checkUser = $("input[name=check]:checked");
					var payBackcheck = "";
					for(var i = 0; i < checkUser.length; i++){
						payBackcheck+="checkUser="+checkUser[i].value;
						if(i<checkUser.length-1){
							payBackcheck+="&";
						}
					}
					location.href = "payBackY.ad?" + payBackcheck;
				}
				
				function payBackX(){
					var checkUser = $("input[name=check]:checked");
					var payBackcheck = "";
					for(var i = 0; i < checkUser.length; i++){
						payBackcheck+="checkUser="+checkUser[i].value;
						if(i<checkUser.length-1){
							payBackcheck+="&";
						}
					}
					location.href = "payBackX.ad?" + payBackcheck;
				}
				
			</script>
			
			
			<div id="test">
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
						<th scope="col">최종 환전 금액</th>
					</tr>
				</thead>
				<tbody  id="test">
					<!-- <tr>
						<td colspan="9">등록된 정보가 없습니다.</td>
					</tr> -->
					<c:forEach var="b" items="${ list }">
					<tr>
						<td>
							<input name="check"value="${ b.memberId }!${ b.eMoney }" type="checkbox">
						</td>
						<td>${ b.rating }</td>
						<td>${ b.memberId }</td>
						<td>${ b.mMoney }</td>
						<td>${ b.eMoney }</td>
						<c:if test="${b.rating eq 'BRONZE'}">
						<c:set var="premium" value="10" scope="page"/> 
						</c:if>
						<c:if test="${b.rating eq 'SILVER'}">
						<c:set var="premium" value="8" scope="page"/>
						</c:if>
						<c:if test="${b.rating eq 'GOLD'}">
						<c:set var="premium" value="6" scope="page"/>
						</c:if>
						<c:if test="${b.rating eq 'DIA'}">
						<c:set var="premium" value="3" scope="page"/>
						</c:if>
						<td>${ pageScope.premium }</td>
						<td>${ b.acName }</td>
						<td>${ b.bkName }</td>
						<td>${ b.accountNo }</td>
						<fmt:parseNumber var="exchange" integerOnly="true" value="${ (b.eMoney - b.eMoney*pageScope.premium/100)/10}"/>
						<td>${ exchange*10 }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			</div>

			
			<!-- 페이징 버튼 영역 -->
      <div id="pagingArea" class="numbox mt50">
         <c:if test="${ pi.currentPage <= 1 }">
            <span class="prevnc">이전</span>
         </c:if>
         <c:if test="${ pi.currentPage > 1 }">
            <c:url var="blistBack" value="/payBackList.ad">
               <c:param name="currentPage" value="${ pi.currentPage - 1}"/>
            </c:url>
            <span><a class="prev" href="${ blistBack }">이전</a></span>
         </c:if>
         
         <c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
            <c:if test="${ p eq pi.currentPage }">
               <span><a class="num on" href="${ blistCheck }">${p}</a></span>
            </c:if>
            <c:if test="${ p ne pi.currentPage }">
               <c:url var="blistCheck" value="payBackList.ad">
                  <c:param name="currentPage" value="${p}"/>
               </c:url>
               <span><a class="num" href="${ blistCheck }">${ p }</a></span>
            </c:if>
         </c:forEach>
         
         <c:if test="${ pi.currentPage >= pi.maxPage }">
            <span class="nextnc">다음</span>
         </c:if>
         <c:if test="${ pi.currentPage < pi.maxPage }">
            <c:url var="blistEnd" value="payBackList.ad">
               <c:param name="currentPage" value="${ pi.currentPage + 1}"/>
            </c:url>
            <span><a class="next" href="${ blistEnd }">다음</a></span>
         </c:if>
      </div>
		</div><!--// contBox E-->

	</div><!--// container E-->

	<%@ include file="include/footer.jsp" %>
	<script>
	function info_print() {

		var initBody = document.body.innerHTML;

		window.onbeforeprint = function () {

			document.body.innerHTML = document.getElementById("test").innerHTML;

		}

		window.onafterprint = function () {

			document.body.innerHTML = initBody;
			
		}

		window.print();

	}

	
	</script>
	
	
</div><!--// Wrap E-->


</body>
</html>