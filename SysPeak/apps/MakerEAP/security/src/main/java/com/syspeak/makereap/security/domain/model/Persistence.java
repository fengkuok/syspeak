/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syspeak.makereap.security.domain.model;

import java.io.Serializable;

public interface Persistence<ID extends Serializable> extends Serializable,Insertable{

	/**
	 * identity for persistence
	 */
	public ID getIdentity( );

}
