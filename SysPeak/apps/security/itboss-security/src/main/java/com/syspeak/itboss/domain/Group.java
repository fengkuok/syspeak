package com.syspeak.itboss.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.syspeak.modules.domain.model.identity.LongIdEntity;

/**
 * Group .
 *
 * @author Lingo
 */
@Entity
@Table(name = "SEC_GROUP")
public class Group extends LongIdEntity {

	/** null. */
	private Group parent;

	/** null. */
	private String code;

	/** null. */
	private String name;

	/** null. */
	private int allowManage;

	/** null. */
	private String creator;

	/** null. */
	private Date createTime;

	/** null. */
	private Date updateTime;

	/** null. */
	private int status;

	/** null. */
	private int seq;

	/** null. */
	private String descn;

	/** . */
	private Set<User> users = new HashSet<User>(0);

	/** . */
	private Set<Resc> ownerRescs = new HashSet<Resc>(0);

	/** . */
	private Set<Group> children = new HashSet<Group>(0);

	/** . */
	private Set<Site> sites = new HashSet<Site>(0);

	/** . */
	private Set<User> ownerUsers = new HashSet<User>(0);

	/** . */
	private Set<Resc> rescs = new HashSet<Resc>(0);

	/** . */
	private Set<Role> ownerRoles = new HashSet<Role>(0);

	/** . */
	private Set<Role> roles = new HashSet<Role>(0);

	public Group() {
	}

	public Group(String code, String name, int allowManage, String creator, Date createTime, int status, int seq) {
		this.code = code;
		this.name = name;
		this.allowManage = allowManage;
		this.creator = creator;
		this.createTime = createTime;
		this.status = status;
		this.seq = seq;
	}

	public Group(Group parent, String code, String name, int allowManage, String creator, Date createTime,
			Date updateTime, int status, int seq, String descn, Set<User> users, Set<Resc> ownerRescs,
			Set<Group> children, Set<Site> sites, Set<User> ownerUsers, Set<Resc> rescs, Set<Role> ownerRoles,
			Set<Role> roles) {
		this.parent = parent;
		this.code = code;
		this.name = name;
		this.allowManage = allowManage;
		this.creator = creator;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.status = status;
		this.seq = seq;
		this.descn = descn;
		this.users = users;
		this.ownerRescs = ownerRescs;
		this.children = children;
		this.sites = sites;
		this.ownerUsers = ownerUsers;
		this.rescs = rescs;
		this.ownerRoles = ownerRoles;
		this.roles = roles;
	}

	/** @return null. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	public Group getParent() {
		return this.parent;
	}

	/** @param parent null. */
	public void setParent(Group parent) {
		this.parent = parent;
	}

	/** @return null. */
	@Column(name = "CODE", nullable = false, length = 50)
	public String getCode() {
		return this.code;
	}

	/** @param code null. */
	public void setCode(String code) {
		this.code = code;
	}

	/** @return null. */
	@Column(name = "NAME", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	/** @param name null. */
	public void setName(String name) {
		this.name = name;
	}

	/** @return null. */
	@Column(name = "ALLOW_MANAGE", nullable = false)
	public int getAllowManage() {
		return this.allowManage;
	}

	/** @param allowManage null. */
	public void setAllowManage(int allowManage) {
		this.allowManage = allowManage;
	}

	/** @return null. */
	@Column(name = "CREATOR", nullable = false, length = 50)
	public String getCreator() {
		return this.creator;
	}

	/** @param creator null. */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/** @return null. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TIME", nullable = false, length = 6)
	public Date getCreateTime() {
		return this.createTime;
	}

	/** @param createTime null. */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/** @return null. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_TIME", length = 6)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	/** @param updateTime null. */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/** @return null. */
	@Column(name = "STATUS", nullable = false)
	public int getStatus() {
		return this.status;
	}

	/** @param status null. */
	public void setStatus(int status) {
		this.status = status;
	}

	/** @return null. */
	@Column(name = "SEQ", nullable = false)
	public int getSeq() {
		return this.seq;
	}

	/** @param seq null. */
	public void setSeq(int seq) {
		this.seq = seq;
	}

	/** @return null. */
	@Column(name = "DESCN", length = 200)
	public String getDescn() {
		return this.descn;
	}

	/** @param descn null. */
	public void setDescn(String descn) {
		this.descn = descn;
	}

	/** @return . */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SEC_GROUP_USER", schema = "PUBLIC", joinColumns = { @JoinColumn(name = "GROUP_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "USER_ID", nullable = false, updatable = false) })
	public Set<User> getUsers() {
		return this.users;
	}

	/** @param users . */
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	/** @return . */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
	public Set<Resc> getOwnerRescs() {
		return this.ownerRescs;
	}

	/** @param ownerRescs . */
	public void setOwnerRescs(Set<Resc> ownerRescs) {
		this.ownerRescs = ownerRescs;
	}

	/** @return . */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
	public Set<Group> getChildren() {
		return this.children;
	}

	/** @param children . */
	public void setChildren(Set<Group> children) {
		this.children = children;
	}

	/** @return . */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
	public Set<Site> getSites() {
		return this.sites;
	}

	/** @param sites . */
	public void setSites(Set<Site> sites) {
		this.sites = sites;
	}

	/** @return . */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
	public Set<User> getOwnerUsers() {
		return this.ownerUsers;
	}

	/** @param ownerUsers . */
	public void setOwnerUsers(Set<User> ownerUsers) {
		this.ownerUsers = ownerUsers;
	}

	/** @return . */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SEC_GROUP_RESC", schema = "PUBLIC", joinColumns = { @JoinColumn(name = "GROUP_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "RESC_ID", nullable = false, updatable = false) })
	public Set<Resc> getRescs() {
		return this.rescs;
	}

	/** @param rescs . */
	public void setRescs(Set<Resc> rescs) {
		this.rescs = rescs;
	}

	/** @return . */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
	public Set<Role> getOwnerRoles() {
		return this.ownerRoles;
	}

	/** @param ownerRoles . */
	public void setOwnerRoles(Set<Role> ownerRoles) {
		this.ownerRoles = ownerRoles;
	}

	/** @return . */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SEC_GROUP_ROLE", schema = "PUBLIC", joinColumns = { @JoinColumn(name = "GROUP_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", nullable = false, updatable = false) })
	public Set<Role> getRoles() {
		return this.roles;
	}

	/** @param roles . */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
