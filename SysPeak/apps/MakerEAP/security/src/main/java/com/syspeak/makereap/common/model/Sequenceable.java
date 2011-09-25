package com.syspeak.makereap.common.model;


/**
 * 序号生成接口
 */
public interface Sequenceable {

    /**
     * 序号KEY
     */
    public String getSequenceKey();

    /**
     * 流水号步长
     */
    public int getSequenceStep();

    /**
     * 流水号长度
     */
    public int getSequenceLength();

}
