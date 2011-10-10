/**
 * Activiti ProcessDefinition Model
 */
Ext.define('Workflow.model.activiti.ProcessDefinition', {
    extend: 'Ext.data.Model',
    fields: ['id','name', 'deploymentId', 'category', 'key', 'version', 'resourceName', 'diagramResourceName', 'hasStartFormKey']
});