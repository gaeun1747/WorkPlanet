<%@page import="com.my.vo.Customer"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<style>
ul.menu { text-align: center;}
/*목록줄바꿈없앰. 목록스타일없앰 */
ul.menu li.submenu>ul{list-style-type:none;}
/*메인 메뉴*/
ul.menu>li{display:inline-block; vertical-align: top;} 
/* a태그 밑줄없앰 */
ul.menu a { text-decoration: none;}
/*서브메뉴*/ 
li.submenu{position:relative;}
li.submenu>ul {display:none;position:absolute;
               top:20px; left:10px;
               padding:10px;
               }
li.submenu:HOVER ul{         
                   list-style-type:none;
                   display:block;
                   text-align: left;
                   border:1px solid;
                   }  
</style>

<ul class="menu">
 <% Customer c = 
    (Customer)session.getAttribute("loginInfo");
    if(c == null){
 %>
 <li><a href="login.jsp">로그인</a></li>
 <li><a href="signup.html">가 입</a></li>
 <%}else{%> 
 <li><a href="logout.do">로그아웃</a></li>
 <li><a href="orderlist.do">주문목록보기</a></li>
 <%}%>
 <!-- <li><a href="productlist.do">상품목록보기</a></li> -->
 <li><a href="categorylist.do">상품카테고리보기</a></li>
 <li><a href="viewcart.do">장바구니</a></li>
 <li class="submenu"><a href="#">&nbsp;게 시 판&nbsp;</a>
    <ul>
     <li><a href="boardlist.do">목록</a></li>
     <li><a href="boardwrite.html">글쓰기</a></li>
    </ul>
 </li>   
 <li class="submenu"><a href="#">JSP문법</a>
    <ul>
      <li><a href="first.jsp">first.jsp</a></li>
      <li><a href="score.html">score.html</a></li>
      <li><a href="pagedirective.jsp">pagedirective.jsp</a></li>
      <li><a href="include.jsp">include.jsp</a></li> 
      <li><a href="usebean.jsp">usebean.jsp</a></li>
      <li><a href="cookie.jsp">쿠키</a></li>  
      <li><a href="upload.html">파일업로드하기</a></li>
      <li><a href="uploadlistresult.jsp">업로드목록보기</a></li>    
    </ul>
 </li>
 <li><a href="path.jsp">경로</a></li>
</ul>
