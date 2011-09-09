package com.syspeak.makereap.workflow.unit.service.account;

import static org.junit.Assert.fail;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springside.modules.test.utils.ShiroTestUtils;

import com.syspeak.makereap.workflow.dao.hibernate.UserDao;
import com.syspeak.makereap.workflow.domain.logic.AccountManager;
import com.syspeak.modules.service.ServiceException;

/**
 * SecurityEntityManager的测试用例, 测试Service层的业务逻辑.
 * 
 * @author calvin
 */
public class AccountManagerTest {

	private IMocksControl control = EasyMock.createControl();

	private AccountManager accountManager;
	private UserDao mockUserDao;

	@Before
	public void setUp() {
		accountManager = new AccountManager();
		mockUserDao = control.createMock(UserDao.class);
		accountManager.setUserDao(mockUserDao);
		ShiroTestUtils.mockSubject("foo");
	}

	@After
	public void tearDown() {
		control.verify();
		ShiroTestUtils.clearSubject();
	}

	@Test
	public void deleteUser() {
		mockUserDao.delete(2L);
		control.replay();

		//正常删除用户.
		accountManager.deleteUser(2L);

		//删除超级管理用户抛出异常.
		try {
			accountManager.deleteUser(1L);
			fail("expected ServicExcepton not be thrown");
		} catch (ServiceException e) {
			//expected exception
		}
	}
}
