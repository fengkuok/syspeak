package com.syspeak.makereap.common.service;


/**
 * Service层公用的Exception.
 * 继承自RuntimeException, 从由Spring管理事务的函数中抛出时会触发事务回滚.
 *
 * @author JemiZhuu(周士淳)
 * @version 1.0
 * @company ZSword (C) Copyright
 * @category ServiceException
 * @since 2011-9-9
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 3583566093089790852L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
