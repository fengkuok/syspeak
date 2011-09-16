Ext.define('Workflow.view.user.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.userlist',

    initComponent: function() {
    	Ext.applyIf(this,{
    		title : 'All Users',
    		closable : true
    	})
    	
        this.store = {
            fields: ['name', 'email'],
            data  : [
                {name: 'Ed',    email: 'ed@sencha.com'},
                {name: 'Tommy', email: 'tommy@sencha.com'}
            ]
        };

        this.columns = [
            {header: 'Name',  dataIndex: 'name',  flex: 1},
            {header: 'Email', dataIndex: 'email', flex: 1}
        ];

        this.callParent(arguments);
    }
});