package com.syspeak.itboss.domain.logic;

import org.springframework.stereotype.Service;

import com.syspeak.itboss.dao.CategoryDao;
import com.syspeak.itboss.domain.model.Category;
import com.syspeak.modules.service.BaseLongIdEntityServiceImpl;

/**
 * 
 * @company SysPeak (C) Copyright
 * @category CategoryService
 * @version 1.0
 * @since 2011-9-29
 * @author JemiZhuu(周士淳)
 */
@Service
public class CategoryService extends BaseLongIdEntityServiceImpl<Category, CategoryDao> {
}
