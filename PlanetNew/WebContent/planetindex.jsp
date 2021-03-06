<%@page import="com.my.vo.Member"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>편리한 팀 커뮤니케이션, 플래닛! - Planet</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js">
</script>
<script>
 $(function(){
	 // 메뉴클릭
	   $(".nav").on("click", "ul.basic>li>a, ul.group>li>a, ul.master>li>a", function(event){
		   event.preventDefault();
			$("ul.basic>li a").css("background-color", "#D5D5D5").css("color", "#555555");
			$("ul.group>li a").css("background-color", "#D5D5D5").css("color", "#555555");
			$("ul.master>li a").css("background-color", "#D5D5D5").css("color", "#555555");
		 	$(this).css("background-color", "#24468A").css("color", "white");  
			var url = $(this).attr("href");  // 클릭 된 속성
			if( url=="#" ){
				return ;
			}
			var success = function(responseResult){
				$(".content").html(responseResult);
			};
		    $.post(url, success);
	   });
	   /* $(".nav").on("click", "ul.group>li>a", function(event){
		   event.preventDefault();
			$("ul.group>li a").css("background-color", "#D5D5D5").css("color", "#555555");
		 	$(this).css("background-color", "#24468A").css("color", "white");  
			var url = $(this).attr("href");  // 클릭 된 속성
			if( url=="#" ){
				return ;
			}
			var success = function(responseResult){
				$(".content").html(responseResult);
			};
		    $.post(url, success);
	   });
	   $(".nav").on("click", "ul.master>li>a", function(event){
		   event.preventDefault();
			$("ul.master>li a").css("background-color", "#D5D5D5").css("color", "#555555");
		 	$(this).css("background-color", "#24468A").css("color", "white");  
			var url = $(this).attr("href");  // 클릭 된 속성
			if( url=="#" ){
				return ;
			}
			var success = function(responseResult){
				$(".content").html(responseResult);
			};
		    $.post(url, success);
	   }); */
   });
 </script>
<style>
  address { text-align:center ; font-size:12px ; }
.frame {
	width: 100%;
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
	height:700px;
}

.nav {
	float: left;
	width: 300px;
	color: #fff;
	margin-right: 50px;
}

.content {
	float: left;
	width: 800px;
	height: 700px;
}
</style>
</head>
<body>
	<div class="frame">
		<div class="header">
			<nav>
				<jsp:include page="indexmenu.jsp" />
			</nav>
			<br><br><br><hr>
		</div>
		<div class="container">
			<div class="nav">
				<!-- 여기에 기본/마스터/그룹 메뉴 세 가지 include -->
				
				<jsp:include page="planetmenu_basic.jsp" />
				<hr>
				<c:if test="${pmemInfo.member_status==89}">
					<jsp:include page="planetmenu_master.jsp" />
				</c:if>
				<hr>
				<jsp:include page="planetmenu_group.jsp" />
			</div>
			<div class="content">
			    <jsp:include page="planetcontent.jsp" />
			</div>
		</div>
	</div>
</body>
<address>한국정보기술연구원 KITRI/공공데이터기반 java application 개발자 과정/3차 프로젝트/임종민, 최가은, 임지수</address>
</html>







