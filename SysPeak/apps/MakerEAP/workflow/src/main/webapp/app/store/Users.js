Ext.define('Workflow.store.Users', {
    extend: 'Workflow.store.cls.Store',
    
    model: 'Workflow.model.User',
    //autoLoad: true,
	readUrl: 'probe/processengine',//'resources/data/users.js',
    updateUrl: 'resources/data/updateUsers.js'
//    proxy: {
//        type: 'ajax',
//	    api: {
//	        read: 'data/users.json',
//	        update: 'data/updateUsers.json'
//	    },
//	    reader: {
//	        type: 'json',
//	        root: 'users',
//	        //totalProperty  : 'total',
//	        successProperty: 'success'
//	    }
//    }
});