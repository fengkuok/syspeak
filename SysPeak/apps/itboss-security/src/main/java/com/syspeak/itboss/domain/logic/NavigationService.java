package com.syspeak.itboss.domain.logic;

import org.springframework.stereotype.Service;

import com.syspeak.itboss.dao.NavigationDao;
import com.syspeak.itboss.domain.model.Navigation;
import com.syspeak.modules.service.BaseLongIdEntityServiceImpl;

/**
 * 
 * @company SysPeak (C) Copyright
 * @category NavigationService
 * @version 1.0
 * @since 2011-9-29
 * @author JemiZhuu(周士淳)
 */
@Service
public class NavigationService extends BaseLongIdEntityServiceImpl<Navigation, NavigationDao> {
}
