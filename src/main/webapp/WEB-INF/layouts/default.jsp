<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.springframework.security.core.AuthenticationException" %>
<%@ page import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>  
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta name="description" content=""/>
  <meta name="author" content=""/>
  <c:set var="ctx" value="${pageContext.request.contextPath}" />
  <title>用户中心-<sitemesh:title/></title>
	<link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="${ctx}/static/css/style.css" rel="stylesheet"/>
	<script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/scripts.js"></script>
<sitemesh:head/>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<div class="col-md-12 column">
			<c:if test="${not empty message}">
			<div class="alert alert-success alert-dismissable">
				 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<c:out value="${message}"></c:out>
			</div>
			</c:if>
			
			<div class="row clearfix">
				<div class="col-md-3 column">
					<div class="list-group">
					 	<a id="profilelink" href="${ctx}/settings/profile" class="list-group-item">用户资料</a>
						<a id="adminlink" href="${ctx}/settings/admin" class="list-group-item">账户设置</a>
						<a id="billinglink" href="${ctx}/settings/billing" class="list-group-item">资费信息</a>
					</div>
				</div>
				<sitemesh:body/>
			</div>
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
		</div>
	</div>
</body>
</html>