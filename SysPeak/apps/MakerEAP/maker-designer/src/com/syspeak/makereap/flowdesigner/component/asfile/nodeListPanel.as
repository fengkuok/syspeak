// ActionScript file
/**
 * NodeListPanel as file
 * @company SysPeak (C) Copyright
 * @author JemiZhuu(周士淳)
 * @category NodeListPanel
 * @version 1.0
 * @since ${date}
 *
 */
import flash.events.MouseEvent;

import mx.core.IVisualElementContainer;

import com.syspeak.makereap.flowdesigner.event.SelectNodeLinkEvent;
import com.syspeak.makereap.flowdesigner.ini18.Ini18ResourceLoader;
import com.syspeak.makereap.flowdesigner.model.node.BaseNodeLink;
import com.syspeak.makereap.flowdesigner.model.node.INode;
import com.syspeak.makereap.flowdesigner.model.node.MarqueeLink;
import com.syspeak.makereap.flowdesigner.model.node.MarqueeNode;
import com.syspeak.makereap.flowdesigner.model.node.SelectLink;
import com.syspeak.makereap.flowdesigner.model.node.SelectNode;
import com.syspeak.makereap.flowdesigner.model.node.alfresco.AlfrescoMailTaskLink;
import com.syspeak.makereap.flowdesigner.model.node.alfresco.AlfrescoMailTaskNode;
import com.syspeak.makereap.flowdesigner.model.node.alfresco.AlfrescoScriptTaskLink;
import com.syspeak.makereap.flowdesigner.model.node.alfresco.AlfrescoScriptTaskNode;
import com.syspeak.makereap.flowdesigner.model.node.alfresco.AlfrescoStartEventLink;
import com.syspeak.makereap.flowdesigner.model.node.alfresco.AlfrescoStartEventNode;
import com.syspeak.makereap.flowdesigner.model.node.alfresco.AlfrescoUserTaskLink;
import com.syspeak.makereap.flowdesigner.model.node.alfresco.AlfrescoUserTaskNode;
import com.syspeak.makereap.flowdesigner.model.node.boundaryevent.ErrorBoundaryEventLink;
import com.syspeak.makereap.flowdesigner.model.node.boundaryevent.ErrorBoundaryEventNode;
import com.syspeak.makereap.flowdesigner.model.node.boundaryevent.TimerBoundaryEventLink;
import com.syspeak.makereap.flowdesigner.model.node.boundaryevent.TimerBoundaryEventNode;
import com.syspeak.makereap.flowdesigner.model.node.connection.SequenceFlowLink;
import com.syspeak.makereap.flowdesigner.model.node.connection.SequenceFlowNode;
import com.syspeak.makereap.flowdesigner.model.node.event.EndEventLink;
import com.syspeak.makereap.flowdesigner.model.node.event.EndEventNode;
import com.syspeak.makereap.flowdesigner.model.node.event.ErrorEndEventLink;
import com.syspeak.makereap.flowdesigner.model.node.event.ErrorEndEventNode;
import com.syspeak.makereap.flowdesigner.model.node.event.StartEventLink;
import com.syspeak.makereap.flowdesigner.model.node.event.StartEventNode;
import com.syspeak.makereap.flowdesigner.model.node.event.TimerStartEventLink;
import com.syspeak.makereap.flowdesigner.model.node.event.TimerStartEventNode;
import com.syspeak.makereap.flowdesigner.model.node.gateway.ExclusiveGatewayLink;
import com.syspeak.makereap.flowdesigner.model.node.gateway.ExclusiveGatewayNode;
import com.syspeak.makereap.flowdesigner.model.node.gateway.ParallelGatewayLink;
import com.syspeak.makereap.flowdesigner.model.node.gateway.ParallelGatewayNode;
import com.syspeak.makereap.flowdesigner.model.node.task.BusinessRuleTaskLink;
import com.syspeak.makereap.flowdesigner.model.node.task.BusinessRuleTaskNode;
import com.syspeak.makereap.flowdesigner.model.node.task.CallActivityLink;
import com.syspeak.makereap.flowdesigner.model.node.task.CallActivityNode;
import com.syspeak.makereap.flowdesigner.model.node.task.MailTaskLink;
import com.syspeak.makereap.flowdesigner.model.node.task.MailTaskNode;
import com.syspeak.makereap.flowdesigner.model.node.task.ManualTaskLink;
import com.syspeak.makereap.flowdesigner.model.node.task.ManualTaskNode;
import com.syspeak.makereap.flowdesigner.model.node.task.ReceiveTaskLink;
import com.syspeak.makereap.flowdesigner.model.node.task.ReceiveTaskNode;
import com.syspeak.makereap.flowdesigner.model.node.task.ScriptTaskLink;
import com.syspeak.makereap.flowdesigner.model.node.task.ScriptTaskNode;
import com.syspeak.makereap.flowdesigner.model.node.task.ServiceTaskLink;
import com.syspeak.makereap.flowdesigner.model.node.task.ServiceTaskNode;
import com.syspeak.makereap.flowdesigner.model.node.task.SubProcessLink;
import com.syspeak.makereap.flowdesigner.model.node.task.SubProcessNode;
import com.syspeak.makereap.flowdesigner.model.node.task.UserTaskLink;
import com.syspeak.makereap.flowdesigner.model.node.task.UserTaskNode;

