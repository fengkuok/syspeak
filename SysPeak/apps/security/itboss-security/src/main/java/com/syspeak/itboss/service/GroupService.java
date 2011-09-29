package com.syspeak.itboss.service;

import com.syspeak.itboss.domain.Group;
import com.syspeak.itboss.domain.Permission;
import com.syspeak.itboss.domain.Role;
import com.syspeak.itboss.domain.User;

import java.util.Set;

/**
 * 
 * @company SysPeak (C) Copyright
 * @category GroupService
 * @version 1.0
 * @since 2011-9-29
 * @author JemiZhuu(周士淳)
 */
public interface GroupService {

    /**
     * 为当前系统建立根组织
     *
     * @return 当前系统的根组织
     * @throws SecurityException
     */
    public Group addRootGroup(Group group) throws SecurityException;

    /**
     * 取得当前系统中的根组织
     *
     * @return 当前系统的根组织
     * @throws SecurityException
     */
    public Group getRootGroup() throws SecurityException;

    /**
     * 增加组织
     *
     * @param group 增加组织
     * @param parentGroupId 父组织
     * @return Group
     * @throws SecurityException
     */
    public Group addGroup(Group group, int parentGroupId) throws SecurityException;


    /**
     * 修改组织信息
     *
     * @param group 组织信息
     * @throws SecurityException
     */
    public void modifyGroup(Group group) throws SecurityException;

    /**
     * 删除某个组织
     * @param groupId 组织id
     * @throws SecurityException
     */
    public void removeGroup(int groupId) throws SecurityException;

    /**
     * 计算组织数量
     *
     * @return int 组织数量
     * @throws SecurityException
     */
    public int count() throws SecurityException;

    /**
     * 根据条件计算组织数量
     * @return int 组织数量
     * @throws SecurityException
     */
    public int count(Group group, int groupId) throws SecurityException;

    /**
     * 功能：根据ID得到相应组织实例
     *
     * @param groupId 组织id
     * @return Group 组织
     * @throws SecurityException
     */
    public Group getGroup(int groupId) throws SecurityException;

    /**
     * 功能：根据组织编码得到相应组织实例
     *
     * @param code 组织编码
     * @return Group 组织
     * @throws SecurityException
     */
    public Group getGroup(String code) throws SecurityException;

    /**
     * 取得某个组织中用户的数量
     * 如loginName为 "" 或 null， 则计算组织中所有用户数量；否则使用 '%"+loginName+"%'模糊查找用户
     * @param loginName 用户登陆名前缀
     * @param groupId 组织id
     * @param loginName
     * @return int    用户数量
     * @throws SecurityException
     */
    public int getUserCountFromGroup(String loginName, int groupId) throws SecurityException;

    /**
     * 判断某个组织名是否已经被使用(在同一个父组织下，同一级组织名不得重复)
     *
     * @param groupName 组织名
     * @param parentId 上级组织id
     * @return boolean  存在为true,不存在为false
     */
    public boolean hasGroup(String groupName, int parentId);

    /**
     * 判断某个组织名是否已经被使用
     *
     * @param groupName 组织名
     * @return boolean  存在为true,不存在为false
     */
    public boolean hasGroup(String groupName);

    /**
     * 取下属组织，不包含嵌套
     *
     *
     * @param parentGroupId 父组织
     * @return GoupSet 组织集合
     * @throws SecurityException
     */
    public Set<Group> getChildGroups(int parentGroupId) throws SecurityException;

    /**
     * 取下属组织，包含嵌套
     *
     * @param parentGroupId 父组织
     * @return GoupSet 组织集合
     */
    public Set<Group> getNestGroups(int parentGroupId) throws SecurityException;

    /**
     * 取下属组织，不包含嵌套,实现分页
     *
     *
     * @param parentGroupId 父组织
     * @param offset 页码
     * @param size   每页数量
     * @return GoupSet 组织集合
     * @throws SecurityException
     */
    public Set<Group> getChildGroups(int parentGroupId, int offset, int size) throws SecurityException;

    /**
     * 取下属组织，包含嵌套 (分页)
     *
     * @param parentGroupId 父组织
     * @param offset 页码
     * @param size   每页数量
     * @return GoupSet 组织集合
     */
    public Set<Group> getNestGroups(int parentGroupId, int offset, int size) throws SecurityException;

    /**
     * 取得某个组织中角色的数量
     * 如roleName为 "" 或 null， 则计算组织中所有角色数量；否则使用 '%"+roleName+"%'模糊查找角色
     * @param roleName 角色名前缀
     * @param groupId 组织id
     * @return 角色数量
     * @throws SecurityException
     */
    public int getRoleCountFromGroup(String roleName, int groupId) throws SecurityException;

    /**
     * 删除组织中的若干用户的关系
     * 操作：删除当前组织与User的关系，如果当前User不再属于其他组，则将User删除
     *
     * @param groupId 组织id
     * @param userSet 用户集合
     * @throws SecurityException
     */
    public void removeUsersFromGroup(int groupId, Set<User> userSet) throws SecurityException;

    /**
     * 用户是否在组织中
     * @param userId 用户ID
     * @param groupId 组织ID
     * @return boolean 存在为true,不存在为false
     */
    public boolean hasUser(int userId, int groupId) throws SecurityException;

    /**
     * 删除组织对应的若干角色的关系
     * 如果当前组织是Role的创建组织（由Role的GroupId属性取得），则彻底删除Role，包括删除与Role相关的其他组织关系；
     *
     * @param groupId 组织
     * @param roleSet 角色集合
     * @throws SecurityException
     */
    public void removeRolesFromGroup(int groupId, Set<Role> roleSet) throws SecurityException;

