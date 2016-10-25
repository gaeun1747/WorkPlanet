<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  
          prefix="c"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 리스트</title>
<script>
$(".category>ul>li").click(function(){
var cate_no = $(this).attr("id");
var url = "productlist.do";
var data = "cate_no=" + cate_no;
$(".category>ul>li").css("background-color", '#FFFFFF');
var obj = $(this);
var success = function(responseResult){
	 $(".product").html(responseResult.trim());
	 $(obj).css("background-color", '#BDBDBD');	 
};
$.post(url, data, success);	 	
});
</script>
<style>
div.category {display: inline-block; width:15%; margin: 0px; padding:10px 0px; border:1px solid;}
div.product {display: inline-block; width:80%; vertical-align: top; margin:10px 0px;}
div.product>div.cell {float:left;width:30%;}
div.product>div.cell:nth-child(3n){clear: both;}
div.product>div.cell ul{padding:5px 10px;}
div.product>div.cell:HOVER { border: 1px solid;border-radius: 10px}
</style>
</head>
<body>
<div class="category">
 <ul style="list-style-type: none;padding: 10px">
 <c:forEach items="${requestScope.categorylist}" var="cate">   
      <li id="${cate.cate_no}">${cate.cate_name}</li>
 </c:forEach>
 </ul>
</div>
<div class="product">
</div>
</body>
</html>