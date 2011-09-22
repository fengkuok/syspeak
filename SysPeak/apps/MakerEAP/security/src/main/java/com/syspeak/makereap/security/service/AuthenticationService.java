package com.syspeak.makereap.security.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;


/**
 * 为缓存提供 User 和 Resource 实例.
 * 来自www.springside.org.cn
 *
 * @author cac
 * @author Lingo
 * @since 2007-03-22
 * @version 1.0
 */
public interface AuthenticationService {
    /**
     * 获得所有用户.
     *
     * @return List
     */
    List<UserDetails> getUsers();

    /**
     * 获得所有资源.
     *
     * @return List
     */
//    List<Resource> getResources();
}
