package com.syspeak.makereap.system.security.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Site .
 *
 * @author Lingo
 */
@Entity
@Table(name = "CMS_SITE")
public class Site implements java.io.Serializable {
	/** null. */
	private Long id;

	/** null. */
	private Group group;

	/** null. */
	private String name;

	/** null. */
	private String descn;

	/** . */
	private Set<Category> categories = new HashSet<Category>(0);

	public Site() {
	}

	public Site(Group group, String name, String descn, Set<Category> categories) {
		this.group = group;
		this.name = name;
		this.descn = descn;
		this.categories = categories;
	}

	/** @return null. */
	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	/** @param id null. */
	public void setId(Long id) {
		this.id = id;
	}

	/** @return null. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GROUP_ID")
	public Group getGroup() {
		return this.group;
	}

	/** @param group null. */
	public void setGroup(Group group) {
		this.group = group;
	}

	/** @return null. */
	@Column(name = "NAME", length = 50)
	public String getName() {
		return this.name;
	}

	/** @param name null. */
	public void setName(String name) {
		this.name = name;
	}

	/** @return null. */
	@Column(name = "DESCN", length = 50)
	public String getDescn() {
		return this.descn;
	}

	/** @param descn null. */
	public void setDescn(String descn) {
		this.descn = descn;
	}

	/** @return . */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "site")
	public Set<Category> getCategories() {
		return this.categories;
	}

	/** @param categories . */
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
}
