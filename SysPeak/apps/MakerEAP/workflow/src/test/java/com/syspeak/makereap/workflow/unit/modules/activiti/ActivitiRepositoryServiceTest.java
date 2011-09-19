package com.syspeak.makereap.workflow.unit.modules.activiti;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PageRequest;
import org.springside.modules.orm.PropertyFilter;
import org.springside.modules.test.spring.SpringTxTestCase;

import com.syspeak.makereap.workflow.modules.activiti.ActivitiRepositoryService;

/**
 * Activiti Repository Service测试类
 * @company SysPeak (C) Copyright
 * @category ActivitiRepositoryServiceTest
 * @version 1.0
 * @since 2011-9-19
 * @author JemiZhuu(周士淳)
 */
@ContextConfiguration(locations = { "/applicationContext-test.xml" })
public class ActivitiRepositoryServiceTest extends SpringTxTestCase {

	@Test
	public void findPage() {
		PageRequest pageRequest = new PageRequest(1, 20);
		Page<Deployment> page = new Page<Deployment>(pageRequest);
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		page = repositoryService.findDeploymentPage(page, filters);
		System.out.println(page.getResult());
	}

	@Autowired
	private ActivitiRepositoryService repositoryService;
}
