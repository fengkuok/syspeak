package com.syspeak.makereap.flowdesigner.model.node.boundaryevent
{
	import com.syspeak.makereap.flowdesigner.model.node.Node;
	
	public class BaseBoundaryEventNode extends Node {
		
		override protected function initDatas():void {
			super.initDatas();
			this.category = CAT_BOUNDARY_EVENT;
		}	
	}
}