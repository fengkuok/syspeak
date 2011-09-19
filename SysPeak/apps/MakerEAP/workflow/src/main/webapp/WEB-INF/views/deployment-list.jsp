<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<title>流程部署测试页面</title>
	<%@include file="/common/meta.jsp" %>	
	<script>
		$(document).ready(function() {
			//聚焦第一个输入框
			$("#loginName").focus();
			//为inputForm注册validate函数
			$("#inputForm").validate({
				rules: {
					loginName: {
						required: true,
						remote: "user!checkLoginName.action?oldLoginName=" + encodeURIComponent('${loginName}')
					},
					name: "required",
					password: {
						required: true,
						minlength:3
					},
					passwordConfirm: {
						equalTo:"#password"
					},
					email:"email",
					checkedGroupIds:"required"
				},
				messages: {
					loginName: {
						remote: "用户登录名已存在"
					},
					passwordConfirm: {
						equalTo: "输入与上面相同的密码"
					}
				}
			});
		});
	</script>
</head>

<body>
	<h3>流程部署列表</h3>
	<div class="menu">
		<ul>
			<li><a href="create">部署流程</a></li>
		</ul>
	</div>
	<form:form id="searchForm" modelAttribute="page" action="list" method="post">
		<input type="hidden" name="pageNo" value="${page.pageNo}" />
		<input type="hidden" name="pageSize" value="${page.pageSize}" />
		<input type="hidden" name="orderBy" value="${page.orderBy}" />
		<input type="hidden" name="orderDir" value="${page.orderDir}" />
		<table border="1" bgcolor="#03e9f7" cellpadding="1" cellspacing="1">		
			<tr>
				<th>部署ID</th>
				<th>部署名称</th>
				<th>部署时间</th>
				<th>操作</th>
			</tr>			
			<c:forEach items="${page.result}" var="dto">
			<tr>
				<td><input type="checkbox" name="ids" value="${dto.id}" />${dto.id}</td>
				<td>${dto.name}</td>
				<td><fmt:formatDate value="${dto.deploymentTime}" pattern="yyyy年MM月dd日 HH:mm" /></td>
				<td></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="5">
					<div class="menu">
						<ul>
							<li><a>首页</a>&nbsp;|&nbsp;<a>上一页</a>&nbsp;|&nbsp;</li>
							<c:if test="${page.totalPages!=0}">
							<li>
								<c:forEach var="cur" begin="${page.pageNo}" end="${page.totalPages}">
									<c:if test="${cur==page.pageNo}">【</c:if><a>${cur}</a><c:if test="${cur==page.pageNo}">】</c:if>
								</c:forEach>&nbsp;|&nbsp;
							</li>
							</c:if>
							<li><a>下一页</a>&nbsp;|&nbsp;<a>末页</a>&nbsp;|&nbsp;</li>
							<li>共<b style="color:#ff0000;">${page.totalItems}</b>条记录&nbsp;|&nbsp;</li>
							<li>当前<b style="color:#ff0000;">${page.pageNo}</b>页/共<b style="color:#ff0000;">${page.totalPages}</b>页</li>
						</ul>
					</div>																								
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
