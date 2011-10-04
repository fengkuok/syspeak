package com.syspeak.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syspeak.oa.dao.MenuMapper;
import com.syspeak.oa.domain.Menu;
import com.syspeak.oa.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;

	public List<Menu> listMenus(int parent_id) {
		List<Menu> firstMenus = menuMapper.listMenus(parent_id);
		for (Menu menu : firstMenus) {
			BuildMenuCascade(menu);
		}
		return firstMenus;
	}

	private void BuildMenuCascade(Menu menu) {
		menu.getAttribute().put("text", menu.getMenuname());
		menu.getAttribute().put("id", menu.getId());
		menu.getAttribute().put("url", menu.getUrl());
		List<Menu> children = menuMapper.listMenus(menu.getId());
		if (children.size() == 0) {
			menu.setChildren(null);
		} else {
			menu.setChildren(children);
		}
		for (Menu child : children) {
			BuildMenuCascade(child);
		}
	}

	public List<Menu> listMenus() {
		return null;
	}

}
