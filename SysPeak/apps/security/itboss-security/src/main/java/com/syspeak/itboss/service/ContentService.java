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
 * @category ContentService
 * @since 2011-9-29
 */
public interface ContentService {

    /**
     * 增加内容
     *
     * @param contentData 内容值对象
     * @return 内容值对象
     * @throws CmsException
     */
    public Content addContent(Content contentData, Category cat) throws CmsException;


    /**
     * 修改内容
     *
     * @param contentData 内容值对象
     * @return 内容值对象
     * @throws CmsException
     */
    public Content modifyContent(Content contentData) throws CmsException;

    /**
     * 按ID号获得内容值对象
     *
     * @param contentId 内容ID号
     * @return 内容值对象
     * @throws CmsException
     */
    public Content viewContent(Long contentId) throws CmsException;


    /**
     * 按ID集合删除内容
     *
     * @param contentIds 内容ID集合
     * @throws CmsException
     */
    public void removeContent(Long[] contentIds) throws CmsException;

    /**
     * 调整内容状态
     *
     * @param contentIds 内容ID集合
     * @param auditFlag  审核标记，"-"未审核，"Y"审核通过，"N"审核不通过
     * @throws CmsException
     */
    public void auditContent(Long contentIds[], String auditFlag) throws CmsException;

    /**
     * 调整内容状态
     *
     * @param contentIds 内容ID集合
     * @throws CmsException
     */
    public void auditContent(Long contentIds[]) throws CmsException;

    /**
     * 内容全文搜索，未实现
     */
    public void searchContent() throws CmsException;

    /**
     * 添加内容扩展属性
     *
     * @param contentData 内容值对象
     * @throws CmsException
     */
    public void addExtendProperty(Content contentData) throws CmsException;

    /**
     * 删除内容属性
     *
     * @param contentData 内容值对象
     * @throws CmsException
     */
    public void removeExtendProperty(Content contentData) throws CmsException;

    /**
     * 获得内容扩展属性
     *
     * @param content 内容值对象
     * @return 内容扩展属性
     * @throws CmsException
     */
    public Hashtable getExtendProperty(Content content) throws CmsException;

    /**
     * 预留接口，检验内容正确性
     *
     * @return 内容正确性，返回true
     * @throws CmsException
     */
    public boolean validateContent() throws CmsException;


    /**
     * 将指定的内容复制到指定的栏目下
     *
     * @param content  需要复制的内容
     * @param category 复制到的栏目
     * @return 复制后的内容
     */
    public Content copyContent(Content content, Category category) throws CmsException;

    /**
     * 将指定的内容移动到指定的栏目下
     *
     * @param content     需要移动的内容
     * @param desCategory 目标栏目
     * @return 移动后的内容
     */
    public Content moveContent(Content content, Category desCategory) throws CmsException;

    /**
     * 为内容列表设置扩展属性
     *
     * @param contentList 内容列表
     * @return 被设置扩展属性的内容列表
     */
    public List setExtendPropertiesToContents(List contentList) throws CmsException;
}
