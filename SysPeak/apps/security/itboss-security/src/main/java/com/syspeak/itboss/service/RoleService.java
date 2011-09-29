package com.syspeak.itboss.service;

import org.springframework.stereotype.Service;

import com.syspeak.itboss.dao.RoleDao;
import com.syspeak.itboss.domain.Role;
import com.syspeak.modules.service.BaseLongIdEntityServiceImpl;

/**
 * 
 * @company SysPeak (C) Copyright
 * @category RoleService
 * @version 1.0
 * @since 2011-9-29
 * @author JemiZhuu(周士淳)
 */
@Service
public class RoleService extends BaseLongIdEntityServiceImpl<Role, RoleDao> {
}
