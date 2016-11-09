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
	function enterplanet(planet_id){
		console.log(planet_id);
	}
	// 플래닛 관리
	function enterplanetinfo(planet_id){
		console.log("planet_id : "+planet_id);
		if($("table.planet tr td").eq(1).html()!=""){
			var data="planet_id="+planet_id
					+"&master_id="+"${member_id}";
			var url="enterplanetinfo.do";
			var success = function(responseResult){
				$(".content").html(responseResult);
			}
			$.post(url, data, success);
		}		
	}
	// 플래닛 나가기
	function exitplanet(planet_id){
		if (confirm("정말 플래닛을 탈퇴하시겠습니까?")==true){    //확인
		   var data="planet_id="+planet_id;
		   var url="exitplanet.do";
		   var success=function(responseResult){
			   location.href="home.jsp";
		   }
		   $.post(url, data, success)
	    }else{   //취소
		   return;
		}		
	}
	$("table.planet tr td").click(function(event){
		event.preventDefault();
		console.log($(this).index());
		var planet_id = $(this).parent().attr("class");
		if($(this).index()==0) enterplanet(planet_id);
		else if($(this).index()==1) enterplanetinfo(planet_id);
		else exitplanet(planet_id);
	});
});
</script>
<h1>나의 플래닛</h1>
<hr>
<table class="planet" >
   <tbody>
   <c:forEach items="${requestScope.list}" var="pmem" >
      <tr class="${pmem.planet.planet_id}" >
         <td style="width:630px; ">
         ${pmem.planet.planet_name }</td>
         <td style="width:120px;">
            <c:if test="${pmem.member_status==89}">
            <%-- <c:if test="${pmem.member_status==Y}">
            <c:if test="${pmem.member_status=='Y'}">
            <c:if test="${pmem.member_status.equals(Y)}">
            <c:if test="${pmem.member_status.equals('Y')}">--%>
               플래닛 관리 &nbsp;&nbsp;|
            </c:if>
         </td>
         <td style="width:50px;"> 나가기</td>
      </tr>
   </c:forEach>
   </tbody>
</table>