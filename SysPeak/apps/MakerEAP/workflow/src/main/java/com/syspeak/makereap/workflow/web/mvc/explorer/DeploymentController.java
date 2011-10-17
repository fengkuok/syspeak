package com.syspeak.makereap.workflow.web.mvc.explorer;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

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
import org.springside.modules.orm.PageRequest.Sort;
import org.springside.modules.orm.PropertyFilter;

import com.syspeak.makereap.workflow.modules.activiti.ActivitiRepositoryService;
import com.syspeak.makereap.workflow.modules.activiti.bean.DeploymentInfo;
import com.syspeak.makereap.workflow.web.mvc.BaseMvcController;
import com.syspeak.modules.web.json.ExtPage;
import com.syspeak.modules.workflow.activiti.AbstractRepositoryService;

/**
 * Restful流程部署Controller
 * @company SysPeak (C) Copyright
 * @category DeploymentController
 * @version 1.0
 * @since 2011-10-13
 * @author JemiZhuu(周士淳)
 */
@Controller
@RequestMapping(value = "explorer/deployment")
public class DeploymentController extends BaseMvcController {
	private static final String BAR = ".bar";

	@RequestMapping(value = "view")
	public ModelAndView index(@ModelAttribute PageRequest pageRequest, HttpServletRequest request) {
		ModelAndView modelAndView = prepareIndexModelAndView();
		ExtPage<DeploymentInfo> infoPage = this.list(pageRequest, request);
		modelAndView.addObject(PAGE_BEAN, infoPage);
		return modelAndView;
	}

	@RequestMapping
	@ResponseBody
	public ExtPage<DeploymentInfo> list(@ModelAttribute PageRequest pageRequest, HttpServletRequest request) {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(request);
		pageRequest = preparePageRequest(pageRequest);
		if (!pageRequest.isOrderBySetted()) {
			pageRequest.setOrderBy(AbstractRepositoryService.ID);
			pageRequest.setOrderDir(Sort.ASC);
		}
		ExtPage<DeploymentInfo> infoPage = new ExtPage<DeploymentInfo>(pageRequest);
		infoPage = repositoryService.findDeploymentInfoPage(infoPage, filters);
		infoPage.setSuccess(true);
		return infoPage;
	}

	@RequestMapping(value = "new")
	public String input(Model model) {
		return getInputViewName();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView create(@RequestParam MultipartFile deploymentResources, HttpServletRequest request)
			throws Exception {
		Deployment deployment = null;
		String fileName = deploymentResources.getOriginalFilename();
		InputStream inputStream = deploymentResources.getInputStream();
		if (fileName.toLowerCase().endsWith(BAR)) {
			inputStream = new ZipInputStream(inputStream);
		}
		deployment = repositoryService.createDeployment(inputStream, deploymentResources.getOriginalFilename());
		System.out.println(deployment);
		return null;
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
		return null;
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ModelAndView deleteBatch(@RequestParam String[] ids, HttpServletRequest request) {
		if (ids != null) {
			for (String id : ids) {
				deleteDeployment(id);
			}
		}
		return null;
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