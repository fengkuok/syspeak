Ext.define('Workflow.view.Menu', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Workflow.view.Tree' ],

	id : 'menu',
	region : 'west',
	layout : 'accordion',
	minWidth : 130,
	maxWidth : 280,
	split : true,
	collapsible : true,
	border : false,

	defaultMargins : {
		top : 0,
		right : 0,
		bottom : -1,
		left : 1
	},
	defaults : {
		// applied to each contained panel
		bodyStyle : 'padding:0px'
	},
	layoutConfig : {
		// layout-specific configs go here
		titleCollapse : true,
		animate : true,
		activeOnTop : true
	},

	initComponent : function() {
		Ext.apply(this, {
			id : 'menu-panel',
			title : '当前用户:FengKuok',
			iconCls : 'icon-menu',
			width : 200
		});
		this.loadMenus();
		// this.items = [{
		// title: 'Panel 1',
		// iconCls : 'icon-tree-accordion',
		// items : [
		//	        	
		// ]
		// },{
		// title: 'Panel 2',
		// iconCls : 'icon-tree-accordion',
		// html: 'Panel content!'
		// },{
		// title: 'Panel 3',
		// iconCls : 'icon-tree-accordion',
		// html: 'Panel content!'
		// }];

		this.bbar = [ {
			text : '开始',
			iconCls : 'icon-start',
			menu : {
				xtype : 'menu',
				items : [ {
					text : '返回首页',
					iconCls : 'icon-home',
					handler : function(n) {
						try {
							// Ext.getCmp('content-panel').layout.setActiveItem('start-panel');
						} catch (e) {
						}
					}
				}, {
					text : '关于系统',
					iconCls : 'icon-home',
					handler : function(n) {
						Ext.Msg.alert('关于系统', 'Copyright © 2011 SysPeak MakerEAP');
					}
				}, {
					text : '联系我们',
					iconCls : 'icon-home',
					handler : function(n) {
						Ext.Msg.alert('联系我们', 'QQ群：19564395');
					}
				} ]
			}
		}];

		this.callParent(arguments);
	},

	buildMenuTree : function(trees) {

		alert(trees);
	},

	loadMenus : function() {
		Ext.Ajax.request({
			url : 'data/tree.json',
			params : {
				id : 1
			},
			scope : this,
			success : function(response) {
				var text = response.responseText;
				var trees = Ext.JSON.decode(text);
//				 alert(trees.length);
				Ext.Object.each(trees, function(key, value, myself) {
//					 alert(value.id)
//					 alert(key + ":" + value)
					// alert(Ext.JSON.encode(value.children));
					var tree = Ext.create('Ext.tree.Panel', {
						title : value.text,
						margins : '0 0 -1 1',
						useArrows : true,
						iconCls : value.iconCls,
						rootVisible : false,
						border : true,
						split : true,
						collapsible : true,
						defaults : {
							expanded : true
						},
						// loader: new Ext.tree.TreeLoader(),
						root : {
							// text: "Root node",
							expanded : true,
							children : value.children
						},
						listeners : {
							itemclick : function() {
								Ext.Msg.alert('fuck you', 'bitches');
							}
						}

					// root: Ext.JSON.encode(value.children)
					});
					// 发现ext4中已经去除了createDelegate方法，所以只能是scope中指定为this了（不知道是不是用别方法替代了，很奇怪为什么createDelegate不见了）
					this.add(tree); // this 指的是menu-panel
					// alert(this.getItemId())
					// alert(Ext.getCmp('menu-panel').getItemId());
				}, this);
			}
		});
	}
});