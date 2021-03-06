package com.syspeak.makereap.common.dao.cache;


import com.syspeak.makereap.common.dao.DaoException;

/**
 * Cache Exception
 */
public class CacheException extends DaoException {

    private static final long serialVersionUID = 1944110147460938093L;

    public CacheException() {
        super();
    }

    public CacheException(String message, Throwable cause) {
        super(message, cause);
    }

    public CacheException(String message) {
        super(message);
    }

    public CacheException(Throwable cause) {
        super(cause);
    }

}
