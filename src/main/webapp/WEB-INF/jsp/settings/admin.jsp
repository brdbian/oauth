<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.springframework.security.core.AuthenticationException" %>
<%@ page import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException" %>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>修改密码</title>
<script type="text/javascript">
$(document).ready(
	function(){
	  	$("#adminlink").addClass("active");
	}
);
</script>
</head>

<body>
<div class="col-md-9 column">
	<form role="form">
		<div class="form-group">
			 <label for="exampleInputEmail1">原密码</label><input type="password" class="form-control" id="password" />
		</div>
		<div class="form-group">
			<label for="plainPassword" class="control-label">新密码:</label>
			<div class="controls">
				<input type="password" id="plainPassword" name="plainPassword" class="form-control" placeholder="...Leave it blank if no change"/>
			</div>
		</div>
		<div class="form-group">
			<label for="confirmPassword" class="control-label">确认密码:</label>
			<div class="controls">
				<input type="password" id="confirmPassword" name="confirmPassword" class="form-control" equalTo="#plainPassword" />
			</div>
		</div>
		<button type="submit" class="btn btn-default">提交</button>
	</form>
</div>
</body>
</html>
