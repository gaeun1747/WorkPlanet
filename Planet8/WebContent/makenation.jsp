<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			/* console.log("planet_id: "+planet_id); */
			
			event.preventDefault();
			var url = "makenation.do"; // 클릭 된 속성
			var data = $("form").serialize();
			console.log(data);
			var success = function(responseResult) {
				console.log(responseResult.trim());
				
				if (responseResult.trim() == "1") {
					alert("그룹이 개설되었습니다");
					location.href = "home.jsp";
				} else {
					alert("오류");
				}
			}
			$.post(url, data, success);
	});
});
$(document).ready(function(){
	   console.log($("input[name=nation_status]:checked").val());
	});
$(init);


</script>
<style>
.makenation {
	text-align: center; 
	margin:auto;
}

.makenation>input {
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
	<h1 class="makenation-tit">NATION 개설</h1>
	<hr>
	<form class = "makenation" method="post">
		<input type="text" name="nation_name" placeholder="그룹 이름" required>
		<br> <br> 
		공개<input type="radio" name="nation_status" value="o" checked="checked">
		비공개<input type="radio" name="nation_status"value="x">
		<br> <br> 
		<button id="btSave">개설하기</button>
	</form>
</body>
</html>