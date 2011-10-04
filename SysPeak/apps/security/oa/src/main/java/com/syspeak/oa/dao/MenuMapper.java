package com.syspeak.oa.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.syspeak.oa.domain.Menu;

@Component
public interface MenuMapper {
	public List<Menu> listMenus(int parent_id);
}
