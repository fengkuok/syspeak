Ext.define('AM.controller.Users', {
    extend: 'Ext.app.Controller',

    views: [
        'user.List',
		'user.Edit'
    ],
    stores: [
        'Users'
    ],

    init: function() {
        this.control({
            'userlist': {
                itemdblclick: this.editUser
            }
        });
    },

	editUser: function(grid, record) {
        var view = Ext.widget('useredit');

        view.down('form').loadRecord(record);
    }
});