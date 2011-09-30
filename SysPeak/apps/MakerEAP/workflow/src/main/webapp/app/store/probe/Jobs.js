Ext.define('Workflow.store.probe.Jobs', {
    extend: 'SysPeak.store.Store',
    
    model: 'Workflow.model.probe.Job',
    //autoLoad: true,
	readUrl: 'probe/job'
    //updateUrl: 'resources/data/updateUsers.js'
});