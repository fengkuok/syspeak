package com.syspeak.itboss.service;

import com.syspeak.itboss.domain.Category;
import com.syspeak.itboss.domain.Content;
import com.syspeak.itboss.exception.CmsException;

import java.util.Hashtable;
import java.util.List;

/**
 * @author JemiZhuu(周士淳)
 * @version 1.0
 * @company SysPeak (C) Copyright
 * @category CategoryService
 * @since 2011-9-29
 */
public interface CategoryService {
    /**
     * 获得某个栏目的子栏目数量
     *
     * @param parentId 栏目分级编码
     * @return 子栏目数量
     * @throws CmsException
     */
    public int listSubCategoryCount(Long parentId) throws CmsException;

    /**
     * 获得某个栏目的有效子栏目数量
     *
     * @param parentId 栏目分级编码
     * @return 子栏目数量
     * @throws CmsException
     */
    public int listAvailableSubCategoryCount(Long parentId)
            throws CmsException;

    /**
     * 查询某个栏目的所有子栏目
     *
     * @param parentId 栏目分级编码
     * @return java.util.List 某个栏目的所有子栏目
     * @throws CmsException
     */
    public List listSubCategory(Long parentId) throws CmsException;

    /**
     * 分页查询某个栏目的所有子栏目
     *
     * @param parentId 栏目分级编码
     * @param offset   当前页码
     * @param size     每页显示数量
     * @return java.util.List 某个栏目的所有子栏目
     * @throws CmsException
     */
    public List listSubCategory(Long parentId, int offset, int size)
            throws CmsException;

    /**
     * 获得某个栏目下的所有子孙栏目
     *
     * @param parentId 栏目分级编码
     * @return java.util.List 某个栏目的所有子孙栏目
     * @throws CmsException
     */
    public List listNestSubCategory(Long parentId) throws CmsException;

    /**
     * 增加一个新的栏目
     *
     * @param categoryData 栏目值对象
     * @return Category 新增栏目
     * @throws CmsException
     */
    public Category addCategory(Category categoryData) throws CmsException;

    /**
     * 删除栏目
     *
     * @param categoryIds 栏目ID集合
     * @throws CmsException
     */
    public void removeCategory(Long[] categoryIds) throws CmsException;

    /**
     * 修改栏目属性
     *
     * @param categoryData 修改栏目
     * @return Category 修改栏目
     * @throws CmsException
     */
    public Category modifyCategory(Category categoryData) throws CmsException;

    /**
     * 判断某个栏目下是否有内容
     *
     * @param categoryData 栏目，至少要保持categoryId完整
     * @return boolean 是否含有内容，是为true，否则为false
     * @throws CmsException
     */
    public boolean hasContent(Category categoryData) throws CmsException;

    /**
     * 判断某个栏目下是否有子栏目
     *
     * @param categoryData 栏目，至少要保持id完整
     * @return boolean 是否含有子栏目，是为true，否则为false
     * @throws CmsException
     */
    public boolean hasChildCategory(Category categoryData) throws CmsException;

    /**
     * 判断某个栏目下的内容是否需要审核
     *
     * @param categoryId 栏目id
     * @return boolean 是否需要审核，是为true，否则为false
     * @throws CmsException
     */
    public boolean needAudit(Long categoryId) throws CmsException;

    /**
     * 将栏目categoryId下的所有内容及其子栏目，从fromCategoryId栏目下，转移到toCategory Id栏目下
     *
     * @param categoryId
     * @param fromCategoryId
     * @param toCategoryId
     * @return boolean
     * @throws CmsException
     */
    //public boolean moveCategory(int categoryId, int fromCategoryId, int
    // toCategoryId) throws CmsException;

    /**
     * 判断栏目是否可用
     *
     * @param categoryId 栏目ID
     * @return boolean 栏目是否可用，是为true，否则为false
     * @throws CmsException
     */
    public boolean isEnabled(Long categoryId) throws CmsException;

