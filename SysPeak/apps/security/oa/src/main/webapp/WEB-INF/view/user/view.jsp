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
		<div style="background-color: yellow;">
			<label>
				帐号：
			</label>
			<input type="text" id="searchUsername">
			<label>
				启用：
			</label>
			<select id="searchEnabled">
				<option value="">
				</option>
				<option value="1">
					启用
				</option>
				<option value="0">
					停用
				</option>
			</select>
			<input type="button" id="btn_search" value="查询">
		</div>
		<div id="usertoolbar"></div>
		<div id="usergrid"></div>
	</body>
</html>
