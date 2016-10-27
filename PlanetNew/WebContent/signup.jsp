<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
//javascript
function init(){
	var inputId = $(".inputId");
	inputId.focus(function(){
		if(inputId.val()=='아이디를 입력하세요') {
			inputId.val('');
		} else { return; }
	});
	inputId.blur(function(){
		if(inputId.val()=='' || inputId.val==null) {
			inputId.val('아이디를 입력하세요');
		} else { return; }	
	});
	
	var inputPw1 = $(".inputPw1");
	inputPw1.focus(function(){
		if(inputPw1.val()=='비밀번호를 입력하세요') {
			inputPw1.val('');
		} else { return; }
	});
	inputPw1.blur(function(){
		if(inputPw1.val()=='' || inputPw1.val==null) {
			inputPw1.val('비밀번호를 입력하세요');
		} else { return; }	
	});
	
	var inputPw2 = $(".inputPw2");
	inputPw2.focus(function(){
		if(inputPw2.val()=='비밀번호를 재 입력하세요') {
			inputPw2.val('');
		} else { return; }
	});
	inputPw2.blur(function(){
		if(inputPw2.val()=='' || inputPw2.val==null) {
			inputPw2.val('비밀번호를 재 입력하세요');
		} else { return; }	
	});
	
	var inputName = $(".inputName");
	inputName.focus(function(){
		if(inputName.val()=='이름을 입력하세요') {
			inputName.val('');
		} else { return; }
	});
	inputName.blur(function(){
		if(inputName.val()=='' || inputName.val==null) {
			inputName.val('이름을 입력하세요');
		} else { return; }	
	});
	
	var inputBirth = $(".inputBirth");
	inputBirth.focus(function(){
		if(inputBirth.val()=='주민등록번호 앞자리를 입력하세요') {
			inputBirth.val('');
		} else { return; }
	});
	inputBirth.blur(function(){
		if(inputBirth.val()=='' || inputBirth.val==null) {
			inputBirth.val('주민등록번호 앞자리를 입력하세요');
		} else { return; }	
	});
	
	var inputdept = $(".inputdept");
	inputdept.focus(function(){
		if(inputdept.val()=='부서를 입력하세요') {
			inputdept.val('');
		} else { return; }
	});
	inputdept.blur(function(){
		if(inputdept.val()=='' || inputdept.val==null) {
			inputdept.val('부서를 입력하세요');
		} else { return; }	
	});
	
	
	var inputEmail= $(".inputEmail");
	inputEmail.focus(function(){
		if(inputEmail.val()=='email을 입력하세요') {
			inputEmail.val('');
		} else { return; }
	});
	inputEmail.blur(function(){
		if(inputEmail.val()=='' || inputEmail.val==null) {
			inputEmail.val('email을 입력하세요');
		} else { return; }	
	});
	
	
	
	
	
	
	
	
	
	$("input[type=button]").click(function(){	
		var url = "iddupchk.do";
		var data = $("form").serialize();
		var success = function(responseResult){
			$("#idDupChkResult").css("color","red").html(responseResult);
		};
		$.post(url, data, success);
	});
	
}
$(init);
</script>
<style>
	table{margin:auto; background-color:gray; text-align: left; }
</style>
<form>
	<table class="signup">
	<tr><td>
	ID
	</td></tr>
	<tr><td>
	<input name="inputId" class="inputId" value="아이디를 입력하세요" required>
	</td></tr>
	<tr><td>
	PW
	</td></tr>
	<tr><td>
	<input name="inputPw1" class="inputPw1" value="비밀번호를 입력하세요" required>
	</td></tr>
	<tr><td>
	<input name="inputPw2" class="inputPw2" value="비밀번호를 재 입력하세요" required>
	</td></tr>
	<tr><td>
	이름
	</td></tr>
	<tr><td>
	<input name="inputName" class="inputName" value="이름을 입력하세요" required>
	</td></tr>
	<tr><td>
	생일
	</td></tr>
	<tr><td>
	<input name="inputBirth" class="inputBirth" value="주민등록번호 앞자리를 입력하세요" required>
	</td></tr>
	<tr><td>
	소속
	</td></tr>
	<tr><td>
	<input name="inputdept" class="inputdept" value="부서를 입력하세요" required>
	</td></tr>
	<tr><td>
	이메일
	</td></tr>
	<tr><td>
	<input name="inputEmail" class="inputEmail" value="email을 입력하세요" required>
	</td></tr>
	</table>
</form>