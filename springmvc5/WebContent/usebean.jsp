<%@page import="com.my.vo.Person1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>usebean.jsp</title>
</head>
<body>
<jsp:useBean id="person1" class="com.my.vo.Person1" 
             scope="request" />
<%-- //request의 속성중 "person1"이라는 이름의 속성값 얻기
Person1 obj = (Person1)request.getAttribute("person1");
   //그 속성값이 null이면  Person1타입의 객체를 생성해서 request의 속성으로 설정하기
   //속성명 : person1, 값: Person1타입의 객체
if(obj == null){
	obj = new Person1();
	request.setAttribute("person1", obj); 
}
--%>
<jsp:setProperty name="person1" property="name" value="오문정"/>
<%-- //속성객체의 프로퍼티 설정
   obj.setName("오문정");
   
   Pet pet = new Pet();
   pet.setName("바둑이");
   obj.setPet( pet );
--%>
<jsp:getProperty name="person1" property="name"/>
<%--=obj.getName()--%>
<%--=obj.getPet().getName()--%>
</body>
</html>