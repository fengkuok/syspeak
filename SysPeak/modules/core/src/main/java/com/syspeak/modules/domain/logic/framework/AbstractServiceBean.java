package com.syspeak.modules.domain.logic.framework;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springside.modules.orm.Page;

public abstract class AbstractServiceBean<T, PK extends Serializable>
		implements AbstractService<T, PK> {

//	private EntityManager entityManager;
	
	@Resource
	private SessionFactory sessionFactory;
	
	protected final Class<T> clazz;
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	

	@SuppressWarnings("unchecked")
	public AbstractServiceBean() {
		this.clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	/**
	 * 取得当前Session.
	 */
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
//	private boolean isManaged(final T entity) {
//		return entity.getId() == null ? false : true;
//		return false;
//	}

	@SuppressWarnings("unchecked")
	@Override
	public final T find(PK id) {
		
		assert this.clazz != null : "clazz != null";
		
		return (T) this.getSession().load(this.clazz, id);
	}
	

	@Override
	public void delete(T entity) {
		
		assert entity != null : "entity不能为空";
		
		this.getSession().delete(entity);
		logger.debug("delete entity: {}", entity);
	}

	@Override
	public void delete(PK id) {
		this.delete(this.find(id));
		logger.debug("delete entity {},id is {}", this.clazz.getSimpleName(), id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void batchDelete(String ids) {
		
		assert ids != null : "ids不能为空";
		
		for(String id : ids.split(",")){
			this.delete((PK) id);
		}
		logger.debug("delete entity {},ids is {}", this.clazz.getSimpleName(), ids);
	}

	@Override
	public void saveOrUpdate(T entity) {
		assert entity != null : "entity != null";

		this.getSession().saveOrUpdate(entity);
		
		assert this.getSession().contains(entity);

	}

	@Override
	public void refresh(T entity) {
		this.getSession().refresh(entity);
		logger.debug("refresh entity: {}", entity);
	}

	@Override
	public Page<T> pagedQuery(Page<T> page) {
		// TODO Auto-generated method stub
		return null;
	}

}
