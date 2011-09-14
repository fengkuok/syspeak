Ext.define('Workflow.view.South',{
    extend: 'Ext.Toolbar',
    region: 'south',
    height: 23,
    
    initComponent : function(){
        Ext.apply(this,{
            id: 'bottom',
//            items:["当前用户：Feng Kuok",{
//            	width: 800,
//            	html:'<center>Copyright © 2011 SysPeak MakerEAP</center>'
//            }]
            html:'<center>Copyright © 2011 SysPeak MakerEAP</center>'
        });
        
        this.callParent(arguments);
    }
});