/**
 * alias :
 * 
 * store : 
 * 
 * columns :[]
 * 
 * 
 */
Ext.define('Workflow.view.cls.CrudGrid' ,{
    extend: 'Ext.grid.Panel',
    //alias : 'widget.userlist',
    
    //config
    loadMask : {msg : '数据加载中...'},
	columnLines: true,
    frame : true,
    
    // other options
//    viewConfig: {
//        plugins: {
//            ddGroup: 'people-group',
//            ptype: 'gridviewdragdrop',
//            enableDrop: ture
//        }
//    },

    //初始化
    initComponent: function() {
    	Ext.applyIf(this,{
    		title : 'Crud Grid Template',
    		closable : true,
    		//设置默认分页大小
    		pageSize : 20
    	});
    	
        
        var me = this;
        me.store = Ext.data.StoreManager.lookup(me.store);
        
        this.buildColumnModel();
		this.buildToolbar();
        this.buildPagingToolbar();
        
        this.callParent(arguments);
    },
    
    //初始化ColumnModel
    buildColumnModel : function(){
    	//表头
    	var columnHeaders = new Array();
    	//设置第一个表头为序列号
    	columnHeaders[0] = Ext.create('Ext.grid.RowNumberer');
    	for(var i = 0; i < this.columns.length; i++){
    		columnHeaders.push(this.columns[i]);
    	}
    	this.columns = columnHeaders;
    	//设置复选框
    	this.selModel = Ext.create('Ext.selection.CheckboxModel',{
    		injectCheckbox : 1
    	});
    	
    	delete columnHeaders;
    },
    
    buildToolbar : function(){
	    this.tbar = [{ 
	    	xtype : 'button', 
	    	text : '新增',
	    	iconCls : 'icon-btn-add',
	    	handler : function(){
	    		Ext.ux.Toast.msg('xxx','fsadfadfadfad');
	    	}
    	},'-', {
    		xtype : 'button',
    		text : '修改',
    		iconCls : 'icon-btn-edit'
    	},'-', {
    		xtype : 'button',
    		text : '删除',
    		iconCls : 'icon-btn-delete'
    	}];
    },
    
    buildPagingToolbar : function(){
    	this.dockedItems = [{
           xtype: 'pagingtoolbar',
           store: this.getStore(),   // same store GridPanel is using
           dock: 'bottom',
           displayInfo: true,
           displayMsg: '显示第 {0} - {1} 条记录，一共 {2} 条',
           pageSize: this.pageSize,
           plugins : [
           		Ext.create('Workflow.view.cls.PageSizePlugin')
           ]
       }];
    }
});