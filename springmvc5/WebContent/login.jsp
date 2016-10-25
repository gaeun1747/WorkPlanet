<%@page contentType="text/html;charset=UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
function init(){
	$("#btLogin").click (function(event){
		event.preventDefault();
		var url='login.do';
		var data = $("form").serialize();
		var success = function(responseResult){
            if(responseResult.trim() == '1'){          
            	location.href="${pageContext.request.contextPath}"; //URL redirect
           }else{
        	   alert(responseResult.trim());
           } 
		};
		$.post(url, data, success);	 
		//checkbox객체의 checked속성값이 true인경우 localstorage에 저장
		var checkedValue = $("#saveId").prop("checked");		
		if(checkedValue){
			//HTML5에서 지원해주는 객체
			localStorage.setItem("id",$("input[name=id]").val() );
		}else{
			localStorage.removeItem("id");
		}
	});	
	$("#btSignup").click(function(event){
		event.preventDefault();
		location.href="signup.html";
	});
	
	
	//name속성이 id인객체의 value속성으로 localstorage의 값을 설정한다
	var value = localStorage.getItem("id");
	if(value != undefined && value != null){
		$("input[name=id]").val(value);
		$("#saveId").prop("checked", true);
	}
}	
$(init);
</script>
<form method="post">
  ID : <input name="id"><br>
  비밀번호  : <input type="password" name="pwd"><br>
  <input type="checkbox" id="saveId">ID저장<br>
  <button id="btLogin">로그인</button>
  <button id="btSignup">가입</button>
</form>