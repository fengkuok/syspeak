package com.syspeak.makereap.flowdesigner.model.node.connection
{
	import com.syspeak.makereap.flowdesigner.component.connection.SequenceFlowComponent;
	import com.syspeak.makereap.flowdesigner.model.node.INode;
	import com.syspeak.makereap.flowdesigner.model.node.Node;

	/**
	 * Sequence Flow Node
	 * @company SysPeak (C) Copyright
	 * @author JemiZhuu(周士淳)
	 * @category SequenceFlowNode
	 * @version 1.0
	 * @since 2011-09-01
	 *
	 */
	public class SequenceFlowNode extends Node {
		
		public function SequenceFlowNode(fromNode:Node, toNode:Node) {
			super();
			this.fromNode = fromNode;
			this.toNode = toNode;
		}
		
		override protected function initDatas():void {
			super.initDatas();
			this.category = CAT_CONNECTION;
			this.component = new SequenceFlowComponent();
			component.node = this;
			this.flow = component as SequenceFlowComponent;
		}
		
		private var _fromNode:INode;
		private var _toNode:INode;
		
		public function set fromNode(node:INode):void {
			if(_fromNode===node) {
				return;
			}
			notifyFromNodeChanged(node);
		}
		
		public function get fromNode():INode {
			return this._fromNode;			
		}
		
		public function set toNode(node:INode):void {
			if(_toNode===node) {
				return;
			}
			notifyToNodeChanged(node);
		}
		
		public function get toNode():INode {
			return this._toNode;
		}
		
		/**
		 * 通知From节点被修改 
		 * 
		 */
		private function notifyFromNodeChanged(newNode:INode):void {
			if(_fromNode===newNode) {
				return;
			}
			if(_fromNode!=null) {
				_fromNode.removeFromFlow(flow);
			}
			this._fromNode = newNode;
			_fromNode.updateFromFlow(flow);
		}
		
		/**
		 * 通知To节点被修改 
		 * 
		 */
		private function notifyToNodeChanged(newNode:INode):void {
			if(_toNode===newNode) {
				return;
			}
			if(_toNode!=null) {
				_toNode.removeFromFlow(flow);
			}
			this._toNode = newNode;
			_toNode.updateFromFlow(flow);
		}
		
		private var flow:SequenceFlowComponent;
	}
}