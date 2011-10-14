/**
 * Deployment List
 */
Ext.define('Workflow.view.explorer.deployment.List' ,{
    extend: 'SysPeak.grid.CrudGrid',
//    alias : 'widget.wf.explorer.DeploymentList',

    store : 'explorer.Deployments',
    //we no longer define the Users store in the `initComponent` method
    initComponent: function() {
    	Ext.applyIf(this,{
    		title : 'Deployments',
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
            {header: 'ID', width : 80, dataIndex: 'id'},
            {header: 'Name', width : 80, dataIndex: 'name'},
            {header: 'DeploymentTime', width : 150, dataIndex: 'deploymentTime'},
            {
                xtype: 'actioncolumn',
                width: 50,
                items: [{
                	iconCls: 'delete',
                    tooltip: 'Delete Deployment!',
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