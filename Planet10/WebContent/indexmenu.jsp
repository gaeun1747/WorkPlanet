<%@page import="com.my.vo.Member"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
  ul { color:#555555 !important }
  a { text-decoration:none; color:#555555 }
  ul.indexmenu>li { width:100px ; list-style:none ; display:inline-block ; 
  margin:auto ; font-size:18px ; float:right; padding:10px 10px }
  ul.indexmenu li.logo { font-size:36px !important ; font-weight:bold ; float:left; padding:0 }
</style>
<ul class="indexmenu" >
  <%Member member = (Member)session.getAttribute("loginInfo");
    if(member==null){
  %>
  <li class="logo"><a href="index.jsp">planet</a></li>
  <li><a href="login.jsp">로그인</a></li>
  <li style="width:5px">|</li>
  <li><a href="signup.jsp">가입하기</a></li>
  <%} else{ %>
  <li class="logo"><a href="home.jsp">planet</a></li>
  <li><a href="logout.do" >로그아웃</a></li>  
  <li style="width:5px">|</li>
  <li><a href="home.jsp">계정관리</a>
  <%} %>
</ul>
