package com.syspeak.makereap.workflow.unit.utils.json;

import java.io.StringWriter;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.junit.Before;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTxTestCase;

@ContextConfiguration(locations = "/applicationContext-test.xml")
public class BaseJacksonMapperTest extends SpringTxTestCase {
	protected static ObjectMapper objectMapper = new ObjectMapper();

	@Before
	public void setupMapper() throws Exception {
		//Fixtures.loadData(dataSource, "/data/sample-data.xml");
		SerializationConfig serializationConfig = objectMapper.getSerializationConfig();
		serializationConfig = serializationConfig.withDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		objectMapper.setSerializationConfig(serializationConfig);
		//using custom serializer/deserializer
		/*SimpleModule module = new SimpleModule("MyModule", new Version(1, 0, 0, null));
		module.addSerializer(new DeploymentSerializer());
		objectMapper.registerModule(module);*/
		System.out.println("Setup Jackson Mapper!");
	}

	protected String writeValueToJson(Object o) throws Exception {
		StringWriter writer = new StringWriter();
		JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(writer);
		objectMapper.writeValue(jsonGenerator, o);
		return writer.getBuffer().toString();
	}
}
