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
    
    loadMask : {msg : '数据加载中...'},
    //alias : 'widget.userlist',
//	columnLines: true,
//    frame : true,
    // other options
//    viewConfig: {
//        plugins: {
//            ddGroup: 'people-group',
//            ptype: 'gridviewdragdrop',
//            enableDrop: false
//        }
//    },

//we no longer define the Users store in the `initComponent` method
    //store: 'Users',
    initComponent: function() {
    	Ext.applyIf(this,{
    		title : 'Crud Grid Template',
    		closable : true,
    		//设置默认分页大小
    		pageSize : 20
    	});
    	
        
        var me = this;
        me.store = Ext.data.StoreManager.lookup(me.store);
        //this.buildColumnModel();
		this.buildToolbar();
        this.buildPagingToolbar();
        this.callParent(arguments);
    },
    
    //初始化ColumnModel
    buildColumnModel : function(){
    	//表头
//    	var columnHeaders = new Array();
//    	columnHeaders[0] = Ext.create('Ext.grid.RowNumberer');
//    	this.selModel = Ext.create('Ext.selection.CheckboxModel',{
//    		injectCheckbox : 1
//    	});
//    	
//    	for(var i = 0; i < this.columns.length; i++){
//    		columnHeaders.push(this.columns[i]);
//    	}
//    	this.columns = columnHeaders;
//    	
//    	delete columnHeaders;
    },
    
    buildToolbar : function(){
	    this.tbar = [{ 
	    	xtype : 'button', 
	    	text : '新增',
	    	iconCls : 'icon-btn-add'
    	}, {
    		xtype : 'button',
    		text : '修改',
    		iconCls : 'icon-btn-edit'
    	}, {
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
           displayMsg: '显示第 {0} 条到 {1} 条记录，一共 {2} 条',
           pageSize: this.pageSize,
           plugins : [
           		Ext.create('Workflow.view.cls.PageSizePlugin')
           ]
       }];
    }
});