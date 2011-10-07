<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<script src="static/ligerui/jquery.js" type="text/javascript"></script>
		<script src="static/ligerui/ligerui.js" type="text/javascript"></script>
		<script src="static/js/user/add.js" type="text/javascript"></script>
		<style>
tr {
	margin-top: 20px;
}
</style>
	</head>
	<body>
		<form id="user_add_form">
			<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin: 20 auto;">
				<tr>
					<td align="right">
						用户名：
					</td>
					<td align="left">
						<input name="username" type="text" id="username" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td id="userExisted"></td>
				</tr>
				<tr>
					<td align="right">
						启用：
					</td>
					<td align="left">
						<input name="enabled" type="checkbox" id="enabled" />
					</td>
				</tr>
				<tr>
					<td style="text-align: center;">
						<input type="button" value="提交" id="submit" />
					</td>
					<td style="text-align: center;">
						<input type="reset" value="重置" />
					</td>
				</tr>
			</table>
			<br />
		</form>
	</body>
</html>