    /**
     * 在某个栏目下添加内容(建立关联)
     *
     * @param contentId  内容ID
     * @param categoryId 栏目ID
     * @return boolean 操作是否成功，是为true，否则为false
     * @throws CmsException
     */
    public boolean addContentToCategory(Long contentId, Long categoryId)
            throws CmsException;

    /**
     * 从栏目中删除内容(取消关联)
     *
     * @param categoryId 栏目ID
     * @param contentId  内容ID
     * @return boolean 操作是否成功，是为true，否则为false
     * @throws CmsException
     */
    public boolean removeContentFromCategory(Long categoryId, Long contentId)
            throws CmsException;

    /**
     * 添加栏目的扩展属性
     *
     * @param categoryData 栏目值对象
     * @throws CmsException
     */
    public void addExtendProperty(Category categoryData) throws CmsException;

    /**
     * 获得扩展属性
     *
     * @param categoryData 栏目值对象
     * @return Hashtable 扩展属性
     * @throws CmsException
     */
    public Hashtable getExtendProperty(Category categoryData)
            throws CmsException;

    /**
     * 删除扩展属性
     *
     * @param categoryData 栏目值对象
     * @throws CmsException
     */
    public void removeExtendProperty(Category categoryData) throws CmsException;

    /**
     * 添加可用内容模板
     *
     * @param categoryData 栏目值对象
     * @throws CmsException
     */
    public void addAvailibleTemplete(Category categoryData) throws CmsException;

    /**
     * 获得可用内容模板
     *
     * @param categoryData 栏目值对象
     * @return List 可用内容模板集合
     * @throws CmsException
     */
    public List getAvailibleTemplete(Category categoryData) throws CmsException;

    /**
     * 删除可用内容模板
     *
     * @param categoryData 栏目值对象
     * @throws CmsException
     */
    public void removeAvailibleTemplete(Category categoryData)
            throws CmsException;

    /**
     * 返回当前栏目的所有祖先栏目列表，按层次顺序加入
     *
     * @param cat 栏目值对象
     * @return List 当前栏目的所有祖先栏目列表，按层次顺序加入
     * @throws CmsException
     */
    public java.util.List listParents(Category cat) throws CmsException;

    /**
     * 返回当前栏目的所有祖先栏目列表，按层次顺序加入，不取扩展属性和可用内容模板
     *
     * @param cat 栏目值对象
     * @return List 当前栏目的所有祖先栏目列表，按层次顺序加入
     * @throws CmsException
     */
    public List listParentsQuickly(Category cat) throws CmsException;

    /**
     * 返回栏目下的内容总数量
     *
     * @param cat 栏目值对象
     * @return int 栏目下的内容总数量
     * @throws CmsException
     */
    public int listContentCount(Category cat) throws CmsException;

    /**
     * 返回栏目下的内容
     *
     * @param cat 栏目值对象
     * @return List 栏目下的内容集合
     * @throws CmsException
     */
    public java.util.List listContent(Category cat) throws CmsException;

    /**
     * 分页获得栏目内容列表
     *
     * @param cat    栏目值对象
     * @param offset 当前页码
     * @param size   每页显示数量
     * @return 栏目内容列表
     * @throws CmsException
     */
    public java.util.List listContent(Category cat, int offset, int size)
            throws CmsException;

    /**
     * 按审核状态返回栏目下的内容总数量
     *
     * @param cat       栏目值对象
     * @param auditFlag 审核标记，"-"未审核，"Y"审核通过，"N"审核不通过
     * @return int 按审核状态返回栏目下的内容总数量
     * @throws CmsException
     */
    public int listContentCount(Category cat, String auditFlag)
            throws CmsException;

