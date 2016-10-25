<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>err.jsp</title>
</head>
<body style="background-color: #FFCCFF">
예외발생!<br>
<%-- <%
Exception e = (Exception)request.getAttribute("e"); 
%>
<%=e.getMessage()%> --%>
<%=exception.getMessage() %>





</body>
</html>