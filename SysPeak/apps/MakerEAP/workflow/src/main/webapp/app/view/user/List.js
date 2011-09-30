Ext.define('Workflow.view.user.List' ,{
    extend: 'SysPeak.grid.CrudGrid',
    alias : 'widget.userlist',

    store : 'Users',
    //we no longer define the Users store in the `initComponent` method
    initComponent: function() {
    	Ext.applyIf(this,{
    		title : 'All Users',
    		closable : true
    	})
    	
        this.columns = [
            {header: 'Name',  dataIndex: 'name',  flex: 1},
            {header: 'Email', dataIndex: 'email', flex: 1}
        ];

        this.callParent(arguments);
    }
});