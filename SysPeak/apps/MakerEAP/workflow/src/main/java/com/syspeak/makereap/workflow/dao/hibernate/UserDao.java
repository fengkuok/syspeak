package com.syspeak.makereap.workflow.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.syspeak.makereap.workflow.domain.entity.account.User;
import com.syspeak.modules.dao.orm.hibernate.BaseHibernateDao;

/**
 * 用户实体DAO
 * @company ZSword (C) Copyright
 * @author JemiZhuu(周士淳)
 * @category UserDao
 * @version 1.0
 * @since 2011-9-9
 */
@Repository
public class UserDao extends BaseHibernateDao<User, Long> {
}
