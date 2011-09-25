package com.syspeak.makereap.common.dao.cache;


import com.syspeak.makereap.common.dao.Dao;
import com.syspeak.makereap.common.entity.Persistence;
import com.syspeak.makereap.common.model.page.Page;
import com.syspeak.makereap.common.model.page.PageRequest;
import com.syspeak.makereap.common.model.page.PropertyFilter;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * EhCache DAO
 */
public class EhCacheDao<T extends Persistence<?>> implements Dao<T> {


    @Override
    public void save(T entity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(T entity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(Serializable id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T get(Serializable id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<T> get(Collection<Serializable> ids) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<T> getAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<T> getAll(String orderByProperty, boolean isAsc) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<T> findBy(String propertyName, Object value) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T findUniqueBy(String propertyName, Object value) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <X> List<X> find(String hql, Object... values) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <X> List<X> find(String hql, Map<String, ?> values) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <X> X findUnique(String hql, Object... values) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <X> X findUnique(String hql, Map<String, ?> values) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int batchExecute(String hql, Object... values) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int batchExecute(String hql, Map<String, ?> values) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void initProxyObject(Object proxy) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void flush() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getIdName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isPropertyUnique(String propertyName, Object newValue, Object oldValue) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Page<T> getAll(PageRequest pageRequest) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Page<T> findPage(PageRequest pageRequest, String hql, Object... values) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Page<T> findPage(PageRequest pageRequest, String hql, Map<String, ?> values) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<T> findBy(String propertyName, Object value, PropertyFilter.MatchType matchType) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<T> find(List<PropertyFilter> filters) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Page<T> findPage(PageRequest pageRequest, List<PropertyFilter> filters) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
