<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie.jsp</title>
</head>
<body>
<% 
String cn = request.getParameter("cn");
String cv = request.getParameter("cv");
//요청전달데이터가 존재하면
if(cn != null && cv!=null && !cn.equals("") && !cv.equals("")){
	Cookie c = new Cookie(cn, cv);
	c.setMaxAge(30);//유효기간설정 -클라이언트사이드에 파일로 저장됨.
	                //설정안하면 현재브라우저에서만쓰이는 쿠기가 됨. 파일저장안됨
	response.addCookie(c);//응답헤더에 추가
	
%>쿠키가 저장되었습니다.<br> 
<a href="cookie.jsp">쿠키보기</a>	
<hr>
<%
}
//쿠키 찾기
Cookie [] cArr = request.getCookies();
if(cArr != null){
  for(Cookie c : cArr){
%> <%=c.getName()%> : <%=c.getValue()%><br>  	  
<%
  }
}
%>
<form method="post" action="cookie.jsp">
  쿠키이름:<input name="cn"><br>
  쿠키값:<input name="cv"><br>
 <button>쿠키저장</button><br>
 
</form>
</body>
</html>