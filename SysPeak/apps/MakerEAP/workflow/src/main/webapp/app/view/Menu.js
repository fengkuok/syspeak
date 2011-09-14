Ext.define('Workflow.view.Menu',{
    extend: 'Ext.panel.Panel',
    region:'west',
    layout: 'accordion',
    minWidth : 130,
    maxWidth : 280,
    split: true,
    collapsible: true,
    border: false,
    
    defaultMargins : {top:0, right:0, bottom:-1, left:1},
	defaults: {
        // applied to each contained panel
        bodyStyle: 'padding:15px'
    },
    layoutConfig: {
        // layout-specific configs go here
        titleCollapse: true,
        animate: true,
        activeOnTop: true
    },    
    
    initComponent : function(){
        Ext.apply(this,{
            id: 'menu-panel',
    		title: '当前用户:FengKuok',
    		iconCls:'icon-menu',
    		width : 200
        });
        
        this.items = [{
	        title: 'Panel 1',
	        iconCls : 'icon-tree-accordion',
	        html: 'Panel content!'
	    },{
	        title: 'Panel 2',
	        iconCls : 'icon-tree-accordion',
	        html: 'Panel content!'
	    },{
	        title: 'Panel 3',
	        iconCls : 'icon-tree-accordion',
	        html: 'Panel content!'
	    }];
	    
	    this.bbar = [{
        	text : '开始',
        	iconCls : 'icon-start',
        	menu : {
        		xtype : 'menu',
				items : [{
					text : '返回首页',
					iconCls : 'icon-home',
					handler : function(n) {
						try {
							//Ext.getCmp('content-panel').layout.setActiveItem('start-panel');
						} catch (e) {}
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
				}]
        	}
        }, '->', {
        	xtype: 'combo',
        	fieldLabel: '主题',
		    store: Ext.create('Ext.data.Store', {
			    fields: ['abbr', 'name'],
			    data : [
			        {"abbr":"AL", "name":"Alabama"},
			        {"abbr":"AK", "name":"Alaska"},
			        {"abbr":"AZ", "name":"Arizona"}
			        //...
			    ]
			}),
			labelAlign: 'left',
			labelWidth: 30,
			width: 100,
		    queryMode: 'local',
		    displayField: 'name',
		    valueField: 'abbr'
        	
        }]
	    
        this.callParent(arguments);
    }
});