/**
 * Copy Right SysPeak @ 2011
 * @author Feng Kuok
 */
Ext.Loader.setConfig({
    enabled: true,
    paths: {
    	'cxt' : '.',		//content path
        'Workflow': './app' 
    }
});

//初始导入
Ext.require([
	'Ext.tip.*',
	'Ext.JSON.*',
	'Ext.Object.*',
	'Ext.picker.Date',
	'Workflow.Application'
]);

Ext.onReady(function() {
	//指定1x1像素空白图片
	Ext.BLANK_IMAGE_URL = Ext.Loader.getPath('cxt') + '/static/extjs4/resources/themes/images/default/s.gif';
	//Ext.QuickTips.init();
	
	if(window.localStorage){
 		var theme = localStorage.themeLocalStore;
 		if(theme == null || theme == "null" || theme == 'undefined'){
 			theme = "";
 		}
 		Ext.util.CSS.swapStyleSheet("theme", Ext.Loader.getPath('cxt') + '/static/extjs4/resources/css/ext-all' + theme + '.css');
	}else{
	 	alert('This browser does NOT support localStorage');
	}
	
	Ext.get('loading-msg').update('模块初始化...');
    Ext.create('Workflow.Application');
});