    /**
     * 按审核状态分页获得栏目内容列表
     *
     * @param cat       栏目值对象
     * @param offset    当前页码
     * @param size      每页显示数量
     * @param auditFlag 审核标记，"-"未审核，"Y"审核通过，"N"审核不通过
     * @return List 按审核状态分页获得栏目内容列表
     * @throws CmsException
     */
    public java.util.List listContent(Category cat, int offset, int size,
                                      String auditFlag) throws CmsException;

    /**
     * 分页搜索栏目内容列表
     *
     * @param cat     栏目值对象
     * @param offset  当前页码
     * @param size    每页显示数量
     * @param content 内容值对象
     * @return List 索栏目内容列表
     * @throws CmsException
     */
    public java.util.List searchContent(Category cat, int offset, int size,
                                        Content content) throws CmsException;

    /**
     * 计算栏目下有多少条符合条件的记录
     *
     * @param cat     栏目值对象
     * @param content 内容值对象
     * @return int 栏目下有多少条符合条件的记录
     * @throws CmsException
     */
    public int countSearchContent(Category cat, Content content)
            throws CmsException;


    /**
     * 按ID号获得栏目
     *
     * @param categoryId 栏目ID
     * @return Category 栏目值对象
     * @throws CmsException
     */
    public Category getCategory(Long categoryId) throws CmsException;

    /**
     * 按栏目编码数组获取栏目列表
     *
     * @param categoryCodes 栏目编码数组
     * @return 栏目列表对象
     * @throws CmsException
     */
    public List getCategory(Long[] categoryIds) throws CmsException;

    /**
     * 校验数据
     *
     * @param category 栏目值对象
     * @return 检验是否正确
     * @throws CmsException
     */
    public boolean validateCategory(Category category) throws CmsException;

    /**
     * 返回栏目下的内容，按优先级排序
     *
     * @param cat 栏目值对象
     * @return java.util.List 栏目下的内容，按优先级排序
     * @throws CmsException
     */
    public java.util.List listContentPeak(Category cat) throws CmsException;

    /**
     * 返回栏目下的内容，按优先级排序
     *
     * @param cat       栏目值对象
     * @param auditFlag 审核标记，"-"未审核，"Y"审核通过，"N"审核不通过
     * @return java.util.List 栏目下的内容，按优先级排序
     * @throws CmsException
     */
    public java.util.List listContentPeak(Category cat, String auditFlag)
            throws CmsException;

    /**
     * 分页获得栏目内容列表，按优先级排序
     *
     * @param cat    栏目值对象
     * @param offset 当前页码
     * @param size   每页显示数量
     * @return List 分页获得栏目内容列表，按优先级排序
     * @throws CmsException
     */
    public java.util.List listContentPeak(Category cat, int offset, int size)
            throws CmsException;

    /**
     * 按审核状态分页获得栏目内容列表，按优先级排序
     *
     * @param cat       栏目值对象
     * @param offset    当前页码
     * @param size      每页显示数量
     * @param auditFlag 审核标记，"-"未审核，"Y"审核通过，"N"审核不通过
     * @return List 按审核状态分页获得栏目内容列表，按优先级排序
     * @throws CmsException
     */
    public java.util.List listContentPeak(Category cat, int offset, int size,
                                          String auditFlag) throws CmsException;

    /**
     * 分页搜索栏目内容列表
     *
     * @param cat     栏目值对象
     * @param offset  当前页码
     * @param size    每页显示数量
     * @param content 内容值对象
     * @return List 分页搜索栏目内容列表，按优先级排序
     * @throws CmsException
     */
    public java.util.List searchContentPeak(Category cat, int offset, int size,
                                            Content content) throws CmsException;

    /**
     * 按审核状态获得内容
     *
     * @param cat       栏目
     * @param auditFlag 审核标记，"-"未审核，"Y"审核通过，"N"审核不通过
     * @return List 按审核状态获得内容
     * @throws CmsException
     */
    public java.util.List listContent(Category cat, String auditFlag)
            throws CmsException;

