package com.syspeak.makereap.common.web.controller;


import com.syspeak.makereap.common.entity.Persistence;
import com.syspeak.makereap.common.service.BaseManager;


/**
 * Spring MVC 实体CRUD基类接口
 *
 * @param <T>
 * @param <ID>
 * @author JemiZhuu(周士淳)
 * @version 1.0
 * @company SysPeak (C) Copyright
 * @category BaseCrudController
 * @since 2011-9-14
 */
public interface BaseCrudController<T extends Persistence<?>> extends BaseController {
    public abstract void setBaseManager(BaseManager<T> baseEntityService);
}
