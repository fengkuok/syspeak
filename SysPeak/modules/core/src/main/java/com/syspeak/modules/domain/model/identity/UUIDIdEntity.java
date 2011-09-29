package com.syspeak.modules.domain.model.identity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * UUID型主键实体映射基类
 * @company SysPeak (C) Copyright
 * @category UUIDIdEntity
 * @version 1.0
 * @since 2011-9-29
 * @author JemiZhuu(周士淳)
 */
@MappedSuperclass
public class UUIDIdEntity implements Serializable {

	protected String id;

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
