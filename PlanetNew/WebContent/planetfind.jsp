<%@ page language="java" contentType="text/html; charset=UTF-8"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(function(){
	$(".planetlist").on("click", "tr td.signupplanet", function(event){
		event.preventDefault();
		var url = "signupplanet.do";
		/* console.log($(".planet_id").text());
		console.log("${sessionScope.loginInfo.member_id}"); */
		console.log("ggg ==  "+$(this).text());
		console.log("test :  "+$(this).parent().get(0).index(1));
		if($(this).text()!="가입하기"){
			return;
		}
		var data = "planet_id="+$(".planet_id").html()
					+"&member_id="+"${sessionScope.loginInfo.member_id}";
		var success = function(responseResult){
			console.log("responseResult  :  "+responseResult)
			if(responseResult==1){
				alert("가입에 성공했습니다."); 
				location.href="home.jsp";
			} else{
				alert("가입 실패");
			}
		}
		$.post(url, data, success);
	});
	
	$(".btSearch").click(function(event) {
		event.preventDefault();
		var url = "planetfind.do";
		var data = $("form").serialize();
		if($("input[name=planet_name]").val()==''){
			alert("찾으시려는 플래닛 이름을 입력해주세요.")
			$("input[name=planet_name]").focus();
			return ;
		}
		var success = function(responseResult){
			if(responseResult==1){
				$(".planetlist").empty();
				$(".planetlist").html("<font style=\"color:red\">이름이 '"+$("input[name=planet_name]").val()
						+"'인 플래닛이 존재하지 않습니다.</font>");
				return ;
			}
			var obj = $.parseJSON(responseResult);
			console.log("json obj  :  "+obj);
			// obj 가 list기 때문에 for문 사용.
			$(".planetlist").empty();
			 var signmsg="";
			$(".planetlist").html("<table>");
			$.each(obj, function(index, data){
				if(obj[index]["signyn"]==0){
					signmsg="<font style=\"color:green\">가입하기</font>";
				} else{
					signmsg="<font style=\"color:red\">이미 가입되었습니다.</font>";
				}
				$(".planetlist").append("<tr><td style=\"display:none\" class=\"planet_id\">"
										+obj[index]["planet_id"]+"</td>"
										+"<td width=\"600px\">"+obj[index]["planet_name"]+"</td>"
										+"<td class=\"signupplanet\" style=\"text-align:right;width:200px\">"+signmsg+"</td></tr>");
			});
			$(".planetlist").append("</table>");
		}
		$.post(url, data, success);
	});
});
</script>
<style>
	form.planetfind{
	margin:auto;
	text-align: center;
	font-size: 20px; 
	}
	input{
	margin-bottom: 20px;
	text-align: center;
	font-size: 30px;
	}
	.btSearch{
	font-weight: bold;
	font-size: 17px;
	background-color: #24468A;
	padding: 10px 20px;
	color: #ffffff;
	border: none;
	border-radius: 6px;
	}
</style>
<h1>플래닛 찾기</h1>
<hr>
<form method="post" class="planetfind">
	<input type="text" name="planet_name" style="font-size:20px ; padding:10px 20px">
	<button class="btSearch">검색</button>
</form>
<br><hr><br>
<div class="planetlist">
찾으시는 플래닛
</div>












