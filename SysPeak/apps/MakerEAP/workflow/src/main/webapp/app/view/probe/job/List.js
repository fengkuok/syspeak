Ext.define('Workflow.view.probe.job.List' ,{
    extend: 'SysPeak.grid.BaseGrid',
//    alias : 'widget.userlist',

    store : 'probe.Jobs',
    //we no longer define the Users store in the `initComponent` method
    initComponent: function() {
    	Ext.applyIf(this,{
    		title : 'Jobs',
    		closable : true
    	})
    	
    	this.buildColumns();
    	this.buildToolBar();
    	
        this.callParent(arguments);
    },
    
    buildColumns : function(){
    	this.columns = [
            {header: 'Status', width : 80, dataIndex: 'exceptionMessage'},
            {header: 'Job Id', width : 80, dataIndex: 'id'},
            {header: 'Execution Id', width : 150, dataIndex: 'executionId'},
            {header: 'Retried Remaining', width : 200, dataIndex: 'retries'},
            {header: 'Process Instance Id', width : 200, dataIndex: 'processInstanceId'},
            {header: 'Due Date', width : 120, dataIndex: 'dueDate'},
            {header: 'Actions', width : 80, dataIndex: 'action', flex: 1}
        ];
    },
    
    buildToolBar : function(){
    	this.tbar = [{ 
	    	xtype : 'button', 
	    	text : 'Execute Selected Jobs',
	    	iconCls : 'icon-btn-add',
	    	handler : function(){
	    		SysPeak.Toast.show('提示','Success...')
	    	}
    	}];
    }
});