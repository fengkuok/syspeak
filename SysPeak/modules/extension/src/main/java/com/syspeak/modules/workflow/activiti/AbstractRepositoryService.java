package com.syspeak.modules.workflow.activiti;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
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
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String KEY = "key";
	public static final String CATEGORY = "category";
	public static final String DEPLOYMENT_TIME = "deploymentTime";
	public static final String VERSION = "version";
	public static final String RESOURCE_NAME = "resourceName";
	public static final String DEPLOYMENT_ID = "deploymentId";

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
	public <T extends Page<Deployment>> T findDeploymentPage(T page, List<PropertyFilter> filters) {
		DeploymentQuery query = repositoryService.createDeploymentQuery();
		for (PropertyFilter filter : filters) {
			MatchType matchType = filter.getMatchType();
			String propertyName = filter.getPropertyName();
			Object value = filter.getMatchValue();
			if (NAME.equals(propertyName)) {
				if (MatchType.LIKE.equals(matchType)) {
					query.deploymentNameLike(String.valueOf(value));
				} else {
					query.deploymentName(String.valueOf(value));
				}
			} else if (ID.equals(propertyName)) {
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

	/**
	 * 设置Deployment Query Order
	 * @param query
	 * @param page
	 * @return
	 */
	private DeploymentQuery setOrderParameterToQuery(DeploymentQuery query, Page<Deployment> page) {
		for (Sort orderBy : page.getSort()) {
			String orderProperty = orderBy.getProperty();
			String orderDir = orderBy.getDir();
			boolean isOrderProperty = false;
			if (NAME.equals(orderProperty)) {
				query.orderByDeploymentName();
				isOrderProperty = true;
			} else if (ID.equals(orderProperty)) {
				query.orderByDeploymentId();
				isOrderProperty = true;
			} else if (DEPLOYMENT_TIME.equals(orderProperty)) {
				query.orderByDeploymenTime();
				isOrderProperty = true;
			}
			if (isOrderProperty == true) {
				if (Sort.DESC.equals(orderDir)) {
					query.desc();
				} else {
					query.asc();
				}
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

	/**
	 * 查找流程定义数据分页
	 * @param page
	 * @param filters
	 * @return
	 */
	public <T extends Page<ProcessDefinition>> T findProcessDefinitionPage(T page, List<PropertyFilter> filters) {
		ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
		for (PropertyFilter filter : filters) {
			MatchType matchType = filter.getMatchType();
			String propertyName = filter.getPropertyName();
			Object value = filter.getMatchValue();
			if (KEY.equals(propertyName)) {
				if (MatchType.LIKE.equals(matchType)) {
					query.processDefinitionKeyLike(String.valueOf(value));
				} else {
					query.processDefinitionKey(String.valueOf(value));
				}
			} else if (CATEGORY.equals(propertyName)) {
				if (MatchType.LIKE.equals(matchType)) {
					query.processDefinitionCategoryLike(String.valueOf(value));
				} else {
					query.processDefinitionCategory(String.valueOf(value));
				}
			} else if (NAME.equals(propertyName)) {
				if (MatchType.LIKE.equals(matchType)) {
					query.processDefinitionNameLike(String.valueOf(value));
				} else {
					query.processDefinitionName(String.valueOf(value));
				}
			} else if (RESOURCE_NAME.equals(propertyName)) {
				if (MatchType.LIKE.equals(matchType)) {
					query.processDefinitionResourceNameLike(String.valueOf(value));
				} else {
					query.processDefinitionResourceName(String.valueOf(value));
				}
			} else if (DEPLOYMENT_ID.equals(propertyName)) {
				query.deploymentId(String.valueOf(value));
			} else if (VERSION.equals(propertyName)) {
				query.processDefinitionVersion(Integer.parseInt(String.valueOf(value)));
			} else if (ID.equals(propertyName)) {
				query.processDefinitionId(String.valueOf(value));
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
		List<ProcessDefinition> result = query.listPage(firstResult, maxResults);
		page.setResult(result);
		return page;
	}

	/**
	 * 设置ProcessDefinition Query Order
	 * @param query
	 * @param page
	 * @return
	 */
	private ProcessDefinitionQuery setOrderParameterToQuery(ProcessDefinitionQuery query, Page<ProcessDefinition> page) {
		for (Sort orderBy : page.getSort()) {
			String orderProperty = orderBy.getProperty();
			String orderDir = orderBy.getDir();
			boolean isOrderProperty = false;
			if (NAME.equals(orderProperty)) {
				query.orderByProcessDefinitionName();
				isOrderProperty = true;
			} else if (DEPLOYMENT_ID.equals(orderProperty)) {
				query.orderByDeploymentId();
				isOrderProperty = true;
			} else if (KEY.equals(orderProperty)) {
				query.orderByProcessDefinitionKey();
				isOrderProperty = true;
			} else if (CATEGORY.equals(orderProperty)) {
				query.orderByProcessDefinitionCategory();
				isOrderProperty = true;
			} else if (ID.equals(orderProperty)) {
				query.orderByProcessDefinitionId();
				isOrderProperty = true;
			} else if (VERSION.equals(orderProperty)) {
				query.orderByProcessDefinitionVersion();
				isOrderProperty = true;
			}
			if (isOrderProperty == true) {
				if (Sort.DESC.equals(orderDir)) {
					query.desc();
				} else {
					query.asc();
				}
			}
		}
		return query;
	}

	protected RepositoryService repositoryService;

	@Autowired
	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}
}