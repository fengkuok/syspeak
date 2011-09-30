Ext.define('Workflow.view.cls.Header', {
    extend: 'Ext.Component',
    initComponent: function() {
        Ext.applyIf(this, {
            xtype: 'box',
            cls: 'header',
            region: 'north',
            html: '<h1>Maker-Workflow(Horse) Business Process Management System</h1>',
            height: 54
        });
        this.callParent(arguments);
    }
});