package com.syspeak.makereap.system.security.entity;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.syspeak.makereap.common.entity.base.BaseModel;
import com.syspeak.makereap.common.model.Period;
import com.syspeak.makereap.system.party.entity.Party;

/**
 * 登录账号
 *
 *
 */
@Entity
@Table( name="T_SECURITY_LOGINACCOUNT" )
public class LoginAccount extends BaseModel implements UserDetails{

	private static final long serialVersionUID = 8280727772996743600L;

	/**
	 * 登录名
	 */
	@Column(name="LOGIN_NAME",unique=true,nullable=false)
	private String loginName;
	
	/**
	 * 密码
	 */
	@Column(name="PASSWORD",unique=false,nullable=false)
	private String password;
	
	/**
	 * 是否有效
	 */
	@Column( name="ENABLED" )
	private Boolean enabled;
	
	/**
	 * 创建时间
	 */
	@Column( name="CREATE_DATE",nullable=false)
	private Date createDate;
	
	/**
	 * 使用期限
	 */
	@Embedded
	private Period period;
	
	/**
	 * 权限角色
	 */
	@ManyToMany( fetch=FetchType.EAGER )
	@JoinTable( name="T_REF_LOGINACCOUNT_ROLE", 
			joinColumns=@JoinColumn( name="LOGINACCOUNT_ID"),
			inverseJoinColumns=@JoinColumn( name="ROLE_ID"))	
	private Set<Role> roles;
	
	/**
	 * 描述
	 */
	@Column( name="DESCRIPTION",length=200 )
	private String description;
	
	/**
	 * 所属组织或人员
	 */
	@ManyToOne( fetch=FetchType.LAZY )
	@JoinColumn( name="PARTY_ID")
	private Party party;
	
	/**
	 * 是否过期
	 * @return 过期返回false
	 */
	public boolean isExpired( ){
		return period==null || period.isExpired(new Date() );
	}
	
	/**
	 * 是否有效
	 */
	public boolean isEnabled( ){
		return Boolean.TRUE.equals( this.enabled );
	}
	
	/**
	 * 设置时间区间
	 * @param start 起始时间
	 * @param end 结束时间
	 */
	public void setPeriod(Date start,Date end ){
		this.period = new Period(start,end);
	}
	
	/**
	 * 添加角色
	 */
	public void addRole( Role role ){
		if( role == null )
			return;
		
		if( this.roles == null )
			roles = new HashSet<Role>();
		
		roles.add(role);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if( roles == null )
			return null;
		
		Set<Permission> all = new HashSet<Permission>( );
		for( Role each:roles )
			all.addAll( each.getPermissions() );
		
		return all;
	}

	@Override
	public String getUsername() {
		return this.getLoginName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return isExpired( );
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//-- getters and setters --------------------------------------------------
	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

}
