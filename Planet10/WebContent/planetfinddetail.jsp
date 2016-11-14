<%@page contentType="text/html; charset=UTF-8"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
[
<c:set var="no" value="0"/>
<c:forEach var="planet" items="${planet}">
  <c:if test="${no!=0}">,</c:if>
  {
  "planet_id":"${planet.planet_id}",
  "planet_name":"${planet.planet_name}",
  "signyn":"${signyn[no]}"
  }
<c:set var="no" value="${no+1}"/>
</c:forEach>
]


