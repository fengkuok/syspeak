/**
 * Copy Right SysPeak @ 2011
 * @author Feng Kuok
 */
Ext.Loader.setConfig({
    enabled: true,
    paths: {
    	'cxt' : '.',		//content path
    	'SysPeak' : './resources/scripts/ux/syspeak',
        'Workflow': './app'
        
    }
});

//初始导入
Ext.require([
	'Ext.tip.*',
	'Ext.JSON.*',
	'Ext.Object.*',
	'Ext.view.View',//LocalStorageProvider need
	'Ext.grid.Panel',//LocalStorageProvider need
	'Ext.form.field.Base',//LocalStorageProvider need
	'Ext.picker.Date',
	'Workflow.Application'
]);

Ext.onReady(function() {
	//指定1x1像素空白图片
	Ext.BLANK_IMAGE_URL = Ext.Loader.getPath('cxt') + '/static/extjs4/resources/themes/images/default/s.gif';
	//Ext.QuickTips.init();
	
	/**
	 *  设置默认Provider
	 *  正常是在Application中定义的，但影响默认换肤效果，所以提前设置；
	 *  引入的问题是需要在之前require以下3个类
	 * 'Ext.view.View','Ext.grid.Panel','Ext.form.field.Base'
	 * 
	 */
	if (window.localStorage) {
        Ext.state.Manager.setProvider(Ext.create('Ext.state.LocalStorageProvider'));
    } else {
        Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider'));
    }
	
	var theme = Ext.state.Manager.get('theme');
	theme = typeof theme == 'undefined' ? '' : theme;
	//换肤
	Ext.util.CSS.swapStyleSheet("theme", Ext.Loader.getPath('cxt') + '/static/extjs4/resources/css/ext-all' + theme + '.css');
    
	
	Ext.get('loading-msg').update('模块初始化...');
	
    Ext.create('Workflow.Application');
    
	delete theme;
});

