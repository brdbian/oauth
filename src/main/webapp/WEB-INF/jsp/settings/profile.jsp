<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<head>
<title>资料修改</title>
<script type="text/javascript">
$(document).ready(
	function(){
	  	$("#profilelink").addClass("active");
	}
);

</script>
</head>
<body>

<div class="col-md-9 column">
	<form role="form" action="${ctx}/settings/profile/save" method="post">
		<input type="hidden" name="id" value="${userProfile.id}"/>
		<div class="form-group">
			 <label for="name">姓名</label><input type="text" class="form-control" value="${userProfile.name}" id="name" name="name" />
		</div>
		<div class="form-group">
			 <label for="publicEmail">公开邮箱</label><input type="text" value="${userProfile.publicEmail}" class="form-control" id="publicEmail" name="publicEmail" />
		</div>
		<div class="form-group">
			 <label for="url">个人链接</label><input type="text" value="${userProfile.url}" class="form-control" id="url" name="url" />
		</div>
		<div class="form-group">
			 <label for="company">公司</label><input type="text" value="${userProfile.company}" class="form-control" id="company" name="company" />
		</div>
		<div class="form-group">
			 <label for="address">地址</label><input type="text" value="${userProfile.address}" class="form-control" id="address" name="address" />
		</div>
		<div class="form-group">
			 <label for="privateEmail">非公开邮箱</label><input type="text" value="${userProfile.privateEmail}" class="form-control" id="privateEmail" name="privateEmail"  />
		</div>
		<button type="submit" class="btn btn-default">保存</button>
	</form>
</div>
</body>
</html>
