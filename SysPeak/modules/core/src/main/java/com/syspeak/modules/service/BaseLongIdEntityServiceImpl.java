package com.syspeak.modules.service;

import com.syspeak.modules.dao.BaseEntityDao;

/**
 * Long型主键实体CRUD Service基类
 * @company SysPeak (C) Copyright
 * @category BaseLongIdEntityServiceImpl
 * @version 1.0
 * @since 2011-9-29
 * @param <T>
 * @param <DAO>
 * @author JemiZhuu(周士淳)
 */
public class BaseLongIdEntityServiceImpl<T, DAO extends BaseEntityDao<T, Long>> extends
		BaseEntityServiceImpl<T, Long, DAO> {
}
