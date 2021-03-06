package com.syspeak.makereap.system.security.entity;

// Generated by Hibernate Tools
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.syspeak.modules.domain.model.identity.LongIdEntity;

/**
 * Content .
 *
 * @author Lingo
 */
@Entity
@Table(name = "CMS_CONTENT")
public class Content extends LongIdEntity {
	/** null. */
	private Category category;

	/** null. */
	private String title;

	/** null. */
	private Integer status;

	/** null. */
	private String creator;

	/** null. */
	private Date createTime;

	/** null. */
	private Date updateTime;

	/** null. */
	private String content;

	/** . */
	private Set<Attach> attachs = new HashSet<Attach>(0);

	public Content() {
	}

	public Content(Category category, String title, Integer status, String creator, Date createTime, Date updateTime,
			String content, Set<Attach> attachs) {
		this.category = category;
		this.title = title;
		this.status = status;
		this.creator = creator;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.content = content;
		this.attachs = attachs;
	}

	/** @return null. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID")
	public Category getCategory() {
		return this.category;
	}

	/** @param category null. */
	public void setCategory(Category category) {
		this.category = category;
	}

	/** @return null. */
	@Column(name = "TITLE", length = 50)
	public String getTitle() {
		return this.title;
	}

	/** @param title null. */
	public void setTitle(String title) {
		this.title = title;
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
	@Column(name = "CREATOR", length = 50)
	public String getCreator() {
		return this.creator;
	}

	/** @param creator null. */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/** @return null. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TIME", length = 6)
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
	@Column(name = "CONTENT", length = 2000)
	public String getContent() {
		return this.content;
	}

	/** @param content null. */
	public void setContent(String content) {
		this.content = content;
	}

	/** @return . */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "content")
	public Set<Attach> getAttachs() {
		return this.attachs;
	}

	/** @param attachs . */
	public void setAttachs(Set<Attach> attachs) {
		this.attachs = attachs;
	}
}
