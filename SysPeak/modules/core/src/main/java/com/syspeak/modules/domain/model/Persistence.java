package com.syspeak.modules.domain.model;

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
