package com.syspeak.itboss.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.syspeak.modules.domain.model.identity.LongIdEntity;

/**
 * Site .
 *
 * @author Lingo
 */
@Entity
@Table(name = "CMS_SITE")
public class Site extends LongIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5198656926383570018L;

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
