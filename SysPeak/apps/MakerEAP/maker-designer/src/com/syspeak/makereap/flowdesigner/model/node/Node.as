package com.syspeak.makereap.flowdesigner.model.node
{
	import avmplus.getQualifiedClassName;
	import avmplus.getQualifiedSuperclassName;
	
	import com.syspeak.makereap.flowdesigner.component.BaseNodeComponent;
	import com.syspeak.makereap.flowdesigner.component.FlowCanvas;
	import com.syspeak.makereap.flowdesigner.component.connection.SequenceFlowComponent;
	import com.syspeak.makereap.flowdesigner.model.node.alfresco.BaseAlfrescoNode;
	import com.syspeak.makereap.flowdesigner.model.node.boundaryevent.BaseBoundaryEventNode;
	import com.syspeak.makereap.flowdesigner.model.node.connection.SequenceFlowNode;
	import com.syspeak.makereap.flowdesigner.model.node.event.BaseEventNode;
	import com.syspeak.makereap.flowdesigner.model.node.gateway.BaseGatewayNode;
	import com.syspeak.makereap.flowdesigner.model.node.task.BaseTaskNode;
	
	import flash.display.Sprite;
	
	/**
	 * 流程Node基类
	 * @company SysPeak (C) Copyright
	 * @author JemiZhuu(周士淳)
	 * @category Node
	 * @version 1.0
	 * @since 2011-08-31
	 *
	 */
	public class Node extends Sprite implements INode
	{
		protected static const CAT_SELECT:String = "select";
		protected static const CAT_CONNECTION:String = "connection";
		protected static const CAT_EVENT:String = "event";
		protected static const CAT_BOUNDARY_EVENT:String = "boundaryEvent";
		protected static const CAT_GATEWAY:String = "gateway";
		protected static const CAT_TASK:String = "task";
		protected static const CAT_ALFRESCO:String = "alfresco";
		
		[Embed(source="assets/icons/cursor/cursor.connection.png")]
		protected static const CURSOR_CONNECTION:Class;
		[Embed(source="assets/icons/cursor/cursor.connection.unallow.png")]
		protected static const CURSOR_CONNECTION_NO:Class;		
		[Embed(source="assets/icons/cursor/cursor.event.png")]
		protected static const CURSOR_EVENT:Class;
		[Embed(source="assets/icons/cursor/cursor.event.unallow.png")]
		protected static const CURSOR_EVENT_NO:Class;		
		[Embed(source="assets/icons/cursor/cursor.boundaryevent.png")]
		protected static const CURSOR_BOUNDARY_EVENT:Class;		
		[Embed(source="assets/icons/cursor/cursor.boundaryevent.unallow.png")]
		protected static const CURSOR_BOUNDARY_EVENT_NO:Class;
		[Embed(source="assets/icons/cursor/cursor.gateway.png")]
		protected static const CURSOR_GATEWAY:Class;
		[Embed(source="assets/icons/cursor/cursor.gateway.unallow.png")]
		protected static const CURSOR_GATEWAY_NO:Class;
		[Embed(source="assets/icons/cursor/cursor.task.png")]
		protected static const CURSOR_TASK:Class;
		[Embed(source="assets/icons/cursor/cursor.task.unallow.png")]
		protected static const CURSOR_TASK_NO:Class;
		[Embed(source="assets/icons/cursor/cursor.alfresco.png")]
		protected static const CURSOR_ALFRESCO:Class;
		[Embed(source="assets/icons/cursor/cursor.alfresco.unallow.png")]
		protected static const CURSOR_ALFRESCO_NO:Class;
		
		public function Node() {
			super();
			initNode();
		}		  
		
		protected function initNode():void {
			initDatas();
			initProperties();
		}
		
		
		protected function initDatas():void {			
		}
		
		protected function initProperties():void {
			if(component!=null) {
				component.node = this;
			}
		}
				
		public function getComponent():BaseNodeComponent {
			return component;
		}
		
		public function getCursor():Class {
			return cursorIcon;
		}
		
		public function getWidth():int {
			return -1;
		}
		public function getHeight():int {
			return -1;
		}
		public function getLeft():int{
			return 0;
		}
		public function getTop():int {
			return 0;
		}
		
		public static function getCursor(type:Class):Class {
			var superType:String = getQualifiedSuperclassName(type);
			switch(superType) {
				case getQualifiedClassName(BaseAlfrescoNode): {
					return CURSOR_ALFRESCO;
				}
					break;
				case getQualifiedClassName(BaseBoundaryEventNode): {
					return CURSOR_BOUNDARY_EVENT; 
				}
					break;
				case getQualifiedClassName(BaseEventNode): {
					return CURSOR_EVENT; 
				}
					break;
				case getQualifiedClassName(BaseGatewayNode): {
					return CURSOR_GATEWAY; 
				}
					break;
				case getQualifiedClassName(BaseTaskNode): {
					return CURSOR_TASK;	
				}
					break;				
			}
			if(type==SequenceFlowNode) {
				return CURSOR_CONNECTION;
			} else {
				return null;
			}
		}
		
		public static function getUnAllowCursor(type:Class):Class {
			var superType:String = getQualifiedSuperclassName(type);
			switch(superType) {
				case getQualifiedClassName(BaseAlfrescoNode): {
					return CURSOR_ALFRESCO_NO;
				}
					break;
				case getQualifiedClassName(BaseBoundaryEventNode): {
					return CURSOR_BOUNDARY_EVENT_NO; 
				}
					break;
				case getQualifiedClassName(BaseEventNode): {
					return CURSOR_EVENT_NO; 
				}
					break;
				case getQualifiedClassName(BaseGatewayNode): {
					return CURSOR_GATEWAY_NO; 
				}
					break;
				case getQualifiedClassName(BaseTaskNode): {
					return CURSOR_TASK_NO;	
				}
					break;				
			}
			if(type==SequenceFlowNode) {
				return CURSOR_CONNECTION_NO;
			} else {
				return null;
			}
		}
		
		public function updateFromFlow(flow:SequenceFlowComponent):void {
		}
		
		public function updateToFlow(flow:SequenceFlowComponent):void {
		}
		
		public function removeFromFlow(flow:SequenceFlowComponent):void {
		}
		
		public function removeToFlow(flow:SequenceFlowComponent):void {
		}
		
		/**
		 * 判断是否可以添加Node 
		 * @param flowCanvas
		 * @return 
		 * 
		 */
		public function canAdd(flowCanvas:FlowCanvas):Boolean {
			return true;
		}
		
		/**
		 * 销毁对象 
		 * 
		 */
		public function destroy():void {
			component.destroy();
			component=null;
			delete this;
		}
		
		public function get nodeName():String {
			return component.name;
		}
		
		protected var component:BaseNodeComponent;
		protected var category:String;
		protected var cursorIcon:Class;
	}
}