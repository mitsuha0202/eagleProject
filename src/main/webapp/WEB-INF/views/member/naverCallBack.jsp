<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
</head>
<body>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script>
		    /* 네이버 callBack 이후  */
			 var naver_id_login = new naver_id_login("4gAxam1u5RbIDQFeajAF", "http://localhost:8003/eg/naverCallBack.me");
			  // 접근 토큰 값 출력
			 /*  alert(naver_id_login.oauthParams.access_token); */
			  // 네이버 사용자 프로필 조회
			  naver_id_login.get_naver_userprofile("naverSignInCallback()");
			  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
			  function naverSignInCallback() {
/* 			    alert(naver_id_login.getProfileData('email'));
			    alert(naver_id_login.getProfileData('name'));
			    alert(naver_id_login.getProfileData('id')); */
		
			   var id = naver_id_login.getProfileData('id');
			   var email = naver_id_login.getProfileData('email');
			   var name = naver_id_login.getProfileData('name');
			   alert("이글스 옥션에 오신걸 환영합니다!");
			   location.href="naverLogin.me?id="+id+"&email="+email+"&name="+name+"&password=0202"; 
			  }
    </script>
</body>
</html>