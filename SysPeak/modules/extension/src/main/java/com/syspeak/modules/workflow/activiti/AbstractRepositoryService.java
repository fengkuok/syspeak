package com.syspeak.modules.workflow.activiti;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Activiti Abstract Repository Service
 * @company SysPeak (C) Copyright
 * @category AbstractRepositoryService
 * @version 1.0
 * @since 2011-9-13
 * @author JemiZhuu(周士淳)
 */
public abstract class AbstractRepositoryService {
	/**
	 * 部署流程资源文件
	 * @param resource
	 * @param resourceName
	 * @return
	 */
	public Deployment createDeployment(Object resource, String resourceName) {
		DeploymentBuilder builder = repositoryService.createDeployment();
		Class<?> resourceType = resource.getClass();
		if (ZipInputStream.class.isAssignableFrom(resourceType)) {
			builder = builder.addZipInputStream((ZipInputStream) resource);
			if (resourceName != null && !"".equals(resourceName)) {
				builder.name(resourceName);
			}
		} else if (String.class.isAssignableFrom(resourceType)) {
			builder = builder.addString(resourceName, String.valueOf(resource));
		} else if (InputStream.class.isAssignableFrom(resourceType)) {
			builder = builder.addInputStream(resourceName, (InputStream) resource);
		} else {
			throw new ActivitiException("Invalid Deployment Resource:" + resourceType);
		}
		Deployment deployment = builder.deploy();
		return deployment;
	}

	/**
	 * 删除流程部署
	 * @param deploymentId
	 */
	public void deleteDeployment(String deploymentId) {
		deleteDeployment(deploymentId, false);
	}

	/**
	 * 删除流程部署
	 * @param deploymentId
	 * @param cascade
	 */
	public void deleteDeployment(String deploymentId, boolean cascade) {
		repositoryService.deleteDeployment(deploymentId, cascade);
	}

	private RepositoryService repositoryService;

	@Autowired
	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}
}