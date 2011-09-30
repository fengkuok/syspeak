//Ext.ux.Toast = function(){
//    var b;
//    function a(c, d){
//        return ['<div class="msg">', '<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>', '<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc"><h3>', c, "</h3>", d, "</div></div></div>", '<div class="x-box-bl"><div class="x-box-br"><div class="x-box-bc"></div></div></div>', "</div>"].join("");
//    }
//    return {
//        msg: function(f, e){
//            if (!b) {
//                b = Ext.DomHelper.insertFirst(document.body, {
//                    id: "msg-div",
//                    style: "position:absolute;z-index:10000;width:400px;"
//                }, true);
//            }
//            var d = String.format.apply(String, Array.prototype.slice.call(arguments, 1));
//            var c = Ext.DomHelper.append(b, {
//                html: a(f, d)
//            }, true);
//            b.alignTo(document, "t-t");
//            c.slideIn("t").pause(2.5).ghost("t", {
//                remove: true
//            });
//        }
//    };
//}();

Ext.define('SysPeak.msg.Toast',{
	constructor : function(config) {
//		alert('xxxx');
//		b;
		Ext.applyIf(this,{
			b : null
		})
	},
	a :function(c, d){
        return ['<div class="msg">', '<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>', '<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc"><h3>', c, "</h3>", d, "</div></div></div>", '<div class="x-box-bl"><div class="x-box-br"><div class="x-box-bc"></div></div></div>', "</div>"].join("");
    },
	show : function(f, e){
        if (!this.b) {
            this.b = Ext.core.DomHelper.insertFirst(document.body, {
                id: "msg-div",
                style: "position:absolute;z-index:10000;width:400px;padding-top : 200px;"
            }, true);
        }
        var d = Ext.String.format.apply(String, Array.prototype.slice.call(arguments, 1));
        var c = Ext.core.DomHelper.append(this.b, {
            html: this.a(f, d)
        }, true);
        this.b.alignTo(document, "t-t");
        c.fadeIn({
		    endOpacity: 0.5, //can be any value between 0 and 1 (e.g. .5)
		    easing: 'easeOut',
		    duration: 500
		}).pause(5).fadeOut({
            endOpacity: 0, //can be any value between 0 and 1 (e.g. .5)
		    easing: 'easeOut',
		    duration: 500,
		    remove: true,
		    useDisplay: false
        });
    }
}, function() {
    SysPeak.Msg = SysPeak.Toast = new this();
});

