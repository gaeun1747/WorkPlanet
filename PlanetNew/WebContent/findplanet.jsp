<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js">
	
</script>

<style>
.search-group {
	margin-top: 30px;
	padding-bottom: 30px;
	font-size: 25px;
}

form {
	text-align: center;
}

form>input {
	font-size: 25px;
}

form>button {
	font-size: 25px;
}
</style>
<script>
	function init() {
		$("#btn_psearch").click(function() {
			event.preventDefault();
			var url = 'findplanet.do';
			var data = $("form").serialize();
			var success = function(responseResult) {
				$(".findresult").html(responseResult);
			}
			$.post(url, data, success); // ResultServlet. service( , );
		});
	}
	$(init);
</script>
</head>
<body>
	<h1 class="search-title">플래닛 찾기</h1>
	<h2 class="search-msg">찾고자 하는 플래닛을 검색하세요.</h2>
	<hr>
	<form class="search-group">
		<input type="text" name="planet_name" required></input>
		<button id="btn_psearch">검색</button>
	</form>

	<nav class="findresult">
		<jsp:include page="planetfindresult.jsp" />
	</nav>
</body>
</html>