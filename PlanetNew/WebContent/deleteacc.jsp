<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js">
	
</script>
<style>
h1 {
	text-align: center;
}

div.btn-group{
	text-align: center;
	margin: auto;
}

div.btn-group>button {
	font-weight: bold;
	font-size: 28px;
	background-color: #24468A;
	padding: 15px 30px;
	color: #ffffff;
	border: none;
	border-radius: 6px;
}
</style>

<script>
function init() {
	$("#btYes").click(function() {
		event.preventDefault();
		var url = 'deleteacc.do';
		var data = $("form").serialize();
		var success = function(responseResult) {
			console.log(responseResult.trim());
			if (responseResult.trim() == "1") {
				alert("계정이 삭제되었습니다");
				location.href="logout.do";
			} else {
				alert("오류");
			}
		}
		$.post(url, data, success); // ResultServlet. service( , );
	});
	
	
	$("#btNo").click(function(event){
			var url="home.jsp";
			var success = function(responseResult) {
				location.href=url;
			};
			$.post(url, success);
	});
}
$(init);
</script>
</head>
<body>
	<h1 class="check-msg">정말로 계정을 삭제하시겠습니까?</h1>
	<div class="btn-group">
		<button id="btYes">네</button>
		<button id="btNo">아니오</button>
	</div>
</body>
</html>