Ext.define('Workflow.view.Viewport',{
    extend: 'Ext.Viewport',
    requires : [
        'Workflow.view.Header',
        'Workflow.view.Menu',
        'Workflow.view.TabPanel',
        'Workflow.view.South'
    ],
    
    id: 'viewport',
    layout: 'border',
    hideBorders: true,
    defaults: { xtype: 'container' },
    
    initComponent : function(){
    	this.items = [
    		Ext.create('Workflow.view.Header'),
            Ext.create('Workflow.view.Menu'),
            Ext.create('Workflow.view.TabPanel'),
            Ext.create('Workflow.view.South')
    	];
    	
        this.callParent(arguments);
    }
});