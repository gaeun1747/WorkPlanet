<%@ page language="java" contentType="text/html; charset=UTF-8"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>플래닛찾기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
//javascript
$(function(){
	$("#btnSearch").click(function(event) {
		var url = "planetfind.do";
		var data = $("form").serialize();
		var success = function(responseResult){
			location.herf("planetfind.do");
		}
		$.post(url, data, success);
	});
});
</script>
<style>
	form{
	margin:auto;
	text-align: center;
	font-size: 20px; 
	}
	input{
	margin-bottom: 20px;
	text-align: center;
	font-size: 30px;}
	button{
	font-weight: bold;
	font-size: 17px;
	background-color: #24468A;
	padding: 15px 30px;
	color: #ffffff;
	border: none;
	border-radius: 6px;
	padding: 15px 30px;
	}
</style>
</head> 
<body>
<form method="post">
	<div>
	<input name="planetName" class="planetName">
	<button name="btnSearch" class="btnSearch">검색</button>
	</div>
</form>
<div>
<jsp:include page="planetfinddetail.jsp"></jsp:include>
</div>
</body>
</html>