Ext.define('Workflow.view.cls.TabPanel',{
    extend: 'Ext.tab.Panel',
    id: 'content-panel',
    region: 'center',
    defaults: {
    	closable: true,
       	autoScroll:true,
       	bodyPadding: 0
    },
    activeTab: 0,
    border: false,
    minTabWidth : 100,
    autoScroll : true,
    
    initComponent : function(){
    	this.items = [{
    		id : 'HomePage',
    		title: '首页',
            iconCls:'icon-home',
            layout: 'fit',
            closable : false,
            items :[
            	Ext.create('Ext.Img',{
            		src : Ext.Loader.getPath('cxt')+'/resources/images/background.gif'
            		//height :
            	})
            ]
            //html : '<br><br><center><img src="'+path+'/content/images/Extreme.gif" /></center>'
    	}];
    	
    	this.plugins = [
    		Ext.create('Ext.ux.TabCloseMenu',{
    			closeTabText : '关闭此窗口',
				closeOthersTabsText : '关闭其他窗口',
				closeAllTabsText : '关闭所有窗口'
    		})
    	]
    	
        this.callParent(arguments);
    }
});