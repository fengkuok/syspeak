package com.syspeak.makereap.common.dao.hibernate;

import com.syspeak.makereap.common.dao.Dao;
import com.syspeak.makereap.common.entity.Persistence;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-25
 * Time: 下午3:23
 * To change this template use File | Settings | File Templates.
 */
public class BaseHibernateDao<T extends Persistence<?>> extends HibernateDao<T>  implements Dao<T> {
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
