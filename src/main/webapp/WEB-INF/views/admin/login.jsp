<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../admin/include/common.jsp" %>


<title>Eagle 관리자페이지</title>
</head>
<body>
<div id="loginWrap"><!-- loginWrap S -->

	<h1><em class="orange font30 bold">eagle</em> 관리자페이지</h1>

	<div class="loginBar mt20">
		<div class="loginBox">				
			<p class="mt50"><span>아이디</span> <label for="member_id">아이디</label><input name="memberId" id="memberId" type="text" placeholder="아이디를 입력하세요" /></p>
			<p class="mt5"><span>패스워드</span> <label for="member_pass">패스워드</label><input name="memberPwd" id="memberPwd" type="password"  placeholder="비밀번호를 입력하세요"/></p>
			<div><a class="flo_right btn" onclick="adminLogin();">로그인</a></div>
		</div>
	</div>
</div><!--// loginWrap E-->

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>
		function adminLogin() {
			
			var memberId = $("#memberId").val();
			var memberPwd = $("#memberPwd").val();
			
			location.href="adminLogin.sad?memberId="+memberId+"&memberPwd="+memberPwd;
		}
	
	</script>
</body>
</html>