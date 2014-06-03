<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta name="description" content=""/>
  <meta name="author" content=""/>
  <c:set var="ctx" value="${pageContext.request.contextPath}" />
  <title>错误页面</title>
	<link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="${ctx}/static/css/style.css" rel="stylesheet"/>
	<script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/scripts.js"></script>
</head>

<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="jumbotron">
				<h1>
					失败了
				</h1>
				<p>
					不知道什么原因，认证失败了。。。
					<c:out value="${message}"/> (<c:out value="${error.summary}"/>)
				</p>
				<p>
					<a class="btn btn-primary btn-large" href="/oauth/index.jsp">到首页</a>
				</p>
			</div>
		</div>
	</div>
</div>
</body>
</html>
