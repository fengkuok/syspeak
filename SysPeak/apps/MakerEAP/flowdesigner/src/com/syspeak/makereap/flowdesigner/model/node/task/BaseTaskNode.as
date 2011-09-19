package com.syspeak.makereap.flowdesigner.model.node.task
{
	import com.syspeak.makereap.flowdesigner.model.node.Node;
	
	public class BaseTaskNode extends Node {
		
		override protected function initDatas():void {
			super.initDatas();
			this.category = CAT_TASK;
		}	
	}
}