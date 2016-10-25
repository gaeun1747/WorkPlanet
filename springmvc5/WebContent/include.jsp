<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>include.jsp</title>
</head>
<body>
<div style="background-color:yellow">
  include지시자
  <hr>
  <%@include file="first.jsp" %>
</div>
<div style="background-color:silver">
  include tag
  <hr>
  <jsp:include page="first.jsp"></jsp:include>
</div>
</body>
</html>










