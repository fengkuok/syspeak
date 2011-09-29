package com.syspeak.itboss.service;

import org.springframework.stereotype.Service;

import com.syspeak.itboss.dao.SiteDao;
import com.syspeak.itboss.domain.Site;
import com.syspeak.modules.service.BaseLongIdEntityServiceImpl;

/**
 * 
 * @company SysPeak (C) Copyright
 * @category SiteService
 * @version 1.0
 * @since 2011-9-29
 * @author JemiZhuu(周士淳)
 */
@Service
public class SiteService extends BaseLongIdEntityServiceImpl<Site, SiteDao> {
}
