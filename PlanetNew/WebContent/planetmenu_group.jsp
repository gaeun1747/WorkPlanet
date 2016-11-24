<%@ page contentType="text/html; charset=UTF-8 " pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.group {
	list-style: none;
	margin: 0;
	padding: 0;
	width:300px
}
ul.group a {
	margin-bottom:10px;
	padding: 15px 20px;
	display: block;
	text-decoration: none;
	color: black;
	font-size: 15px;
	background: #D5D5D5;
}
ul.group li{
	float:left;
	width:150px;
	text-align:center;
}
.group a:hover {
	background: #24468A;
	color:white;
}
.grplist{
	color:#555555;
}
</style>
<ul class="group">
	<li ><a href="makenation.jsp">그룹 추가</a></li>
	<li ><a href="manageacc.jsp">그룹 찾기</a></li>
</ul>
<ul class="grplist">
    <c:forEach items="${group}" var="group">
       <li></li>
    </c:forEach>
</ul>