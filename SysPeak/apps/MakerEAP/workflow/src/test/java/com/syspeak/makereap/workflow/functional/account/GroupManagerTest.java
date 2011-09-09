package com.syspeak.makereap.workflow.functional.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springside.modules.test.groups.Groups;

import com.syspeak.makereap.workflow.data.AccountData;
import com.syspeak.makereap.workflow.domain.entity.account.Group;
import com.syspeak.makereap.workflow.functional.BaseFunctionalTestCase;
import com.syspeak.makereap.workflow.functional.Gui;
import com.syspeak.makereap.workflow.functional.Gui.GroupColumn;

/**
 * 权限组管理的功能测试,测 试页面JavaScript及主要用户故事流程.
 * 
 * @author calvin
 */
public class GroupManagerTest extends BaseFunctionalTestCase {

	/**
	 * 查看权限组列表.
	 */
	@Groups(DAILY)
	@Test
	public void viewGroupList() {
		s.clickTo(By.linkText(Gui.MENU_GROUP));
		WebElement table = s.findElement(By.xpath("//table[@id='contentTable']"));
		assertEquals("管理员", s.getTable(table, 1, GroupColumn.NAME.ordinal()));
		assertEquals("查看用戶,修改用户,查看权限组,修改权限组", s.getTable(table, 1, GroupColumn.PERMISSIONS.ordinal()));
	}

	/**
	 * 创建权限组.
	 */
	@Groups(DAILY)
	@Test
	public void createGroup() {
		s.clickTo(By.linkText(Gui.MENU_GROUP));
		s.clickTo(By.linkText("增加新权限组"));

		//生成测试数据
		Group group = AccountData.getRandomGroupWithPermissions();

		//输入数据
		s.type(By.id("name"), group.getName());
		for (String permission : group.getPermissionList()) {
			s.check(By.id("checkedPermissions-" + permission));
		}
		s.clickTo(By.xpath(Gui.BUTTON_SUBMIT));

		//校验结果
		assertTrue(s.isTextPresent("保存权限组成功"));
		verifyGroup(group);
	}

	private void verifyGroup(Group group) {
		s.clickTo(By.linkText(Gui.MENU_GROUP));
		s.clickTo(By.id("editLink-" + group.getName()));

		assertEquals(group.getName(), s.getText(By.id("name")));

		for (String permission : group.getPermissionList()) {
			assertTrue(s.isChecked(By.id("checkedPermissions-" + permission)));
		}

		List<String> uncheckPermissionList = ListUtils.subtract(AccountData.getDefaultPermissionList(),
				group.getPermissionList());
		for (String permission : uncheckPermissionList) {
			assertFalse(s.isChecked(By.id("checkedPermissions-" + permission)));
		}
	}
}
