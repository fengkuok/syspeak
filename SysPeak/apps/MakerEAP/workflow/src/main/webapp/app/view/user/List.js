Ext.define('Workflow.view.user.List', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.userlist',

	initComponent : function() {
		Ext.applyIf(this, {
			title : 'All Users',
			closable : true
		});
		this.buildGrid();
		this.callParent(arguments);
	},

	buildGrid : function() {
		var store = Ext.create('Workflow.store.Users');

		this.store = store;

		this.columns = [ {
			header : '用户名',
			dataIndex : 'name',
			width : 100
		}, {
			header : '邮箱',
			dataIndex : 'email',
			width : 120
		} ];

		this.bbar = Ext.create('Ext.PagingToolbar', {
			store : store,
			displayInfo : true,
			displayMsg : '显示第 {0} 条到 {1} 条记录，一共 {2} 条',
			emptyMsg : "用户列表为空"

		});

		this.tbar = [ {
			xtype : 'button',
			text : '新增用户',
			handler : function() {
				Ext.Msg.alert('新增', '新增你个鸡巴');
			}
		}, {
			xtype : 'button',
			text : '删除用户'
		} ];
	}
});