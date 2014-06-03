<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta name="description" content=""/>
  <meta name="author" content=""/>
  <c:set var="ctx" value="${pageContext.request.contextPath}" />
  <title>登陆</title>
	<link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="${ctx}/static/css/style.css" rel="stylesheet"/>
	<script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/scripts.js"></script>
	<style type="text/css">
	.vertical-offset-100{
    padding-top:100px;
}
	</style>
</head>
<body>
<c:if test="${not empty error}" >
	<div class="alert alert-warning alert-dismissable">
		 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
		${error}
	</div>
</c:if> 
<div class="container">
    <div class="row vertical-offset-100">
    	<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			    	<h3 class="panel-title">请登陆</h3>
			 	</div>
			  	<div class="panel-body">
			    	<form accept-charset="UTF-8" role="form" action="<c:url value="/login.do"/>" method="post">
                    <fieldset>
			    	  	<div class="form-group">
			    		    <input class="form-control" placeholder="用户名" name="j_username" type="text">
			    		</div>
			    		<div class="form-group">
			    			<input class="form-control" placeholder="密码" name="j_password" type="password" value="">
			    		</div>
			    		<div class="checkbox">
		    	    		<input id="_spring_security_remember_me" name="_spring_security_remember_me" type="checkbox" value="true"> 记住我
			    	    </div>
			    		<input class="btn btn-lg btn-success btn-block" type="submit" value="登陆">
			    	</fieldset>
			      	</form>
			    </div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
