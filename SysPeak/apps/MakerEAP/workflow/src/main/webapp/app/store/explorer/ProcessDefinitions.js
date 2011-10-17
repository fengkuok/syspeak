Ext.define('Workflow.store.explorer.ProcessDefinitions', {
    extend: 'SysPeak.store.Store',
    
    model: 'Workflow.model.activiti.ProcessDefinition',
    autoLoad: true,
	//readUrl: 'explorer/deployment/list'
   	restUrl : 'explorer/processdefinition'
    //updateUrl: 'resources/data/updateUsers.js'
});