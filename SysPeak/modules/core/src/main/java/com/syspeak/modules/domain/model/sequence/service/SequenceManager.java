package com.syspeak.modules.domain.model.sequence.service;

import com.syspeak.modules.domain.model.Sequenceable;
import com.syspeak.modules.domain.model.sequence.Sequence;

/**
 * Sequence Manager
 */
public interface SequenceManager extends Manager {

	/**
	 * 下一个序列号码
	 */
	public String nextSequenceNumber(Sequenceable sa);

	/**
	 * 下一个格式化的流水号
	 */
	public String nextSerialNumber(Sequenceable sa);

	/**
	 * 下一个序列
	 */
	public Sequence nextSequence(Sequenceable sa);

	/**
	 * 下一个序列
	 */
	public Sequence nextSequence(String key, int step);

	/**
	 * 下一个序列
	 */
	public Sequence nextSequence(String key);

}
