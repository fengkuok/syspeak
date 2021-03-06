Ext.define('Workflow.controller.explorer.ProcessDefinitions', {
    extend: 'Ext.app.Controller',

    views: [
        'explorer.processdefinition.List'
    ],
    stores: [
        'explorer.ProcessDefinitions'
    ],
    models: [
    	'activiti.ProcessDefinition'
    ],

    init: function() {
//    	this.control({
//            'userlist': {
//                itemdblclick: this.editUser
//            },
//            'useredit button[action=save]': {
//                click: this.updateUser
//            }
//        });
    },

	editUser: function(grid, record) {
        var view = Ext.widget('useredit');

        view.down('form').loadRecord(record);
    },
    updateUser: function(button) {
       	var win    = button.up('window'),
        form   = win.down('form'),
        record = form.getRecord(),
        values = form.getValues();

    	record.set(values);
    	win.close();
    	this.getUsersStore().sync();
    }
});