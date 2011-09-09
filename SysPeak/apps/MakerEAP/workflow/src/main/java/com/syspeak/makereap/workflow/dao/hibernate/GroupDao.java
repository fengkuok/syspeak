package com.syspeak.makereap.workflow.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Component;

import com.syspeak.makereap.workflow.domain.entity.account.Group;
import com.syspeak.makereap.workflow.domain.entity.account.User;
import com.syspeak.modules.dao.orm.hibernate.BaseHibernateDao;

/**
 * 用户组实体DAO
 * @company ZSword (C) Copyright
 * @author JemiZhuu(周士淳)
 * @category GroupDao
 * @version 1.0
 * @since 2011-9-9
 */
@Component
public class GroupDao extends BaseHibernateDao<Group, Long> {

	private static final String QUERY_USER_BY_GROUPID = "select u from User u left join u.groupList g where g.id=?";

	/**
	 * 重载函数, 因为Group中没有建立与User的关联,因此需要以较低效率的方式进行删除User与Group的多对多中间表中的数据.
	 */
	@Override
	public void delete(Long id) {
		Group group = get(id);
		//查询出拥有该权限组的用户,并删除该用户的权限组.
		List<User> users = createQuery(QUERY_USER_BY_GROUPID, group.getId()).list();
		for (User u : users) {
			u.getGroupList().remove(group);
		}
		super.delete(group);
	}
}
