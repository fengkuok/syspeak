package com.syspeak.makereap.flowdesigner.model.node.event
{
	import com.syspeak.makereap.flowdesigner.component.event.EndEventComponent;
	import com.syspeak.makereap.flowdesigner.model.node.BaseNodeLink;
	import com.syspeak.makereap.flowdesigner.model.node.Node;

	/**
	 * End Event Node
	 * @company SysPeak (C) Copyright
	 * @author JemiZhuu(周士淳)
	 * @category EndEventNode
	 * @version 1.0
	 * @since 2011-09-01
	 *
	 */
	public class EndEventNode extends BaseEventNode {
		
		override protected function initDatas():void {
			super.initDatas(); 
			this.component = new EndEventComponent();
		}
	}
}