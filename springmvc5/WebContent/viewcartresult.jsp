<%@page import="java.util.Set"%>
<%@page import="com.my.vo.Product"%>
<%@page import="java.util.Map"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%--viewcartresult.jsp --%>
<c:set var="cart" value="${sessionScope.cart}"/> 
<c:choose>
 <c:when test="${empty cart}">
장바구니가 비었습니다.	
 </c:when>
 <c:otherwise>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script>
   $(function(){
	  var $targetObj;
	  if($("section").length > 0){
	    $targetObj = $("section");
	  }else{
	    $targetObj = $("body");
	  }	
	  $("button").click(function(){
		 $.post("order.do", function(responseResult){
			$($targetObj).html(responseResult.trim());
		 }); 
	  }); 
   });
  </script>
 <style>
table.cart{margin:0px; width:90%;border:1px solid;border-collapse:collapse; text-align:center;}
table.cart tr{border-bottom:1px solid;}	
table.cart tr:nth-child(2n+1){background-color:#D5D5D5}
table.cart .no{width:20%;}
table.cart .name{width:40%;}
table.cart .price{width:20%; text-align:right;padding:5px;}
 </style>
  <table class="cart" >
   <tr><th>상품번호</th><th>상품명</th><th>가격</th><th>수량</th><th>금액</th></tr>
   <c:set var="totalPrice" value="0"/>
   <c:forEach  items="${cart}"  var="c">
      <tr>
       <td class="no">${c.key.prod_no}</td>
       <td class="name">${c.key.prod_name}</td>
       <td class="price">${c.key.prod_price}</td>
       <td class="price">${c.value}</td>
       <td class="price">${c.value * c.key.prod_price}</td>
       <c:set var="totalPrice" 
              value="${totalPrice + (c.value * c.key.prod_price) }"/>
      </tr>	
   </c:forEach>
   <tr><td colspan="5" class="price">예상금액 : ${totalPrice}</td></tr>   
 </table>
 <button>주문하기</button>
</c:otherwise>
</c:choose>