package com.syspeak.makereap.flowdesigner.event
{
	import flash.events.Event;
	
	import com.syspeak.makereap.flowdesigner.component.BaseNodeComponent;
	import com.syspeak.makereap.flowdesigner.model.node.INode;
	
	/**
	 * 流程节点销毁事件
	 * @company SysPeak (C) Copyright
	 * @author JemiZhuu(周士淳)
	 * @category NodeDestroyEvent
	 * @version 1.0
	 * @since 2011-09-01
	 *
	 */	
	public class NodeDestroyEvent extends Event {
		public static const DESTROY:String = "destroy"; 
		
		public function NodeDestroyEvent(node:INode, type:String=DESTROY, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			this._node = node;
		}
		
		private var _node:INode;
		
		public function get node():INode {
			return _node;
		}
	}
}