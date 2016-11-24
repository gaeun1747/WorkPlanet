<%@ page contentType="text/html; charset=UTF-8 " pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.basic {
	list-style: none;
	margin: 0;
	padding: 0;
	width:300px
}
ul.basic a {
	margin-bottom:10px;
	padding: 15px 20px;
	display: block;
	text-decoration: none;
	color: black;
	font-size: 15px;
	background: #D5D5D5;
}
ul.basic li{
	float:left;
	width:100px;
	text-align:center;
}
.basic a:hover {
	background: #24468A;
	color:white;
}
</style>
<ul class="basic">
	<li style="width:200px; text-align:left;"><a href="modifymyplanetinfo.jsp">${loginInfo.member_name }</a></li>
	<li style="float:right">
		<c:if test="${pmemInfo.member_status==89}">
	      <img class="masterimg" src="image/icon/star.png" alt="star" 
	      		  style="width:20px; width:20px; float:right">
	   </c:if>
	</li>
	<br><br><br>
	<li ><a href="planetmyarticle.jsp">내 글</a></li>
	<li ><a href="manageacc.jsp">요청</a></li>
	<li ><a href="manageacc.jsp">멤버&팀</a></li>
</ul>