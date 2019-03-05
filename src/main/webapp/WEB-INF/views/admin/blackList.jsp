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

		<div class="tit">&bull; 블랙리스트 관리</div>

		<div class="contBox mt30"><!-- contBox S -->
				
			<div class="topsearch mt30 mb30" id=searchArea><!-- topsearch S -->
				<span>
					<label for="col01"></label>
					<select id="searchCondition" name="searchCondition" class="wth140">
						<option value="userId">아이디</option>
						<option value="userName">이름</option>
						<option value="phone">휴대폰번호</option>
					</select> 
				</span>
				<span>
					<label for="Keyword"></label><input id="search" name="search" class="wth240" type="text">
					<a class="sch" onclick="searchBoard();"><img src="resources/images/icoSearch.png" alt="검색" title="검색"></a> 
				</span>
			</div>
			<script>
				function searchBoard(){
					var searchCondition = $("#searchCondition").val();
					var searchValue = $("#search").val();
					
					location.href = "searchBlackList.ad?searchCondition=" + searchCondition + "&searchValue=" + searchValue;
				}
			</script>
			
			<div class="flo_left mt30 mb30">
				<!-- <span><a class="mbtn wh" href="#">전체선택</a></span> -->
				<span><a class="mbtn bk" onclick="blackListoff();">블랙리스트로 해제</a></span>
				<!-- <span><a class="mbtn rd" href="#">정지</a></span> -->
			</div>
			<script>
				function blackListoff(){
					var checkUser = $("input[name=check]:checked");
					console.log(checkUser);
					var blackListcheck = "";
					for(var i = 0; i < checkUser.length; i++){
						blackListcheck+="checkUser="+checkUser[i].value;
						if(i<checkUser.length-1){
						blackListcheck+="&";
						}
					}
					if(checkUser.length==0){
			               alert("회원을 선택해주세요.")
			            }else{
			            	location.href = "blackListoff.ad?" + blackListcheck;  
			            }
					
					
				}
			</script>


			<table class="boardList mt20">
				<caption>블랙리스트 관리 리스트입니다.</caption>
				<colgroup>
					<col style="width:7%;"><!-- No -->
					<col style="width:%;"><!--  -->
					<col style="width:%;"><!--  -->
					<col style="width:%;"><!--  -->
					<col style="width:%;"><!--  -->
					<col style="width:10%;"><!--  -->
					<col style="width:10%;"><!--  -->
					<col style="width:10%;"><!--  -->
					<col style="width:10%;"><!--  -->
				</colgroup>
				<thead>
					<tr>
						<th scope="col">선택</th>
						<th scope="col">회원등급</th>
						<th scope="col">아이디</th>
						<th scope="col">이름</th>
						<th scope="col">전화번호</th>
						<th scope="col">주소</th>
						<th scope="col">이메일</th>
						<th scope="col">보유머니</th>
						<th scope="col">탈퇴여부</th>
					</tr>
				</thead>
				<tbody>
					<!-- <tr>
						<td colspan="9">등록된 정보가 없습니다.</td>
					</tr> -->
					<c:forEach var="b" items="${ list }">
					<tr>
						<td>
							<input name="check" value="${ b.memberId }" type="checkbox">
						</td>
						<td>${ b.rating }</td>
						<td>${ b.memberId }</td>
						<td>${ b.memberName }</td>
						<td>${ b.phone }</td>
						<td>${ b.address }</td>
						<td>${ b.eMail }</td>
						<td>${ b.eMoney }</td>
						<td>${ b.wdStatus }</td>
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
            <c:url var="blistBack" value="/blackList.ad">
               <c:param name="currentPage" value="${ pi.currentPage - 1}"/>
            </c:url>
            <span><a class="prev" href="${ blistBack }">이전</a></span>
         </c:if>
         
         <c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
            <c:if test="${ p eq pi.currentPage }">
               <span><a class="num on" href="${ blistCheck }">${p}</a></span>
            </c:if>
            <c:if test="${ p ne pi.currentPage }">
               <c:url var="blistCheck" value="blackList.ad">
                  <c:param name="currentPage" value="${p}"/>
               </c:url>
               <span><a class="num" href="${ blistCheck }">${ p }</a></span>
            </c:if>
         </c:forEach>
         
         <c:if test="${ pi.currentPage >= pi.maxPage }">
            <span class="nextnc">다음</span>
         </c:if>
         <c:if test="${ pi.currentPage < pi.maxPage }">
            <c:url var="blistEnd" value="blackList.ad">
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