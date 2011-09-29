package com.syspeak.itboss.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Group .
 * 
 * @author 詹益峰
 */
@Entity
@Table(name = "SEC_GROUP")
public class Group {

	private static final long serialVersionUID = -8895529473299903143L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Group parent;

	@Column(name = "CODE", nullable = false, length = 50)
	private String code;

	@Column(name = "NAME", nullable = false, length = 50)
	private String name;

	@Column(name = "ALLOW_MANAGE", nullable = false)
	private int allowManage;

	@Column(name = "CREATOR", nullable = false, length = 50)
	private String creator;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TIME", nullable = false, length = 6)
	private Date createTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_TIME", length = 6)
	private Date updateTime;

	@Column(name = "STATUS", nullable = false)
	private int status;

	@Column(name = "SEQ", nullable = false)
	private int seq;

	@Column(name = "DESCN", length = 200)
	private String descn;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SEC_GROUP_USER", schema = "PUBLIC", joinColumns = { @JoinColumn(name = "GROUP_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "USER_ID", nullable = false, updatable = false) })
	private Set<User> users = new HashSet<User>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
	private Set<Resc> ownerRescs = new HashSet<Resc>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
	private Set<Group> children = new HashSet<Group>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
	private Set<Site> sites = new HashSet<Site>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
	private Set<User> ownerUsers = new HashSet<User>(0);

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SEC_GROUP_RESC", schema = "PUBLIC", joinColumns = { @JoinColumn(name = "GROUP_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "RESC_ID", nullable = false, updatable = false) })
	private Set<Resc> rescs = new HashSet<Resc>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
	private Set<Role> ownerRoles = new HashSet<Role>(0);

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SEC_GROUP_ROLE", schema = "PUBLIC", joinColumns = { @JoinColumn(name = "GROUP_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", nullable = false, updatable = false) })
	private Set<Role> roles = new HashSet<Role>(0);

	public Group() {
	}

	public Group(String code, String name, int allowManage, String creator,
			Date createTime, int status, int seq) {
		this.code = code;
		this.name = name;
		this.allowManage = allowManage;
		this.creator = creator;
		this.createTime = createTime;
		this.status = status;
		this.seq = seq;
	}

	public Group(Group parent, String code, String name, int allowManage,
			String creator, Date createTime, Date updateTime, int status,
			int seq, String descn, Set<User> users, Set<Resc> ownerRescs,
			Set<Group> children, Set<Site> sites, Set<User> ownerUsers,
			Set<Resc> rescs, Set<Role> ownerRoles, Set<Role> roles) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Group getParent() {
		return this.parent;
	}

	public void setParent(Group parent) {
		this.parent = parent;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAllowManage() {
		return this.allowManage;
	}

	public void setAllowManage(int allowManage) {
		this.allowManage = allowManage;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSeq() {
		return this.seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getDescn() {
		return this.descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Resc> getOwnerRescs() {
		return this.ownerRescs;
	}

	public void setOwnerRescs(Set<Resc> ownerRescs) {
		this.ownerRescs = ownerRescs;
	}

	public Set<Group> getChildren() {
		return this.children;
	}

	public void setChildren(Set<Group> children) {
		this.children = children;
	}

	public Set<Site> getSites() {
		return this.sites;
	}

	public void setSites(Set<Site> sites) {
		this.sites = sites;
	}

	public Set<User> getOwnerUsers() {
		return this.ownerUsers;
	}

	public void setOwnerUsers(Set<User> ownerUsers) {
		this.ownerUsers = ownerUsers;
	}

	public Set<Resc> getRescs() {
		return this.rescs;
	}

	public void setRescs(Set<Resc> rescs) {
		this.rescs = rescs;
	}

	public Set<Role> getOwnerRoles() {
		return this.ownerRoles;
	}

	public void setOwnerRoles(Set<Role> ownerRoles) {
		this.ownerRoles = ownerRoles;
	}

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
