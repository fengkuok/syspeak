package com.syspeak.makereap.flowdesigner.model.node
{
	import com.syspeak.makereap.flowdesigner.model.node.connection.SequenceFlowNode;

	public final class NodeUtils
	{
		public function NodeUtils() {
		}
		
		public static function allowAddNode(type:Class):Boolean {
			switch(type) {
				case SequenceFlowNode: {
					return false;
				}
					break;
				default: {
					
				}
			}
			return false;
		}
		
		
	}
}