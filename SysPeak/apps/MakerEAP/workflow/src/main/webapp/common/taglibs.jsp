<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="ctx" value="${ctx=='/'? '' : ctx}" />
<c:if test="${empty sessionScope._res}">
<c:set var="_res" value="${ctx}/resources" />
<c:set var="pagesjs" value="${_res}/js/page" scope="session" />
<c:set var="jqvalid" value="${_res}/js/validate" scope="session" />
<c:set var="jqueryui" value="${_res}/js/jqueryui" scope="session" />
<c:set var="jqtreeview" value="${_res}/js/jqtreeview" scope="session" />
<c:set var="adminTitle" value="MakerEAP-工作流系统管理平台" scope="session" />
<c:set var="appTitle" value="MakerEAP-工作流系统" scope="session" />
</c:if>