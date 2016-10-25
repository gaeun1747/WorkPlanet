<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
//var responseResult='[{"key":"201608", "value":"10000"},{"key":"201609", "value":"20000"}]';
$.post("test3.jsp", function(responseResult){
   var objArr = $.parseJSON(responseResult);  //JSON.parse(responseResult);
  /*  console.log(objArr);
   for(var i=0; i<objArr.length; i++){
	console.log(objArr[i].key + "--" + objArr[i].value);
} */
  drawing(objArr);
});
</script>

</head>
<body>
</body>
</html>