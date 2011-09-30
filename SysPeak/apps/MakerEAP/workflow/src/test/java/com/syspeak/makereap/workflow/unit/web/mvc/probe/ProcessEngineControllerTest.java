package com.syspeak.makereap.workflow.unit.web.mvc.probe;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.syspeak.modules.web.json.JsonWriteBean;

public class ProcessEngineControllerTest {

	// ProcessEngineController controller;
	//
	// @Before
	// public void setup() {
	// controller = new ProcessEngineController();
	// }
	//
	// @Test
	// public void testIndex() throws Exception{
	// controller.index();
	// }

	@Test
	public void testRest() throws Exception {
//		try {
//			HttpClient httpClient = new DefaultHttpClient();
//			String spittleUrl = "http://localhost:8080/maker-workflow/probe/processengine/876/";
//			HttpGet getRequest = new HttpGet(spittleUrl);
//			getRequest.setHeader(new BasicHeader("Accept", "application/json"));
//			getRequest.setParams(new BasicHttpParams().setLongParameter("id", 99l));
//			HttpResponse response = httpClient.execute(getRequest);
//			HttpEntity entity = response.getEntity();
//			ObjectMapper mapper = new ObjectMapper();
//			System.out.println(mapper.readValue(entity.getContent(),
//					Page.class));
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
		new RestTemplate().getForObject(
				"http://localhost:8080/maker-workflow/probe/processengine/{id}",
				JsonWriteBean.class,99l);
	}
}
