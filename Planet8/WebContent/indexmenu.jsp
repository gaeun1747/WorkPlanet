<%@page import="com.my.vo.Member"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
a {
	text-decoration: none;
	color: #555555
}

ul.indexmenu {
	vertical-align: text-bottom;
}

ul.indexmenu>li {
	width: 150px;
	list-style: none;
	display: inline-block;
	margin: auto;
	font-size: 18px;
}

li.logo {
	font-size: 36px !important;
	font-weight: bold;
	float: left;
}
</style>
<ul class="indexmenu">
	<%
		Member member = (Member) session.getAttribute("loginInfo");
		if (member == null) {
	%>
	<li class="logo"><a href="index.jsp">planet</a></li>
	<li><a href="login.jsp">로그인</a></li>
	<li><a href="signup.jsp">가입하기</a></li>
	<%
		} else {
	%>
	<li class="logo"><a href="home.jsp">planet</a></li>
	<li><a href="home.jsp">계정관리</a>
	<li><a href="logout.do">로그아웃</a></li>
	<%
		}
	%>
</ul>