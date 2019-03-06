<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ include file="../admin/include/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../eg/css/jquery.jqplot.css"/>
<link rel="stylesheet" href="../eg/css/jquery-ui.css"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css"/>
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
<meta charset="UTF-8">
<title>문의게시판</title>
<style>

	/* 문의게시판 설명div */
	.queryInfo{
		padding-top: 100px;
		padding-left: 80px;
	}
	
		/* 검색부분 div */
	/* 검색 select태그부분 영역 */
	.selectSize{
		padding-top: 50px;
		padding-left: 80px;
	}
	
	/* 테이블밖 div */
	.queryTableArea{
		padding-top: 80px;
		text-align: center;
	}
	
	.btnArea{
		padding-left: 800px;
	}

	#closeBtn{
		height: 35px;
		width: 105px;
	}
	
	/* 검색 input태그부분 */
	.inputSize{
		position: absolute;
		top: 374px;
		left: 235px;
		width: 400px;
	}
	/* 검색버튼 */
	#searchBtn{
		position: absolute;
		top: 1px;
		left: 405px;
	}
</style>
</head>
<body>
	<!-- 헤더바 -->
	<jsp:include page="../common/header.jsp"/>
	
	<!-- 문의게시판 설명div -->	
	<div class="queryInfo">
		<h3>문의 게시판 안내</h3>
		<br>
		<p>&nbsp; &bull; 경매진행중에 문의한 게시판에서는 진행중인 물품에 문의한 모든 내용을 이곳에서 판매자의 답변을 확인 하실 수 있습니다.<br>&nbsp; &bull; 경매종료 후에 문의한 게시판에서는 낙찰받은 물품에 대해서 문의/협의(반품)사항에 대해 질문후 답변내용 확인 하실 수 있습니다.</p>
	</div>
	
	<!-- 검색부분 div -->
			<div class="selectSize">
				<select id=searchCondition class="form-control" style="width: 150px;">
		  		<option>제목</option>
		  		<option>판매자</option>
				</select>
			</div>
			<div class="inputSize">	
				<input class="form-control" id="searchValue" placeholder="내용을 입력해주세요.">
				<button class="ui black basic button" id="searchBtn" onclick="search();" style="width: 105px; height: 35px;">검색</button>
			</div>

	
	<div class="queryTableArea">
		<table class="table" style="width: 1300px; margin-left: auto; margin-right: auto;">
			<tr>
				<td class="firstTd"><input type="checkbox" id="checkAll" onclick="check();"></td>
				<td class="td1">번호</td>
				<td class="td1">물품번호</td>
				<td class="td1">제목</td>
				<td class="td1">답변</td>
				<td class="td1">판매자</td>
				<td class="td1">등록일</td>			
			</tr>
			<c:if test="${ !empty list }">
         <c:forEach var="b" items="${ list }">
            <tr>
               <td><input type="checkbox" class="checkChild"></td> 
               <td name="choice">${ b.boardNo }</td>
               <td>${ b.itemNo }</td>
               <td>${ b.title }</td>           
               <c:if test="${ b.replyStatus eq 'Y'}">
                  <td><h5>답변완료</h5></td>
               </c:if>
               <c:if test="${ b.replyStatus eq 'N' }">
                  <td><h5>답변대기</h5></td>
               </c:if>             
               <td>${ b.saleMemberName }</td>
               <td>${ b.writeDay }</td>     
            </tr>
         </c:forEach>
         </c:if>
         <c:if test="${ empty list }">
         	<tr>
         		<td colspan="7"><h5>검색된 내용이 없습니다.</h5></td>
         	</tr>
         </c:if>
		</table>
		</div>
	<div class="btnArea">
		<button class="ui black basic button" id="closeBtn" onclick="location.href='myPageMain.mp'">닫기</button>
	</div>
	
	<div id="pagingArea" class="numbox mt50">
			<c:if test="${ pi.currentPage <= 1 }">
				<span class="prevnc">이전</span>
			</c:if>
			<c:if test="${ pi.currentPage > 1 }">
				<c:url var="blistBack" value="userMessage.mp">
					<c:param name="searchCondition" value="${searchCondition}"/>
					<c:param name="searchValue" value="${searchValue}"/>
					<c:param name="currentPage" value="${ pi.currentPage - 1 }"/>
				</c:url>
				<span><a class="prev" href="${ blistBack }">이전</a></span>
			</c:if>
			
			<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
				<c:if test="${ p eq pi.currentPage }">
					<span><a class="num on" href="${ blistCheck }" style="background-color: #168;">${p}</a></span>
				</c:if>
				<c:if test="${ p ne pi.currentPage }">
					<c:url var="blistCheck" value="userMessage.mp">
						<c:param name="searchCondition" value="${searchCondition}"/>
					<c:param name="searchValue" value="${searchValue}"/>
						<c:param name="currentPage" value="${ p }"/>
					</c:url>
					<span><a class="num" href="${ blistCheck }">${ p }</a></span>
				</c:if>
			</c:forEach>
			
			<c:if test="${ pi.currentPage >= pi.maxPage }">
				<span class="nextnc">다음</span>
			</c:if>
			<c:if test="${ pi.currentPage < pi.maxPage }">
				<c:url var="blistEnd" value="userMessage.mp">
					<c:param name="searchCondition" value="${searchCondition}"/>
					<c:param name="searchValue" value="${searchValue}"/>
					<c:param name="currentPage" value="${ pi.currentPage + 1 }"/>
				</c:url>
				<span><a class="next" href="${ blistEnd }">다음</a></span>
			</c:if>
		</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script>
   		/* 체크박스 */
   		function check() {
	   		if( $("#checkAll").is(':checked') ){
	       		$(".checkChild").prop("checked", true);
	     	}else{
	       		$(".checkChild").prop("checked", false);
	     	}
   		}
   		
   		/* 검색 */
   		function search() {
			var searchCondition = $("#searchCondition").val();
			var searchValue = $("#searchValue").val();			
			location.href = "querySearch.mp?searchCondition="+searchCondition+"&searchValue="+searchValue;
		}

   	</script>
</body>
</html>