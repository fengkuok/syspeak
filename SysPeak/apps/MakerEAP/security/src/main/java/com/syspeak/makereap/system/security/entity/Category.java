package com.syspeak.makereap.system.security.entity;

// Generated by Hibernate Tools
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
 * Category .
 *
 * @author Lingo
 */
@Entity
@Table(name = "CMS_CATEGORY")
public class Category extends LongIdEntity {

	/** null. */
	private Site site;

	/** null. */
	private String name;

	/** null. */
	private Integer seq;

	/** null. */
	private Integer status;

	/** null. */
	private String descn;

	/** . */
	private Set<Content> contents = new HashSet<Content>(0);

	public Category() {
	}

	public Category(Site site, String name, Integer seq, Integer status, String descn, Set<Content> contents) {
		this.site = site;
		this.name = name;
		this.seq = seq;
		this.status = status;
		this.descn = descn;
		this.contents = contents;
	}

	/** @return null. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SITE_ID")
	public Site getSite() {
		return this.site;
	}

	/** @param site null. */
	public void setSite(Site site) {
		this.site = site;
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
	@Column(name = "SEQ")
	public Integer getSeq() {
		return this.seq;
	}

	/** @param seq null. */
	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	/** @return null. */
	@Column(name = "STATUS")
	public Integer getStatus() {
		return this.status;
	}

	/** @param status null. */
	public void setStatus(Integer status) {
		this.status = status;
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Content> getContents() {
		return this.contents;
	}

	/** @param contents . */
	public void setContents(Set<Content> contents) {
		this.contents = contents;
	}
}
