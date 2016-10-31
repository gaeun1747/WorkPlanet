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
			if (responseResult.trim() == "1") {
				alert("비밀번호 재확인이 틀렸습니다.");
			}else if(responseResult.trim() == "2"){
				alert("아이디가 중복됩니다.")
			}
			//alert(responseResult);
			location.href="index.jsp";
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
	font-size: 25px;}
</style>
</head>
<body>
<div class="signup">
<form method="post">
	<div>
	ID
	</div>
	<div>
	<input name="inputId" class="inputId" placeholder="아이디를 입력하세요" required>
	</div>
	<div>
	PW
	</div>
	<div>
	<input name="inputPw1" class="inputPw1" placeholder="비밀번호를 입력하세요" required>
	</div>
	<div>
	<input name="inputPw2" class="inputPw2" placeholder="비밀번호를 재 입력하세요" required>
	</div>
	<div>
	이름
	</div>
	<div>
	<input name="inputName" class="inputName" placeholder="이름을 입력하세요" required>
	</div>
	<div>
	생일
	</div>
	<div>
	<input name="inputBirth" class="inputBirth" placeholder="주민등록번호 앞자리를 입력하세요" required>
	</div>
	<div>
	소속
	</div>
	<div>
	<input name="inputdept" class="inputdept" placeholder="부서를 입력하세요" required>
	</div>
	<div>
	이메일
	</div>
	<div>
	<input name="inputEmail" class="inputEmail" placeholder="email을 입력하세요"required>
	</div>
	<div>
	<button id="btnsignup" style="width:220px">가입하기</button>
	</div>
</form>
</div>
</body>
</html>