<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<title>편리한 팀 커뮤니케이션, 플래닛! - Planet</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<meta charset="UTF-8">
<style>
  input[type=button]{
	font-weight: bold;
	font-size: 20px;
	background-color: #24468A;
	padding: 15px 30px;
	color: #ffffff;
	border: none;
	border-radius: 6px;
	padding: 10px 20px;
  }
  input.deleteplanet{
	font-weight: bold;
	font-size: 20px;
	background-color: #DD0000;
	padding: 15px 30px;
	color: #ffffff;
	border: none;
	border-radius: 6px;
	padding: 10px 20px;
  }
  form{
    font-size:21px;
  }
  input[type=text]{
    font-size:18px;
    padding:10px 15px;
    width:400px
  }
</style>
<script>
	function init(){
		//플래닛 이름 수정
		$("input[type=button]").eq(0).click(function(event){
			event.preventDefault();
			if($(".planet_name").val()==''){
				alert("수정할 플래닛 이름을 입력해주세요.");
				return ;
			}
			var data="planet_id="+"${planet_id}"+"&planet_name="+$(".planet_name").val();
			console.log(data);
			var url="modifyplanetname.do";
			var success=function(responseResult){
				alert("플래닛 이름이 수정되었습니다.");
				location.href="home.jsp";
			}
		    $.post(url, data, success)
		});
		
		//플래닛 마스터 위임
		$("input[type=button]").eq(1).click(function(event){
			event.preventDefault();
			if($(".member_id").val()==''){
				alert("마스터로 위임할 멤버의 id를 입력해주세요.");
				return ;
			}
			var data="planet_id="+"${planet_id}"+"&member_id="+$(".member_id").val()
						+"&master_id="+"${master_id}";
			var url="modifyplanetmaster.do";
			var success=function(responseResult){
				if(responseResult==1){
					alert("마스터가 변경되었습니다.");
					location.href="home.jsp";
				} else if(responseResult==0){
					alert("입력하신 멤버id가 플래닛에 존재하지 않습니다.");
				} else{
					alert("마스터가 아닌 멤버를 선택해주세요.")
				}
			}
		    $.post(url, data, success);
		});
		
		//플래닛 폐쇄
		$("input[type=button].deleteplanet").click(function(event){
			event.preventDefault();
			if (confirm("정말 플래닛을 폐쇄하시겠습니까?")==true){    //확인
				var data="planet_id="+"${planet_id}";
				var url="deleteplanet.do";
			    var success=function(responseResult){
				   location.href="home.jsp";
			    }
			    $.post(url, data, success)
		    }else{   //취소
			    return;
		    }
		});
	}
	$(init);
</script>
<h2>플래닛명</h2>
<input type="text" class="planet_name" placeholder="수정할 플래닛 이름을 입력하세요.">
<input type="button" value="저장">
<br><br><hr>
<h2>마스터 위임</h2>
<input type="text" class="member_id" placeholder="마스터를 위임할 멤버의 id를 입력하세요.">
<input type="button" value="위임">
<br><br><hr>
<h2>플래닛 폐쇄</h2>
<input type="button" class="deleteplanet" value="폐쇄">
<br><br><br>