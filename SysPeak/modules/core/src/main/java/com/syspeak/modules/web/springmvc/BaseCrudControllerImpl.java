package com.syspeak.modules.web.springmvc;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.syspeak.modules.service.BaseEntityService;

/**
 * Spring MVC 实体CRUD Controller 基类
 * @company SysPeak (C) Copyright
 * @category BaseCridControllerImpl
 * @version 1.0
 * @since 2011-9-14
 * @param <T>
 * @param <ID>
 * @author JemiZhuu(周士淳)
 */
public class BaseCrudControllerImpl<T, ID extends Serializable> extends BaseControllerImpl implements
		BaseCrudController<T, ID> {

	protected BaseEntityService<T, ID> baseEntityService;

	@Override
	@Autowired
	public void setEntityService(BaseEntityService<T, ID> baseEntityService) {
		this.baseEntityService = baseEntityService;
	}
}
