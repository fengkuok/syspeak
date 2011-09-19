package com.syspeak.modules.web.springmvc;

import java.io.Serializable;

import com.syspeak.modules.service.BaseEntityService;

/**
 * Spring MVC 实体CRUD基类接口
 * @company SysPeak (C) Copyright
 * @category BaseCrudController
 * @version 1.0
 * @since 2011-9-14
 * @param <T>
 * @param <ID>
 * @author JemiZhuu(周士淳)
 */
public interface BaseCrudController<T, ID extends Serializable> extends BaseController {
	public abstract void setEntityService(BaseEntityService<T, ID> baseEntityService);
}
