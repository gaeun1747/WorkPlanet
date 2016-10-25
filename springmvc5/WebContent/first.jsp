<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
FIRST JSP!
<!-- html 주석 : .java파일의 _jspService()내부에 out.write()인자로 포함됨-->
<%-- jsp 주석 : .java파일에 포함되지 않는다 --%>
<%--
JSP파일의 구성요소
  HTML요소
  JSP요소 
    -scripting요소
      -scriptlet : <% %> .java파일의 _jspService()내부에 포함됨. 
      -expression: <%= %> .java파일의 _jspService( )내부에 포함됨.
                   out.print()자동호출됨
      -declaration : <%! %> .java파일의 _jspService( )외부에 포함됨. 
      
    -directive요소 :
      -page directive :<%@page %> 
                 .java파일이 generated될때 필요한 정보를 지정한다
                 import, contentType, buffer, errorPage, isErrorPage 
         <%@page import=" "%> 
      -include directive :<%@include %>
                  정적포함  .java파일이 generated될때 자원을 포함한다
      -taglib directive : <%@taglib prefix="" uri="" %>
      
    -action tag요소 
      -standard action tag
         <jsp:include> 동적포함  실행시 자원을 포함한다
         <jsp:forward page="">
         <jsp:useBean>
         <jsp:setProperty>
         <jsp:getProperty>
      -custom action tag 
    
  내장객체(기본객체) :
   _jspService()내부의 매개변수또는 지역변수로 미리 선언된 객체
   -request
   -response
   -application
   -session
   -page
   -pageContext
   -out
   
   -exception :page지시자의 isErrorPage속성값이 true인 경우만
               사용가능
--%>
<%int i=99; %>
<%=i%>
<%!int i;//인스턴스변수%>
<%!private void m(){ i++; } %>
<hr>
지역변수i값:<%=i %>
<hr>
<% m(); %>
인스턴스변수i값:<%=this.i%>
<hr>
요청매개변수 test값:<%=request.getParameter("test") %>
<hr>
<%--=getServletContext().getInitParameter("devName") --%>
ServletContext 파라메터devName값:
<%=application.getInitParameter("devName") %>


</body>
</html>






