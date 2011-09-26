package com.syspeak.makereap.common.web.controller;


import com.syspeak.makereap.common.entity.Persistence;
import com.syspeak.makereap.common.service.BaseManager;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Spring MVC 实体CRUD Controller 基类
 *
 * @param <T>
 * @author JemiZhuu(周士淳)
 * @version 1.0
 * @company SysPeak (C) Copyright
 * @category BaseCridControllerImpl
 * @since 2011-9-14
 */
public class BaseCrudControllerImpl<T extends Persistence<?>> extends BaseControllerImpl implements
        BaseCrudController<T> {


    protected BaseManager<T> baseManager;

    @Override
    @Autowired
    public void setBaseManager(BaseManager<T> baseManager) {
        this.baseManager = baseManager;
    }
}