    //add by Sunny

    /**
     * 查询某个栏目的所有子栏目，按优先级排序
     *
     * @param parentId 栏目分级编码
     * @return java.util.List 某个栏目的所有子栏目
     * @throws CmsException
     */
    public List listSubCategoryPeak(Long parentId) throws CmsException;

    /**
     * 分页查询某个栏目的所有子栏目，按优先级排序
     *
     * @param parentId 栏目分级编码
     * @param offset   当前页码
     * @param size     每页显示数量
     * @return java.util.List 某个栏目的所有子栏目
     * @throws CmsException
     */
    public List listSubCategoryPeak(Long parentId, int offset, int size)
            throws CmsException;

    /**
     * 获得某个栏目下的所有子孙栏目，按优先级排序
     *
     * @param parentId 栏目分级编码
     * @return java.util.List 某个栏目的所有子孙栏目
     * @throws CmsException
     */
    public List listNestSubCategoryPeak(Long parentId)
            throws CmsException;

    /**
     * 获得某个栏目下的所有子孙栏目，按优先级排序
     *
     * @param parentId 栏目分级编码
     * @return java.util.List 某个栏目的所有子孙栏目
     * @throws CmsException
     */
    public List listNestSubCategoryPeakQuickly(Long parentId)
            throws CmsException;

    /**
     * 获得某个栏目下的所有子孙栏目，按优先级排序
     *
     * @param parentId 栏目分级编码
     * @return java.util.List 某个栏目的所有子孙栏目
     * @throws CmsException
     */
    public List listNestSubCategoryPeakForTree(Long parentId)
            throws CmsException;

    /**
     * 根据内容的ID值，获得内容所属的栏目ID值
     *
     * @param contentId 内容ID值
     * @return 栏目ID数组
     * @throws CmsException
     */
    public Category[] getCategoryIdWithContentId(Long contentId)
            throws CmsException;

    /**
     * @param oldCategoryCode 原有旧栏目代码
     * @param newCategoryCode 新的栏目代码
     * @return 移动后的目录
     */
    public Category copyCategory(Long oldCategoryId, Long newCategoryId)
            throws CmsException;

    /**
     * @param oldCategoryCode 原有旧栏目代码
     * @param newCategoryCode 新的样目代码
     * @return 移动后的新栏目
     */
    public Category moveCategory(Long oldCategoryId, Long newCategoryCode)
            throws CmsException;

    /**
     * @param category 当前栏目
     * @return 当前栏目有效内容的总数
     * @throws CmsException
     * @throws CmsException
     */
    public int listAvailableContentCount(Category category) throws CmsException;

    /**
     * @param category
     * @return 当前栏目所有有效内容列表
     * @throws CmsException
     * @throws CmsException
     */
    public List listAvailableContent(Category category) throws CmsException;

    /**
     * 分页获得当前栏目的有效内容列表
     *
     * @param category 当前栏目
     * @param offset   起始页数
     * @param size
     * @return 当前栏目有效内容分页列表
     */
    public List listAvailableContent(Category category, int offset, int size)
            throws CmsException;

    /**
     * 对指定栏目内容列表的指定字段进行排序
     *
     * @param category 当前栏目
     * @param content  内容实例条件
     * @param field    排序字段
     * @param isDesc   是否倒序（Y=是，N=否）
     * @param offset   起始页面
     * @param size     每页大小
     * @return 排序后的content列表
     */
    public List sortContentList(Category category, Content content,
                                String[] field, boolean[] isDesc, int offset, int size)
            throws CmsException;

    /**
     * 对指定栏目内容列表的指定字段进行排序，快速获取方法（去掉取扩展属性的方法）
     *
     * @param category   当前栏目
     * @param searchData 内容实例条件
     * @param field      排序字段
     * @param isDesc     是否倒序（Y=是，N=否）
     * @param offset     起始页面
     * @param size       每页大小
     * @return 排序后的content列表
     */
    public List sortContentListQuickly(Category category, Content searchData,
                                       String[] field, boolean[] isDesc, int offset, int size)
            throws CmsException;

