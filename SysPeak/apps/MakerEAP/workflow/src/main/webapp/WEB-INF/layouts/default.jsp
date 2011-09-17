<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Mini-Web示例:<sitemesh:write property='title' /></title>
<%@include file="/common/meta.jsp" %>
<link href="${ctx}/static/mini-web.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/jquery-validation/milk.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/blueprint/1.0.1/screen.css" type="text/css" rel="stylesheet" media="screen, projection" />
<link href="${ctx}/static/blueprint/1.0.1/print.css" type="text/css" rel="stylesheet" media="print" />
<!--[if lt IE 8]><link href="${ctx}/static/blueprint/1.0.1/ie.css" type="text/css" rel="stylesheet" media="screen, projection"><![endif]-->

<script src="${ctx}/static/jquery/jquery.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/messages_cn.js" type="text/javascript"></script>
<sitemesh:write property='head' />
</head>

<body>
	<div class="container">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<div id="content">
			<div class="span-24 last">
				<sitemesh:write property='body' />
			</div>
			<%@ include file="/WEB-INF/layouts/footer.jsp"%>
		</div>
	</div>
</body>
</html>