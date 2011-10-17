package com.syspeak.makereap.workflow.web.mvc.explorer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springside.modules.orm.PageRequest;
import org.springside.modules.orm.PropertyFilter;

import com.syspeak.makereap.workflow.modules.activiti.ActivitiRepositoryService;
import com.syspeak.makereap.workflow.modules.activiti.bean.ProcessDefinitionInfo;
import com.syspeak.makereap.workflow.web.mvc.BaseMvcController;
import com.syspeak.modules.web.json.ExtPage;

/**
 * 流程定义Controller
 * @company SysPeak (C) Copyright
 * @category ProcessDefinitionController
 * @version 1.0
 * @since 2011-10-17
 * @author JemiZhuu(周士淳)
 */
@Controller
@RequestMapping(value = "explorer/processdefinition")
public class ProcessDefinitionController extends BaseMvcController {

	@RequestMapping(value = "view")
	public ModelAndView index(@ModelAttribute PageRequest pageRequest, HttpServletRequest request) {
		ModelAndView modelAndView = prepareIndexModelAndView();
		ExtPage<ProcessDefinitionInfo> page = this.list(pageRequest, request);
		modelAndView.addObject(PAGE_BEAN, page);
		return modelAndView;
	}

	@RequestMapping
	@ResponseBody
	public ExtPage<ProcessDefinitionInfo> list(@ModelAttribute PageRequest pageRequest, HttpServletRequest request) {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(request);
		pageRequest = preparePageRequest(pageRequest);
		ExtPage<ProcessDefinitionInfo> page = new ExtPage<ProcessDefinitionInfo>(pageRequest);
		page = repositoryService.findProcessDefinitionInfoPage(page, filters);
		page.setSuccess(true);
		System.out.println("Find ProcessDefinitions: " + page.getResult());
		return page;
	}

	@RequestMapping(value = "new")
	public String input(Model model) {
		return getInputViewName();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@RequestParam MultipartFile deploymentResources, HttpServletRequest request)
			throws Exception {
		return null;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable String id, ModelAndView modelAndView) {
		Deployment deployment = repositoryService.getDeployment(id);
		modelAndView.addObject(deployment);
		modelAndView.setViewName(getInputViewName());
		return modelAndView;
	}

	private void deleteDeployment(String deploymentId) {
		repositoryService.deleteDeployment(deploymentId);
	}

	private ActivitiRepositoryService repositoryService;

	@Autowired
	public void setRepositoryService(ActivitiRepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}
}