Ext.define('Workflow.view.Menu',{
    extend: 'Ext.panel.Panel',
    requires : [
    	'Ext.window.MessageBox',
    	'Ext.form.field.ComboBox'
    ],
    
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
        bodyStyle: 'padding:0px'
    },
    layoutConfig: {
        // layout-specific configs go here
        titleCollapse: true,
        animate: true,
        activeOnTop: true
    },    
    
    initComponent : function(){
        Ext.applyIf(this,{
            id: 'menu-panel',
    		title: '当前用户:FengKuok',
    		iconCls:'icon-menu',
    		width : 210
        });
        
        this.loadMenus();
        //bbar暂时有点问题
        this.buildBottomBar();
	    
        this.callParent(arguments);
    },
    
    //private
    buildMenuTree : function(trees){
		Ext.Object.each(trees,function(key, value, myself){
        	var tree = Ext.create('Workflow.view.cls.Tree', {
		        title: value.text,
		        iconCls: value.iconCls,
	            root: {
			        children: value.children
			    }
		    });
		    
		    tree.on('itemclick',function(view, record, item, index){
    	    	if(!record.raw.isClass){
		    		return;
		    	}
		    	//在center-panel中打开
		    	this.setActiveTab(record);
		    },this);
		    //发现ext4中已经去除了createDelegate方法，所以只能是scope中指定为this了（不知道是不是用别方法替代了，很奇怪为什么createDelegate不见了）
		    this.add(tree); //this 指的是menu-panel
        },this);
        
        this.doLayout();
    },
    
    //private
    setActiveTab : function(record){
    	var tabs = Ext.getCmp('content-panel');
    	//id默认为数据库中的主键，这个以后会更改更长一些的数据。
    	var tabItem = tabs.getComponent(record.data.id);
    	
    	if(tabItem == 'undefined' || tabItem == null){
    		var p = Ext.create(record.raw.clsName,{
	    		title : record.data.text,
	    		iconCls : record.data.iconCls,
	    		closable : true,
	    		id : record.data.id
	    	});
	    	tabItem = tabs.add(p);
    	}
    	tabs.setActiveTab(tabItem);
    },
    
    loadMenus : function(){
    	Ext.Ajax.request({
		    url: 'data/tree.json',
		    scope: this,
		    params: {
		        id: 1
		    },
		    success: function(response){
		        var trees = Ext.JSON.decode(response.responseText);
		        this.buildMenuTree(trees);
		    }
		});
    },
    
    buildBottomBar : function(){
		this.bbar = [{
        	text : '开始',
        	iconCls : 'icon-start',
        	menuAlign : 'tl',
        	menu : {
        		xtype : 'menu',
        		style: {
                    paddingBottom: '47px'
                },
				items : [{
					text : '返回首页',
					iconCls : 'icon-home',
					handler : function(n) {
						try {
							Ext.getCmp('content-panel').setActiveTab(0);
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
        }, {
        	xtype: 'combobox',
        	fieldLabel: '主题',
		    store: Ext.create('Ext.data.Store', {
			    fields: ['id', 'name'],
			    data : [
			        {"id":"", "name":"经典模式"},
			        {"id":"-gray", "name":"银色模式"},
			        {"id":"-access", "name":"夜景模式"}
			    ]
			}),
			autoSelect : true,
			labelAlign: 'left',
			labelWidth: 40,
			width: 136,
		    queryMode: 'local',
		    displayField: 'name',
		    valueField: 'id',
		    editable : false,
		    listeners:{
		         select : function(field, value, options){
		         	if(window.localStorage){
		         		localStorage.themeLocalStore = this.getValue();
					}else{
					 	alert('This browser does NOT support localStorage');
					}
		         	//暂未实现存入cookies中
		         	Ext.util.CSS.swapStyleSheet("theme", Ext.Loader.getPath('cxt') + '/static/extjs4/resources/css/ext-all' + this.getValue() + '.css');
		         },
		         beforerender : function(){
		         	if(window.localStorage){
				 		var theme = localStorage.themeLocalStore;
				 		if(theme == null || theme == "null" || theme == 'undefined'){
				 			theme = "";
				 		}
				 		//设置默认选中
				 		this.setValue(theme);
					}else{
					 	alert('This browser does NOT support localStorage');
					}
		         	
		         }
		    }
        }];
    }
});

//    allowDrag: true
//allowDrop: true
//checked: null
//cls: ""
//depth: 4
//expandable: true
//expanded: false
//href: ""
//hrefTarget: ""
//iconCls: "icon-tree-cassette"
//id: ""
//index: 0
//isFirst: true
//isLast: true
//leaf: true
//loaded: false
//loading: false
//parentId: "4"
//qtip: ""
//qtitle: ""
//root: false
//text: "SuperJsonGrid1"