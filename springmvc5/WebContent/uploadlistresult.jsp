<%@page import="java.io.File"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadlistresult.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(function(){
	$("ul.uploadUL a").click(function(event){
		event.preventDefault();
		$("form>input[name=fileName]").val($(this).attr("href"));
		$("form").submit();
	});
});
</script>
<style>ul.uploadUL {padding: 0px;}</style>
</head>
<body>
<form method="post" action="download.do">
  <input type="hidden" name="fileName">
</form>
<ul class="uploadUL" >
<%
String saveDirectory ="C:\\Users\\pc\\Desktop\\2016\\upload";
File root = new File(saveDirectory);
File[] fArr = root.listFiles();
for(File f : fArr){
%><li style="list-style:none;"><a href="<%=f.getName()%>"><%=f.getName()%></a></li>
<%
}
%>
</ul>
</body>
</html>