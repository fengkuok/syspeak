Ext.define('Workflow.store.Menus', {
    extend: 'Ext.data.TreeStore',
    root: { 
        expanded: true 
    }, 
    proxy: { 
        type: 'ajax', 
        url: 'data/tree.json' 
    } 
});