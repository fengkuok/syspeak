package com.syspeak.modules.domain.logic.framework;

import java.io.Serializable;
import java.util.List;

import org.springside.modules.orm.Page;

//T extends AbstractEntity
public interface AbstractService<T,PK extends Serializable> {
	
	/**
	 * Find entity by technical id.
	 * 
	 * @param id
	 *            id
	 * @return user
	 */
	T find(PK id);
	
	List<T> findAll();

	/**
	 * Delete the entity out the database.
	 * 
	 * @param entity
	 *            entity
	 */
	void delete(final T entity);
	
	void delete(final PK id); 
	
	void batchDelete(final String ids);

	/**
	 * * Store or update the entity in the database.
	 * 
	 * @param entity
	 *            entity
	 * @return
	 */
	void saveOrUpdate(T entity);

	void refresh(T entity);
	
	Page<T> pagedQuery(Page<T> page);

}
