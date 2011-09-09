package com.syspeak.modules.dao.orm.hibernate;

import java.io.Serializable;

import org.springside.modules.orm.hibernate.HibernateDao;

import com.syspeak.modules.dao.BaseEntityDao;

/**
 * Hibernate DAO 基类
 * @company RichJavaGroup (C) Copyright
 * @category BaseHibernateDao
 * @version 1.0
 * @since 2011-9-5
 * @param <T>
 * @param <ID>
 * @author JemiZhuu(周士淳)
 */
public class BaseHibernateDao<T, ID extends Serializable> extends HibernateDao<T, ID> implements BaseEntityDao<T, ID> {

	/**
	 * 通过子类的泛型定义取得对象类型Class.
	 * eg.
	 * public class UserDao extends HibernateDao<User, Long>{
	 * }
	 */
	public BaseHibernateDao() {
		super();
	}

	public BaseHibernateDao(Class<T> entityClass) {
		super(entityClass);
	}
}