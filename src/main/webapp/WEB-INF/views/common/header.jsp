<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<!-- jquery -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
   
   <!-- Semantic UI -->
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
   <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
   <!-- bootstrap -->
   
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
   <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<style>

	.ui {
	height:80px;
	}
	.h1 {
		display: inline-block;
	}
	
	#in {
		height:40px;
		width:400px;
		border:1px solid black;
		background:#ffffff;
	
	}
	#searchItem {
		font-size :16px;
		width:325px;
		padding:10px;
		border:0px;
		outline:none;
		float:left;
		
	}
	#searchBtn {
		width:50px;
		height:100%;
		border:0px;
		background:#1b5ac2;
		outline:none;
		float:right;
		color:#ffffff
	
	}
	input:-ms-input-placeholder {color:#a8a8a8;}
	
	
	
	</style>

</head>

<body>
<div class="ui inverted menu">
  <a class="active item">
 	����ð�
  </a>
  <div style="width:100px"></div>
  <a class="item">
    	�α����� �Ͻø� �پ��� ������ ���� �� �ֽ��ϴ�
  </a>
	<div class="right" style="width:800px"></div>
  <a class="item" href="loginView.me">
    	�α���
  </a>
  	
   <a class="item" href="memberJoinView.me" >
    	ȸ������
  </a>
   <a class="item" href="myPageMain.mp">
    	����������
  </a>
</div>
<h1 class="h1">Eagle's Auction</h1>
<div class="btn-group" role="group" aria-label="...">
	<div style=width:200px></div>
 	<div style=width:150px;font-size:30px>����ϱ�</div>
 	<div style=width:150px;font-size:30px>��ǰ���</div>
  	<div style=width:250px;font-size:30px>���̹��Ӵ� ����</div>
  	<div style=width:150px;font-size:30px>�����Խ���</div>
  	<div style=width:100px></div>
	<div id="in">
		<input type="text" placeholder="�˻��� �Է�" id="searchItem">
		<button id="searchBtn">�˻�</button>
	</div>
</div>




</body>
</html>