package com.syspeak.makereap.common.entity;

/**
 *
 */
public interface Insertable {
	
	/**
	 * 插入之前所做的操作
	 */
	void preInsert( );
	
	/**
	 * 插入失败所做的操作
	 */
	void postInsertFailure( );
	
	/**
	 * 判断是否插入值
	 */
	boolean isInsert( );

}
