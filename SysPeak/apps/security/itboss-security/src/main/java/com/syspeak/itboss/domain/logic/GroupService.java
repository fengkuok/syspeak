package com.syspeak.itboss.domain.logic;

import org.springframework.stereotype.Service;

import com.syspeak.itboss.dao.GroupDao;
import com.syspeak.itboss.domain.model.Group;
import com.syspeak.modules.service.BaseLongIdEntityServiceImpl;

/**
 * 
 * @company SysPeak (C) Copyright
 * @category GroupService
 * @version 1.0
 * @since 2011-9-29
 * @author JemiZhuu(周士淳)
 */
@Service
public class GroupService extends BaseLongIdEntityServiceImpl<Group, GroupDao> {
}
