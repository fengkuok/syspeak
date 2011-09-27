package com.syspeak.modules.web.json;

import java.io.Serializable;

/**
 * Json 输出Bean
 * @author GuoFeng
 *
 */
public class JsonWriteBean implements Serializable{
	
	private static final long serialVersionUID = 8301322508687587979L;
	
	private boolean success;
	private String msg;
	private Object data;

	public JsonWriteBean() {
	}
	
	/**
	 * @param success 是否成功
	 */
	public JsonWriteBean(boolean success) {
		this.success = success;
	}
	
	/**
	 * @param success 是否成功
	 * @param msg 提示信息
	 */
	public JsonWriteBean(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}
	
	/**
	 * @param success 是否成功
	 * @param data 输出对象
	 */
	public JsonWriteBean(boolean success, Object data) {
		this.success = success;
		this.data = data;
	}

	/**
	 * @param success 是否成功
	 * @param msg 提示信息
	 * @param data 输出对象
	 */
	public JsonWriteBean(boolean success, String msg, Object data) {
		this.success = success;
		this.msg = msg;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
