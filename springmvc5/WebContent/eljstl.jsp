<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html><head><meta charset="UTF-8"><title>eljstl.jsp</title>
<style>
span{width:100px; background-color: yellow;}
</style>
</head>
<body>
<%--요청매개변수opt값얻기 --%>
<% String opt = request.getParameter("opt"); %>
Expression결과 : <%=opt%><br>
Expression Language결과 : ${param.opt }<br>
<hr>
산술연산자: +,-,*, /, % :
${1+2}, ${1-2}, ${1*2}, ${1/2}, ${1%2}, ${1/0}
<hr>
논리연산자 : &&, ||, ! : 
${true && false}, ${true || false }, ${!false}
<hr>
<%--요청매개변수 opt가 "1"인경우  --%>
<c:if test="${param.opt==1}">
   추가작업을 선택했습니다.
</c:if>
<c:if test="${param.opt==2}">
  검색작업을 선택했습니다.
</c:if>
<c:if test="${empty param.opt }">
  작업을 선택하세요
 <ol>
   <li><a href="eljstl.jsp?opt=1">추가</a>
   <li><a href="eljstl.jsp?opt=2">검색</a>
 </ol>
</c:if>
<hr>
<% //컨트롤러에서 다음과 같은 자료가 설정되어있다.
    int []arr = {10, 20, 30, 40, 50};
	request.setAttribute("arr", arr);
%>
<c:forEach items="${requestScope.arr}"  
           var="data"  begin="1"  end="3" 
           varStatus="s">
   <span>${s.count}. ${data}</span>
</c:forEach>
<hr>
<hr>
</body>
</html>