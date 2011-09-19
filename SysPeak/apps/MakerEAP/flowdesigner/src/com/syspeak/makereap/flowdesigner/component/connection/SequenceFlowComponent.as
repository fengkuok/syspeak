package com.syspeak.makereap.flowdesigner.component.connection
{	
	import com.syspeak.makereap.flowdesigner.component.BaseNodeComponent;
	import com.syspeak.makereap.flowdesigner.model.node.INode;
	import com.syspeak.makereap.flowdesigner.model.node.connection.SequenceFlowNode;
	
	[IconFile("../../assets/icons/ui/node/type.sequence.png")]	
	[Alternative(replacement="spark.primitives.Line", since="4.0")]
	
	/**
	 * Sequence Flow Component
	 * @company SysPeak (C) Copyright
	 * @author JemiZhuu(周士淳)
	 * @category SequenceFlowComponent
	 * @version 1.0
	 * @since 2011-09-03
	 *
	 */	
	public class SequenceFlowComponent extends BaseNodeComponent {
		
		private static const DEFAULT_PREFERRED_WIDTH:Number = 1;		
						
		private var _fromNode:INode;
		private var _toNode:INode;
		private var _flowNode:SequenceFlowNode;
		
		public function get fromNode():INode {
			return this._flowNode.fromNode;
		}
		
		
		public function get toNode():INode {
			return this._flowNode.toNode;
		}
	}
}