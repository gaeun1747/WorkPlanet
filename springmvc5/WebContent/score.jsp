<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! int totalCnt=0;//총참여인원수
    int totalScore=0; //총점
%>
<%
String sc = request.getParameter("score");
int score = Integer.parseInt(sc);
totalCnt++;
totalScore+=score;
double avgScore = (double)totalScore / totalCnt;
java.text.DecimalFormat df = 
     new java.text.DecimalFormat("#.00");
%>
 현재별점 :<%=score%>점<br>
 총참여인원수:<%=totalCnt%>명<br>
 총점 : <%=totalScore%>점<br>
 평점 : <%=avgScore %>점   <%=df.format(avgScore) %>점 