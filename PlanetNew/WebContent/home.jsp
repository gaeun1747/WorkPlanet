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
	width: 1000px;
	margin: 0 auto;
	/* border: 1px solid #aaa; */
}

.header {
	width: 100%;
	height: 100px; 
	margin-bottom: 20px;
	text-align: center;
}

.container {
	/* margin-top:20px; */
	overflow: hidden;
}

.nav {
	float: left;
	width: 200px;
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
			<nav>
				<jsp:include page="indexmenu.jsp" />
			</nav>
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