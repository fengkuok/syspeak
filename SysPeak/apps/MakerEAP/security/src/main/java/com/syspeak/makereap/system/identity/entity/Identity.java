package com.syspeak.makereap.system.identity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.syspeak.makereap.common.entity.Persistence;
import com.syspeak.makereap.common.entity.base.BaseModel;

/**
 * 
 *
 *
 */
@Entity
@Table( name="T_IDENTITY",uniqueConstraints={@UniqueConstraint(columnNames={"type","value"})} )
public class Identity extends BaseModel{
	
	private static final long serialVersionUID = 1L;
	
	public static final String CLASS_SEPARATOR = "#";
		
	/**
	 * 类型
	 */
	@Column(name="TYPE")
	@Enumerated(value=EnumType.STRING)
	private IdentityType type;
	
	/**
	 * 扩展名
	 */
	@Column(name="EXT_NAME")
	private String extName;
	
	/**
	 * 值
	 */
	@Column(name="VALUE")
	private String value;
	
	public Identity() {
		super();
	}
	
	public Identity( Persistence<?> model) {
		this.type = IdentityType.CLASS;
		this.value = model.getClass().getCanonicalName() + 
			CLASS_SEPARATOR + model.getIdentity();
	}

	public IdentityType getType() {
		return type;
	}

	public void setType(IdentityType type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}	

	public String getExtName() {
		return extName;
	}

	public void setExtName(String extName) {
		this.extName = extName;
	}

	@Override
	public String toString() {
		return "Identity [type=" + type + ", extName=" + extName +", value=" + value + "]";
	}	
	
}
