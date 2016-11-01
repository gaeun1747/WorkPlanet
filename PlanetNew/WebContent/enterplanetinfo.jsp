<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<title>편리한 팀 커뮤니케이션, 플래닛! - Planet</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<meta charset="UTF-8">
<style>
  input[type=button]{
	font-weight: bold;
	font-size: 20px;
	background-color: #24468A;
	padding: 15px 30px;
	color: #ffffff;
	border: none;
	border-radius: 6px;
	padding: 10px 20px;
  }
  input.deleteplanet{
	font-weight: bold;
	font-size: 20px;
	background-color: #DD0000;
	padding: 15px 30px;
	color: #ffffff;
	border: none;
	border-radius: 6px;
	padding: 10px 20px;
  }
  form{
    font-size:21px;
  }
  input[type=text]{
    font-size:18px;
    padding:10px 15px;
    width:400px
  }
</style>
<script>
	function init(){
		$("#btLogin").click(function(evgent) {
			event.preventDefault();
			var url = 'login.do';
			if($("input[name=member_id]").val()==''){
				alert("아이디를 입력해주세요.")
				$("input[name=member_id]").focus();
				return ;
			}
			if($("input[name=member_pw]").val()==''){
				alert("비밀번호를 입력해주세요.")
				$("input[name=member_pw]").focus();
				return ;
			}
			var data = $("form").serialize();
			var success = function(responseResult) {
				console.log(responseResult.trim());
				if (responseResult.trim() == "1") {
					alert("로그인 성공");
					location.href="home.jsp";
				} else {
					alert("로그인 실패");
				}
			}
			$.post(url, data, success); // ResultServlet. service( , );
		});
		
		
		
	}
	$(init);
</script>
<h2>플래닛명</h2>
<input type="text" placeholder="수정할 플래닛 이름을 입력하세요.">
<input type="button" value="저장">
<br><br><hr>
<h2>마스터 위임</h2>
<input type="text" placeholder="마스터를 위임할 멤버를 입력하세요.">
<input type="button" value="위임">
<br><br><hr>
<h2>플래닛 폐쇄</h2>
<input type="button" class="deleteplanet" value="폐쇄">
<br><br><br>