<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page errorPage="err.jsp" %>
<%@page buffer="100kb" %>
<!DOCTYPE html>
<html><body>
<%for(int i=1; i<=100000; i++){%>
<%=i%>
<%} %>
<hr>
오늘날짜 : 
<% SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");%>
<%= sdf.format( new Date() ) %>
<hr>
<%
FileInputStream fis;
fis = new FileInputStream("a.txt");
%>
<%--
   FileInputStream fis;
   try{
     fis = new FileInputStream("a.txt");
   }catch(FileNotFoundException e){
	   request.setAttribute("e", e);
	   RequestDispatcher rd = 
			   request.getRequestDispatcher("err.jsp");
	   rd.forward(request, response);
   }
--%>




</body>
</html>




