<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js">
	
</script>
<script>
	$(function() {
		$("#btnpw").click(function(event) {
			var url = "updatepw.jsp"; // 클릭 된 속성
			var success = function(responseResult) {
				$(".content").html(responseResult);
			};
			$.post(url, success);
		});
		$("#btndel").click(function(event) {
			event.preventDefault();
			if(confirm("정말 계정을 삭제하시겠습니까?")==1){
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
			}
			/* 
			var url = "deleteacc.jsp"; // 클릭 된 속성
			var success = function(responseResult) {
				$(".content").html(responseResult);
			};
			$.post(url, success); */
		});
	});
</script>
<style>
dt{
	display: block;
	float: left;
	overflow: visible;
	border-color: black;
	font-size: 20px;
}
button{
	float: right;
	margin-left:150px;
	text-size: 40px;
	background: white;
	border: none;
}
</style>
</head>
<body>
	<h1 class="myplanet-tit">계정 관리</h1>
	<hr>
	<div class="manage-group">
		<dl>
			<dt>계정 : ${sessionScope.loginInfo.member_id}</dt>
			<dd>
				<button id="btndel">계정삭제</button>
				<!-- 그룹의 마스터로 되어있을 경우 계정삭제 안되도록 설정하기 -->
			</dd>

		</dl>
		<br>
		<dl>
			<dt>비밀번호</dt>
			<dd>
				<button id="btnpw">변경하기</button>
			</dd>
		</dl>
	</div>
</body>
</html>