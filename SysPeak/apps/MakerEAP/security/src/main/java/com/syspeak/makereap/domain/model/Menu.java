package com.syspeak.makereap.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import com.syspeak.modules.domain.model.tree.LongTreeNode;

/**
 * Menu generated by Lingo.
 *
 * @author Lingo
 * @since 2007年08月18日 下午 20时18分45秒0
 */
@Entity
@Table(name = "WEB_MENU")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Menu extends LongTreeNode<Menu> {
	/** * serial. */
	static final long serialVersionUID = 0L;

	/** * id. */
	private Long id;

	/** * parent. */
	private Menu parent;

	/** * name. */
	private String name;

	/** * theSort. */
	private Integer theSort;

	/** * qtip. */
	private String qtip;

	/** * iconCls. */
	private String iconCls;

	/** * forward. */
	private String url;

	/** * descn. */
	private String descn;

	/** 功能类型*/
	private String function_type;

	private String button_id;

	/** * menus. */
	private Set<Menu> children = new HashSet<Menu>(0);

	/** * roles. */
	private Set<Role> roles = new HashSet<Role>(0);

	private Set<Resc> rescs = new HashSet<Resc>(0);

	/** * checked. */
	private boolean checked = false;

	/** * 构造方法. */
	public Menu() {
	}

	/** * @return id. */
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", nullable = false)
	public Long getId() {
		return id;
	}

	/** * @param id id. */
	public void setId(Long id) {
		this.id = id;
	}

	/** * @return parent. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	public Menu getParent() {
		return parent;
	}

	/** * @param parent Menu. */
	public void setParent(Menu parent) {
		this.parent = parent;
	}

	/** * @return name. */
	@Column(name = "NAME", length = 50)
	public String getName() {
		return name;
	}

	/** * @param name name. */
	public void setName(String name) {
		this.name = name;
	}

	/** * @return theSort. */
	@Column(name = "THE_SORT")
	public Integer getTheSort() {
		return theSort;
	}

	/** * @param theSort Integer. */
	public void setTheSort(Integer theSort) {
		this.theSort = theSort;
	}

	/** * @return qtip. */
	@Column(name = "QTIP", length = 50)
	public String getQtip() {
		return qtip;
	}

	/** * @param qtip String. */
	public void setQtip(String qtip) {
		this.qtip = qtip;
	}

	/** * @return iconCls. */
	@Column(name = "ICON_CLS", length = 50)
	public String getIconCls() {
		return iconCls;
	}

	/** * @param iconCls icon. */
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	/** * @return url. */
	@Column(name = "URL", length = 250)
	public String getUrl() {
		return url;
	}

	/** * @param url String. */
	public void setUrl(String url) {
		this.url = url;
	}

	/** * @return descn. */
	@Column(name = "DESCN", length = 200)
	public String getDescn() {
		return descn;
	}

	/** * @param descn descn. */
	public void setDescn(String descn) {
		this.descn = descn;
	}

	@Column(name = "FUNCTION_TYPE", length = 60)
	public String getFunction_type() {
		return function_type;
	}

	public void setFunction_type(String function_type) {
		this.function_type = function_type;
	}

	@Column(name = "BUTTON_ID", length = 60)
	public String getButton_id() {
		return button_id;
	}

	public void setButton_id(String button_id) {
		this.button_id = button_id;
	}

	/** * @return children. */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
	@OrderBy("theSort asc, id desc")
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	public Set<Menu> getChildren() {
		return children;
	}

	/** * @param children Set. */
	public void setChildren(Set<Menu> children) {
		this.children = children;
	}

	/** * @return roles. */
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "WEB_MENU_ROLE", joinColumns = { @JoinColumn(name = "MENU_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	public Set<Role> getRoles() {
		return roles;
	}

	/** * @param roles roles. */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "WEB_RESC_MENU", joinColumns = { @JoinColumn(name = "MENU_ID") }, inverseJoinColumns = { @JoinColumn(name = "RESC_ID") })
	public Set<Resc> getRescs() {
		return rescs;
	}

	public void setRescs(Set<Resc> rescs) {
		this.rescs = rescs;
	}

	/** * @return isChecked. */
	@Transient
	public boolean isChecked() {
		return checked;
	}

	/** * @param checked boolean. */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
