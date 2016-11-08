<%@ page language="java" contentType="text/html; charset=UTF-8"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(function(){
	$(".planetlist").on("click", "table tr td.signupplanet", function(event){
		event.preventDefault();
		
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
			var detail="";
			if(responseResult==1){
				$(".planetlist").empty();
				$(".planetlist").html("이름이 '"+$("input[name=planet_name]").val()
						+"'인 플래닛이 존재하지 않습니다.");
				return ;
			}
			console.log(responseResult);
			var obj = $.parseJSON(responseResult);
			$(".planetlist").empty();
			detail ="";
			detail += "<table><tr>";
			detail += "<td width=\"700px\">"+obj.planet_name+"</td>";
			detail += "<td class=\"signupplanet\">가입하기</td>";
			$(".planetlist").html(detail);
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
찾으시는 플래닛 목록
</div>