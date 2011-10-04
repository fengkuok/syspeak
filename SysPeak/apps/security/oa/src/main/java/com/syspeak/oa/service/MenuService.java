package com.syspeak.oa.service;

import java.util.List;

import com.syspeak.oa.domain.Menu;

public interface MenuService {
	public List<Menu> listMenus();
	public List<Menu> listMenus(int parent_id);
}
