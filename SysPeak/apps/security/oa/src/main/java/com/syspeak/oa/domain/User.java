package com.syspeak.oa.domain;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.syspeak.oa.util.CustomDateSerializer;

public class User {
	private long id;
	private String username;
	private String password;
	private boolean enabled;
	private Date createDate;

	public User() {

	}

	public User(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
