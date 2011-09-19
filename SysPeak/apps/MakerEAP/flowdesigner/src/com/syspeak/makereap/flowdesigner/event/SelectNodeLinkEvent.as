package com.syspeak.makereap.flowdesigner.event
{
	import flash.events.Event;
	
	import com.syspeak.makereap.flowdesigner.model.node.BaseNodeLink;
	
	/**
	 * 流程Node Link选中事件
	 * @company SysPeak (C) Copyright
	 * @author JemiZhuu(周士淳)
	 * @category BaseNodeComponent
	 * @version 1.0
	 * @since 2011-09-04
	 *
	 */
	public class SelectNodeLinkEvent extends Event
	{
		public static const SELECT_LINK:String = "selectNodeLink";
				
		public function SelectNodeLinkEvent(_nodeLink:BaseNodeLink, type:String=SELECT_LINK, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			this._nodeLink = _nodeLink;
		}
				
		private var _nodeLink:BaseNodeLink;

		public function get nodeLink():BaseNodeLink {
			return _nodeLink;
		}		 
	}
}