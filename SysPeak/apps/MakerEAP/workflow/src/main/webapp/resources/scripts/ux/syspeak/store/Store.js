/**
 * readUrl :
 * 
 * updateUrl :
 * 
 */
Ext.define('SysPeak.store.Store', {
    extend: 'Ext.data.Store',
    
	accepts: {
		'xml': "application/xml, text/xml",
		'html': "text/html",
		'text': "text/plain",
		'json': "application/json, text/javascript",
		"*": ["*/"] + ["*"]
	},
	
	proxyFormat: 'json',
    
	constructor: function(config) {
    	
    	Ext.applyIf(config, {
    		autoLoad: false,
    		updateUrl : ''    		
    	});
    	
    	Ext.applyIf(config, {
    		proxy : {
		        type: 'rest',		        
		        extraParams :{
		        	//pageNo : 0,//start
		        	//limit : 30
		        },
		        url: this.restUrl,
		        simpleSortMode: true,
		        headers: {'Accept': this.accepts[this.proxyFormat]},
		        sortParam: 'orderBy',
		        directionParam: 'orderDir',
		        limitParam: 'pageSize',
		        pageParam: 'pageNo',
		        format: this.proxyFormat,
//		        startParam : '',
//		        limitParam : '',
//		        pageParam : '',
			    /*api: { 
			        read: this.readUrl,
			        update: this.updateUrl
			        create  : '/controller/new',
				    read    : '/controller/load',
				    update  : '/controller/update',
				    destroy : '/controller/destroy_action'
			    },*/
			    reader: {
			        type: 'json',
			        root: 'result',
			        totalProperty  : 'totalItems',
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