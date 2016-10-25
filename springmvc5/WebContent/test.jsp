<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="animalList"  value="${animalList},Sylvester"/>

${fn:length(animalList)}
${animalList}

<%-- <c:set target="${animalList}" value="Goofy"/>
<c:set target="${animalList}" value="Mickey"/>
 ${animalList} --%>
<%-- <c:forEach items="${animalList}" var="animal">
${animal}<br>

</c:forEach> --%>
</body>
</html>