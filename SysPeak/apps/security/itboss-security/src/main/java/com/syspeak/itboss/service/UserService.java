package com.syspeak.itboss.service;

import com.syspeak.itboss.domain.User;

public interface UserService {

	/**
	 * 按登录用户名查找用户
	 *
	 * @param username
	 * @return
	 */
	public User findByUserName(String username) ;

//
//    /**
//     * 增加用户（不指定组织ID时加到根组织下）
//     *
//     * @param user 被添加的用户信息
//     * @return void
//     * @throws SecurityException
//     */
//    public User addUser(User user) throws SecurityException;
//
//    /**
//     * 增加用户
//     *
//     * @param user 被添加的用户信息
//     * @return void
//     * @throws SecurityException
//     */
//    public User addUser(User user, Long groupId) throws SecurityException;
//
//    /**
//     * 功能：凭用户名找到该用户的值对象
//     *
//     * @param loginName 登陆名
//     * @param type      登陆类型
//     * @return User 登陆对应的用户
//     * @throws SecurityException
//     */
//    public User getUser(String loginName, String type) throws SecurityException;
//
//    /**
//     * 修改用户信息 操作：修改User的数据 判断：只允许用户自己修改自己信息，管理员只能查看
//     *
//     * @param user 用户信息:User值对象中User.userId为要修改的原用户ID
//     * @throws SecurityException
//     */
//    public User modifyUser(User user) throws SecurityException;
//
//    /**
//     * 强制修改用户密码
//     *
//     * @param userId   用户id
//     * @param password 新密码
//     * @throws SecurityException
//     */
//    public void modifyPassword(Long userId, String password)
//            throws SecurityException;
//
//    /**
//     * 判断是否存在某个用户
//     *
//     * @param userId 用户id
//     * @return boolean 存在为true,不存在为false
//     * @throws SecurityException
//     */
//    public boolean hasUser(Long userId) throws SecurityException;
//
//    /**
//     * 判断一个用户是否属于某个角色
//     *
//     * @param userId 用户id
//     * @param roleId 角色id
//     * @return boolean 存在为true,不存在为false
//     * @throws SecurityException
//     */
//    public boolean isUserInRole(Long userId, Long roleId)
//            throws SecurityException;
//
//    /**
//     * 用户登陆（这里不用指定用户类型，缺省认为用户类型为管理员：0）
//     *
//     * @param login_name 登陆名
//     * @param password   口令
//     * @return User 登陆成功的用户信息
//     * @throws SecurityException
//     */
//    public User login(String login_name, String password)
//            throws SecurityException;
//
//    /**
//     * 计算user数量
//     *
//     * @return int用户数量
//     * @throws SecurityException
//     */
//    public int count() throws SecurityException;
//
//    /**
//     * 计算系统中具有特定属性用户的数量
//     *
//     * @param user 存储特定属性的对象
//     * @return 对应的用户数量
//     * @throws SecurityException 计算的过程中出现任何异常
//     */
//    public int count(User user) throws SecurityException;
//
//    /**
//     * 根据用户属性条件计算user数量
//     *
//     * @return int用户数量
//     * @throws SecurityException
//     */
//    public int count(User user, Long groupId) throws SecurityException;
//
//    /**
//     * 取得用户信息
//     *
//     * @param userId 用户id
//     * @return User 用户信息
//     * @throws SecurityException
//     */
//    public User getUser(Long userId) throws SecurityException;
//
//    /**
//     * 判断是否存在某个用户登陆名
//     *
//     * @param login_name 用户登陆名
//     * @param type       类型
//     * @return boolean 存在为true,不存在为false
//     * @throws SecurityException
//     */
//    public boolean hasUser(String login_name, String type)
//            throws SecurityException;
//
//    /**
//     * 判断某个用户是否存在于某个组织中
//     *
//     * @param userId  用户id
//     * @param groupId 组织id
//     * @return boolean 存在为true,不存在为false
//     * @throws SecurityException
//     */
//    public boolean isUserInGroup(Long userId, Long groupId)
//            throws SecurityException;
//
//    /**
//     * 用户登陆
//     *
//     * @param login_name 登陆名
//     * @param password   口令
//     * @param userType   用户类型（各个项目自定义）
//     * @return User 登陆成功的用户信息
//     * @throws SecurityException
//     */
//    public User login(String login_name, String password, String userType)
//            throws SecurityException;
//
//    /**
//     * 删除用户
//     *
//     * @param userId 用户id
//     * @throws SecurityException
//     */
//    public void removeUser(Long userId) throws SecurityException;
//
//    /**
//     * 删除某个用户的对应的若干组织的关系
//     *
//     * @param userId   用户
//     * @param groupSet 组集合
//     * @throws SecurityException
//     */
//    public void removeGroupsFromUser(Long userId, Set<Group> groupSet)
//            throws SecurityException;
//
//    /**
//     * 删除用户对应的若干角色的关系
//     *
//     * @param userId  用户
//     * @param roleSet 角色集合
//     * @throws SecurityException
//     */
//    public void removeRolesFromUser(Long userId, Set<Role> roleSet)
//            throws SecurityException;
//
//    /**
//     * 取用户所有角色集合
//     *
//     * @param userId 组织Id
//     * @return Set<Role> 角色集合
//     * @throws SecurityException
//     */
//    public Set<Role> getRolesFromUser(Long userId) throws SecurityException;
//
//    /**
//     * 取用户所有角色集合,实现分页
//     *
//     * @param userId 组织
//     * @param offset 起始位置
//     * @param size   集合大小
//     * @return Set<Role> 角色集合
//     * @throws SecurityException
//     */
//    public Set<Role> getRolesFromUser(Long userId, int offset, int size)
//            throws SecurityException;
//
//    /**
//     * 取得某个用户的组织集合
//     *
//     * @param userId 用户id
//     * @return Set<Group> 组织集合
//     * @throws SecurityException
//     */
//    public Set<Group> getGroupsFromUser(Long userId) throws SecurityException;
//
//    /**
//     * 取得某个用户的组织集合,实现分页
//     *
//     * @param userId 用户id
//     * @param offset 起始位置
//     * @param size   集合大小
//     * @return Set<Group> 组织集合
//     * @throws SecurityException
//     */
//    public Set<Group> getGroupsFromUser(Long userId, int offset, int size)
//            throws SecurityException;
//
//    /**
//     * 取所有用户列表，不分页
//     *
//     * @return Set<User> 用户集
//     */
//    public Set<User> getAllUser() throws SecurityException;
//
//    /**
//     * 取所有用户列表,实现分页
//     *
//     * @param offset 起始位置
//     * @param size   集合大小
//     * @return Set<User> 用户集
//     */
//    public Set<User> getAllUser(int offset, int size) throws SecurityException;
//
//    /**
//     * 删除用户对应的所有角色的关系
//     *
//     * @param userId 用户id
//     * @throws SecurityException
//     */
//    public void removeAllRoleFromUser(Long userId) throws SecurityException;
//
//    /**
//     * 删除某个用户的对应的所有组织的关系
//     *
//     * @param userId 用户id
//     * @throws SecurityException
//     */
//    public void removeAllGroupFromUser(Long userId) throws SecurityException;
//
//    /**
//     * 根据指定的用户相关信息(属性)在所有的组织当中查找对应的用户 并实现分页功能
//     *
//     * @param user   存储搜索条件的对象
//     * @param offset 搜索的起始位置
//     * @param size   搜索的集合大小
//     * @return 搜索到的用户集合
//     * @throws SecurityException 如果在搜索的过程中出现任何异常
//     */
//    public Set<User> searchUserFromAllGroup(User user, int offset, int size)
//            throws SecurityException;
//
//    /**
//     * 根据指定的查询条件(存储在给定的 <code>user</code> 对象中) 在所有的组织中搜索满足条件的所有用户
//     *
//     * @param user 存储搜索条件的对象
//     * @return 搜索到的用户的集合
//     * @throws SecurityException 如果在搜索的过程中出现任何异常
//     */
//    public Set<User> searchUserFromAllGroup(User user) throws SecurityException;
//
//    /**
//     * 搜索用户列表,实现分页
//     *
//     * @param offset 起始位置
//     * @param size   集合大小
//     * @return Set<User> 用户集
//     */
//    public Set<User> searchUser(User user, Long group_id, int offset, int size)
//            throws SecurityException;
//
//    /**
//     * 取得指定用户的所有权限（不使用用户所属组织的缺省角色）
//     *
//     * @param userId
//     * @return 权限集和
//     * @throws SecurityException
//     */
//    public Set<Permission> getPermissionsByUserId(Long userId)
//            throws SecurityException;
//
//    /**
//     * 取得指定用户的所有权限（使用用户所属组织的缺省角色）
//     *
//     * @param userId
//     * @return 权限集和
//     * @throws SecurityException
//     */
//    public Set<Permission> getPermissionsByUserIdWithDefaultRoleId(Long userId)
//            throws SecurityException;
//
//
//    /**
//     * 用户移动
//     *
//     * @param userId
//     * @param sourceGroupId
//     * @param targetGroupId
//     * @throws SecurityException
//     */
//    public String moveUser(Long userId, Long sourceGroupId, Long targetGroupId)
//            throws SecurityException;

}
