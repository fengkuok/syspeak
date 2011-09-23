/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syspeak.makereap.security.domain.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * 系统角色
 *
 */
@Entity
@Table( name="T_SECURITY_ROLE")
public class Role extends BaseModel{

	private static final long serialVersionUID = -2118356457067244665L;

	/**
	 * 只读，用于系统初始化角色
	 */
	@Column( name="READONLY" )
	private Boolean readonly;

	/**
	 * 角色名称
	 */
	@Column( name="NAME",length=100,unique=true )
	private String name;

	/**
	 * 描述
	 */
	@Column( name="DESCRIPTION",length=200  )
	private String description;

	/**
	 * 创建日期
	 */
	@Column( name="CREATE_DATE")
	private Date createDate;

	/**
	 * 角色对应权限
	 */
	@ManyToMany( fetch=FetchType.EAGER )
	@JoinTable( name="T_REF_ROLE_PERMISSION",
			joinColumns=@JoinColumn( name="ROLE_ID"),
			inverseJoinColumns=@JoinColumn( name="PERMISSION_ID"))
	private Set<Permission> permissions;

	public void addPermission( Permission p ){
		if( p == null )
			return;

		List<Permission> list = new ArrayList<Permission>( );
		list.add(p);
		addPermission(list);
	}

	/**
	 * 添加权限
	 */
	public void addPermission( Collection<Permission> colls ){
		if( this.permissions == null )
			this.permissions = new HashSet<Permission>();

		if( colls == null )
			return;

		for( Permission p:colls )
			this.permissions.add( p );
	}

	/**
	 * get permission as string array
	 */
	public Collection<String> getPermissionsAsString(){
		if( this.permissions == null || this.permissions.isEmpty() )
			return null;

		List<String> result = new ArrayList<String>();
		for( Permission each: this.getPermissions() ){
			result.add( each.getToken() );
		}

		return result;
	}

	//-- getters and setters --------------------------------------------------

	public Boolean getReadonly() {
		return readonly;
	}

	public void setReadonly(Boolean readonly) {
		this.readonly = readonly;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

}
