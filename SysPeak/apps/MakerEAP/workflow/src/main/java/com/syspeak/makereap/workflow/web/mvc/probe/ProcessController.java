package com.syspeak.makereap.workflow.web.mvc.probe;

import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syspeak.modules.web.json.ExtPage;
import com.syspeak.modules.web.springmvc.AbstractJsonController;

@Controller
@RequestMapping("/probe/process")
public class ProcessController  extends AbstractJsonController<ProcessInstance>{

	@Override
	public ExtPage<ProcessInstance> index() {
		// TODO Auto-generated method stub
		return null;
	}

}
