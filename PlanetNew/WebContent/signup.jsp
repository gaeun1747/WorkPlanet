<%@ page language="java" contentType="text/html; charset=UTF-8"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GWPro v1.0 그룹웨어 프로젝트</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
//javascript
$(function(){
	$("#btnsignup").click(function(){	
		var url = "signup.do";
		var data = $("form").serialize();
		alert(url);
		alert(data);
		var success = function(responseResult){
			//alert(responseResult);
			location.href="index.jsp";
		}
		$.post(url, data, success);
	});
});
</script>
<style>
	table{margin:auto; background-color:gray; text-align: left; width:220px }
	input{width:220px;}
</style>
</head>
<body>
<form method="post">
	<table class="signup">
	<tr><td>
	ID
	</td></tr>
	<tr><td>
	<input name="inputId" class="inputId" placeholder="아이디를 입력하세요" required>
	</td></tr>
	<tr><td>
	PW
	</td></tr>
	<tr><td>
	<input name="inputPw1" class="inputPw1" placeholder="비밀번호를 입력하세요" required>
	</td></tr>
	<tr><td>
	<input name="inputPw2" class="inputPw2" placeholder="비밀번호를 재 입력하세요" required>
	</td></tr>
	<tr><td>
	이름
	</td></tr>
	<tr><td>
	<input name="inputName" class="inputName" placeholder="이름을 입력하세요" required>
	</td></tr>
	<tr><td>
	생일
	</td></tr>
	<tr><td>
	<input name="inputBirth" class="inputBirth" placeholder="주민등록번호 앞자리를 입력하세요" required>
	</td></tr>
	<tr><td>
	소속
	</td></tr>
	<tr><td>
	<input name="inputdept" class="inputdept" placeholder="부서를 입력하세요" required>
	</td></tr>
	<tr><td>
	이메일
	</td></tr>
	<tr><td>
	<input name="inputEmail" class="inputEmail" placeholder="email을 입력하세요"required>
	</td></tr>
	<tr><td>
	<button id="btnsignup" style="width:220px">가입하기</button>
	</td></tr>
	</table>
</form>
</body>
</html>