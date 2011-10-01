package com.syspeak.itboss.service;

import com.syspeak.itboss.domain.Permission;
import com.syspeak.itboss.domain.User;

import java.util.Set;

/**
 * @author JemiZhuu(周士淳)
 * @version 1.0
 * @company SysPeak (C) Copyright
 * @category PermissionService
 * @since 2011-9-29
 */
public interface PermissionService {

    /**
     * 增加权限信息（不指定组织ID时加到根组织下）
     *
     * @param permissionSet 被增加的权限信息
     * @throws SecurityException
     */
    public Set<Permission> addPermissions(Set<Permission> permissionSet)
            throws SecurityException;

    /**
     * 增加权限信息
     *
     * @param permissionSet 被增加的权限信息
     * @param groupId       被增加到的组
     * @throws SecurityException
     */
    public Set<Permission> addPermissions(Set<Permission> permissionSet, int groupId)
            throws SecurityException;

    /**
     * 用户是否拥有组织的管理权限
     *
     * @param userId  用户id
     * @param groupId 组织id
     * @return
     */
    public boolean checkGroupAdminPermission(int userId, int groupId);


    /**
     * 取得当前系统中的所有权限信息
     *
     * @return Set<Permission> 权限信息集合
     * @throws SecurityException
     */
    public Set<Permission> getAllPermissions() throws SecurityException;

    /**
     * 根据权限id取得权限
     *
     * @param permissionId 权限id
     * @return Permission 权限信息
     * @throws SecurityException
     */
    public Permission getPermission(int permissionId) throws SecurityException;


    /**
     * 功能：根据id数组获得权限集
     *
     * @param ids 权限id数组
     * @return Set<Permission>
     * @throws SecurityException
     */
    public Set<Permission> getPermissionsByIds(int[] ids)
            throws SecurityException;

    /**
     * 判断是否超级管理员用户
     *
     * @param userId 用户id
     * @return boolean 是为true,不是为false
     * @throws SecurityException
     */
    public boolean isAdminUser(int userId) throws SecurityException;

    /**
     * 修改权限信息
     *
     * @param per 权限信息
     * @throws SecurityException
     */
    public void modifyPermission(Permission per) throws SecurityException;

    /**
     * 删除指定id的权限
     *
     * @param permissionId 权限id
     * @throws SecurityException
     */
    public void removePermission(int permissionId) throws SecurityException;

    /**
     * 删除一组权限信息
     *
     * @param permissionSet 被删除的权限信息集合
     * @throws SecurityException
     */
    public void removePermissions(Set<Permission> permissionSet)
            throws SecurityException;

    /**
     * 取得拥有指定permission的用户列表
     *
     * @param permission
     * @return 用户集合
     * @throws SecurityException
     */
    public Set<User> getUsersByPermission(Permission permission)
            throws SecurityException;

    /**
     * 取得拥有指定permission的用户列表, 并且在groupId指定的组中
     *
     * @param permission
     * @param groupId
     * @return 用户集合
     * @throws SecurityException
     */
    public Set<User> getUsersByPermission(Permission permission, int groupId)
            throws SecurityException;
}
