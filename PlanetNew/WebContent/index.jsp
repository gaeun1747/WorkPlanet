<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js" ></script>
<meta charset="UTF-8">
<title>편리한 팀 커뮤니케이션, 플래닛! - Planet</title>
<style>
  header { width:100% ; height:100px }
  section { margin:auto ; width:100% ; height:700px }
  footer>address { text-align:center ; font-size:12px ; }
  section>div.indexcolorimg { width:100% ; height:400px ; 
  position:absolute ; top:250px ; background-color:rgba(0, 0, 0, 0.5) }
  section>div.backgroundimage { width:100% ; height:100% }
  img.indeximg { width:100% ; height:100% }
  section>div.indexmsg { width:100% ; position:absolute ; top: 370px ; 
  color:white ; text-align:center ; font-size:32px ; font-weight: bold ; }
  section>input[type=button] { position:absolute ; top:500px ; left:45% ; 
  font-weight:bold ; font-size:28px ; background-color:white ; 
  border:none ; padding:15px 30px ; color:#555555 ; border-radius:6px }
</style>
<script>
$(function(){
	$("nav").on("click", "ul.indexmenu>li a", function(event){
		event.preventDefault();
		var url = $(this).attr("href");
		if( url=="#"){
			return ;
		}
		var success = function(responseResult){
			if(url == "logout.do" || url=="index.jsp"){
				location.href="${pageContext.request.contextPath}";
			}
			else{
				$("section").html(responseResult);
			}
		};
		$.post(url, success);
	});	
	$("input[type=button]").click(function(event){
		event.preventDefault();
		var url="signup.jsp";
		var success = function(responseResult){
			$("section").html(responseResult);
		};
		$.post(url, success);
	});
});
</script>
</head>
<body>
<header>
  <nav style="text-align:center"><jsp:include page="indexmenu.jsp" /></nav>
  <br><br><br>
  <hr>
</header>
<section>
  <div class="indexcolorimg"></div>
  <div class="backgroundimage">
    <img class="indeximg" src="image/indeximage.png" alt="indeximg" >
  </div>
  <div class="indexmsg">
    함께 일하는 즐거움, 편리한 커뮤니케이션<br>
    우리들의 플래닛
  </div>
  <input type="button" value="가입하기" />
</section>
<footer>
  <address>한국정보기술연구원 KITRI/공공데이터기반 java application 개발자 과정/3차 프로젝트/임종민, 최가은, 임지수</address>
</footer>
</body>
</html>