    /**
     * 添加一批用户到一个组中
     *
     * @param userSet 用户集合
     * @param groupId 目标组织
     * @throws SecurityException
     */
    public void addUsersToGroup(Set<User> userSet, int groupId) throws SecurityException;

    /**
     * 添加一批角色到一个组中
     *
     * @param roleSet 角色集合
     * @param groupId 目标组织
     * @throws SecurityException
     */
    public void addRolesToGroup(Set<Role> roleSet, int groupId) throws SecurityException;

    /**
     * 取得某个组织中的所有用户,实现分页
     * 如name为 "" 或 null， 则取组织中所有用户数量；否则使用 '%"+name+"%'模糊查找用户
     * @param name 登陆名前缀
     * @param groupId 组织ID
     * @param offset 页码
     * @param size   每页数量
     * @return Set<User> 用户信息集合
     * @throws SecurityException
     */
    public Set<User> getUsersFromGroup(String name, int groupId, int offset, int size) throws SecurityException;

    /**
     * 取得某个组织中的所有用户
     * 如name为 "" 或 null， 则取组织中所有用户数量；否则使用 '%"+name+"%'模糊查找用户
     * @param name 登陆名前缀
     * @param groupId 组织编号
     * @return Set<User> 用户信息集合
     * @throws SecurityException
     */
    public Set<User> getUsersFromGroup(String name, int groupId) throws SecurityException;

    /**
     * 按组织取可分配的角色集合
     *
     * @param groupId 组织
     * @return RoleSet  角色集合
     * @throws SecurityException
     */
    public Set<Role> getRolesFromGroup(int groupId) throws SecurityException;

    /**
     * 取系统所有组织
     *
     * @return GroupSet  组织集合
     * @throws SecurityException
     */
    public Set<Group> getAllGroup() throws SecurityException;


    /**
     * 按组织取可分配的角色集合,实现分页
     *
     * @param groupId 组织
     * @param offset 页码
     * @param size   每页数量
     * @return RoleSet  角色集合
     * @throws SecurityException
     */
    public Set<Role> getRolesFromGroup(int groupId, int offset, int size) throws SecurityException;

    /**
     * 判断某个组织名是否已经被使用
     *
     * @param groupId 组织ID
     * @return boolean 存在为true,不存在为false
     */
    public boolean hasGroup(int groupId);

    /**
     * 删除组织中的所有用户的关系
     *
     * @param groupId 组织ID
     * @throws SecurityException
     */
    public void removeAllUserFromGroup(int groupId) throws SecurityException;

    /**
     * 删除组织对应的所有角色的关系
     *
     * @param groupId 组ID
     * @throws SecurityException
     */
    public void removeAllRoleFromGroup(int groupId) throws SecurityException;

    /**
     * 用户是否在组织中
     * @param userName 用户名
     * @param groupId 组ID
     * @return boolean 存在为true,不存在为false
     */
    public boolean hasUser(String userName, int groupId);

    /**
     * 角色是否在组织中
     * @param roleId 角色ID
     * @param groupId 组ID
     * @return boolean 存在为true,不存在为false
     */
    public boolean hasRole(int roleId, int groupId);

    /**
     * 角色是否在组织中
     * @param roleName 角色名
     * @param groupId 组ID
     * @return boolean 存在为true,不存在为false
     */
    public boolean hasRole(String roleName, int groupId);

    /**
     * 向组织中增加一批权限
     *
     * @param permSet  权限集合
     * @param groupId  组织id
     * @throws SecurityException
     */
    public void addPermissionsToGroup( Set<Permission> permSet, int groupId) throws SecurityException;

    /**
     * 从组织中删除一批权限
     *
     * @param permSet  权限集合
     * @param groupId  组织id
     * @throws SecurityException
     */
    public void removePermissionsFromGroup(Set<Permission> permSet, int groupId) throws SecurityException;

    /**
     * 从组织中删除所有权限
     *
     * @param groupId  组织id
     * @throws SecurityException
     */
    public void removeAllPermissionsFromGroup(int groupId) throws SecurityException;

    /**
     * 取得某个组织下的所有权限
     *
     * @param groupId  组织id
     * @return Set<Permission> 权限集合
     * @throws SecurityException
     */
    public Set<Permission> getPermissionsFromGroup(int groupId) throws SecurityException;

    /**
     * 取得组织下的省缺角色
     *
     * @param groupId  组织id
     * @return Role 省缺角色
     * @throws SecurityException
     */
    public Role getDefaultRoleFromGroup(int groupId) throws SecurityException;

    /**
     * 计算下级组织数量
     * @param parentGroupId     父组织id
     * @return   下级组织数量
     * @throws SecurityException
     */
    public int countChildGroups(int parentGroupId) throws SecurityException;

    /**
     * 取的指定组织的父组织
     * @param groupId  组织id
     * @return    父组织
     * @throws SecurityException
     */
    public Group getParentGroup(int groupId) throws SecurityException;

    /**
     * 在父组织下查找下级组织（支持分页）
     * @param group            组织（用于组织查询条件）
     * @param groupId         父组织id
     * @param offset             页号
     * @param size                每页显示记录数
     * @return    组织集和
     * @throws SecurityException
     */
    public Set<Group> searchGroup(Group group, int groupId, int offset, int size) throws SecurityException;

}