/**other tab*/
private var selectNodeLink:SelectLink;
private var marqueeNodeLink:MarqueeLink;
/**connection tab*/
private var sequenceFlowNodeLink:SequenceFlowLink;
/**Event tab*/
private var startEventNodeLink:StartEventLink;
private var timerStartEventNodeLink:TimerStartEventLink;
private var endEventNodeLink:EndEventLink;
private var errorEndEventNodeLink:ErrorEndEventLink;
/**Task tab*/
private var userTaskNodeLink:UserTaskLink;
private var scriptTaskNodeLink:ScriptTaskLink;
private var serviceTaskNodeLink:ServiceTaskLink;
private var mailTaskNodeLink:MailTaskLink;
private var manualTaskNodeLink:ManualTaskLink;
private var receiveTaskNodeLink:ReceiveTaskLink;
private var businessRuleTaskNodeLink:BusinessRuleTaskLink;
private var subProcessNodeLink:SubProcessLink;
private var callActivityNodeLink:CallActivityLink;
/**Gateway tab*/
private var parallelGatewayNodeLink:ParallelGatewayLink;
private var exclusiveGatewayNodeLink:ExclusiveGatewayLink;
/**Boundary event tab*/
private var timerBoundaryEventNodeLink:TimerBoundaryEventLink;
private var errorBoundaryEventNodeLink:ErrorBoundaryEventLink;
/**Alfresco tab*/
private var alfrescoStartEventNodeLink:AlfrescoStartEventLink;
private var alfrescoUserTaskNodeLink:AlfrescoUserTaskLink;
private var alfrescoScriptTaskNodeLink:AlfrescoScriptTaskLink;
private var alfrescoMailTaskNodeLink:AlfrescoMailTaskLink;
private var selectedNodeLink:BaseNodeLink;

private function init():void {				
	var bundleName:String = this.className;
	paletteLbTitle = Ini18ResourceLoader.getLocaleString(bundleName, "palette");
	connectionLbTitle = Ini18ResourceLoader.getLocaleString(bundleName, "connection");
	eventLbTitle = Ini18ResourceLoader.getLocaleString(bundleName, "event");
	taskLbTitle = Ini18ResourceLoader.getLocaleString(bundleName, "task");
	gatewayLbTitle = Ini18ResourceLoader.getLocaleString(bundleName, "gateway");
	boundaryEventLbTitle = Ini18ResourceLoader.getLocaleString(bundleName, "boundaryEvent");
	alfrescoLbTitle = Ini18ResourceLoader.getLocaleString(bundleName, "alfresco");
	initDatas();
	initList();
	initListeners();
}

private function initDatas():void {
	/**other tab*/
	this.selectNodeLink = new SelectLink();
	this.marqueeNodeLink = new MarqueeLink();
	/**connection tab*/
	this.sequenceFlowNodeLink = new SequenceFlowLink();
	/**Event tab*/
	this.startEventNodeLink = new StartEventLink();
	this.timerStartEventNodeLink = new TimerStartEventLink();
	this.endEventNodeLink = new EndEventLink();
	this.errorEndEventNodeLink = new ErrorEndEventLink();
	/**Task tab*/
	this.userTaskNodeLink = new UserTaskLink();
	this.scriptTaskNodeLink = new ScriptTaskLink();
	this.serviceTaskNodeLink = new ServiceTaskLink();
	this.mailTaskNodeLink = new MailTaskLink();
	this.manualTaskNodeLink = new ManualTaskLink();
	this.receiveTaskNodeLink = new ReceiveTaskLink();
	this.businessRuleTaskNodeLink = new BusinessRuleTaskLink();;
	this.subProcessNodeLink = new SubProcessLink();
	this.callActivityNodeLink = new CallActivityLink();
	/**Gateway tab*/
	this.parallelGatewayNodeLink = new ParallelGatewayLink();
	this.exclusiveGatewayNodeLink = new ExclusiveGatewayLink();
	/**Boundary event tab*/
	this.timerBoundaryEventNodeLink = new TimerBoundaryEventLink();
	this.errorBoundaryEventNodeLink = new ErrorBoundaryEventLink();
	/**Alfresco tab*/
	this.alfrescoStartEventNodeLink = new AlfrescoStartEventLink();
	this.alfrescoUserTaskNodeLink = new AlfrescoUserTaskLink();
	this.alfrescoScriptTaskNodeLink = new AlfrescoScriptTaskLink();
	this.alfrescoMailTaskNodeLink = new AlfrescoMailTaskLink();
}

