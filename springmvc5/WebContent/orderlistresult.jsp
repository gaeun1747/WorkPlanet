<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>orderlistresult.jsp</title>
<style>
table.order, table.order td, 
table.order th{border:1px solid; border-collapse:collapse;}
</style>
</head>
<body>
<h1>주문 목록</h1>
<c:set var="orders" value="${requestScope.orders}"/>
<table class="order">
<tr><th>주문번호</th><th>주문일자</th><th>상세번호</th><th>상품번호</th><th>상품명</th><th>가격</th><th>수량</th><th>금액</th></tr>
<c:forEach items="${orders}" var="orderInfo">
 <tr>
  <td rowspan="${fn:length(orderInfo.lines)}">${orderInfo.order_no}</td>
  <td rowspan="${fn:length(orderInfo.lines)}">
     <fmt:formatDate value="${orderInfo.order_dt}" 
                     pattern="yyyy-MM-dd hh:mm:ss"/>
  </td>
  <c:forEach items="${orderInfo.lines}" 
             var="line" varStatus="status">
   <c:if test="${status.count > 1}">
     </tr>
     <tr>
   </c:if>  
   <td>${line.line_no}</td>
   <td>${line.product.prod_no}</td>
   <td>${line.product.prod_name}</td>
   <td>${line.product.prod_price}</td>
   <td>${line.quantity}</td>
   <td>${line.product.prod_price * line.quantity}</td>   
  </c:forEach>
  </tr>
</c:forEach>
</table>
</body>
</html>