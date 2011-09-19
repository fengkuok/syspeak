package com.syspeak.makereap.workflow.web.mvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.impl.persistence.entity.DeploymentEntity;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PageRequest;
import org.springside.modules.orm.PropertyFilter;

import com.syspeak.makereap.workflow.modules.activiti.ActivitiRepositoryService;
import com.syspeak.modules.web.springmvc.BaseControllerImpl;

@Controller
public class DeploymentController extends BaseControllerImpl {

	@RequestMapping(method = { RequestMethod.GET })
	public ModelAndView index(HttpServletRequest request, ModelAndView modelAndView) {
		modelAndView.setViewName(getIndexViewName());
		return modelAndView;
	}

	@RequestMapping(value = "list", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView list(HttpServletRequest request, ModelAndView modelAndView) {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(request);
		PageRequest pageRequest = new PageRequest(1, PAGE_SIZE);
		Page<DeploymentEntity> page = new Page<DeploymentEntity>(pageRequest);
		page = repositoryService.findDeploymentPage(page, filters);
		modelAndView.addObject(PAGE_BEAN, page);
		modelAndView.setViewName(getListViewName());
		return modelAndView;
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String input(Model model) {
		return getInputViewName();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@RequestParam MultipartFile deploymentResources, HttpServletRequest request)
			throws IOException {
		Deployment deployment = repositoryService.createDeployment(deploymentResources.getInputStream(),
				deploymentResources.getOriginalFilename());
		System.out.println(deployment);
		ModelAndView modelAndView = new ModelAndView();
		return list(request, modelAndView);
	}

	@RequestMapping(value = "${id}", method = { RequestMethod.GET })
	public ModelAndView view(@PathVariable String id, ModelAndView modelAndView) {
		Deployment deployment = repositoryService.getDeployment(id);
		modelAndView.addObject(deployment);
		modelAndView.setViewName(getInputViewName());
		return modelAndView;
	}

	private ActivitiRepositoryService repositoryService;

	@Autowired
	public void setRepositoryService(ActivitiRepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}
}