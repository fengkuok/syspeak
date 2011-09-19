package com.syspeak.makereap.flowdesigner.model.node.event
{
	import com.syspeak.makereap.flowdesigner.model.node.Node;
	
	public class BaseEventNode extends Node {
		
		public static const CURSOR:Class = CURSOR_EVENT;
		
		override protected function initDatas():void {
			super.initDatas();
			this.category = CAT_EVENT; 
		}
	}
}