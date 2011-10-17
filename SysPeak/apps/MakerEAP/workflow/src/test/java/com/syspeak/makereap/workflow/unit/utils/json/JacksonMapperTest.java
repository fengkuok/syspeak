package com.syspeak.makereap.workflow.unit.utils.json;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springside.modules.orm.PropertyFilter;

import com.syspeak.makereap.workflow.domain.entity.account.User;
import com.syspeak.makereap.workflow.domain.logic.UserService;
import com.syspeak.modules.web.json.ExtPage;

public class JacksonMapperTest extends BaseJacksonMapperTest {
	protected static ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void testWriteEntityJson() throws Exception {
		ExtPage<User> page = new ExtPage<User>();
		page.setOrderBy("");
		page.setOrderDir("");
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		page = userService.findPage(page, filters);
		String jsonString = writeValueToJson(page);
		System.out.println(page + "=(User)(json)>" + jsonString);
	}

	@Autowired
	private UserService userService;
}
