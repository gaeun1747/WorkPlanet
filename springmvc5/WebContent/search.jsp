<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(function(){
<c:set var="item"  value="${param.item}"/>
<c:set var="value" value="${param.value}"/>
	
<c:if test="${!empty item && !empty value}"> 
 $("select[name=item]>option[value=${item}]").attr("selected", "true");
 $("input[name=value]").val('${value}');
</c:if>

 var $targetObj;
 if($("div.product").length > 0){
	  $targetObj = $("div.product");
 }else{
	  $targetObj = $("body");
 }
 $("button").click(function(event){	
	if($("section").length > 0){
		event.preventDefault();
		var url = $("form").attr("action");
		var data = $("form").serialize();
		var success = function(responseResult){
			$($targetObj).html(responseResult);
		}
		$.post(url, data, success);
	}	
 });
});
</script>
<form method="post" action="productlist.do">
 <select name="item">
   <option value="no">상품번호로 검색</option>
   <option value="name">상품명으로 검색</option>
 </select>
 <input type="search" name="value" placeholder="값을 입력하세요">
 <button>search</button>
</form>