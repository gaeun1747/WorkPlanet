<%@tag import="java.io.File"%><%@tag import="com.my.vo.Product"%><%@ tag body-content="empty" pageEncoding="UTF-8"%><%@ attribute name="file" %><%
 //상품번호에 해당하는 이미지파일찾기
 String imageFile = "image/" + getFile()+".png";
 String imageRealPath = application.getRealPath(imageFile);
 if(!new File(imageRealPath).exists()){ //이미지파일이 없으면 
 	imageFile = "image/noexist.jpg";//noexist.jpg파일이 대신한다
 }
 out.print(imageFile);
%>