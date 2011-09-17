/**
 * Copy Right SysPeak @ 2011
 * @author Feng Kuok
 */

Ext.Loader.setConfig({
    enabled: true,
    paths: {
        'Workflow': './app',
        'cxt' : './'
    }
});

Ext.require('Workflow.Application');
//发现用动态加载后竟然不能直接用Ext.Msg.XX方法，暂时解决办法如下：
Ext.require([
	'Ext.window.MessageBox',
	'Ext.tip.*',
	'Ext.JSON.*',
	'Ext.Object.*'
]);

Ext.onReady(function() {
	Ext.QuickTips.init();
	//Ext core没会使用，很惭愧；以后会把所有的document.XXX改为Ext core来实现。
	//Ext.core.DomHelper.useDom = true;
	document.getElementById('loading-msg').innerHTML = '模块初始化...';
    Ext.create('Workflow.Application');
});

