package com.syspeak.makereap.system.log.entity;


import com.syspeak.makereap.common.entity.base.UUIDModel;
import com.syspeak.makereap.common.model.Period;
import com.syspeak.makereap.system.identity.entity.Identity;
import com.syspeak.makereap.system.identity.entity.IdentityType;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * 访问日志
 */
@Entity
@Table(name = "T_LOG_ACCESS")
public class Access extends UUIDModel {

    private static final long serialVersionUID = 1L;

    /**
     * Identity type == class
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "IDENTITY_ID", nullable = false)
    private Identity classIdentity;

    /**
     * 操作员
     */
    @Column(name = "OPERATOR")
    private String operator;

    /**
     * 访问时间
     */
    @Column(name = "TIME")
    private Date time;

    /**
     * ip地址
     */
    @Column(name = "IP")
    private String ip;

    /**
     * uri地址或方法名
     */
    @Column(name = "ACTION")
    private String action;

    /**
     * 类型
     */
    @Column(name = "TYPE")
    @Enumerated(value = EnumType.STRING)
    private AccessType type;

    /**
     * description
     */
    @Column(name = "DESCRIPTION")
    private String description;

    @Transient
    private Period _period;

    public Access() {
        super();
    }

    public boolean isShowHistory() {
        return AccessType.CREATE.equals(this.type)
                || AccessType.UPDATE.equals(this.type)
                || AccessType.DELETE.equals(this.type);
    }

    public Access(Identity classIdentity) {
        if (IdentityType.CLASS.equals(classIdentity))
            throw new IllegalArgumentException("");
        this.classIdentity = classIdentity;
    }

    public void init(HttpServletRequest request) {
        setTime(new Date());
        setIp(request.getRemoteAddr());
        setOperator(request.getRemoteUser());
        setAction(request.getRequestURI());
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccessType getType() {
        return type;
    }

    public void setType(AccessType type) {
        this.type = type;
    }

    public Identity getClassIdentity() {
        return classIdentity;
    }

    public void setClassIdentity(Identity classIdentity) {
        this.classIdentity = classIdentity;
    }

    public Period get_period() {
        return _period;
    }

    public void set_period(Period period) {
        _period = period;
    }

}
