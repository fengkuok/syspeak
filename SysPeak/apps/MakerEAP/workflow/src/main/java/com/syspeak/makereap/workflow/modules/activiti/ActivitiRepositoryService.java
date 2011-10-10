package com.syspeak.makereap.workflow.modules.activiti;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.repository.Deployment;
import org.springframework.stereotype.Service;
import org.springside.modules.orm.PropertyFilter;

import com.syspeak.makereap.workflow.modules.activiti.bean.DeploymentInfo;
import com.syspeak.modules.web.json.ExtPage;
import com.syspeak.modules.workflow.activiti.AbstractRepositoryService;

/**
 * Activiti Repository Service
 * @company SysPeak (C) Copyright
 * @category ActivitiRepositoryService
 * @version 1.0
 * @since 2011-9-13
 * @author JemiZhuu(周士淳)
 */
@Service
public class ActivitiRepositoryService extends AbstractRepositoryService {
	/**
	 * 查找流程部署信息数据分页,并包装为信息Bean
	 * @param page
	 * @param filters
	 * @return
	 */
	public ExtPage<DeploymentInfo> findDeploymentInfoPage(ExtPage<Deployment> page, List<PropertyFilter> filters) {
		page = findDeploymentPage(page, filters);
		ExtPage<DeploymentInfo> infoPage = new ExtPage<DeploymentInfo>(page);
		infoPage.setOrderBy(page.getOrderBy());
		infoPage.setOrderDir(page.getOrderDir());
		infoPage.setTotalItems(page.getTotalItems());
		List<DeploymentInfo> infoResult = new ArrayList<DeploymentInfo>();
		List<Deployment> result = page.getResult();
		for (Deployment deployment : result) {
			DeploymentInfo info = new DeploymentInfo(deployment);
			infoResult.add(info);
		}
		infoPage.setResult(infoResult);
		return infoPage;
	}
}
