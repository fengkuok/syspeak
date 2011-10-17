/**
 * Deployment List
 */
Ext.define('Workflow.view.explorer.processdefinition.List' ,{
    extend: 'SysPeak.grid.CrudGrid',
//    alias : 'widget.wf.explorer.DeploymentList',

    store : 'explorer.ProcessDefinitions',
    //we no longer define the Users store in the `initComponent` method
    initComponent: function() {
    	Ext.applyIf(this,{
    		title : 'ProcessDefinitions',
    		closable : true
    	});
    	
    	this.buildColumns();
    	this.buildToolBar();
    	
        this.callParent(arguments);
    },
    
    buildColumns : function(){
    	var deleteConfirmTitle = this.deleteConfirmTitle;
    	var deleteConfirmMessage = this.deleteConfirmMessage;
    	this.columns = [
    		{header: 'ID', dataIndex: 'id'},    		
            {header: 'Name', dataIndex: 'name'},
            {header: 'DeploymentID', dataIndex: 'deploymentId'}, 
            {header: 'Category', dataIndex: 'category'}, 
            {header: 'Key', dataIndex: 'key'}, 
            {header: 'Version', dataIndex: 'version'}, 
            {header: 'ResourceName', dataIndex: 'resourceName'}, 
            {header: 'DiagramResourceName', dataIndex: 'diagramResourceName'},
            {header: 'HasStartFormKey', dataIndex: 'hasStartFormKey'},
            {
                xtype: 'actioncolumn',
                width: 50,
                items: [{
                	iconCls: 'execute',
                    tooltip: 'Start Process!',
                    handler: function(grid, rowIndex, colIndex) {
                    	var store = grid.getStore();
                        var rec = store.getAt(rowIndex);                        
                        var delId = rec.get('id');
                        if(delId) {
                        	Ext.MessageBox.confirm(deleteConfirmTitle, deleteConfirmMessage, function(btn) {
                        		if(btn!='yes') {return;}
                        		store.removeAt(rowIndex);
                        		store.sync();
                        	});
                        }
                    }
                }]
            }
        ];
    },
    
    buildToolBar : function(){
    	this.tbar = [{ 
	    	xtype : 'button', 
	    	text : 'Execute Selected Deployments',
	    	iconCls : 'icon-btn-add',
	    	handler : function(){
	    		SysPeak.Toast.show('提示','Success...')
	    	}
    	}];
    }
});