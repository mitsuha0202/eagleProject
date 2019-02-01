<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eagle's Join</title>
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
	h1 {
	  margin: 0;
	  font: bold 100px/1 "Helvetica Neue", Helvetica, Arial, sans-serif;
	  color: #fff;
	  text-shadow: 0 1px 0 #cccccc, 0 2px 0 #c9c9c9, 0 3px 0 #bbbbbb, 0 4px 0 #b9b9b9, 0 5px 0 #aaaaaa, 0 6px 1px rgba(0, 0, 0, 0.1), 0 0 5px rgba(0, 0, 0, 0.1), 0 1px 3px rgba(0, 0, 0, 0.3), 0 3px 5px rgba(0, 0, 0, 0.2), 0 5px 10px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.2), 0 20px 20px rgba(0, 0, 0, 0.15);
	  -webkit-transition: .2s all linear;
	  letter-spacing:-2px;
	}
	h1:hover {
	  cursor: text;
	}
	h1:focus {
	  outline: none;
	}
	h1.ui.header{
		font-size: 4rem;
	}
	.ui.form .field>label{
		font-size: 1.5em;
	}
	.field{
		width:500px;
	}
	
</style>
</head>
<body>
	 <h1 class="ui header" align="center" style="margin-top:250px">E a g l e ' s&nbsp;&nbsp;&nbsp;&nbsp;J O I N</h1>
	 <div class="memberJoin" align="center">
		 <form class="ui form">
			 <table>
			 	<tr>
			 		<td colspan="2"><label align="left">* 아이디</label></td>
			 	</tr>
			 	<tr>
		 		  <td>
					  <div class="field" style="display:inline-block;">	    
					    <input type="text" name="userId" placeholder="ID" style="height:45px">
					  </div>
				  </td>
  				  <td><button class="ui button" type="submit">Submit</button></td>
				 </tr>
				 <tr>
				    <td colspan="2"><label align="left">* 비밀번호</label></td>
				 </tr>
				 <tr>
				 	<td>
					  <div class="field">
					    <input type="password" name="userPwd" placeholder="PASSWORD" style="height:45px">
					  </div>
				  	</td>
				  </tr>
				  <tr>
				    <td colspan="2"><label align="left">* 비밀번호확인</label></td>
				 </tr>
				 <tr>
				 	<td colspan="2">
					  <div class="field">
					    <input type="password" name="userPwd2" placeholder="PASSWORD" style="height:45px">
					  </div>
				  	</td>
				  </tr>
				  <tr>
				    <td colspan="2"><label align="left">* 이메일</label></td>
				 </tr>
				 <tr>
				 	<td colspan="2">
					  <div class="field">
					    <input type="email" name="email" placeholder="EAMAIL@EAMAIL.COM" style="height:45px">
					  </div>
				  	</td>
				  </tr>	 
			</table>
			<div class="btnAtra" align="center">
				<button class="ui button" type="submit">Submit</button>
				<button class="ui button" type="submit">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>