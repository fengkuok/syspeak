<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>流程部署</title>
	<%@include file="/common/meta.jsp" %>
	<link href="${ctx}/static/mini-web.css" type="text/css" rel="stylesheet" />
	<link href="${ctx}/static/jquery-validation/milk.css" type="text/css" rel="stylesheet" />
	<link href="${ctx}/static/blueprint/1.0.1/screen.css" type="text/css" rel="stylesheet" media="screen, projection" />
	<link href="${ctx}/static/blueprint/1.0.1/print.css" type="text/css" rel="stylesheet" media="print" />
	<!--[if lt IE 8]><link href="${ctx}/static/blueprint/1.0.1/ie.css" type="text/css" rel="stylesheet" media="screen, projection"><![endif]-->	
	<script src="${ctx}/static/jquery/jquery.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/jquery-validation/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/jquery-validation/messages_cn.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			//为inputForm注册validate函数
			$("#inputForm").validate({
				rules: {
					deploymentResources: {'accept': 'bar|zip|bpmn20.xml'}
				},
				messages: {
					deploymentResources: {'accept': '流程资源文件仅支持bar,zip,bpmn20.xml'}
				}
			});
		});
	</script>
</head>

<body>
	<h3><c:if test="${empty id}">部署</c:if><c:if test="${not empty id}">查看</c:if>流程</h3>
	<div class="menu">
		<ul>
			<li><a href="list">流程部署列表</a></li>
		</ul>
	</div>	
	<form id="inputForm" action="${ctx}/deployment/${id}" method="post" enctype="multipart/form-data">
		<table class="noborder">
			<tr>
				<td>流程定义资源文件:</td>
				<td><input type="file" name="deploymentResources" size="40" id="deploymentResources" class="required" /></td>
			</tr>
			<tr>
				<td colspan="2">					
					<input class="button" type="submit" value="提交"/>&nbsp;	
					<input class="button" type="button" value="返回" onclick="history.back()"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
