package com.syspeak.makereap.workflow.web.mvc.probe;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PageRequest.Sort;

import com.syspeak.makereap.workflow.domain.entity.account.User;
import com.syspeak.modules.web.json.JsonWriteBean;
import com.syspeak.modules.web.springmvc.AbstractJsonController;

@Controller
@RequestMapping("/probe/processengine")
public class ProcessEngineController  {
//extends AbstractJsonController<User>
	@RequestMapping(method = RequestMethod.GET )
	@ResponseBody
	public Page<User> index() {
		User user = new User();
		user.setName("fengkuok");
		Page<User> page = new Page<User>();
		page.setPageSize(100);
		page.setOrderBy(Sort.ASC);
		page.setOrderDir("desc");
		System.out.println("index---------------------");
		return page;
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String show(@RequestParam("id") Long id) {
		//JsonWriteBean write = new JsonWriteBean(true, "hahahahahahahaa");
		System.out.println("show--------------    " + id);
		return "xxxxxxxxx";
	}

}
