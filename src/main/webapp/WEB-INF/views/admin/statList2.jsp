<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<%@ include file="../admin/include/common.jsp" %>


<title>Eagle 관리자페이지</title>
</head>
<body>
<div id="Wrap"><!-- Wrap S -->

	<%@ include file="include/header.jsp" %>

	<div id="container"><!-- container S -->

		<div class="tit">&bull; 통계보기</div>

		<div class="contBox mt30"><!-- contBox S -->			
						
			<div class="tabBigBox btab_2ea mt40">
				<ul>
					<li><a href="statList1.ad">카테고리별 통계</a></li>
					<li class="on"><a href="statList2.ad">경매금액별 통계</a></li>
				</ul>
			</div>

			<div>
			</div>
			
		</div><!--// contBox E-->

	</div><!--// container E-->

	<%@ include file="include/footer.jsp" %>


</div><!--// Wrap E-->

</body>
</html>