package com.syspeak.makereap.workflow.web.mvc;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import javax.servlet.http.HttpServletRequest;

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

@Controller
@RequestMapping(value = "deployment")
public class DeploymentController extends BaseMvcController {
	private static final String BAR = ".bar";

	@RequestMapping
	public ModelAndView index(HttpServletRequest request, ModelAndView modelAndView) {
		this.list(request, modelAndView);
		modelAndView.setViewName(getIndexViewName());
		return modelAndView;
	}

	@RequestMapping(value = "list", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView list(HttpServletRequest request, ModelAndView modelAndView) {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(request);
		PageRequest pageRequest = new PageRequest(1, PAGE_SIZE);
		Page<Deployment> page = new Page<Deployment>(pageRequest);
		page = repositoryService.findDeploymentPage(page, filters);
		modelAndView.addObject(PAGE_BEAN, page);
		modelAndView.setViewName(getListViewName());
		return modelAndView;
	}

	@RequestMapping(value = "create")
	public String input(Model model) {
		return getInputViewName();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@RequestParam MultipartFile deploymentResources, HttpServletRequest request)
			throws Exception {
		Deployment deployment = null;
		String fileName = deploymentResources.getOriginalFilename();
		InputStream inputStream = deploymentResources.getInputStream();
		if (fileName.toLowerCase().endsWith(BAR)) {
			inputStream = new ZipInputStream(inputStream);
		}
		deployment = repositoryService.createDeployment(inputStream, deploymentResources.getOriginalFilename());
		System.out.println(deployment);
		ModelAndView modelAndView = new ModelAndView();
		return index(request, modelAndView);
	}

	@RequestMapping(value = "{id}")
	public ModelAndView show(@PathVariable String id, ModelAndView modelAndView) {
		Deployment deployment = repositoryService.getDeployment(id);
		modelAndView.addObject(deployment);
		modelAndView.setViewName(getInputViewName());
		return modelAndView;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable String id, HttpServletRequest request) {
		if (id != null) {
			deleteDeployment(id);
		}
		ModelAndView modelAndView = new ModelAndView();
		return index(request, modelAndView);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ModelAndView deleteBatch(@RequestParam String[] ids, HttpServletRequest request) {
		if (ids != null) {
			for (String id : ids) {
				deleteDeployment(id);
			}
		}
		ModelAndView modelAndView = new ModelAndView();
		return index(request, modelAndView);
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