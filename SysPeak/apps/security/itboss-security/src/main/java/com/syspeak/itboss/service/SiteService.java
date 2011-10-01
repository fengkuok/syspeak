package com.syspeak.itboss.service;

import com.syspeak.itboss.domain.Category;
import com.syspeak.itboss.domain.Site;
import com.syspeak.itboss.domain.User;
import com.syspeak.itboss.exception.CmsException;

import java.util.List;

/**
 * @author JemiZhuu(周士淳)
 * @version 1.0
 * @company SysPeak (C) Copyright
 * @category SiteService
 * @since 2011-9-29
 */
public interface SiteService {
    /**
     * 取得父站点下的子站点
     *
     * @param parentId 父站点分级编码
     * @return java.util.List 父站点下的子站点
     * @throws CmsException
     */
    public java.util.List listSite(String parentId) throws CmsException;

    /**
     * 增加站点
     *
     * @param site 站点值对象
     * @return Site  站点值对象
     * @throws CmsException
     */
    public Site addSite(Site site) throws CmsException;

    /**
     * 修改站点
     *
     * @param site 站点值对象
     * @return boolean 修改是否成功，是为true，否则为false
     * @throws CmsException
     */
    public boolean modifySite(Site site) throws CmsException;

    /**
     * 根据站点ID删除站点
     *
     * @param siteIds 站点ID集合
     * @return boolean   删除是否成功，是为true，否则为false
     *         throws CmsException
     */
    public boolean removeSite(int[] siteIds) throws CmsException;

    /**
     * 根据站点ID取得站点
     *
     * @param siteId 站点ID
     * @return Site   站点值对象
     *         throws CmsException
     */
    public Site getSite(int siteId) throws CmsException;


    /**
     * 取得站点下的栏目列表
     *
     * @param siteId      站点ID
     * @param catParentId 栏目分级编码
     * @param isAll       isAll为true时，取得包含子栏目列表,为flase时不包含子栏目列表
     * @return List  栏目列表
     *         throws CmsException
     */
    public java.util.List listCategory(int siteId, String catParentId, boolean isAll) throws CmsException;

    /**
     * 获取某个站点下某个栏目的内容列表分页显示
     *
     * @param siteId     站点ID
     * @param categoryId 栏目ID
     * @param offset     当前页码
     * @param size       每页显示数量
     * @param auditFlag  审核标记
     * @return List        内容列表
     */
    public List listContent(int siteId, int categoryId, int offset, int size, String auditFlag) throws CmsException;

    /**
     * 根据用户权限获取某个站点下某个栏目的内容列表;分页显示
     *
     * @param siteId    站点ID
     * @param cat       栏目
     * @param offset    当前页码
     * @param size      每页显示数量
     * @param auditFlag 审核标记
     * @param user      操作用户
     * @return List        内容列表
     */
    public java.util.List listContent(int siteId, Category cat, int offset, int size, String auditFlag, User user) throws CmsException;


    /**
     * 为栏目和站点建立关联
     *
     * @param categoryId       栏目ID
     * @param siteId           站点ID
     * @param flag             为"Y"时表示是首页栏目，否则为“N”;
     * @param categoryTemplete 栏目模板
     * @param contentTemplete  内容模板
     */
    public void addCategoryToSite(int categoryId, int siteId, String flag, String categoryTemplete, String contentTemplete) throws CmsException;

    /**
     * 为内容与站点建立关联
     *
     * @param contentId 栏目ID
     * @param siteId    站点ID
     */
    public void addContentToSite(int contentId, int siteId) throws CmsException;

    /**
     * 删除栏目与站点的关联
     *
     * @param categoryIds 栏目ID集合
     * @param siteId      站点ID
     */
    public void removeCategoryFromSite(int[] categoryIds, int siteId) throws CmsException;

    /**
     * 删除内容与站点的关联
     *
     * @param contentIds 栏目ID集合
     * @param siteId     站点ID
     */
    public void removeContentFromSite(int[] contentIds, int siteId) throws CmsException;

    /**
     * 根据用户权限取得站点列表
     *
     * @param user 当前操作用户
     * @param id   站点分级编码
     * @return java.util.List  站点列表
     */
    public java.util.List listSite(User user, int id) throws CmsException;

    /**
     * 根据用户权限增加站点
     *
     * @param site 站点值对象
     * @param user 当前操作用户
     * @return Site           站点值对象
     */
    public Site addSite(Site site, User user) throws CmsException;

    /**
     * 根据用户权限修改站点
     *
     * @param site 站点值对象
     * @param user 当前操作用户
     * @return boolean    修改是否成功
     */
    public boolean modifySite(Site site, User user) throws CmsException;

    /**
     * 根据用户权限删除站点
     *
     * @param siteIds 删除站点ID集合
     * @param user    当前操作用户
     * @return boolean     删除是否成功
     */
    public boolean removeSite(int[] siteIds, User user) throws CmsException;

