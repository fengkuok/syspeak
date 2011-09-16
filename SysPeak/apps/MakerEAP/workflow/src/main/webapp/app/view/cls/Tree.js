Ext.define('Workflow.view.cls.Tree',{
    extend: 'Ext.tree.Panel',
    //alias: 'widget.cls.Tree',
    //requires:['Workflow.store.Menus'],
    rootVisible: false,
    margins : '0 0 -1 1',
    border : true,
    split: true,
	collapsible : true,
    defaults :{
    	expanded : true
    },
    initComponent : function(){
        Ext.apply(this,{
           useArrows: true,
           children :[]
        });
        this.callParent(arguments);
    }
})