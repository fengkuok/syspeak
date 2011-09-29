package com.syspeak.itboss.dao;

import org.springframework.stereotype.Repository;

import com.syspeak.itboss.domain.model.Role;
import com.syspeak.modules.dao.orm.hibernate.BaseHibernateDao;

/**
 * 
 * @company SysPeak (C) Copyright
 * @category RoleDao
 * @version 1.0
 * @since 2011-9-29
 * @author JemiZhuu(周士淳)
 */
@Repository
public class RoleDao extends BaseHibernateDao<Role, Long> {
}
