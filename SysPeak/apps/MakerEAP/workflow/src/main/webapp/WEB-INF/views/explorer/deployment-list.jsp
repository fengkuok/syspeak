<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>流程部署测试页面</title>
	<%@include file="/common/meta.jsp" %>
	<script type="text/javascript">
	function deleteData(id) {
		if(!confirm("确定要删除数据吗?")) {
			return;
		}
		$('#searchForm').attr('action', '${ctx}/deployment/'+id);
		//$('#_method').val('delete');
		$('#searchForm').submit();
	}
	</script>	
</head>

<body>
<%
Enumeration names = request.getAttributeNames();
while(names.hasMoreElements()) {
	System.out.println(names.nextElement());
}
%>
	<h3>流程部署列表</h3>
	<div class="menu">
		<ul>
			<li><a href="${ctx}/deployment/create">部署流程</a></li>
		</ul>
	</div>
	<form:form id="searchForm" action="deployment" method="delete">		
		<input type="hidden" name="pageNo" value="${extPage.pageNo}" />
		<input type="hidden" name="pageSize" value="${extPage.pageSize}" />
		<input type="hidden" name="orderBy" value="${extPage.orderBy}" />
		<input type="hidden" name="orderDir" value="${extPage.orderDir}" />
		<table border="1" bgcolor="#03e9f7" cellpadding="1" cellspacing="1">		
			<tr>
				<th>部署ID</th>
				<th>部署名称</th>
				<th>部署时间</th>
				<th>操作</th>
			</tr>			
			<c:forEach items="${extPage.result}" var="dto">
			<tr>
				<td><input type="checkbox" name="ids" id="ids_${dto.id}" value="${dto.id}" />${dto.id}</td>
				<td>${dto.name}</td>
				<td><fmt:formatDate value="${dto.deploymentTime}" pattern="yyyy年MM月dd日 HH:mm" /></td>
				<td><a href="javascript:void(0)" onclick="deleteData('${dto.id}')">删除</a></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="5">
					<div class="menu">
						<ul>
							<li><a>首页</a>&nbsp;|&nbsp;<a>上一页</a>&nbsp;|&nbsp;</li>
							<c:if test="${extPage.totalPages!=0}">
							<li>
								<c:forEach var="cur" begin="${extPage.pageNo}" end="${extPage.totalPages}">
									<c:if test="${cur==extPage.pageNo}">【</c:if><a>${cur}</a><c:if test="${cur==extPage.pageNo}">】</c:if>
								</c:forEach>&nbsp;|&nbsp;
							</li>
							</c:if>
							<li><a>下一页</a>&nbsp;|&nbsp;<a>末页</a>&nbsp;|&nbsp;</li>
							<li>共<b style="color:#ff0000;">${extPage.totalItems}</b>条记录&nbsp;|&nbsp;</li>
							<li>当前<b style="color:#ff0000;">${extPage.pageNo}</b>页/共<b style="color:#ff0000;">${extPage.totalPages}</b>页</li>
						</ul>
					</div>																								
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
