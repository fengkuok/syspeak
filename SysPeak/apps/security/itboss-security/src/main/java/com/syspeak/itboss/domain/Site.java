package com.syspeak.itboss.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	private static final long serialVersionUID = 5198656926383570018L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GROUP_ID")
	private Group group;

	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "DESCN", length = 50)
	private String descn;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "site")
	private Set<Category> categories = new HashSet<Category>(0);

	public Site() {
	}

	public Site(Group group, String name, String descn, Set<Category> categories) {
		this.group = group;
		this.name = name;
		this.descn = descn;
		this.categories = categories;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescn() {
		return this.descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
}
