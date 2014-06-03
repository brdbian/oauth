<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='security' uri='http://www.springframework.org/security/tags' %> 

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>青牛软件</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
	
	<link href="static/css/bootstrap.min.css" rel="stylesheet">
	<link href="static/css/style.css" rel="stylesheet">

  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->

  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="img/favicon.png">
  
	<script type="text/javascript" src="static/js/jquery.min.js"></script>
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="static/js/scripts.js"></script>
</head>

<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="jumbotron">
				<h1>
					测试首页
				</h1>
				<p>
					<security:authorize ifAnyGranted="ROLE_USER,ROLE_ADMIN">
					你好， <security:authentication property="principal.authorities"></security:authentication> <security:authentication property="principal.username"></security:authentication> 
					</security:authorize>
					<security:authorize ifAllGranted="ROLE_ANONYMOUS">
					你还没有登陆
					</security:authorize>
				</p>
				<p>
					<security:authorize ifNotGranted="ROLE_USER,ROLE_ADMIN">
						<a class="btn btn-primary btn-large" href="login.jsp">登陆</a>
					</security:authorize>
					<a class="btn btn-primary btn-large" href="logout.do">登出</a>
					<!-- <a class="btn btn-primary btn-large" href="testmvc">测试mvc</a> -->
					<security:authorize ifAnyGranted="ROLE_USER,ROLE_ADMIN">
					<a class="btn btn-primary btn-large" href="settings/profile">用户资料</a>
					</security:authorize>
				</p>
			</div>
		</div>
	</div>
</div>
</body>
</html>
