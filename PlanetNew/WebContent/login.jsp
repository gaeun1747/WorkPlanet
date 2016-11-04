<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>편리한 팀 커뮤니케이션, 플래닛! - Planet</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<meta charset="UTF-8">
<style>
.loginmsg {
	margin-top:20px;
	text-align: center;
	margin-bottom: 40px;
	font-size: 25px;
}

form {
	text-align: center;
	margin: auto;
}

form>input {
	font-size: 25px;
	padding: 10px 15px;
}

form>button {
	font-weight: bold;
	font-size: 24px;
	background-color: #24468A;
	padding: 15px 30px;
	color: #ffffff;
	border: none;
	border-radius: 6px;
	padding: 15px 30px;
}
</style>

<script>
	function init() {
		$("#btLogin").click(function(event) {
			event.preventDefault();
			var url = 'login.do';
			if($("input[name=member_id]").val()==''){
				alert("아이디를 입력해주세요.")
				$("input[name=member_id]").focus();
				return ;
			}
			if($("input[name=member_pw]").val()==''){
				alert("비밀번호를 입력해주세요.")
				$("input[name=member_pw]").focus();
				return ;
			}
			var data = $("form").serialize();
			var success = function(responseResult) {
				console.log(responseResult.trim());
				if (responseResult.trim() == "1") {
					alert("로그인 성공");
					location.href="home.jsp";
				} else {
					alert("로그인 실패");
				}
			}
			$.post(url, data, success); // ResultServlet. service( , );
		});
		
	}
	$(init);
</script>
</head>
<body>
	<div>
		<div class="loginmsg">
			<h1>planet 로그인</h1>
		</div>
		<form method="post">
			<input type="text" name="member_id" placeholder="아이디" required><br>
			<br> <input type="password" name="member_pw" placeholder="비밀번호"	required><br> <br>
			<button id="btLogin" >로그인</button>
		</form>
	</div>
</body>
</html>