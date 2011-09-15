Ext.define('Workflow.view.Tree',{
    extend: 'Ext.tree.Panel',
    alias: 'widget.smsmenu',
    requires:['Workflow.store.Menus'],
    initComponent : function(){
        Ext.apply(this,{
            border : false,
            enableDD : false,
            split: true,
            width : 212,
            minSize : 130,
            maxSize : 300,
            rootVisible: false,
            containerScroll : true,
            collapsible : true,
            autoScroll: false,
            store:Ext.create('Workflow.store.Menus')
        });
        this.callParent(arguments);
    }
})