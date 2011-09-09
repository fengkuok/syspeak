package com.syspeak.makereap.workflow.functional;

import java.util.Properties;

import javax.sql.DataSource;

import org.eclipse.jetty.server.Server;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springside.modules.test.data.Fixtures;
import org.springside.modules.test.functional.JettyFactory;
import org.springside.modules.test.functional.Selenium2;
import org.springside.modules.test.functional.WebDriverFactory;
import org.springside.modules.test.groups.GroupsTestRunner;
import org.springside.modules.utils.PropertiesUtils;
import org.springside.modules.utils.spring.SpringContextHolder;

import com.syspeak.makereap.workflow.Start;

/**
 * 功能测试基类.
 * 
 * 在整个测试期间启动一次Jetty Server, 并在每个TestCase执行前重新载入默认数据, 创建WebDriver.
 * 
 * @author calvin
 */
@Ignore
@RunWith(GroupsTestRunner.class)
public class BaseFunctionalTestCase {

	//Test Groups define
	public final static String DAILY = "DAILY";
	public final static String NIGHTLY = "NIGHTLY";

	protected static Server jettyServer;

	protected static DataSource dataSource;

	protected static Selenium2 s;

	@BeforeClass
	public static void startAll() throws Exception {
		startJetty();
		reloadSampleData();
		createSelenium();
		loginAsAdminIfNecessary();
	}

	@AfterClass
	public static void stopAll() throws Exception {
		quitSelenium();
	}

	/**
	 * 启动Jetty服务器, 仅启动一次.
	 */
	protected static void startJetty() throws Exception {
		if (jettyServer == null) {
			jettyServer = JettyFactory.buildTestServer(Start.PORT, Start.CONTEXT);
			jettyServer.start();

			dataSource = SpringContextHolder.getBean("dataSource");
		}
	}

	/**
	 * 载入测试数据.
	 */
	protected static void reloadSampleData() throws Exception {
		Fixtures.reloadAllTable(dataSource, "/data/sample-data.xml");
	}

	/**
	 * 创建Selenium.
	 */
	protected static void createSelenium() throws Exception {
		Properties props = PropertiesUtils.loadProperties("classpath:/application.test.properties",
				"classpath:/application.test-local.properties");
		WebDriver driver = WebDriverFactory.createDriver(props.getProperty("selenium.driver"));

		s = new Selenium2(driver, Start.BASE_URL);
	}

	/**
	 * 退出Selenium.
	 */
	protected static void quitSelenium() {
		s.quit();
	}

	/**
	 * 登录管理员,如果用户还没有登录.
	 */
	protected static void loginAsAdminIfNecessary() {
		s.open("/account/user.action");

		if ("Mini-Web 登录页".equals(s.getTitle())) {
			s.type(By.name("username"), "admin");
			s.type(By.name("password"), "admin");
			s.clickTo(By.xpath(Gui.BUTTON_LOGIN));
		}
	}
}