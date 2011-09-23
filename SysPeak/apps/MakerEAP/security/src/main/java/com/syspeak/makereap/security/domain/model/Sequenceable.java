/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syspeak.makereap.security.domain.model;


/**
 * 序号生成接口
 *
 */
public interface Sequenceable {

	/**
	 * 序号KEY
	 */
	public String getSequenceKey( );

	/**
	 * 流水号步长
	 */
	public int getSequenceStep( );

	/**
	 * 流水号长度
	 */
	public int getSequenceLength( );

}