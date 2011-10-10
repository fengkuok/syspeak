Ext.define('Workflow.store.explorer.Deployments', {
    extend: 'SysPeak.store.Store',
    
    model: 'Workflow.model.activiti.Deployment',
    //autoLoad: true,
	readUrl: 'explorer/deployment/list'
    //updateUrl: 'resources/data/updateUsers.js'
});