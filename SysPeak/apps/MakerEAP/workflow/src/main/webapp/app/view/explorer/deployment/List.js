/**
 * Deployment List
 */
Ext.define('Workflow.view.explorer.deployment.List' ,{
    extend: 'SysPeak.grid.CrudGrid',
//    alias : 'widget.wf.explorer.DeploymentList',

    store : 'activiti.Deployment',
    //we no longer define the Users store in the `initComponent` method
    initComponent: function() {
    	Ext.applyIf(this,{
    		title : 'Deployments',
    		closable : true
    	})
    	
    	this.buildColumns();
    	this.buildToolBar();
    	
        this.callParent(arguments);
    },
    
    buildColumns : function(){
    	this.columns = [
            {header: 'ID', width : 80, dataIndex: 'id'},
            {header: 'Name', width : 80, dataIndex: 'name'},
            {header: 'DeploymentTime', width : 150, dataIndex: 'deploymentTime'},
            {header: 'Resources', width : 200, dataIndex: 'resources'}
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