/**
 * readUrl :
 * 
 * updateUrl :
 * 
 */
Ext.define('Workflow.store.cls.Store', {
    extend: 'Ext.data.Store',
    
	constructor: function(config) {
    	
    	Ext.applyIf(config, {
    		autoLoad: false
    	});
    	
    	Ext.applyIf(config, {
    		proxy : {
		        type: 'rest',
		        extraParams :{
		        	//pageNo : 0,//start
		        	//limit : 30
		        },
//		        startParam : '',
//		        limitParam : '',
//		        pageParam : '',
			    api: {
			        read: this.readUrl,
			        update: this.updateUrl
//			        create  : '/controller/new',
//				    read    : '/controller/load',
//				    update  : '/controller/update',
//				    destroy : '/controller/destroy_action'
			    },
			    reader: {
			        type: 'json',
			        root: 'result',
			        totalProperty  : 'totalCount',
			        successProperty: 'success'
			    }
		    }
    	});
    	
    	//设置默认分页大小
		this.pageSize = Ext.state.Manager.get('ext_PageSizePlugin_pageSize') || 30;
    	this.remoteSort = true;
    	
	    this.callParent([config]);
    }
});