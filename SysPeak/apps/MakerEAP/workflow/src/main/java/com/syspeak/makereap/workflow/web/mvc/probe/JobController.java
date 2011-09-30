package com.syspeak.makereap.workflow.web.mvc.probe;

import org.activiti.engine.runtime.Job;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syspeak.modules.web.json.ExtPage;
import com.syspeak.modules.web.springmvc.AbstractJsonController;

@Controller
@RequestMapping("/probe/job")
public class JobController extends AbstractJsonController<Job> {

	@RequestMapping(method = RequestMethod.GET )
	@ResponseBody 
	public ExtPage<Job> index() {
		System.out.println("excuteing job");
		return null;
	}

}
