<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a.jsp</title>
</head>
<body>
요청속성 result=${requestScope.result}<br>
고객정보=${requestScope.customer}<br>
요청정보session2=${requestScope.session2}<br>
<hr>
세션정보확인<br>
세션1=${sessionScope.session1}<br>
세션2=${sessionScope.session2}<br>

</body>
</html>