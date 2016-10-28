<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js">
	
</script>

<style>
.frame {
	width: 800px;
	margin: 0 auto;
	border: 1px solid #aaa;
}

.header {
	
	text-align: center;
	margin-bottom: 20px;
}
.container{
	/* margin-top:20px; */
	overflow:hidden;
}
.nav {
	float: left;
	width: 150px;
	color: #fff;
	margin-right: 50px;
}

.content {
	float: left;
	width: 600px;
}
</style>
</head>
<body>
	<div class="frame">
		<div class="header">
			<nav style="text-align: center"><jsp:include
					page="indexmenu.jsp" /></nav>
		</div>


		<div class="container">
			<div class="nav">
				<nav>
					<jsp:include page="homemenu.jsp" />
				</nav>
			</div>
			<div class="content">
				<h1>hello world</h1>
			</div>
		</div>

	</div>
</body>
</html>