<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="b" value="${requestScope.board}" />
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>boarddetailresult.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
var $targetObj;
var opt;//작업구분
function showDivChkPassword(){
	$("div.reply").hide();
	$("input[name=board_password]").val('');
	$("div.chkPassword").show();	
};
function chkPassword(action){
	var returnValue;
	var url = "boardchkpassword.do";
	var data = "board_seq="+${b.board_seq}+"&board_password="+$("div.chkPassword input[name=board_password]").val();
	var success = function(responseResult){
		returnValue = responseResult.trim();
	};
	console.log(data);
	$.ajax({
  		type: 'POST',
  		url: url,
  		data: data,
  		success: success,  	
  		async:false //동기요청
	});
	return returnValue;
};

$(function(){	
	 if($("section").length > 0){
	  $targetObj = $("section");
	 }else{
	  $targetObj = $("body");
	 }	

	$("#reply").click(function(){
		$("div.chkPassword").hide();
		$("div.reply").toggle();
		if(opt !='reply'){
			opt = 'reply';
		}else {
			opt = '';
		}
	});
	//비밀번호블럭의 버튼이 클릭되었을때
	$("div.chkPassword button").click(function(event){
		//console.log("작업구분:" + opt);
		var returnValue = chkPassword();
		if(returnValue == '1'){
			$("div.chkPassword").hide();
			$("div.update").hide();
			$("div.delete").hide();
			if(opt == "update"){
				$("input[name=board_password]").val('');
				$("div.detail").hide();
				$("div.update").show();				
			}else if(opt == "delete"){				
				$("div.delete").show();								
			}
		}else{
			//opt = '';
			alert("실패");
		}
	});
	
	$("#update").click(function(event){
		opt = "update";
		showDivChkPassword();
	});
	$("#delete").click(function(event){
		opt = "delete";
		showDivChkPassword();			
	});
	$("div.reply form").submit(function(event){
		event.preventDefault();
		var url = "boardreply.do";
		
		var data = $(this).serialize();
		var success = function(responseResult){	
			$($targetObj).html(responseResult);
		};
		$.post(url, data, success);
	});
	$("div.reply button.reset").click(function(event){
		event.preventDefault();
		opt = "";
		$("div.reply").hide();	
	});
	$("div.update form").submit(function(event){
		event.preventDefault();
		var url = "boardupdate.do";
		var data = $(this).serialize();
		var success = function(responseResult){		 	
		  $($targetObj).html(responseResult);
		  
		};
		$.post(url, data, success);
	});
	
	$("div.update button.reset").click(function(event){
		event.preventDefault();
		opt = "";
		$("input[name=board_password]").val('');
		$("div.update").hide();
		$("div.detail").show();
	});		
	$("div.delete button.action").click(function(event){
		event.preventDefault();
		var url = "boarddelete.do";
		var data ="board_seq="+${b.board_seq};
		var success = function(responseResult){
	  	try {
	        var o = JSON.parse(responseResult.trim());//문자열을 객체로 파싱
	        if (o && typeof o === "object") { //o가 null이 아니고 object타입인 경우
	        	var childDiv = $("div.delete div");	   
	        	$(childDiv).html(o.msg);
	        }
	    }catch (e) { //json객체파싱시 예외가 발생한 경우란 resonseResult가 json객체가 아닌경우를 말함
	    	$($targetObj).html(responseResult);
	    }
		};
		$.post(url, data, success);
	});
	$("div.delete button.reset").click(function(event){
		$("div.delete").hide();
	});
});
</script>
<style>
div.reply, div.chkPassword, div.update, div.delete{display:none;}
</style>
</head>
<body>
<div class="detail" style="position: relative;">
<h1>글내용</h1>
글번호 : ${b.board_seq}<br>
부모글번호 : ${b.parent_seq}<br>
제목: ${b.board_subject}<br>
작성자 : ${b.board_writer}<br>
작성일자 : ${b.board_date}<br>
내용 : ${b.board_contents}<br>
조회수 : ${b.board_viewcount }
<button id="reply">답글</button>
<button id="update">수정</button>
<button id="delete">삭제</button>
<div class="chkPassword" style="position: absolute; top:200px;">
  비밀번호 : <input type="password" name="board_password">
 <button>비밀번호확인</button> 
</div>
<div class="reply" style="position: absolute; top:200px;">
<form>
   <input type="hidden" name="parent_seq" value="${b.board_seq}" > 
답글제목:<input name="board_subject" required><br>
작성자:<input name="board_writer" required><br>
비밀번호:<input name="board_password" type="password" required><br>
내용 :<textarea name="board_contents"  required></textarea>
<input type="submit" class="action" value="답글쓰기">
<button class="reset">취소</button>
</form>
</div>
</div>

<div class="update" style="position: relative;">
<h1>글 수정</h1>
<form>
글번호 : <input type="hidden" name="board_seq" value="${b.board_seq}">${b.board_seq}<br>
부모글번호 : ${b.parent_seq}<br>
제목: <input name="board_subject" value="${b.board_subject}"><br>
작성자 : <input name="board_writer" value="${b.board_writer}"><br>
비밀번호 : <input name="board_password" type="password" value="${b.board_password}" required><br>
내용 : <textarea name="board_contents">${b.board_contents}</textarea><br>
<input type="submit" class="action" value="수정"><button class="reset">취소</button>
</form>
</div>

<div class="delete" style="position: relative;">
       정말 삭제하시겠습니까?<br>
    <button class="action">예</button>
    <button class="reset">아니오</button>
    <div style="color:red; font-weight: bold;"></div>
</div>
</body>
</html>