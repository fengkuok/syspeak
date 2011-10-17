package com.syspeak.makereap.workflow.unit.utils.json;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springside.modules.orm.PropertyFilter;

import com.syspeak.makereap.workflow.modules.activiti.ActivitiRepositoryService;
import com.syspeak.makereap.workflow.modules.activiti.bean.DeploymentInfo;
import com.syspeak.makereap.workflow.modules.activiti.bean.ProcessDefinitionInfo;
import com.syspeak.modules.web.json.ExtPage;

public class ActivitiJacksonMapperTest extends BaseJacksonMapperTest {

	@Test
	public void testWriteDeploymentInfosPageJson() throws Exception {
		ExtPage<DeploymentInfo> page = new ExtPage<DeploymentInfo>();
		page.setOrderBy("");
		page.setOrderDir("");
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		page = repositoryService.findDeploymentInfoPage(page, filters);
		String jsonString = writeValueToJson(page);
		System.out.println(page + "=(DeploymentInfo)(json)> " + jsonString);
	}

	@Test
	public void testWriteProcessDefinitionInfosPageJson() throws Exception {
		ExtPage<ProcessDefinitionInfo> page = new ExtPage<ProcessDefinitionInfo>();
		page.setOrderBy("");
		page.setOrderDir("");
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		page = repositoryService.findProcessDefinitionInfoPage(page, filters);
		String jsonString = writeValueToJson(page);
		System.out.println(page + " =(ProcessDefinitionInfo)(json)> " + jsonString);
	}

	@Autowired
	private ActivitiRepositoryService repositoryService;
}
