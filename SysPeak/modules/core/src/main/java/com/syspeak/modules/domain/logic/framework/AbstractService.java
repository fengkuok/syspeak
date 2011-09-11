package com.syspeak.modules.domain.logic.framework;

import org.springside.modules.orm.Page;

import com.syspeak.modules.domain.model.AbstractEntity;

public interface AbstractService<T extends AbstractEntity> {
	public static String SUCCESS = "success";
	public static String ERROR = "error";
//	public static String 
	
	/**
	 * Find entity by technical id.
	 * 
	 * @param id
	 *            id
	 * @return user
	 */
	T find(Long id);

	/**
	 * Delete the entity out the database.
	 * 
	 * @param entity
	 *            entity
	 */
	String remove(T entity);

	/**
	 * * Store or update the entity in the database.
	 * 
	 * @param entity
	 *            entity
	 * @return
	 */
	String saveOrUpdate(T entity);

	void refresh(T entity);
	
	Page<T> pagedQuery(Page<T> page);

}
