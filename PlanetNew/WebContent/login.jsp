<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	function init() {
		$("#btLogin").click(function() {
			event.preventDefault();
			var url='login.do';
			var data = $("form").serialize();
			var success = function(responseResult) {
				console.log(responseResult.trim());
				if (responseResult.trim() == "1") {
					alert("로그인 성공");
				} else {
					alert("로그인 실패");
				}
			}
			$.post(url, data, success); // ResultServlet. service( , );
		});
	}
	$(init);
</script>

<style>
form {
	text-align: center ; margin:auto ; 
}
</style>
<form method="post" >
	<h1>PLANET 로그인</h1>
	ID : <input name="member_id" required><br> <br>
	PASSWORD : <input name="member_pw" required><br> <br>
	<button id="btLogin">로그인</button>
	<button id="btRegister">회원가입</button>
</form>
