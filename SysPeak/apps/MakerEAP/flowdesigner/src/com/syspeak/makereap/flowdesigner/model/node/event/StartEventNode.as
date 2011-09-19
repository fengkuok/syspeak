package com.syspeak.makereap.flowdesigner.model.node.event
{
	import com.syspeak.makereap.flowdesigner.component.FlowCanvas;
	import com.syspeak.makereap.flowdesigner.component.event.StartEventComponent;
	import com.syspeak.makereap.flowdesigner.model.node.BaseNodeLink;
	import com.syspeak.makereap.flowdesigner.model.node.Node;

	/**
	 * Start Event Node
	 * @company SysPeak (C) Copyright
	 * @author JemiZhuu(周士淳)
	 * @category StartEventNode
	 * @version 1.0
	 * @since 2011-09-01
	 *
	 */
	public class StartEventNode extends BaseEventNode	{
		
		override protected function initDatas():void {
			super.initDatas(); 
			this.component = new StartEventComponent();			
		}
		
		override public function canAdd(flowCanvas:FlowCanvas):Boolean {
			return flowCanvas.startNodes.length<1;
		}
	}
}