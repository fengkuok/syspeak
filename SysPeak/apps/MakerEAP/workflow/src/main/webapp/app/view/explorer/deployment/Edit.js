/**
 * Deployment Edit
 */
Ext.define('Workflow.view.explorer.deployment.Edit', {
    extend: 'Ext.window.Window',
    //alias : 'widget.wf.explorer.deploymentEdit',

    title : 'Input Deployment',
    layout: 'fit',
    autoShow: true,

    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                items: [
                    {
                        xtype: 'textfield',
                        name : 'name',
                        fieldLabel: 'Name'
                    },
                    {
                        xtype: 'filefield',
                        name : 'deploymentResource',
                        fieldLabel: 'Resource'
                    }
                ]
            }
        ];

        this.buttons = [
            {
                text: 'Deploy',
                action: 'save'
            },
            {
                text: 'Cancel',
                scope: this,
                handler: this.close
            }
        ];

        this.callParent(arguments);
    }
});