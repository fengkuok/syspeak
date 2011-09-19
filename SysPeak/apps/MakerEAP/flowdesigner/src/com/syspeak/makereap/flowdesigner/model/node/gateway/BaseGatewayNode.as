package com.syspeak.makereap.flowdesigner.model.node.gateway
{
	import com.syspeak.makereap.flowdesigner.model.node.Node;
	
	public class BaseGatewayNode extends Node {
		
		override protected function initDatas():void {
			super.initDatas();
			this.category = CAT_GATEWAY;
		}	
	}
}