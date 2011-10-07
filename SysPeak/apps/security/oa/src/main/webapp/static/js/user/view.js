$(function() {
	$('#usertoolbar').ligerToolBar({
		items : [ {
			text : '添加用户',
			click : function() {
				$.ligerDialog.open({
					url : 'user/add',
					title : '添加用户',
					width : 300,
					height : 250
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
						var users = '?1=1';
						var rows = $('#usergrid').ligerGetGridManager().getCheckedRows();
						$.each(rows, function(index, value) {
							users += '&id=' + value.id;
						});
						$.ajax({
							type : 'post',
							url : 'user/delete' + users,
							success : function(responseData, textStatus) {
								if (textStatus == 'success') {
									if (responseData.success == true) {
										$("#usergrid").ligerGetGridManager().loadData();
										$.ligerDialog.alert('删除成功！', '', 'none');
									} else {
										alert('删除失败');
									}
								} else {
									alert('未知原因导致添加失败，请检查网络或者与系统管理员联系');
								}
							}
						});
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