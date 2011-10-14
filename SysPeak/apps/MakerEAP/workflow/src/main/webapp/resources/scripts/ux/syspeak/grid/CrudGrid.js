/**
 * alias :
 * 
 * store : 
 * 
 * columns :[]
 * 
 * 
 */
Ext.define('SysPeak.grid.CrudGrid' ,{
    extend: 'SysPeak.grid.BaseGrid',
    
    deleteConfirmTitle: 'Confirm Delete Record?',
    deleteConfirmMessage: 'Do you confirm delete this record?',
    
    //初始化
    initComponent: function() {
    	Ext.applyIf(this,{
    		title : 'Crud Grid Template'
    	});
    	
        
		this.buildToolbar();
        
        this.callParent(arguments);
    },
    
    buildToolbar : function(){
	    this.tbar = [{ 
	    	xtype : 'button', 
	    	text : '新增',
	    	tooltip : 'tip采用系统常量...',
	    	iconCls : 'icon-btn-add',
	    	handler : function(){
	    		SysPeak.Toast.show('提示','操作成功！');
	    	}
    	},'-', {
    		itemId: 'editBtn',
    		xtype : 'button',
    		text : '修改',
    		disabled: true,
    		controllRole : '== 0',
    		iconCls : 'icon-btn-edit'
    	},'-', {
    		itemId: 'removeBtn',
    		xtype : 'button',
    		text : '删除',
    		controllRole : '> 1',
    		disabled: true,
    		iconCls : 'icon-btn-delete'
    	}];
    }
    
});