    /**
     * 根据用户权限和站点id取得站点
     *
     * @param siteId 站点ID
     * @param user   当前操作用户
     * @return Site           站点值对象
     */
    public Site getSite(int siteId, User user) throws CmsException;

    /**
     * 取得用户在指定站点下可管理栏目列表
     *
     * @param siteId      站点ID
     * @param catParentId 父栏目分级编码
     * @param user        当前操作用户
     * @param isAll       isAll为true时，取得包含子栏目列表,为flase时不包含子栏目列表
     * @return java.util.List     栏目列表
     */
    public java.util.List listCategory(int siteId, String catParentId, User user, boolean isAll) throws CmsException;

    /**
     * 取得站点下的需要在首页显示栏目列表
     *
     * @param siteId      站点ID
     * @param catParentId 父栏目分级编码
     * @param isAll       isAll为true时，取得包含子栏目列表,为flase时不包含子栏目列表
     * @return java.util.List   栏目集合
     *         throws CmsException
     */
    public java.util.List listCategoryInHomepage(int siteId, String catParentId, boolean isAll) throws CmsException;

    /**
     * 站点下需要在首页显示栏目列表
     *
     * @param siteId           站点ID
     * @param categoryParentId 父栏目分级编码
     * @param user             操作用户
     * @param isAll            为"true"时包含嵌套子栏目，为“false”时不包含嵌套子栏目
     * @return 栏目集合
     * @throws CmsException
     */
    public java.util.List listCategoryInHomepage(int siteId, int categoryParentId, User user, boolean isAll) throws CmsException;

    /**
     * 获得某个站点下某个栏目内容总数
     *
     * @param site 站点值对象
     * @param cat  栏目值对象
     * @return int             某个站点下某个栏目内容总数
     * @throws CmsException
     */
    public int listSiteCatContentCount(Site site, Category cat) throws CmsException;

    /**
     * 按审核状态获得内容列表总数
     *
     * @param site      站点值对象
     * @param cat       栏目值对象
     * @param auditFlag 审核标记，"Y" = 审核通过，"N" = 审核未通过, 其他为全部状态
     * @return int             按审核状态获得内容列表总数
     * @throws CmsException
     */
    public int listSiteCatContentCount(Site site, Category cat, String auditFlag) throws CmsException;

    /**
     * 根据用户权限获得某个站点下某个栏目内容总数
     *
     * @param site 站点值对象
     * @param cat  栏目值对象
     * @param user 当前操作用户
     * @return int            根据用户权限获得某个站点下某个栏目内容总数
     * @throws CmsException
     */
    public int listSiteCatContentCount(Site site, Category cat, User user) throws CmsException;

    /**
     * 根据用户权限按审核状态获得内容列表总数
     *
     * @param site      站点值对象
     * @param cat       栏目值对象
     * @param auditFlag 审核标记，"Y" = 审核通过，"N" = 审核未通过, 其他为全部状态
     * @param user      当前操作用户
     * @return int        根据用户权限按审核状态获得内容列表总数
     * @throws CmsException
     */
    public int listSiteCatContentCount(Site site, Category cat, String auditFlag, User user) throws CmsException;

    /**
     * 根据用户权限和站点id取得站点
     *
     * @param user   当前操作用户
     * @param siteId 站点分级编码
     * @return Site       站点值对象
     */
    public Site getSite(User user, int siteId) throws CmsException;

    /**
     * 删除站点下所有栏目关联
     *
     * @param siteId 站点ID
     * @throws CmsException
     */
    public void removeAllCategoryFromSite(int siteId) throws CmsException;


    /**
     * 查询站点内容是否发布
     *
     * @param siteId    站点ID
     * @param contentId 内容ID
     * @return boolean       操作是否正常
     * @throws CmsException
     */
    public boolean getContentPubFlag(int siteId, int contentId) throws CmsException;

    /**
     * 站点是否绑定栏目
     *
     * @param siteId     站点ID
     * @param categoryId 栏目ID
     * @return String[]       结果字符串数组，如果栏目被绑定 [0]为checked，否则为"" 如果栏目在首页显示,[1]为checked，否则为""
     * @throws CmsException
     */
    public String[] isCatBindingWithSite(int siteId, int categoryId) throws CmsException;


    /**
     * 获得站点栏目信息，包括栏目模板，栏目下内容模板
     *
     * @param siteId  站点ID
     * @param cat     栏目
     * @param offset  页码
     * @param size    每页大小
     * @param keyWord 关键字
     * @param user    用户
     * @return list     内容列表
     * @throws CmsException
     */
    public java.util.List listLikeLink(int siteId, Category cat, int offset, int size, String keyWord, User user) throws CmsException;
}
