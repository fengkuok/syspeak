package com.syspeak.modules.service;

import com.syspeak.modules.dao.BaseEntityDao;

/**
 * String型主键实体CRUD Service基类
 * @company SysPeak (C) Copyright
 * @category BaseStringIdEntityServiceImpl
 * @version 1.0
 * @since 2011-9-29
 * @param <T>
 * @param <DAO>
 * @author JemiZhuu(周士淳)
 */
public class BaseStringIdEntityServiceImpl<T, DAO extends BaseEntityDao<T, String>> extends
		BaseEntityServiceImpl<T, String, DAO> {
}
