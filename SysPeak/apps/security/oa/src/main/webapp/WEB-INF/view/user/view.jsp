<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<link href="static/ligerui/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
		<script src="static/ligerui/jquery.js" type="text/javascript"></script>
		<script src="static/ligerui/ligerui.js" type="text/javascript"></script>
		<script src="static/js/user/view.js" type="text/javascript"></script>
	</head>

	<body>
		<div id="usertoolbar"></div>
		<div id="usergrid"></div>
	</body>
</html>
