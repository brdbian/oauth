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
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta name="description" content=""/>
  <meta name="author" content=""/>
  <c:set var="ctx" value="${pageContext.request.contextPath}" />
  <title>确认页面</title>
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
						青牛软件欢迎您！
					</h1>
					<% if (session.getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) != null && !(session.getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) instanceof UnapprovedClientAuthenticationException)) { %>
				        <h2>糟糕!</h2>
				
				        <p>进入被拒. (<%= ((AuthenticationException) session.getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY)).getMessage() %>)</p>
				    <% } %>
				    <c:remove scope="session" var="SPRING_SECURITY_LAST_EXCEPTION"/>
				    <authz:authorize ifAllGranted="ROLE_USER"> 
				      <h2>注意</h2>
				
				      <p>需要认证 "<c:out value="${client.clientId}"/>" 获取资源.</p>
				
				      <form id="confirmationForm" name="confirmationForm" action="<%=request.getContextPath()%>/oauth/authorize" method="post">
				        <input name="user_oauth_approval" value="true" type="hidden"/>
				        <label><input class="btn btn-primary btn-large" name="authorize" value="Authorize" type="submit"/></label>
				      </form>
				      <form id="denialForm" name="denialForm" action="<%=request.getContextPath()%>/oauth/authorize" method="post">
				        <input name="user_oauth_approval" value="false" type="hidden"/>
				        <label><input class="btn btn-large" name="deny" value="Deny" type="submit"/></label>
				      </form>
				   </authz:authorize>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
