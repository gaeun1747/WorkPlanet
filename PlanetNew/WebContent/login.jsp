<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<meta charset="UTF-8">
<style>
.loginmsg {
	margin-top: 20px;
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
	font-size: 28px;
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
		$("#btLogin").click(function() {
			event.preventDefault();
			var url = 'login.do';
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
		
		
// 		$("input[type=button]").click(function(event){
// 			if (responseResult.trim() == "1") {
			
// 			/* 이곳에 비번, 아이디 확인시 조건 들어감 */
// 			var url="home.jsp";
// 			var success = function(responseResult){
// 				$("section").html(responseResult);
// 			};
// 			$.post(url, success);
// 		});
// 		}
		
	}
	$(init);
</script>
</head>
<body>
	<div>
		<div class="loginmsg">
			<h1>planet 로그인</h1>
		</div>
		<div class="loginsubmit">
			<form method="post">
				<input type="text" name="member_id" placeholder="아이디" required><br>
				<br> <input type="text" name="member_pw" placeholder="비밀번호"
					required><br> <br>
				<button id="btLogin">로그인</button>
			</form>
		</div>
	</div>
</body>
</html>