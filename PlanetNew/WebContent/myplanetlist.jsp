<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<meta charset="UTF-8">
<style>

</style>
<script>
$(function(){
	// 해당 플래닛으로 가기
	$("table.planet tr td").eq(0).click(function(event){
		event.preventDefault();
		var planet_id = $(this).html().trim();
	});
	// 플래닛 관리
	$("table.planet tr td").eq(1).click(function(event){
		event.preventDefault();
		if($("table.planet tr td").eq(1).html()!=""){
			var data="planet_id="+$(this).attr("class")+"&master_id="+"${member_id}";
			var url="enterplanetinfo.do";
			var success = function(responseResult){
				$(".content").html(responseResult);
			}
			$.post(url, data, success);
		}
	});
	// 플래닛 나가기
	$("table.planet tr td").eq(3).click(function(event){
		event.preventDefault();
		if (confirm("정말 플래닛을 탈퇴하시겠습니까?")==true){    //확인
		   var data="planet_id="+$(this).attr("class");
		   var url="exiteplanet.do";
		   var success=function(responseResult){
			   location.href="home.jsp";
		   }
		   $.post(url, data, success)
	    }else{   //취소
		   return;
		}
	});
});
</script>
<h1>나의 플래닛</h1>
<hr>
<table class="planet" style="float:right">
   <tbody>
   <c:forEach items="${requestScope.list}" var="pmem" >
      <tr>
         <td class="${pmem.planet.planet_id}" style="width:570px; float:left">
         ${pmem.planet.planet_name }</td>
         <td class="${pmem.planet.planet_id}" style="width:130px;">
            <c:if test="${pmem.member_status==89}">
            <%-- <c:if test="${pmem.member_status==Y}">
            <c:if test="${pmem.member_status=='Y'}">
            <c:if test="${pmem.member_status.equals(Y)}">
            <c:if test="${pmem.member_status.equals('Y')}">--%>
               플래닛 관리
            </c:if>
         </td>
         <td width="30px">|</td>
         <td class="${pmem.planet.planet_id}" style="width:50px;">나가기</td>
      </tr>
   </c:forEach>
   </tbody>
</table>