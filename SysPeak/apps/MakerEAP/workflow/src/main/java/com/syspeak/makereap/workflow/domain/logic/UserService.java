package com.syspeak.makereap.workflow.domain.logic;

import org.springframework.stereotype.Service;

import com.syspeak.makereap.workflow.dao.hibernate.UserDao;
import com.syspeak.makereap.workflow.domain.entity.account.User;
import com.syspeak.modules.service.BaseEntityServiceImpl;

/**
 * 用户实体Service
 * @company ZSword (C) Copyright
 * @author JemiZhuu(周士淳)
 * @category UserService
 * @version 1.0
 * @since 2011-9-9
 */
@Service
public class UserService extends BaseEntityServiceImpl<User, Long, UserDao> {

}
