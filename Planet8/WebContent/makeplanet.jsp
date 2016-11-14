<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js">
	
</script>
<script>
$(function(){
		$("#btSave").click(function(event) {
			event.preventDefault();
			console.log("iyyt");
			
			var url = "makeplanet.do"; // 클릭 된 속성
			var data = $("form").serialize();
			console.log(data);
			var success = function(responseResult) {
				console.log(responseResult.trim());
				if (responseResult.trim() == "1") {
					alert("플래닛이 개설되었습니다");
					location.href = "home.jsp";
				} else {
					alert("오류");
				}
			}
			$.post(url, data, success);
	});
});
$(init);
</script>
<style>
.makeplanet {
	text-align: center; 
	margin:auto;
}

.makeplanet>input {
	font-size: 20px;
	padding: 10px 15px;
}

#btSave {
	font-weight: bold;
	font-size: 25px;
	background-color: #24468A;
	padding: 10px 15px;
	color: #ffffff;
	border: none;
	border-radius: 6px;
}
</style>
</head>
<body>
	<h1 class="myplanet-tit">플래닛 개설</h1>
	<hr>
	<form class = "makeplanet" method="post">
		<input type="text" name="planet_name" placeholder="플래닛 이름" required>
		<br> <br> 
		<input type="text" name="nickname" placeholder="닉네임" required> 
		<br> <br>
		<button id="btSave">개설하기</button>
	</form>
</body>
</html>