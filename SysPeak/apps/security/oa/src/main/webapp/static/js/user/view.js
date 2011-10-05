$(function() {
	$('#usertoolbar').ligerToolBar({
		items : [ {
			text : '添加用户',
			click : function() {
				$.ligerDialog.open({
					url : 'user/add',
					title : '添加用户',
					width : 500,
					height : 450
				});
			}
		}, {
			text : '删除所选',
			click : function() {
				var hasAdmin = false;
				if ($('#usergrid').ligerGetGridManager().getCheckedRows().length == 0) {
					$.ligerDialog.error('请选择要删除的用户！');
					return;
				}
				$.each($('#usergrid').ligerGetGridManager().getCheckedRows(), function(index, value) {
					if (value.username == 'admin') {
						hasAdmin = true;
						$.ligerDialog.error('管理员不允许删除！');
						return false;
					}
				});
				if (hasAdmin == true)
					return;
				$.ligerDialog.confirm('确认删除？', function(r) {
					if (r) {
						$.ligerDialog.alert('删除成功！', '', 'none');
					}
				});
			}
		} ]
	});

	$("#usergrid").ligerGrid({
		checkbox : true,
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
			width : 100,
			render : function(row) {
				var html;
				if (row.enabled == true)
					html = '<font color="green">启用</font>';
				else
					html = '<font color="red">停用</font>';
				return html;
			}
		}, {
			display : '创建日期',
			name : 'createDate',
			width : 150
		} ],
		width : 600,
		url : "user/list",
		pageSizeOptions : [ 5, 10, 15, 20 ]
	});

});