<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>OA协同办公平台</title>
		<link href="static/ligerui/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
		<script src="static/ligerui/jquery.js" type="text/javascript"></script>
		<script src="static/ligerui/ligerui.js" type="text/javascript"></script>
		<script src="static/js/index.js" type="text/javascript"></script>
		<style type="text/css">
			a {
				text-decoration: none;
			},
			ul {
				float: right;
			}
		</style>
	</head>
	<body>
		<div id="index_layout">
			<div id="left" position="left">
			</div>
			<div id="main" position="center">
			</div>
			<div id="top" position="top">
				<div>
					<ul>
						<li>
							<a href="logout">退出</a>
						</li>
					</ul>
				</div>
			</div>
			<div id="bottom" position="bottom">
				<div style="padding-top: 5px; text-align: center;">
					<a href="http://www.syspeak.com" target="_blank">copyright &copy SysPeak 信息系统有限公司</a>
				</div>
			</div>
		</div>
	</body>
</html>