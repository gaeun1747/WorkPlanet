<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<meta charset="UTF-8">
<style>
   .one {
     width:100px;
   }
   .two {
     width:700px;
   }
</style>
<script>
$(function(){
	// 해당 플래닛으로 가기
	function enterplanet(planet_id){
		var url="getplanethome.do";
		var data="planet_id="+planet_id
				+"&member_id="+"${member_id}";
		var success = function(responseResult){
			console.log(responseResult);
			if(responseResult == 1){
				location.href="planetindex.jsp";
			} else{
				alert("플래닛에 들어갈 수 없습니다.")				
			}
		}
		$.post(url, data, success);
	}
	$("table.planet tr td").click(function(event){
		event.preventDefault();
		/* console.log($(this).index()); */
		var planet_id = $(this).parent().attr("class");
		if($(this).index()==0) enterplanet(planet_id);
		else if($(this).index()==1) enterplanetinfo(planet_id, $(this).html().trim());
		else exitplanet(planet_id);
	});
});
</script>
<h1>나의 정보</h1>
<hr>
<!-- class="${pmem.member.member_id}" -->
<form>
<table class="planetinfo" >
   <tbody>
   
   <tr>
      <td class="one">${pmem.planet.planet_name }</td>
      <td style="width:120px;">
         <c:if test="${pmem.member_status==89}">
            플래닛 관리 &nbsp;&nbsp;|
         </c:if>
      </td>
      <td style="width:50px;"> 나가기</td>
   </tr>
   
   
   <tr>
      <td>아이디</td>
      <td>${pmem.member.member_id }</td>
   </tr> <!-- 아이디/수정X -->
   <tr>
      <td>이름</td>
      <td><input type="text" value="${pmem.member.member_name}" ></td>
   </tr> <!-- 이름(수정O) -->
   <tr>
      <td></td>
      <td></td>
   </tr> <!-- 패스워드/수정O -->
   <tr>
      <td></td>
      <td></td>
   </tr> <!-- 패스워드확인/수정O -->
   <tr>
      <td></td>
      <td></td>
   </tr> <!-- 닉네임/수정O -->
   <tr>
      <td></td>
      <td></td>
   </tr> <!-- 생일/수정O -->
   <tr>
      <td></td>
      <td></td>
   </tr> <!-- 이메일/수정O -->
   <tr>
      <td></td>
      <td></td>
   </tr> <!-- 멤버상태(마스터여부)/수정X -->
   
   </tbody>
</table>
</form>