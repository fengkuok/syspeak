package com.syspeak.makereap.workflow.domain.logic;

import org.springframework.stereotype.Service;

import com.syspeak.makereap.workflow.dao.hibernate.GroupDao;
import com.syspeak.makereap.workflow.domain.entity.account.Group;
import com.syspeak.modules.service.BaseEntityServiceImpl;

/**
 * 用户组实体Service
 * @company ZSword (C) Copyright
 * @author JemiZhuu(周士淳)
 * @category GroupService
 * @version 1.0
 * @since 2011-9-9
 */
@Service
public class GroupService extends BaseEntityServiceImpl<Group, Long, GroupDao> {

}
