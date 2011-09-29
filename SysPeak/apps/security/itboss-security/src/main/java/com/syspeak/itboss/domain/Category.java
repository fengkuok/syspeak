package com.syspeak.itboss.domain;

// Generated by Hibernate Tools
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Category .
 * 
 * @author Lingo
 */
@Entity
@Table(name = "CMS_CATEGORY")
public class Category {

	private static final long serialVersionUID = -8499775434683045253L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Site site;

	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "SEQ")
	private Integer seq;

	@Column(name = "STATUS")
	private Integer status;

	@Column(name = "DESCN", length = 200)
	private String descn;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	private Set<Content> contents = new HashSet<Content>(0);

	public Category() {
	}

	public Category(Site site, String name, Integer seq, Integer status,
			String descn, Set<Content> contents) {
		this.site = site;
		this.name = name;
		this.seq = seq;
		this.status = status;
		this.descn = descn;
		this.contents = contents;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescn() {
		return this.descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public Set<Content> getContents() {
		return this.contents;
	}

	public void setContents(Set<Content> contents) {
		this.contents = contents;
	}
}
