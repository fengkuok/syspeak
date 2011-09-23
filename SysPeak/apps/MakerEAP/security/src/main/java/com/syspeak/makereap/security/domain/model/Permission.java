/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syspeak.makereap.security.domain.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;


@Entity
@Table( name="T_SECURITY_PERMISSION")
public class Permission implements Persistence<String>
      ,GrantedAuthority
{

	private static final long serialVersionUID = 1649939616381932770L;

	/**
	 * 权限名称
	 */
	@Id
	@Column( name="TOKEN",length=100 )
	private String token;

	/**
	 * 描述
	 */
	@Column( name="DESCRIPTION",length=200 )
	private String description;

	/**
	 * TOKEN控制的资源(URL)
	 */
	@Column( name="URL",length=300 )
	private String url;

	@Override
	public String getAuthority() {
		return this.getToken();
	}

	@Override
	public String getIdentity() {
		return this.token;
	}

	public void preInsert( ){
		//do nothing
	}

	public void postInsertFailure( ){
		//do nothing
	}

	public boolean isInsert( ){
		return this.token == null;
	}

	//-- getters and setters ---------------------------------------------------

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
