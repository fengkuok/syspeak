package com.syspeak.makereap.flowdesigner.model.node
{
	import com.syspeak.makereap.flowdesigner.component.BaseNodeComponent;
	import com.syspeak.makereap.flowdesigner.component.FlowCanvas;
	import com.syspeak.makereap.flowdesigner.component.connection.SequenceFlowComponent;
	
	public interface INode
	{
		function getComponent():BaseNodeComponent;
		function updateFromFlow(flow:SequenceFlowComponent):void;
		function updateToFlow(flow:SequenceFlowComponent):void;
		function removeFromFlow(flow:SequenceFlowComponent):void;
		function removeToFlow(flow:SequenceFlowComponent):void;
		function destroy():void;
		function get nodeName():String;
		function canAdd(flowCanvas:FlowCanvas):Boolean;
		function getWidth():int;
		function getHeight():int;
		function getLeft():int;
		function getTop():int;
	}
}