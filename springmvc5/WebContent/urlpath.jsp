<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>urlpath.jsp</title>
</head>
<body>
request.getRequestURL : <%=request.getRequestURL() %>,
                        ${pageContext.request.requestURL}
<br>
request.getRequestURI : <%=request.getRequestURI() %><br>
request.getServletPath : <%=request.getServletPath() %><br>
request.getRemoteHost :<%=request.getRemoteHost() %><br>
request.getRemotePort: <%=request.getRemotePort() %><br>
</body>
</html>