<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<meta charset="UTF-8">
<style>

</style>
<script>

</script>
<h1>그룹 찾기</h1>
<hr>
<table class="nation" >
   <tbody>
   <c:forEach items="${requestScope.list}" var="nation" >
      <tr class="${nation.nation_id}" >
         <td style="width:630px;">
         ${nation.nation_name}</td>
         <td style="width:120px;">
           <%-- <c:if test="${pmem.member_status==89}">
               가입하기
            </c:if>
             --%>
         </td>
      </tr>
   </c:forEach>
   </tbody>
</table>