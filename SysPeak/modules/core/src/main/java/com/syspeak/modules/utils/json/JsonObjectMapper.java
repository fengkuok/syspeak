package com.syspeak.modules.utils.json;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * 扩展的JSON对象转换工具类
 * @company SysPeak (C) Copyright
 * @category JsonObjectMapper
 * @version 1.0
 * @since 2011-10-11
 * @author JemiZhuu(周士淳)
 */
public class JsonObjectMapper extends ObjectMapper {

	/**日期JSON格式化参数*/
	private String dateFormatPattern = "yyyy-MM-dd HH:mm:ss";
	private DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);

	public JsonObjectMapper() {
		this(null, null, null);
	}

	public JsonObjectMapper(JsonFactory jf) {
		this(jf, null, null);
	}

	public JsonObjectMapper(JsonFactory jf, SerializerProvider sp, DeserializerProvider dp) {
		this(jf, sp, dp, null, null);
	}

	public JsonObjectMapper(JsonFactory jf, SerializerProvider sp, DeserializerProvider dp,
			SerializationConfig sconfig, DeserializationConfig dconfig) {
		super(jf, sp, dp, sconfig, dconfig);
		configureDateSerialization();
	}

	/**
	 * 配置日期数据JSON格式化输出
	 */
	private void configureDateSerialization() {
		this.configure(Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		this.getSerializationConfig().withDateFormat(dateFormat);
	}

	public void setDateFormatPattern(String dateFormatPattern) {
		this.dateFormatPattern = dateFormatPattern;
		this.dateFormat = new SimpleDateFormat(dateFormatPattern);
		configureDateSerialization();
	}
}
