package com.syspeak.makereap.common.web;



import com.syspeak.makereap.common.entity.Persistence;
import com.syspeak.makereap.common.service.BaseManager;

import java.io.Serializable;



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
public interface BaseCrudController<T extends Persistence<?>> extends BaseController {
	public abstract void setBaseManager(BaseManager<T> baseEntityService);
}
