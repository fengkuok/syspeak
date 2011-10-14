<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Maker-Workflow(Horse) BPMS</title>
	<%@ include file="/common/meta.jsp" %>
	<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/style.css" />
	<!-- 
	<script type="text/javascript" src="static/extjs4/ext.js"></script>
	 -->
</head>
<body>
    <div id="loading">
    	<span class="logo"></span>
    	<span class="indicator">
			Maker-Workflow(Hosrse) BPMS
			<span id="loading-msg">加载样式和图片...</span>
		</span>
    </div>
    <link id="theme" rel="stylesheet" type="text/css" href="${ctx}/static/extjs4/resources/css/ext-all.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/tree.css" />
	<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/button.css" />
	<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/actioncolumn.css" />
	<script type="text/javascript" src="${ctx}/static/extjs4/ext-debug.js"></script>
    <script type="text/javascript">
    	//Ext.get('loading-msg').update('加载UI组件...');
    	Ext.get('loading-msg').update('加载核心...');
    </script>
    
    
    <script type="text/javascript" src="${ctx}/app.js"></script>
    <script type="text/javascript" src="${ctx}/static/extjs4/locale/ext-lang-zh_CN.js" charset="utf-8"></script>
</body>
</html>