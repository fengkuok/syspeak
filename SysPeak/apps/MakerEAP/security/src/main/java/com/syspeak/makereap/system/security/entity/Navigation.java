package com.syspeak.makereap.system.security.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.syspeak.makereap.common.entity.base.BaseModel;

/**
 * 导航
 *
 *
 */
@Entity
@Table( name="T_SECURITY_NAVIGATION")
public class Navigation extends BaseModel{
	
	private static final long serialVersionUID = 8876574038535772527L;

	/**
	 * 顺序
	 */
	@Column( name="SEQUENCE")
	private Integer sequence;
	
	/**
	 * 名称
	 */
	@Column( name="NAME",length=100 )
	private String name;
	
	/**
	 * 描述
	 */
	@Column( name="DESCRIPTION",length=200 )
	private String description;
	
	/**
	 * 对应权限
	 */
	@OneToOne
	@JoinColumn( name="PERMISSION_ID" )
	private Permission permission;
	
	/**
	 * parent
	 */
	@ManyToOne
	@JoinColumn( name="PARENT_ID" )
	private Navigation parent;
	
	/**
	 * children
	 */
	@OneToMany( mappedBy="parent" )
	private Set<Navigation> children;
	
	/**
	 * sort by sequence
	 * @param colls
	 * @return
	 */
	public static Collection<Navigation> sort( Collection<Navigation> colls ){
		if( colls == null )
			return null;
		
		List<Navigation> list = new ArrayList<Navigation>(colls);
		Collections.sort( list, new Comparator<Navigation>(){
				public int compare(Navigation o1, Navigation o2) {
					if( o1==null || o2==null || 
							o1.getSequence()==null || o2.getSequence()==null )
						return 0;
					else 
						return o1.getSequence()>o2.getSequence()?1:-1;
				}
			}//end new Comparator
		);
		
		return list;
	}
	
	/**
	 * sorted children 
	 */
	public Collection<Navigation> sortedChildren( ){
		return sort( this.children );
	}
	
	/**
	 * add children
	 * @param child
	 */
	public void addChildren( Navigation child ){
		if( child == null )
			return;
		
		if( this.children == null )
			children = new HashSet<Navigation>();
		
		children.add(child);
		child.parent = this;
	}
	
	/**
	 * add children
	 * @param children
	 */
	public void addChildren( Collection<Navigation> children ){
		if( children == null || children.isEmpty() )
			return;
		
		for( Navigation child:children )
			addChildren( child );
	}

	public Navigation getParent() {
		return parent;
	}

	public void setParent(Navigation parent) {
		this.parent = parent;
	}

	public Set<Navigation> getChildren() {
		return children;
	}

	public void setChildren(Set<Navigation> children) {
		this.children = children;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

}
