package com.syspeak.makereap.system.sequence.service;


import com.syspeak.makereap.common.model.Sequenceable;
import com.syspeak.makereap.common.service.Manager;
import com.syspeak.makereap.system.sequence.entity.Sequence;

/**
 * Sequence Manager
 *
 */
public interface SequenceManager extends Manager {

	/**
	 * 下一个序列号码
	 */
	public String nextSequenceNumber( Sequenceable sa );

	/**
	 * 下一个格式化的流水号
	 */
	public String nextSerialNumber(Sequenceable sa );

	/**
	 * 下一个序列
	 */
	public Sequence nextSequence(Sequenceable sa );

	/**
	 * 下一个序列
	 */
	public Sequence nextSequence(String key ,int step );

	/**
	 * 下一个序列
	 */
	public Sequence nextSequence(String key );

}
