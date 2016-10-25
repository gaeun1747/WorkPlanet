<%@page import="java.net.URLEncoder"%><%@page import="java.io.FileInputStream"%><%@page import="java.io.File"%><%@page contentType="application/octet-stream;charset=UTF-8"%><%
request.setCharacterEncoding("UTF-8");
String fileName = request.getParameter("fileName");
//실제 서버의 파일찾기
//클라이언트에게 다운로드하기위한 헤더설정
response.setHeader("Content-Disposition", 
 "attachment;filename=\""+URLEncoder.encode(fileName, "UTF-8")+"\"");
//클라이언트에게 파일내용 출력
String saveDirectory ="C:\\Users\\pc\\Desktop\\2016\\upload";
File file = new File(saveDirectory, fileName);
FileInputStream fis = new FileInputStream(file);
//out객체 : JspWriter타입의 출력스트림==>문자단위출력스트림
ServletOutputStream os = response.getOutputStream();

byte[] bArr = new byte[1024];
//1024byte씩처리
int readCnt = -1;
while( (readCnt = fis.read(bArr)) != -1){
	System.out.println(readCnt);
	os.write(bArr, 0, readCnt);
}%>