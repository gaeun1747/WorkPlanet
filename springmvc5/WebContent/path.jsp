<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
expression : request.getContextPath()=    
<%=request.getContextPath()%><br>
el : pageContext.request.contextPath=
${pageContext.request.contextPath}
<hr>
expression : request.getRequestURL()=
<%=request.getRequestURL() %><br>
el : pageContext.request.requestURL=
${pageContext.request.requestURL}
<hr>
expression : request.getRequestURI() =
<%=request.getRequestURI() %><br>
el : pageContext.request.requestURI=
${pageContext.request.requestURI}
<hr>
</body>
</html>