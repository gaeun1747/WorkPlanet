<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>session.jsp</title>
</head>
<body>
새로운 세션객체:<%= session.isNew() %><br>
세션ID : <%=session.getId() %><br>
세션 생성시간 : <%=new SimpleDateFormat("hh:mm:ss").format(
		new Date(session.getCreationTime()))
%><br>
세션상태정보값: <%=session.getAttribute("test") %>
</body>
</html>