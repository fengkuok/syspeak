package com.syspeak.makereap.common.entity.base;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import com.syspeak.makereap.common.model.Lifecycle;
import com.syspeak.makereap.common.model.Period;

/**
 * 生命周期
 */
@MappedSuperclass
public class LifecycleModel extends BaseModel implements Lifecycle{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 时间区间
	 */
	protected Period period;
	
	/**
	 * 是否过期
	 */
	public boolean isExpired( Date date ){
		return !period.isIncluded( date );
	}
	
	/**
	 * 是否过期
	 */
	public boolean isExpired( ){
		return isExpired( new Date() );
	}
	
	/**
	 * �?��时间
	 */
	public Date getFromDate(){
		return this.period.getStart();
	}
	
	/**
	 * 结束时间
	 */
	public Date getThruDate(){
		return this.period.getEnd();
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	
}
