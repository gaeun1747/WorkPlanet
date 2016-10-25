<%@page import="com.my.vo.TestVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(function(){
	$("button#btPrev").click(function(){
		var currMonth = $("#month").val();
		
	});
	
	$("td").click(function(){
		var gubun = $(this).attr("class");
		if(typeof gubun =='undefined'){ //날짜에 해당하는 새프로젝트 보여주기
			var i = $(this).index();
			var ths = $("table tr").eq(0).children();
			var thDate = $(ths).eq(i).html();
			console.log("클릭한 날짜:" +  thDate);
		}else{
			console.log("이미 추가된 프로젝트확인" +gubun);
		}
		
	});
});
</script>
<style>
table {border: 1px solid;}
td{width:30px; height:30px;}
</style>
</head>
<body>
<% List<Date> list = new ArrayList<Date>();
/* Calendar startDate = Calendar.getInstance();
startDate.set(2016, 9-1, 31);
Calendar endDate = Calendar.getInstance();
endDate.set(2016, 10-1, 21);
Calendar c= startDate;
 */
 String startStr = "20160831";
 String endStr = "20161020";
 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
 Date startDate = sdf.parse(startStr);
 Date endDate = sdf.parse(endStr);
 Date c = startDate;
 do{
	 list.add(c);
	 Calendar cal = Calendar.getInstance();
	 cal.setTime(c);
	 cal.add(Calendar.DATE, 1);
	 c = cal.getTime();
}while(!c.equals(endDate));
 
for(int i=0; i<list.size(); i++){
	System.out.println( i + " = " + list.get(i) );
}


List<TestVO> list1 = new ArrayList<TestVO>();
TestVO vo = new TestVO();
vo.setEmpNo("1");
vo.setStart(sdf.parse("20160831"));
vo.setEnd(sdf.parse("20160901"));
list1.add(vo);

 vo = new TestVO();
 vo.setEmpNo("1");
vo.setStart(sdf.parse("20160920"));
vo.setEnd(sdf.parse("20161007"));
list1.add(vo);
vo = new TestVO();
vo.setEmpNo("2");
vo.setStart(sdf.parse("20160901"));
vo.setEnd(sdf.parse("20161019"));
list1.add(vo);

vo = new TestVO();
vo.setEmpNo("3");
vo.setStart(sdf.parse("20160930"));
vo.setEnd(sdf.parse("20161001"));
list1.add(vo);
%>
<button id="btPrev">전</button><span id="month" value="2016-09">2016-09</span><button id="btNext">후</button>
<table>
<tr>
<%for(Date d: list){
%><th><%=sdf.format(d)%></th>	
<%}%>
</tr>
<%
int beforeEndIndex=0;
for(int vIndex = 0; vIndex <list1.size(); vIndex++){
	TestVO v = list1.get(vIndex);
	int startIndex, endIndex;
	startIndex=0; endIndex =0;
    for( int i=0; i<list.size(); i++ ){	   
	   if(list.get(i).equals(v.getStart())){
		   startIndex = i;
	   }else if(list.get(i).equals(v.getEnd())){
		   endIndex = i;		   
	   }
    }   
    System.out.println("start=" + startIndex + ", end="+endIndex);
    if(vIndex > 0){
		if(v.getEmpNo().equals(list1.get(vIndex-1).getEmpNo())){ //이전사원과 현재사원이 같으면
			System.out.println("이전사원과 같음 사번:" + v.getEmpNo() + "beforeEndIndex:"+ beforeEndIndex+", startIndex:" + startIndex); 
			for(int i=beforeEndIndex+1; i<startIndex; i++){%><td></td><%}		
		}else{
			System.out.println("이전사원과 다름 사번:" + v.getEmpNo() + "beforeEndIndex:"+ beforeEndIndex+", startIndex:" + startIndex);
			 for(int i=beforeEndIndex+1; i<list.size(); i++){%><td></td><%}%>
			 </tr><tr>
			 <%for(int i=0; i<startIndex; i++){ %><td></td><%}			 
		}
  }else{ //첫행
%><tr>
<%	  for(int i=0; i<startIndex; i++){ %><td></td><%}
  }
  beforeEndIndex = endIndex;
  for(int i=startIndex; i<=endIndex; i++){%><td style="background-color:gray"></td><%}
}//end for vIndex
for(int i=beforeEndIndex+1; i<list.size(); i++){%><td></td><%}
%>
</tr>
</table>

</body>
</html>