private function initList():void {
	initOther();
	initConnection();
	initEventTab();
	initTaskTab();
	initGatewayTab();
	initBoundaryEventTab();
	initAlfrescoTab();
}

private function initOther():void {
	addTabLink(otherTab, selectNodeLink);
	addTabLink(otherTab, marqueeNodeLink);
}

private function initConnection():void {
	addTabLink(connectionTab, sequenceFlowNodeLink);
}

private function initEventTab():void {
	addTabLink(eventTab, startEventNodeLink);
	addTabLink(eventTab, timerStartEventNodeLink);
	addTabLink(eventTab, endEventNodeLink);
	addTabLink(eventTab, errorEndEventNodeLink);
}

private function initTaskTab():void {
	addTabLink(taskTab, userTaskNodeLink);	
	addTabLink(taskTab, scriptTaskNodeLink);
	addTabLink(taskTab, serviceTaskNodeLink);
	addTabLink(taskTab, mailTaskNodeLink);
	addTabLink(taskTab, manualTaskNodeLink);
	addTabLink(taskTab, receiveTaskNodeLink);
	addTabLink(taskTab, businessRuleTaskNodeLink);
	addTabLink(taskTab, subProcessNodeLink);
	addTabLink(taskTab, callActivityNodeLink);
} 

private function initGatewayTab():void {
	addTabLink(gatewayTab, parallelGatewayNodeLink);
	addTabLink(gatewayTab, exclusiveGatewayNodeLink);
}

private function initBoundaryEventTab():void {
	addTabLink(boundaryEventTab, timerBoundaryEventNodeLink);
	addTabLink(boundaryEventTab, errorBoundaryEventNodeLink);
}

private function initAlfrescoTab():void {
	addTabLink(alfrescoTab, alfrescoStartEventNodeLink);
	addTabLink(alfrescoTab, alfrescoUserTaskNodeLink);
	addTabLink(alfrescoTab, alfrescoScriptTaskNodeLink);
	addTabLink(alfrescoTab, alfrescoMailTaskNodeLink);
}

private function addTabLink(tab:IVisualElementContainer, nodeLink:BaseNodeLink):void {
	tab.addElement(nodeLink);
	nodeLink.addEventListener(SelectNodeLinkEvent.SELECT_LINK, handleNodeLinkSelect);
}

private function initListeners():void {
}

private function handleNodeLinkSelect(event:SelectNodeLinkEvent):void {
	var linkObj:BaseNodeLink = event.nodeLink;
	if(linkObj===selectedNodeLink) {
		return;
	}
	if(selectedNodeLink!=null) {
		selectedNodeLink.unselect();
	}
	this.selectedNodeLink = linkObj;
	var evt:SelectNodeLinkEvent = new SelectNodeLinkEvent(linkObj);
	this.dispatchEvent(evt);
}

private function handleShowModeChanged(event:MouseEvent):void {
	switch(showMode) {
		case MINUS: {
			showMode = PLUS;			
			this.left = 0;
		}
			break;
		case PLUS: {
			showMode = MINUS;
			this.left = -this.width+leftMinusBtn.getExplicitOrMeasuredWidth()+1;
		}
			break;
	}
}

override protected function createChildren():void {				
	super.createChildren();
	this.titleBar.addChild(leftMinusBtn);
	this.titleBar.addChild(rightPlusBtn);
	leftMinusBtn.setActualSize(leftMinusBtn.getExplicitOrMeasuredWidth(),
		leftMinusBtn.getExplicitOrMeasuredHeight());			
	rightPlusBtn.setActualSize(rightPlusBtn.getExplicitOrMeasuredWidth(),
		rightPlusBtn.getExplicitOrMeasuredHeight());
	
}

private function onCreationComplete():void {
}

override protected function updateDisplayList (unscaledWidth:Number, unscaledHeight:Number):void
{
	super.updateDisplayList(unscaledWidth, unscaledHeight);
	updateShowModeButton();	
}

private function updateShowModeButton():void {
	var x:int = 0;
	switch(showMode) {
		case MINUS: {
			leftMinusBtn.visible = false;
			rightPlusBtn.setActualSize(rightPlusBtn.getExplicitOrMeasuredWidth(),
				rightPlusBtn.getExplicitOrMeasuredHeight());						
			x = this.width - rightPlusBtn.width - 1;
			rightPlusBtn.move(x, 8);
		}
			break;
		case PLUS: {
			rightPlusBtn.visible = false;
			leftMinusBtn.setActualSize(leftMinusBtn.getExplicitOrMeasuredWidth(),
				leftMinusBtn.getExplicitOrMeasuredHeight());			
			x = this.width - leftMinusBtn.width - 1;
			leftMinusBtn.move(x, 8);
		}
			break;
	}			
}