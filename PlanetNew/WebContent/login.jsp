<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script>
	function init() {
		$("#btLogin").click(function() {
			event.preventDefault();
			var url = 'login.do';
			var data = $("form").serialize();
			var success = function(responseResult) {
				console.log(responseResult.trim());
				if (responseResult.trim() == "1") {
					location.href = "main.jsp";
				} else {
					alert("로그인 실패");
				}
			}
			$.post(url, data, success); // ResultServlet. service( , );
		});

		$("#btRegister").click(function() {
			location.href = "signup.jsp";
		});

	}
	$(init);
</script>
<body>
	<header>
		<nav style="text-align: center"><jsp:include
				page="indexmenu.jsp" /></nav>
	</header>
</body>
<style>
@import url('http://fonts.googleapis.com/earlyaccess/nanumgothic.css');

h1 {
	font-size: 40px;
	font-family: 'Nanum Gothic';
}

form {
	text-align: center;
	margin-top: 100px;
	font-size: 20px;
}

button {
	margin-top: 30px;
	border: 3px solid #ffffff;
	background: #24468A;
	padding: 15px 25px;
	border-radius: 30px;
	color: #FFFFFF;
	font-size: 30px;
	font-family: 'Nanum Gothic';
	vertical-align: middle;
}

#btLogin {
	margin-right: 20px;
}

input {
	font-size: 25px;
	font-family: 'Nanum Gothic';
}
</style>
<section>
	<form method="post"
		action="${pageContext.request.contextPath}/login.do">
		<h1>PLANET 로그인</h1>
		ID : <input name="member_id" required><br> <br>
		PASSWORD : <input name="member_pw" required><br> <br>
		<button id="btLogin">로그인</button>
		<button id="btRegister">회원가입</button>
	</form>
</section>


