/**
 * 
 */
Ext.define('SysPeak.plugin.PageSizePlugin',{
    extend: 'Ext.form.field.ComboBox',
    
    store: Ext.create('Ext.data.ArrayStore', {
	    fields: ['text', 'value'],
	    data : [['1', 1], ['10', 10], ['20', 20], ['30', 30], ['50', 50], ['100', 100]] 
	}),
	
	queryMode: 'local',           
    displayField: 'text',           
    valueField: 'value',           
    allowBlank: false,           
    triggerAction: 'all',           
    width: 50,           
    maskRe: /[0-9]/  ,      
    beforeText:'显示',       
    afterText:'条/页',
    
    init: function(paging) {           
         paging.on('render', this.onInitView, this);
         this.initDefaultValue(paging);
    }, 
    
    onInitView : function(paging){
    	paging.insert(paging.items.length-2, ['-',this.beforeText, this, this.afterText]);
    },
    
    initDefaultValue : function(paging){
	    var pageSize = Ext.state.Manager.get('ext_PageSizePlugin_pageSize');
	    
	    pageSize = typeof pageSize == 'undefined' ? paging.pageSize : pageSize;
	    //设置默认combo值
       	this.setValue(parseInt(pageSize)); 
	    
     	this.on('select', this.onPageSizeChanged, paging); 
     	this.on('specialkey', function(combo, e) {
            if(13 === e.getKey()) {
                this.onPageSizeChanged.call(paging, this);                       
            }           
        });
    },
    
    onPageSizeChanged: function(combo) {
        this.pageSize = parseInt(combo.getRawValue(), 10);   
		//持久化
		Ext.state.Manager.set('ext_PageSizePlugin_pageSize',this.pageSize);
        //设置store pageSize
        this.store.pageSize = this.pageSize
        this.doRefresh();
     }
});