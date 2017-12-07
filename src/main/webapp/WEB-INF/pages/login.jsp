<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value='/js/jquery.min.js'/>"></script>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	
</script>
<style type="text/css">
	.login-div{
	  	background-color:red;
		width: 300px;
		margin-left: 40%;
	}

</style>
</head>
<body>

	<div class="container">
		<div class="jumbotron">
			<div class="login-div">
				<form   class="form-horizontal" action="${pageContext.request.contextPath }/mydemo/login" method="get">
				<div class="form-group">
					<label for="name">用户名：</label>
					<input type="text" name="username" placeholder="用户名">
				</div>
				<div class="form-group">
				    <label for="name">密码：</label>
					<input type="text" name="password" placeholder="密码">
				</div>	
					<input type="submit" value="提交">
				</form>
			</div>
		</div>
	</div>
</body>
</html>