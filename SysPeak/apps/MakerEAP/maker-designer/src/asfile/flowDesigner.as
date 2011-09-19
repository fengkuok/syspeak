import mx.controls.Alert;

import com.syspeak.makereap.flowdesigner.component.FlowCanvas;
import com.syspeak.makereap.flowdesigner.component.NodeListPanel;
import com.syspeak.makereap.flowdesigner.event.SelectNodeLinkEvent;
import com.syspeak.makereap.flowdesigner.model.node.BaseNodeLink;
import com.syspeak.makereap.flowdesigner.model.node.INode;

/**
 * 工作流节设计器应用程序
 * @company SysPeak (C) Copyright
 * @author JemiZhuu(周士淳)
 * @category RichWorkDesigner
 * @version 1.0
 * @since 2011-08-31
 *
 */

private var selectedNode:INode;

private function initListeners():void {
	nodeListPanel.addEventListener(SelectNodeLinkEvent.SELECT_LINK, handleNodeLinkSelected); 
}

private function handleNodeLinkSelected(event:SelectNodeLinkEvent):void {
	var linkObj:BaseNodeLink = event.nodeLink;	
	if(selectedNode===linkObj) {
		return;
	}
	selectedNode = linkObj.node;
	flowCanvas.selectedNodeType = linkObj.NodeType;
}
