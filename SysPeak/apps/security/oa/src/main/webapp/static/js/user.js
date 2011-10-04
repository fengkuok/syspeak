$(function() {
	$("#usergrid").ligerGrid({
		columns : [ {
			display : 'Id',
			name : 'id',
			width : 100
		}, {
			display : '帐号',
			name : 'username',
			width : 100
		}, {
			display : '是否启用',
			name : 'enabled',
			width : 100
		}, {
			display : '创建日期',
			name : 'createDate',
			width : 100
		} ],
		width : 600,
		url : "user/list",
		pageSizeOptions : [ 5, 10, 15, 20 ]
	});
});