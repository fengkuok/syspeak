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
		<script type="text/javascript" src="static/js/user/add.js"></script>
	</head>
	<body>
		<form name="user_add_form" method="post" action="user/doAdd" id="user_add_form">
			<div>
			</div>
			<table cellpadding="0" cellspacing="0" class="l-table-edit">
				<tr>
					<td align="right" class="l-table-edit-td">
						名字:
					</td>
					<td align="left" class="l-table-edit-td">
						<input name="txtName" type="text" id="txtName" ltype="text" />
					</td>
					<td align="left"></td>
				</tr>
				<tr>
					<td align="right" class="l-table-edit-td" valign="top">
						性别:
					</td>
					<td align="left" class="l-table-edit-td">
						<input id="rbtnl_0" type="radio" name="rbtnl" value="1" checked="checked" />
						<label for="rbtnl_0">
							男
						</label>
						<input id="rbtnl_1" type="radio" name="rbtnl" value="2" />
						<label for="rbtnl_1">
							女
						</label>
					</td>
					<td align="left"></td>
				</tr>

				<tr>
					<td align="right" class="l-table-edit-td" valign="top">
						爱好:
					</td>
					<td align="left" class="l-table-edit-td">
						<input id="CheckBoxList1_0" type="checkbox" name="CheckBoxList1$0" checked="checked" />
						<label for="CheckBoxList1_0">
							篮球
						</label>
						<br />
						<input id="CheckBoxList1_1" type="checkbox" name="CheckBoxList1$1" />
						<label for="CheckBoxList1_1">
							网球
						</label>
						<br />
						<input id="CheckBox1" type="checkbox" name="CheckBoxList1$1" />
						<label for="CheckBoxList1_1">
							足球
						</label>
					</td>
					<td align="left"></td>
				</tr>

				<tr>
					<td align="right" class="l-table-edit-td">
						入职日期:
					</td>
					<td align="left" class="l-table-edit-td">
						<input name="txtDate" type="text" id="txtDate" ltype="date" />
					</td>
					<td align="left"></td>
				</tr>
				<tr>
					<td align="right" class="l-table-edit-td">
						年龄:
					</td>
					<td align="left" class="l-table-edit-td">
						<input name="txtAge" type="text" id="txtAge" ltype='spinner' ligerui="{type:'int'}" value="20" />
					</td>
					<td align="left"></td>
				</tr>
				<tr>
					<td align="right" class="l-table-edit-td">
						部门:
					</td>
					<td align="left" class="l-table-edit-td">
						<select name="ddlDepart" id="ddlDepart" ltype="select">
							<option value="1">
								主席
							</option>
							<option value="2">
								研发中心
							</option>
							<option value="3">
								销售部
							</option>
							<option value="4">
								市场部
							</option>
							<option value="5">
								顾问组
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right" class="l-table-edit-td">
						地址:
					</td>
					<td align="left" class="l-table-edit-td">
						<textarea cols="100" rows="4" class="l-textarea" style="width: 400px"></textarea>
					</td>
					<td align="left"></td>
				</tr>
			</table>
			<br />
			<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" />
			<input type="reset" value="重置" class="l-button l-button-reset" />
		</form>
	</body>
</html>