    /**
     * 获得指定栏目下的排序内容列表
     *
     * @param category 当前栏目
     * @param content  内容条件实例
     * @param isDesc   指定排序字段名
     * @param field
     * @return 排序后的结果列表
     */
    public List sortContentList(Category category, Content content,
                                String[] field, boolean[] isDesc) throws CmsException;

    /**
     * 按id排序
     *
     * @param categoryList 当前栏目
     * @return 排序后的结果列表
     */
    public List orderCategoryById(List categoryList);

    /**
     * 按审核状态分页获得栏目内容列表，不取内容的扩展属性以加快速度
     *
     * @param cat       栏目值对象
     * @param offset    当前页码
     * @param size      每页显示数量
     * @param auditFlag 审核标记，"-"未审核，"Y"审核通过，"N"审核不通过
     * @return List 按审核状态分页获得栏目内容列表，按优先级排序
     * @throws CmsException
     */
    public java.util.List listContentPeakQuickly(Category cat, int offset,
                                                 int size, String auditFlag) throws CmsException;

    /**
     * 分页查询某个栏目的所有子栏目，按优先级排序,不取栏目的可用内容模板和扩展属性，以加快速度
     *
     * @param parentId 栏目分级编码
     * @param offset   当前页码
     * @param size     每页显示数量
     * @return java.util.List 某个栏目的所有子栏目
     * @throws CmsException
     */
    public List listSubCategoryPeakQuickly(Long parentId, int offset,
                                           int size) throws CmsException;

    /**
     * 分页查询某个栏目的所有有效的子栏目，按优先级排序,不取栏目的可用内容模板和扩展属性，以加快速度
     *
     * @param parentId 栏目分级编码
     * @param offset   当前页码
     * @param size     每页显示数量
     * @return java.util.List 某个栏目的所有子栏目
     * @throws CmsException
     */
    public List listAvailableSubCategoryPeakQuickly(Long parentId,
                                                    int offset, int size) throws CmsException;

    /**
     * 向列表中的内容添加扩展属性
     *
     * @param contentList
     * @return
     * @throws CmsException
     */
    public List getContentListWithExt(List contentList) throws CmsException;

    /**
     * 分页获得当前栏目的有效内容列表
     *
     * @param category 当前栏目
     * @param offset   起始页数
     * @param size
     * @return 当前栏目有效内容分页列表
     */
    public List quickListAvailableContent(Category category, int offset,
                                          int size) throws CmsException;

    /**
     * 分页搜索栏目内容列表
     *
     * @param cat    栏目值对象
     * @param offset 当前页码
     * @param size   每页显示数量
     * @param ct     内容值对象
     * @return List 索栏目内容列表
     * @throws CmsException
     */
    public java.util.List quickSearchContent(Category cat, int offset,
                                             int size, Content ct) throws CmsException;

    /**
     * 分页搜索栏目内容列表
     *
     * @param cat    栏目值对象
     * @param offset 当前页码
     * @param size   每页显示数量
     * @param ct     内容值对象
     * @return List 分页搜索栏目内容列表，按优先级排序
     * @throws CmsException
     */
    public java.util.List quickSearchContentPeak(Category cat, int offset,
                                                 int size, Content ct) throws CmsException;

    /**
     * 一次性设定所有在List中的栏目的扩展属性
     *
     * @param categories 栏目列表
     * @return 设置了扩展属性的栏目列表
     */
    public List setExtendPropertiesToCategories(List categories);

    /**
     * 一次性设定所有在List中的栏目的可用模板
     *
     * @param categories categories 栏目列表
     * @return 设置了可用模板的栏目列表
     */
    public List setAvailibleTempletesToCategories(List categories);

}
