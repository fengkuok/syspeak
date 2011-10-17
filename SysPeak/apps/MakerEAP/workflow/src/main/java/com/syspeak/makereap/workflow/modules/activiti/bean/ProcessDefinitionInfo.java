package com.syspeak.makereap.workflow.modules.activiti.bean;

import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.repository.ProcessDefinition;

/**
 * Activiti流程定义信息Bean
 * (解决JSON化报错问题)
 * @company SysPeak (C) Copyright
 * @category ProcessDefinitionInfo
 * @version 1.0
 * @since 2011-10-17
 * @author JemiZhuu(周士淳)
 */
@SuppressWarnings("serial")
public class ProcessDefinitionInfo extends ProcessDefinitionEntity {

	public ProcessDefinitionInfo(ProcessDefinition processDefinition) {
		this.id = processDefinition.getId();
		this.category = processDefinition.getCategory();
		this.name = processDefinition.getName();
		this.deploymentId = processDefinition.getDeploymentId();
		this.diagramResourceName = processDefinition.getDiagramResourceName();
		this.key = processDefinition.getKey();
		this.resourceName = processDefinition.getResourceName();
		this.version = processDefinition.getVersion();
	}

	@Override
	public ProcessDefinitionImpl getProcessDefinition() {
		if (processDefinition.equals(this)) {
			return null;
		}
		return processDefinition;
	}
}
