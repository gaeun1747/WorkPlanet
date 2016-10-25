<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(function(){	
	console.log($("nav>ul.menu>li>a"));//DOM트리에 아직 없음
                                 //menu.html응답성공후에 추가될객체임.
    //nav객체의 child로 ul객체가 현재는 없지만 
    //향후 추가될 것을 예상해서 이벤트 처리를 미리 할 수 있다. on( )메서드 사용.    
	//메뉴가 클릭되었을때 기본이벤트 막고 post방식으로 ajax기술로 요청
	$("nav").on("click", "ul.menu>li a", function(event){
		event.preventDefault();
		$("ul.menu>li a").css("background-color","white").css("color", "black");
		$(this).css("background-color","silver").css("color","blue");
		var url = $(this).attr("href");
		if(url=="#"){
			return;
		}
		var success = function(responseResult){
		 	if(url=='logout.do'){		 	
				location.href="${pageContext.request.contextPath}";
		 	}else{
				$("section").html(responseResult);
			}
		};
		$.post(url, success);
	});	
});
</script>
<style>
header {margin:auto; height: 20%;}
section {margin:auto; border:1px solid;width:100%; height:800px;  overflow: auto;}
footer>address {text-align:center;font-size: 12px;}
</style>
</head>
<body>
<header>
 <nav><jsp:include page="menu.jsp"/></nav>
</header>
<section id="test"> 
테스트
</section>
<footer><address>서울시 구로구</address></footer>
</body>
</html>