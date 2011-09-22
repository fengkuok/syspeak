package com.syspeak.makereap.security.api.module;

import java.util.List;

/***
 * 
 * @author GuoFeng
 *
 */
public interface Menu {
	
	String getId();
	
	Menu getParent();
	
	List<Menu> getChilds();
	
	
}
