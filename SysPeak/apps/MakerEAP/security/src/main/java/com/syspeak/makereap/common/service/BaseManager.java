package com.syspeak.makereap.common.service;


import com.syspeak.makereap.common.entity.Persistence;
import com.syspeak.makereap.common.model.page.Page;
import com.syspeak.makereap.common.model.page.PageRequest;
import com.syspeak.makereap.common.model.page.PropertyFilter;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * base manager
 */
public interface BaseManager<T extends Persistence<?>> extends Manager {
    /**
     * 保存新增或修改的对象.
     */
    public abstract void save(final T entity);

    /**
     * 删除对象.
     *
     * @param entity 对象必须是session中的对象或含id属性的transient对象.
     */
    public abstract void delete(final T entity);

    /**
     * 按id删除对象.
     */
    public abstract void delete(final Serializable id);

    /**
     * 按id获取对象.
     */
    public abstract T get(final Serializable id);

    /**
     * 按id列表获取对象列表.
     */
    public abstract List<T> get(final Collection<Serializable> ids);

    /**
     * 获取全部对象.
     */
    public abstract List<T> getAll();

    /**
     * 获取全部对象, 支持按属性行序.
     */
    public abstract List<T> getAll(String orderByProperty, boolean isAsc);

    /**
     * 按属性查找对象列表, 匹配方式为相等.
     */
    public abstract List<T> findBy(final String propertyName, final Object value);

    /**
     * 按属性查找唯一对象, 匹配方式为相等.
     */
    public abstract T findUniqueBy(final String propertyName, final Object value);

    /**
     * 按HQL查询对象列表.
     *
     * @param values 数量可变的参数,按顺序绑定.
     */
    public abstract <X> List<X> find(final String hql, final Object... values);

    /**
     * 按HQL查询对象列表.
     *
     * @param values 命名参数,按名称绑定.
     */
    public abstract <X> List<X> find(final String hql, final Map<String, ?> values);

    /**
     * 按HQL查询唯一对象.
     *
     * @param values 数量可变的参数,按顺序绑定.
     */
    public abstract <X> X findUnique(final String hql, final Object... values);

    /**
     * 按HQL查询唯一对象.
     *
     * @param values 命名参数,按名称绑定.
     */
    public abstract <X> X findUnique(final String hql, final Map<String, ?> values);

    /**
     * 执行HQL进行批量修改/删除操作.
     *
     * @param values 数量可变的参数,按顺序绑定.
     * @return 更新记录数.
     */
    public abstract int batchExecute(final String hql, final Object... values);

    /**
     * 执行HQL进行批量修改/删除操作.
     *
     * @param values 命名参数,按名称绑定.
     * @return 更新记录数.
     */
    public abstract int batchExecute(final String hql, final Map<String, ?> values);

    /**
     * 初始化对象.
     * 使用load()方法得到的仅是对象Proxy, 在传到View层前需要进行初始化.
     * 如果传入entity, 则只初始化entity的直接属性,但不会初始化延迟加载的关联集合和属性.
     * 如需初始化关联属性,需执行:
     * Hibernate.initialize(user.getRoles())，初始化User的直接属性和关联集合.
     * Hibernate.initialize(user.getDescription())，初始化User的直接属性和延迟加载的Description属性.
     */
    public abstract void initProxyObject(Object proxy);

    /**
     * Flush当前Session.
     */
    public abstract void flush();

    /**
     * 取得对象的主键名.
     */
    public abstract String getIdName();

    /**
     * 判断对象的属性值在数据库内是否唯一.
     * <p/>
     * 在修改对象的情景下,如果属性新修改的值(value)等于属性原来的值(orgValue)则不作比较.
     */
    public abstract boolean isPropertyUnique(final String propertyName, final Object newValue, final Object oldValue);

    /**
     * 分页获取全部对象.
     */
    public abstract Page<T> getAll(final PageRequest pageRequest);

    /**
     * 按HQL分页查询.
     *
     * @param pageRequest 分页参数.
     * @param hql         hql语句.
     * @param values      数量可变的查询参数,按顺序绑定.
     * @return 分页查询结果, 附带结果列表及所有查询输入参数.
     */
    public abstract Page<T> findPage(final PageRequest pageRequest, String hql, final Object... values);

    /**
     * 按HQL分页查询.
     *
     * @param page   分页参数.
     * @param hql    hql语句.
     * @param values 命名参数,按名称绑定.
     * @return 分页查询结果, 附带结果列表及所有查询输入参数.
     */
    public abstract Page<T> findPage(final PageRequest pageRequest, String hql, final Map<String, ?> values);

    /**
     * 按属性查找对象列表,支持多种匹配方式.
     *
     * @param matchType 匹配方式,目前支持的取值见PropertyFilter的MatcheType enum.
     */
    public abstract List<T> findBy(final String propertyName, final Object value, final PropertyFilter.MatchType matchType);

    /**
     * 按属性过滤条件列表查找对象列表.
     */
    public abstract List<T> find(List<PropertyFilter> filters);

    /**
     * 按属性过滤条件列表分页查找对象.
     */
    public abstract Page<T> findPage(final PageRequest pageRequest, final List<PropertyFilter> filters);

}
