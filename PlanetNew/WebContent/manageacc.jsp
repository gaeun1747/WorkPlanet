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
			event.preventDefault();
			var url = "updatepw.jsp"; // 클릭 된 속성
			var success = function(responseResult) {
				$(".content").html(responseResult);
			};
			$.post(url, success);
		});
		$("#btndel").click(function(event) {
			event.preventDefault();
			var url = "deleteacc.jsp"; // 클릭 된 속성
			var success = function(responseResult) {
				$(".content").html(responseResult);
			};
			$.post(url, success);
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
#btndel, #btnpw {
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
			<dt>계정  ${sessionScope.loginInfo.member_id}</dt>
			<dd>
				<button id="btndel">계정삭제</button>
				<!-- 그룹의 마스터로 되어있을 경우 계정삭제 안되도록 설정하기 -->
			</dd>

		</dl>

		<dl>
			<dt>비밀번호</dt>
			<dd>
				<button id="btnpw">변경하기</button>
			</dd>
		</dl>
	</div>
</body>
</html>