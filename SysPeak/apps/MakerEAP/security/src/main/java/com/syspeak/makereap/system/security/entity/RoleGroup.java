package com.syspeak.makereap.system.security.entity;



import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.syspeak.makereap.common.entity.base.BaseModel;


@Entity
@Table(name = "T_SECURITY_ROLEGROUP")
public class RoleGroup extends BaseModel {

	/**
	 *
	 */
	private static final long serialVersionUID = -8612753926437583406L;


	/**
	 * 角色组名称
	 */
	@Column(name = "name", nullable = false, length = 36, unique = true)
	private String name;

	/**
	 * 描述
	 */
	@Column(name = "description", nullable = true, length = 60)
	private String description;

	/**
	 * 所包含的角色列表
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "T_SECURITY_RoleGroup_rl", joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> roles;

	/**
	 * 所包含的角色组列表
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "T_SECURITY_RoleGroupContain_rl_tb", joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ref_group_id", referencedColumnName = "id"))
	private Set<RoleGroup> roleGroups;

	/**
	 * 数据的所有者
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner")
	private LoginAccount owner;


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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<RoleGroup> getRoleGroups() {
		return roleGroups;
	}

	public void setRoleGroups(Set<RoleGroup> roleGroups) {
		this.roleGroups = roleGroups;
	}

	public LoginAccount getOwner() {
		return owner;
	}

	public void setOwner(LoginAccount owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleGroup other = (RoleGroup) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
