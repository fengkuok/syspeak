/**
 * alias :
 * 
 * store : 
 * 
 * columns :[]
 * 
 * 
 */
Ext.define('SysPeak.grid.BaseGrid' ,{
    extend: 'Ext.grid.Panel',
    
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
    		title : 'BaseGrid Grid Template',
    		closable : true,
    		//设置默认分页大小
    		pageSize : 20
    	});
    	
    	Ext.apply(this, {
    		tbarItemIds : []
    	});
        
        var me = this;
        me.store = Ext.data.StoreManager.lookup(me.store);
        
        this.initBtnControll();
        
        this.buildColumnModel();
        
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
    	
    	//alert(tbarItemIds.length)
    	//listener
    	this.selModel.on('selectionchange',function(sm, selections){
    		//alert(this.getXType())
    		for(var i = 0; i < tbarItemIds.length; i++){
    			var itemId = tbarItemIds[i].itemId;
    			var controllRole = tbarItemIds[i].controllRole;
    			alert(controllRole.split(' ')[0]);
    			switch(controllRole.split(' ')[0]){
    				case '==': {
    					this.down(itemId).setDisabled(selections.length == parseInt(controllRole.split(' ')[1]));
    				};
    				case '>': {
    					this.down(itemId).setDisabled(selections.length > parseInt(controllRole.split(' ')[1]));
    				}
    			}
    			//this.down().setDisabled(selections.length == 0);
    		}
    		
    		//this.down('#removeBtn').setDisabled(selections.length == 0);
    	},this);
    	
    	delete columnHeaders;
    },
    
    initBtnControll : function(){
    	tbarItemIds = new Array();
    	for(var i = 0;i < this.tbar.length; i++){
    		if(this.tbar[i].disabled){
    			alert(this.tbar[i].itemId);
    			tbarItemIds.push({
    				itemId : '#' + this.tbar[i].itemId,
    				controllRole : this.tbar[i].controllRole
    			});
    		}
    	}
    	
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
           		Ext.create('SysPeak.plugin.PageSizePlugin')
           ]
       }];
    }
});