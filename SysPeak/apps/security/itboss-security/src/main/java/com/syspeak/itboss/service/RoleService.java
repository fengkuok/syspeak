package com.syspeak.itboss.service;

import com.syspeak.itboss.domain.Group;
import com.syspeak.itboss.domain.Permission;
import com.syspeak.itboss.domain.Role;
import com.syspeak.itboss.domain.User;

import java.util.Set;

/**
 * 
 * @company SysPeak (C) Copyright
 * @category RoleService
 * @version 1.0
 * @since 2011-9-29
 * @author JemiZhuu(周士淳)
 */
public interface RoleService {

     /**
     * 增加角色（不指定组织ID时加到根组织下）
     *
     * @param role     新添加角色的值对象
     * @return void
     * @throws SecurityException
     */
    public Role addRole(Role role) throws SecurityException;

    /**
     * 增加角色
     *
     * @param role     新添加角色的值对象
     * @param groupId  该角色所属的组ID
     * @return void
     * @throws SecurityException
     */
    public Role addRole(Role role, int groupId) throws SecurityException;

    /**
     * 取得系统中所有角色
     *
     * @return RoleSet  角色集合
     * @throws SecurityException
     */
    public Set<Role> getAllRole() throws SecurityException;

//    /**
//     * 根据角色名取得角色信息
//     * 如roleName为 "" 或 null， 则取所有角色；否则使用 '%"+roleName+"%'模糊查找角色
//     * @param roleName 要查找的角色名(模糊查询)
//     * @return RoleSet 跟据角色名找到的角色集合
//     * @throws SecurityException
//     */
//    public RoleSet getRolesByName(String roleName) throws SecurityException;

    /**
     * 修改角色信息
     *
     * @param role 角色信息:Role值对象中Role.roldId为要修改的原角色ID
     * @throws SecurityException
     */
    public void modifyRole(Role role) throws SecurityException;

    /**
     * 删除某个角色
     *
     * @param roleId 删除某个角色
     * @throws SecurityException
     */
    public void removeRole(int roleId) throws SecurityException;

    /**
     * 取得角色总数
     *
     * @return int 角色数量
     * @throws SecurityException
     */
    public int count() throws SecurityException;

    /**
     * 根据条件取得角色数目
     * @return int 角色数量
     * @throws SecurityException
     */
    public int count(Role role,int groupId) throws SecurityException;

    /**
     * 取得系统中所有角色,实现分页
     *
     * @param offset 起始位置
     * @param size 集合大小
     * @return RoleSet  角色集合
     * @throws SecurityException
     */
    public Set<Role> getAllRole(int offset, int size) throws SecurityException;

    /**
     * 根据角色id取得角色信息
     *
     * @param roleId  角色id
     * @return Role   角色
     * @throws SecurityException
     */
    public Role getRole(int roleId) throws SecurityException;

//    /**
//     * 判断某个角色明是否已经被使用
//     *
//     * @param roleName 角色名
//     * @return boolean 存在为true,不存在为false
//     * @throws SecurityException
//     */
//    public boolean hasRole(String roleName) throws SecurityException;

    /**
     * 删除角色与用户的关联
     *
     * @param roleId 角色id
     * @param userSet 用户集合(User值对象中只用设置ID)
     * @throws SecurityException
     */
    public void removeUsersFromRole(int roleId,  Set<User> userSet) throws SecurityException;

//    /**
//     * 角色是否有某一项权限
//     *
//     * @param permissionName 权限名
//     * @param roleId         角色ID
//     * @return boolean       存在为true,不存在为false
//     * @throws SecurityException
//     */
//    public boolean hasPermission(String permissionName, int roleId) throws SecurityException;

    /**
     * 删除角色对应的若干组织的关系
     *
     * @param roleId 角色id
     * @param groupSet 组织集合
     * @throws SecurityException
     */
    public void removeGroupsFromRole(int roleId, Set<Group> groupSet) throws SecurityException;

