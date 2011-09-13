package com.syspeak.makereap.workflow.web.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.syspeak.makereap.workflow.modules.activiti.ActivitiRepositoryService;

@Controller
@RequestMapping(value = "/deployment")
public class DeploymentController {

	@RequestMapping(method = { RequestMethod.GET }, value = "input")
	public String input() {
		return "deployment-input";
	}

	private ActivitiRepositoryService repositoryService;

	@Autowired
	public void setRepositoryService(ActivitiRepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}
}
