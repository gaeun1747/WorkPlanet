<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js">
	
</script>
<style>
h1{
text-align:center;
}
form {
	text-align: center;
	margin: auto;
}

form>input {
	font-size: 20px;
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
	$("#btSave").click(function() {
		event.preventDefault();
		var url = 'updatepw.do';
		var data = $("form").serialize();
		var success = function(responseResult) {
			console.log(responseResult.trim());
			if (responseResult.trim() == "1") {
				alert("비밀번호 변경성공");
				location.href="home.jsp";
			} else if(responseResult.trim() == "2") {
				alert("비밀번호 변경실패 현재 비밀번호를 확인하세요");
			}else {
				alert("비밀번호 변경실패 바꿀 비밀번호가 일치하지않습니다");
			}
		}
		$.post(url, data, success); // ResultServlet. service( , );
	});
	
}
$(init);
</script>
</head>
<body>
	<h1 class="myplanet-tit" >새로운 비밀번호 설정</h1>
	<form method="post">
		<input type="text" name="origin_pw" placeholder="현재 비밀번호" required><br>
		<br> <input type="text" name="new_pw1" placeholder="변경할 비밀번호"
			required><br> <br>
			<input type="text" name="new_pw2" placeholder="비밀번호 확인"
			required><br> <br>
		<button id="btSave">저장하기</button>
	</form>
</body>
</html>