package com.syspeak.makereap.flowdesigner.component
{
	import com.syspeak.makereap.flowdesigner.event.NodeDestroyEvent;
	import com.syspeak.makereap.flowdesigner.model.node.INode;
	
	import flash.events.Event;
	import flash.events.KeyboardEvent;
	import flash.events.MouseEvent;
	import flash.filters.GlowFilter;
	import flash.ui.Keyboard;
	
	import mx.core.IVisualElementContainer;
	import mx.core.UIComponent;
	
	/**
	 * 流程Node Component基类
	 * @company SysPeak (C) Copyright
	 * @author JemiZhuu(周士淳)
	 * @category BaseNodeComponent
	 * @version 1.0
	 * @since 2011-09-04
	 *
	 */
	[Event(name=NODE_MOVE, type="flash.events.Event")]
	[Event(name=DESTROY, type="flash.events.Event")]
	public class BaseNodeComponent extends UIComponent implements IBaseNodeComponent {
		
		private static const COMPONENT:String = "Component";
		public static const NODE_MOVE:String = "nodeMove";
		public static const DESTROY:String = NodeDestroyEvent.DESTROY;
		/**from joint type*/
		protected static const FROM:int = 1;
		/**to joint type*/
		protected static const TO:int = 2;		
		private static const selectFilters:Array = [new GlowFilter(0x0781C6)];
		
		public function BaseNodeComponent() {			
			super();			
			this.buttonMode = true;
			preInit();
		}
				
		protected function preInit():void {
			initDatas();
		}
		
		protected function initUI():void {
		}
		
		protected function initDatas():void {
			this._nodeName = this.name.replace(COMPONENT, "");
		}
		
		override protected function initializationComplete():void {
			super.initializationComplete();
			initUI();			
			initListeners();
		}
		
		protected function initListeners():void {
			this.addEventListener(MouseEvent.MOUSE_DOWN,handleMouseDown, false, 0, true);
			this.addEventListener(MouseEvent.CLICK, handleMouseClick, false, 0, true);
		}
				
		protected function handleMouseClick(event:MouseEvent):void {
			notifySelected();
			stage.addEventListener(MouseEvent.CLICK, handleStageMouseClick, false, 0, true);
		}
		
		protected function handleStageMouseClick(event:MouseEvent):void {
			var obj:Object = event.target;
			if(obj==this) {
				return;
			}
			notifyUnselect();
			stage.removeEventListener(MouseEvent.CLICK, handleStageMouseClick);
		}
		
		private function removeAllListeners():void {
			this.removeEventListener(MouseEvent.MOUSE_DOWN,handleMouseDown);
			this.removeEventListener(MouseEvent.CLICK, handleMouseClick);
			this.removeEventListener(KeyboardEvent.KEY_DOWN, handleKeyDown);
			stage.removeEventListener(MouseEvent.CLICK, handleStageMouseClick);
			stage.removeEventListener(MouseEvent.MOUSE_UP, handleMouseUp);
			stage.removeEventListener(MouseEvent.MOUSE_MOVE, handleMouseMove);			
		}
		
		/**
		 * 被选中 
		 * 
		 */
		protected function notifySelected():void {
			this.filters = selectFilters;
			this.setFocus();
			this.addEventListener(KeyboardEvent.KEY_DOWN, handleKeyDown, false, 0, true);
		}
		
		private function handleKeyDown(event:KeyboardEvent):void {
			var code:uint = event.keyCode;
			switch(code) {
				case Keyboard.DELETE: {					
					this.sendDeleteEvent();
				}
					break;
			}
		}
		
		public function sendDeleteEvent():void {
			var evt:NodeDestroyEvent = new NodeDestroyEvent(_node);
			this.dispatchEvent(evt);
		}
		
		/**
		 * 取消选中
		 * 
		 */
		protected function notifyUnselect():void {
			this.filters = null;
			this.removeEventListener(KeyboardEvent.KEY_DOWN, handleKeyDown);
		}
		
		protected function handleMouseDown(event:MouseEvent):void {			
			stage.addEventListener(MouseEvent.MOUSE_UP, handleMouseUp, false, 0, true);
			stage.addEventListener(MouseEvent.MOUSE_MOVE, handleMouseMove, false, 0, true);
			this.startDrag();
		}
		
		protected function handleMouseMove(event:MouseEvent):void {
			this.dispatchEvent(new Event(NODE_MOVE));
		}				
		
		protected function handleMouseUp(event:MouseEvent):void {			
			this.stopDrag();
			stage.removeEventListener(MouseEvent.MOUSE_UP, handleMouseUp);
			stage.removeEventListener(MouseEvent.MOUSE_MOVE, handleMouseMove);
		}		
		
		/**
		 * 销毁对象 
		 * 
		 */
		public function destroy():void {
			removeAllListeners();
			remove();
		}
		
		private function remove():void {
			if(parent is IVisualElementContainer) {
				var parentElement:IVisualElementContainer = this.parent as IVisualElementContainer;
				parentElement.removeElement(this);
			} else {
				parent.removeChild(this);
			}
			_node = null;
			delete this;
		}
		
		public function moveTo(px:Number, py:Number):void {
			this.move(px, py);
		}
		
		protected var _node:INode;
		
		public function get node():INode {
			return this._node;
		}
		
		public function set node(node:INode):void {
			this._node = node;
		}
		
		public function get nodeName():String {
			return this._nodeName;
		}
		
		private var _nodeName:String;
	}
}