    /**
     * 添加一批用户到一个角色中
     *
     * @param userSet 用户集合
     * @param roleId  角色id
     * @param groupId  组织id，说明是在哪一个组织下把角色分配给这个用户
     * @throws SecurityException
     */
    public void addUsersToRole(int roleId,Set<Group>  userSet,int groupId) throws SecurityException;

//    /**
//     * 取得某个角色中的所有用户,实现分页
//     *
//     * @param roleId 角色编号
//     * @param offset 起始位置
//     * @param size 集合大小
//     * @param roleId
//     * @return Set<User> 用户信息集合
//     * @throws SecurityException
//     */
//    public Set<User> getUsersFromRole(int roleId, int offset, int size) throws SecurityException;

    /**
     * 取得某个角色中的所有用户(不分页)
     *
     * @param roleId 角色编号
     * @return Set<User> 用户信息集合
     * @throws SecurityException
     */
    public Set<User> getUsersFromRole(int roleId) throws SecurityException;

    /**
     * 取得某个角色的组织集合
     *
     * @param roleId 角色id
     * @return GroupSet 组织集合
     * @throws SecurityException
     */
    public Set<Permission> getGroupsFromRole(int roleId) throws SecurityException;

//    /**
//     * 取得某个角色的组织集合,实现分页
//     *
//     * @param roleId 角色id
//     * @param offset 起始位置
//     * @param size 集合大小
//     * @return GroupSet 组织集合
//     * @throws SecurityException
//     */
//    public GroupSet getGroupsFromRole(int roleId, int offset, int size) throws SecurityException;

    /**
     * 给某个角色增加一批权限
     *
     * @param roleId 角色id
     * @param permissionSet 权限集合

     * @throws SecurityException
     */
    public void addPermissionsToRole(int roleId,Set<Permission> permissionSet) throws SecurityException;

    /**
     * 根据角色编码取角色拥有的权限集合
     *
     * @param roleId 角色id
     * @return Set<Permission> 权限集合
     * @throws SecurityException
     */
    public <Permission>Permission getPermissionsFromRole(int roleId) throws SecurityException;

    /**
     * 删除某个角色的一部分权限
     *
     * @param permissionSet 权限集合
     * @param roleId 角色id
     * @throws SecurityException
     */
   public void removePermissionsFromRole(int roleId,Set<Permission> permissionSet) throws SecurityException;

    /**
     * 删除某个角色的所有权限
     *
     * @param roleId 角色id
     * @throws SecurityException
     */
    public void removeAllPermissionFromRole(int roleId) throws SecurityException;

    /**
     * 判断某个角色明是否已经被使用
     *
     * @param roleId 角色ID
     * @return boolean  存在为true,不存在为false
     * @throws SecurityException
     */
    public boolean hasRole(int roleId) throws SecurityException;

//    /**
//     * 删除角色对应的所有组织的关系
//     *
//     * @param roleId 角色id
//     * @throws SecurityException
//     */
//    public void removeAllGroupFromRole(int roleId) throws SecurityException;

//    /**
//     * 删除角色对应的所有用户的关系
//     *
//     *
//     * @param roleId 角色id
//     * @throws SecurityException
//     */
//    public void removeAllUserFromRole(int roleId) throws SecurityException;

    /**
     * 角色是否有某一项权限
     *
     * @param permissionId 权限ID
     * @param roleId  角色ID
     * @return boolean  存在为true,不存在为false
     */
    public boolean hasPermission(int permissionId, int roleId) throws SecurityException;

    /**
     * 角色是否有指定权限集合
     *
     * @param permissionSet 权限集合
     * @param roleId 角色ID
     * @return boolean  全部存在为true,其中一个不存在为false
     */
    public boolean hasPermissions(Set<Permission>permissionSet, int roleId) throws SecurityException;

    /**
     * 搜索系统中所有角色,实现分页
     *
     * @param searchrole 查找role的条件
     * @param group_id 组织id
     * @param offset 起始位置
     * @param size 集合大小
     * @return RoleSet  角色集合
     * @throws SecurityException
     */
    public Set<Role> searchRole(Role searchrole,int group_id, int offset, int size) throws SecurityException ;
}
