<%@ page language="java" contentType="text/html; charset=UTF-8"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<meta charset="UTF-8">
<title>플래닛-회원가입</title>
<title></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
//javascript
$(function(){
	$("#btnsignup").click(function(){	
		var url = "signup.do";
		var data = $("form").serialize();
		for(var i=0; i<data.length; i++){
			if(data.charAt(i)=="=" && data.charAt(i+1)=="&"){
				alert("모든 데이터를 입력해주세요");
				return ;
			}
		}
		var success = function(responseResult){
			if (responseResult.trim() == "1") {
				alert("비밀번호 재확인이 틀렸습니다.");
			}else if(responseResult.trim() == "2"){
				alert("아이디가 중복됩니다.")
			}
			alert(responseResult);
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
	padding: 10px 15px;
	font-size: 16px;}
	button{
		font-weight: bold;
	font-size: 25px;
	background-color: #24468A;
	padding: 15px 30px;
	color: #ffffff;
	border: none;
	border-radius: 6px;
	padding: 15px 30px;
	}
</style>
<form method="post">
	ID<br>
	<input name="inputId" placeholder="아이디를 입력하세요" required>
	<br>PW <br>
	<input name="inputPw1" placeholder="비밀번호를 입력하세요" required>
	<br><input name="inputPw2" placeholder="비밀번호를 재 입력하세요" required>
	<br>이름<br>
	<input name="inputName"  placeholder="이름을 입력하세요" required>
	<br>생일<br>
	<input name="inputBirth" placeholder="주민등록번호 앞자리를 입력하세요" required>
	<br>소속<br>
	<input name="inputdept" placeholder="부서를 입력하세요" required>
	<br>이메일<br>
	<input name="inputEmail" placeholder="email을 입력하세요"required>
	<br><button class="btnsignup" id="btnsignup">가입하기</button>
</form>