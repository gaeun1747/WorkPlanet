<%@page contentType="text/html; charset=UTF-8"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>플래닛-플래닛찾기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
</script>
<div>
<table class="pl">
<tr>
<td>PlanetName</td>
<c:forEach items="${requestScope.palnetlist}" var="palnetlist">
<td class="list">${palnetlist.planet_name}</td>
</c:forEach>
</tr>
</table>
</div>