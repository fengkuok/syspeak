Ext.define('Workflow.controller.probe.Jobs', {
    extend: 'Ext.app.Controller',

    views: [
        'probe.job.List'
    ],
    stores: [
        'probe.Jobs'
    ],
    models: [
    	'probe.Job'
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