Ext.define('Workflow.model.probe.Job', {
    extend: 'Ext.data.Model',
    fields: ['exceptionMessage','id', 'executionId','retries','processInstanceId','dueDate','action']
});