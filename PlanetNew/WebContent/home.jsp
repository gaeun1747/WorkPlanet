<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js">
</script>
<script>
 $(function(){
	   $("nav").on("click", "ul.nav-list>li>a", function(event){
		   event.preventDefault();
			$("ul.nav-list>li a").css("background-color", "#24468A").css("color", "#ffffff");
		 	$(this).css("background-color", "#D5D5D5").css("color", "#555555");  
			var url = $(this).attr("href");  // 클릭 된 속성
			if( url=="#" ){
				return ;
			}
			var success = function(responseResult){
				$(".content").html(responseResult);
			};
		    $.post(url, success);
	   });
   });
 </script>
<style>
.frame {
	width: 1000px;
	margin: 0 auto;
	/* border: 1px solid #aaa; */
}

.header {
	width: 100%;
	height: 100px; 
	margin-bottom: 20px;
	text-align: center;
}

.container {
	/* margin-top:20px; */
	overflow: hidden;
}

.nav {
	float: left;
	width: 200px;
	color: #fff;
	margin-right: 50px;
}

.content {
	float: left;
	width: 600px;
}
</style>
</head>
<body>
	<div class="frame">
		<%-- <div class="header">
			<nav>
				<jsp:include page="indexmenu.jsp" />
			</nav>
		</div> --%>
		<div class="container">
			<div class="nav">
				<nav>
					<jsp:include page="homemenu.jsp" />
				</nav>
			</div>
			<div class="content">
				<h1>홈화면</h1>
			</div>
		</div>

	</div>
</body>
</html>