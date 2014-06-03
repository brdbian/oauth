<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="org.springframework.security.core.AuthenticationException"%>
<%@ page
	import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter"%>
<%@ page
	import="org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException"%>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>资费情况</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#billinglink").addClass("active");
	});
</script>
</head>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<body>
<div class="col-md-9 column">
	<table class="table">
		<thead>
			<tr>
				<th>名称</th>
				<th>价格</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${plans}" var="plan">
				<tr>
					<td>${plan.name}</td>
					<td>${plan.price}</td>
					<c:if test="${plan.id==userPlan.id}">
					<td>当前资费</td>
					</c:if>
					<c:if test="${plan.id!=userPlan.id}">
					<td><a href="">选择</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>
