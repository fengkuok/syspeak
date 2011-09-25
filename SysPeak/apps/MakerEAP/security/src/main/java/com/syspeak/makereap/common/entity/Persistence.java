package com.syspeak.makereap.common.entity;

import java.io.Serializable;


/**
 * persistence
 */
public interface Persistence<ID extends Serializable> extends Serializable, Insertable {

    /**
     * identity for persistence
     */
    public ID getIdentity();

}
