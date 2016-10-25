<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.my.vo.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(function(){	
 var $targetObj;
 if($("section").length > 0){
  $targetObj = $("section");
 }else{
  $targetObj = $("body");
 }	
 $("table.board tr td a").click(function(event){
	event.preventDefault();
	var url = "boarddetail.do";
	var data = "board_seq=" + $(this).html().trim();
	console.log(data);
	var success =function(responseResult){
		$($targetObj).html(responseResult);
	}
	$.post(url, data, success);
 });
});
</script>
<style>
table.board, table.board th, table.board td{border: 1px solid; border-collapse: collapse; }
</style>
<h1>게시판목록</h1>
 <table class="board">
<tr><th>글번호</th><th>부모글번호</th><th>제목</th><th>작성자</th><th>작성일자</th><th>조회수</th></tr>
<% List<Board> list =(List)request.getAttribute("boardlist");
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
   List<Integer> group = new ArrayList<Integer>();
   int level=0;
   for(int i=0; i<list.size(); i++){
	   Board b = list.get(i);
	   if(b.getParent_seq() == 0){//원글이면
		   group = new ArrayList<Integer>();	   
		   group.add(b.getBoard_seq());
		   level=0;
	   }else {//답글
		 //현재부모글번호와 이전글번호들비교해서
		  int index = group.size();
	   	  int j=0;	   	
	   	  for(; j<index;j++){	
	   		  if(group.get(j)==b.getParent_seq()){	   			  
	   			  break;
	   		  }
	   	  }	   	  
	   	  //현재부모글번호가 이전글번호들과 같지않으면 
	   	  if(index == j){	
	   		level++;//level을 1증가
	   		group.add(b.getParent_seq());//현재부모글번호를 그룹에 저장
	   	  }else { //현재답글번호가 이전글번호와 같으면 level을 이전글번호위치+1 
	   		level = j+1;
	   	  }	   	
	   }//end else if
%>
<tr>
 <td><%for(int j=0; j<level; j++){%>▶<%}%>
   <a href="#"><%=b.getBoard_seq()%></a>
 </td>
 <td><%=b.getParent_seq() %></td>
 <td><%=b.getBoard_subject()%></td>
 <td><%=b.getBoard_writer()%></td>
 <td><%=sdf.format(b.getBoard_date())%></td>
 <td><%=b.getBoard_viewcount()%></td>
 </tr> 
 <%} %>
</table>