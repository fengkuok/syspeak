package com.syspeak.itboss.service;

import org.springframework.stereotype.Service;

import com.syspeak.itboss.dao.PermissionDao;
import com.syspeak.itboss.domain.Permission;
import com.syspeak.modules.service.BaseStringIdEntityServiceImpl;

/**
 * 
 * @company SysPeak (C) Copyright
 * @category PermissionService
 * @version 1.0
 * @since 2011-9-29
 * @author JemiZhuu(周士淳)
 */
@Service
public class PermissionService extends BaseStringIdEntityServiceImpl<Permission, PermissionDao> {
}
