package com.syspeak.modules.domain.model;

import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.StringUtils;

/**
 * 模型基类,程序生成ID
 */
@MappedSuperclass
public abstract class UUIDModel implements Persistence<String> {

	private static final long serialVersionUID = 1;

	/**
	 * uuid
	 */
	@Id
	@Column(name = "ID")
	protected String id;

	/**
	 * 创建日期
	 */
	@Column(name = "CREATED_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	protected Calendar createdTime;

	public UUIDModel() {
	}

	public String getIdentity() {
		return this.id;
	}

	public void preInsert() {
		this.id = UUID.randomUUID().toString();
		this.createdTime = Calendar.getInstance();
	}

	public void postInsertFailure() {
		this.createdTime = null;
		this.id = null;
	}

	public boolean isInsert() {
		return StringUtils.isBlank(this.getIdentity());
	}

	public String getUuid() {
		return id;
	}

	public void setUuid(String uuid) {
		this.id = uuid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Calendar getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Calendar createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		UUIDModel other = (UUIDModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
