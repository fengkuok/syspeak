package com.syspeak.modules.domain.model.identity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Long型主键实体映射基类
 * 
 * @company SysPeak (C) Copyright
 * @category LongIdEntity
 * @version 1.0
 * @since 2011-9-29
 * @author JemiZhuu(周士淳)
 */
@MappedSuperclass
public class LongIdEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
