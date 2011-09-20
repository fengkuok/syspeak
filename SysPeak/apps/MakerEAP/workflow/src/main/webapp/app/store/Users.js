Ext.define('Workflow.store.Users', {
	extend : 'Ext.data.Store',
	fields : [ 'name', 'email' ],
	// data: [
	// {name: 'Ed', email: 'ed@sencha.com'},
	// {name: 'Tommy', email: 'tommy@sencha.com'}
	// ],

	pageSize : 3,
	proxy : {
		type : 'ajax',
		url : 'user/list',
		reader : {
			type : 'json',
			root : 'users',
			totalProperty : 'total'
		}

	},

	autoLoad : true
});