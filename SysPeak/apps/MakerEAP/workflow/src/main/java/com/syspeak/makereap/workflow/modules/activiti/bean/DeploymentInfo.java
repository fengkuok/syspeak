package com.syspeak.makereap.workflow.modules.activiti.bean;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.impl.persistence.entity.DeploymentEntity;
import org.activiti.engine.impl.persistence.entity.ResourceEntity;
import org.activiti.engine.repository.Deployment;

/**
 * 流程部署信息Bean
 * @company SysPeak (C) Copyright
 * @category DeploymentInfo
 * @version 1.0
 * @since 2011-10-10
 * @author JemiZhuu(周士淳)
 */
@SuppressWarnings("serial")
public class DeploymentInfo extends DeploymentEntity implements Deployment {

	public DeploymentInfo(Deployment deployment) {
		this.id = deployment.getId();
		this.name = deployment.getName();
		this.deploymentTime = deployment.getDeploymentTime();
	}

	@Override
	public Map<String, ResourceEntity> getResources() {
		if (resources == null && id != null) {
			resources = new HashMap<String, ResourceEntity>();
		}
		return resources;
	}
}
