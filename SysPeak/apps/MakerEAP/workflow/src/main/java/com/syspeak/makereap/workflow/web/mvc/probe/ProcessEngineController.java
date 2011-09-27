package com.syspeak.makereap.workflow.web.mvc.probe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syspeak.makereap.workflow.domain.entity.account.User;
import com.syspeak.modules.web.json.JsonWriteBean;
import com.syspeak.modules.web.json.Page;
import com.syspeak.modules.web.springmvc.AbstractJsonController;

@Controller
@RequestMapping("/probe/processengine")
public class ProcessEngineController extends AbstractJsonController<User> {

	@RequestMapping(method = RequestMethod.GET )
	@ResponseBody 
	public Page<User> index() {
		User user1 = new User();
		user1.setName("fengkuok");
		
		User user2 = new User();
		user2.setName("guofeng");
		
		
		User user3 = new User();
		user3.setName("tom");
		
		User user4 = new User();
		user4.setName("lucy");
		
		User user5 = new User();
		user5.setName("jetty");

		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		
		Page<User> page = new Page<User>();
		
		page.setResult(users);
		page.setTotalCount(5l);
		page.setLimit(20);
		page.setSuccess(true);
		
//		Page<User> page = new Page<User>();
//		page.setPageSize(100);
//		page.setOrderBy(Sort.ASC);
//		page.setOrderDir("desc");
//		page.setResult(users);
//		System.out.println("index---------------------");
//		return page;
		return page;
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public JsonWriteBean show(@PathVariable("id") Long id) {
		User user = new User();
		user.setName("fengkuok");
		JsonWriteBean write = new JsonWriteBean(true, "成功",user);
		System.out.println("show--------------    " + id);
		return write;
	}
	
}

