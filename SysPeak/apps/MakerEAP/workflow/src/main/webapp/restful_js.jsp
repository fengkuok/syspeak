<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Restful JS Demos</title>
<%@ include file="/common/meta.jsp"%>
<script type="text/javascript" src="${ctx}/static/jquery/jquery-1.6.4.js"></script>
<script type="text/javascript">
jQuery(function() {
	$('#jqJsonBtn').click(function() {
		$.ajax({
			url: '${ctx}/explorer/deployment',
			dataType: 'text',
			headers: {'Accept': "application/json, text/javascript"},
			success: function(data) {
				$('#jqJsonResult').html(data);
			},
			error: function(e, jqxhr, settings, exception) {
				alert("Error:"+e+", "+jqxhr+", "+settings+", "+exception);
			}
		});
	});
});
</script>
</head>
<body>
<h3>Restful JavaScript Demos!</h3>
<h4>JQuery:</h4>
	Load JSON: <input type="button" value="LoadJson" id="jqJsonBtn" />
	<div style="color: blue;" id="jqJsonResult"></div>	
</body>
</html>