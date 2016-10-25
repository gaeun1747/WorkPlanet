<%@page import="java.io.File"%>
<%@page import="com.my.vo.Product"%>
<%@ page  contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="your" tagdir="/WEB-INF/tags" %>

<c:choose>
<c:when test="${!empty requestScope.errormsg}">
{"errorMsg":"${requestScope.errormsg}"}
</c:when>
<c:otherwise>
<c:set var="product" value="${requestScope.product}" />
{"imageFile":"<your:img file="${product.prod_no}"/>",
 "prod_no":"${product.prod_no}",
 "prod_name":"${product.prod_name}",
 "prod_price":"${product.prod_price}",
 "prod_mf_dt":"${product.prod_mf_dt}",
 "prod_reg_dt":"${product.prod_reg_dt}",
 "cate_no":"${product.cate.cate_no}",
 "cate_name":"${product.cate.cate_name}"
 }
 </c:otherwise>
</c:choose>