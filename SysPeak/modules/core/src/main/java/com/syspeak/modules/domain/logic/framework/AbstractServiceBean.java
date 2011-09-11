package com.syspeak.modules.domain.logic.framework;

import org.springside.modules.orm.Page;

import com.syspeak.modules.domain.model.AbstractEntity;

public abstract class AbstractServiceBean<T extends AbstractEntity> implements AbstractService<T> {

	public abstract Page<T> pagedQuery(Page<T> page);
	
	public abstract T find(Long id);

	public abstract String remove(T entity);

	public abstract String saveOrUpdate(T entity);

	public abstract void refresh(T entity);
	
	

}
