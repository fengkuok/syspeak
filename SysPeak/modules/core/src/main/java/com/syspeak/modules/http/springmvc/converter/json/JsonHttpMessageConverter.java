package com.syspeak.modules.http.springmvc.converter.json;

import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

/**
 * 扩展的JSON对象HTTP消息转换工具类
 * @company SysPeak (C) Copyright
 * @category JsonHttpMessageConverter
 * @version 1.0
 * @since 2011-10-11
 * @author JemiZhuu(周士淳)
 */
public class JsonHttpMessageConverter extends MappingJacksonHttpMessageConverter {

	/**日期JSON格式化参数*/
	private String dateFormatPattern = "yyyy-MM-dd HH:mm:ss";
	private SimpleDateFormat dateFormat = new SimpleDateFormat();
	protected ObjectMapper objectMapper = new ObjectMapper();

	public JsonHttpMessageConverter() {
		super();
		configureDateSerialization();
		setObjectMapper(objectMapper);
	}

	/**
	 * 配置日期数据JSON格式化输出
	 */
	private void configureDateSerialization() {
		this.dateFormat.applyPattern(dateFormatPattern);
		SerializationConfig serializationConfig = objectMapper.getSerializationConfig().withDateFormat(dateFormat);
		objectMapper.setSerializationConfig(serializationConfig);
	}

	public void setDateFormatPattern(String dateFormatPattern) {
		this.dateFormatPattern = dateFormatPattern;
		configureDateSerialization();
	}
}
