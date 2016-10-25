<%@page import="java.util.List"%>
<%@page import="com.my.vo.Product"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="your" tagdir="/WEB-INF/tags" %>
<c:choose> 
<c:when test="${!empty requestScope.errormsg }">
   ${requestScope.errormsg}
</c:when>
<c:otherwise>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(function(){
  var $targetObj;
  if($("div.product").length > 0){
	  $targetObj = $("div.product");
  }else{
	  $targetObj = $("body");
  }
  $(".cell").click(function(){	  
	var prod_no = $(this).attr("id").trim();
	if(prod_no==''){
		 return;
	}	
	event.preventDefault();
	var url = "productdetail.do";
	var data = "prod_no=" + prod_no;//$(this).html().trim();
	var success = function(responseResult){
	var jsonObj = $.parseJSON(responseResult);	 
	$($targetObj).empty();//영역 비우기
	if(jsonObj.errorMsg != undefined){
		 $($targetObj).html(jsonObj.errorMsg);
		 return;
	}
	$($targetObj).append("<div>"); 
	$($targetObj).append("<div>");
	$($targetObj).children().first().css("display","table-cell")
	               .css("width","50%")
	               .html('<img src="'+jsonObj.imageFile+'" alt="'+jsonObj.imageFile+'" style="width:100%;height:100%;" >');
	var detail = '상품번호 :'+jsonObj.prod_no+'<br>';
		 detail+= '상품명 :'+jsonObj.prod_name+'<br>'
		  +'가격 :'+jsonObj.prod_price+'<br>'
		  +'제조일자 :'+jsonObj.prod_mf_dt+'<br>'
		  +'등록일자 :'+jsonObj.prod_reg_dt+'<br>'
		  +'카테고리 :'+jsonObj.cate_name;
	 	 
	$($targetObj).children().last().css("display","table-cell").css("vertical-align", "middle").html(detail);
	 
	var inputInfo = 
 '<div><input type="number" name="quantity" value="1" min="1" max="10">';
 inputInfo +=
 '<button id="btCart">장바구니넣기</button></div>';	 
	 $($targetObj).children().last().append(inputInfo);	 
	 $("#btCart").click(function(){
		$.post("addcart.do",
"no="+jsonObj.prod_no+"&quantity="+$("input[name=quantity]").val()	,
			function(responseResult){
				if(responseResult.trim()=='1'){
					alert('상품을 장바구니에 넣었습니다');			
				}else{
					alert('장바구니넣기 실패!');
				}
		    }); 
	 });	 
	};
	$.post(url, data, success);	 	
 });
});
</script>
<style>

</style>
<h1>상품목록</h1>
<%--search.jsp를 동적포함 --%>
<div style="margin: 20px;">
<jsp:include page="search.jsp"></jsp:include>
</div>
<c:forEach items="${requestScope.list}" var="p">
 <div class="cell" id="${p.prod_no}">
  <ul style="list-style: none;">
  <li style="width:100%;height:200px;"><img src='<your:img file="${p.prod_no}"/>' style="width:100%; height:100%;"></li>
  <li class="no">상품번호:${p.prod_no}</li>
  <li class="name">상품명:${p.prod_name}</li>
  <li class="price">가격:${p.prod_price}</li>
 </ul>
 </div>
</c:forEach>
</c:otherwise>
</c:choose>