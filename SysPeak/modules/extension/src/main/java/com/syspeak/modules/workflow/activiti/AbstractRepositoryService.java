package com.syspeak.modules.workflow.activiti;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.DeploymentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PageRequest.Sort;
import org.springside.modules.orm.PropertyFilter;
import org.springside.modules.orm.PropertyFilter.MatchType;

/**
 * Activiti Abstract Repository Service
 * @company SysPeak (C) Copyright
 * @category AbstractRepositoryService
 * @version 1.0
 * @since 2011-9-13
 * @author JemiZhuu(周士淳)
 */
public abstract class AbstractRepositoryService {
	public static final String DEPLOYMENT_ID = "deploymentId";
	public static final String DEPLOYMENT_NAME = "deploymentName";
	public static final String DEPLOYMENT_TIME = "deploymentTime";

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
	 * 查找流程部署数据分页
	 * @param page
	 * @param filters
	 * @return
	 */
	public Page<Deployment> findDeploymentPage(Page<Deployment> page, List<PropertyFilter> filters) {
		DeploymentQuery query = repositoryService.createDeploymentQuery();
		for (PropertyFilter filter : filters) {
			MatchType matchType = filter.getMatchType();
			String propertyName = filter.getPropertyName();
			Object value = filter.getMatchValue();
			if (DEPLOYMENT_NAME.equals(propertyName)) {
				if (MatchType.LIKE.equals(matchType)) {
					query.deploymentNameLike(String.valueOf(value));
				} else {
					query.deploymentName(String.valueOf(value));
				}
			} else if (DEPLOYMENT_ID.equals(propertyName)) {
				query.deploymentId(String.valueOf(value));
			}
		}
		int firstResult = page.getOffset();
		int maxResults = page.getPageSize();
		if (page.isCountTotal()) {
			long totalItems = query.count();
			page.setTotalItems(totalItems);
		}
		if (page.isOrderBySetted()) {
			setOrderParameterToQuery(query, page);
		}
		List<Deployment> result = query.listPage(firstResult, maxResults);
		page.setResult(result);
		return page;
	}

	private DeploymentQuery setOrderParameterToQuery(DeploymentQuery query, Page<Deployment> page) {
		for (Sort orderBy : page.getSort()) {
			String orderProperty = orderBy.getProperty();
			String orderDir = orderBy.getDir();
			if (DEPLOYMENT_NAME.equals(orderProperty)) {
				query.orderByDeploymentName();
			} else if (DEPLOYMENT_ID.equals(orderProperty)) {
				query.orderByDeploymentId();
			} else if (DEPLOYMENT_TIME.equals(orderProperty)) {
				query.orderByDeploymenTime();
			}
			if (Sort.DESC.equals(orderDir)) {
				query.desc();
			} else {
				query.asc();
			}
		}
		return query;
	}

	/**
	 * 根据部署ID获取部署实例
	 * @param deploymentId
	 * @return
	 */
	public Deployment getDeployment(String deploymentId) {
		DeploymentQuery query = repositoryService.createDeploymentQuery();
		query = query.deploymentId(deploymentId);
		return query.singleResult();
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