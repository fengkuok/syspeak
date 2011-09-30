Ext.define('Workflow.view.Viewport',{
    extend: 'Ext.Viewport',
    requires : [
        'Workflow.view.cls.Header',
        'Workflow.view.cls.Menu',
        'Workflow.view.cls.TabPanel',
        'Workflow.view.cls.South'
    ],
    
    id: 'viewport',
    layout: 'border',
    hideBorders: true,
    defaults: { xtype: 'container' },
    
    initComponent : function(){
    	this.items = [
    		Ext.create('Workflow.view.cls.Header'),
            Ext.create('Workflow.view.cls.Menu'),
            Ext.create('Workflow.view.cls.TabPanel'),
            Ext.create('Workflow.view.cls.South')
    	];
    	
        this.callParent(arguments);
    }
});