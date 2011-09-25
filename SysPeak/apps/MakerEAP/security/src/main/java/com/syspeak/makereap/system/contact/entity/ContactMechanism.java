package com.syspeak.makereap.system.contact.entity;

import com.syspeak.makereap.common.entity.base.UUIDModel;

import javax.persistence.*;

/**
 * 联系机制
 */
@Entity
@Table(name = "T_CONTACT_MECHANISM")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CLAZZ_TYPE", discriminatorType = DiscriminatorType.STRING, length = 50)
@DiscriminatorValue("base")
public class ContactMechanism extends UUIDModel {

    private static final long serialVersionUID = 2168747780776560365L;

    /**
     * 联系方式类型
     */
    public enum ContactMechanismType {
        POSTAL_ADDRESS("邮政地址"), TELEPHONE("电话"), FAX("传真"), MOBILE("手机"), WEB_ADDRESS("网址"), EMAIL("邮箱"), QQ("QQ"), MSN("MSN"), OTHER("其它");
        private String value;

        ContactMechanismType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public String toString() {
            return this.value;
        }
    }

    /**
     * 联系方式目的
     */
    public enum ContactMechanismPurpose {
        OTHER("其它");

        private String value;

        ContactMechanismPurpose(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public String toString() {
            return this.value;
        }
    }

    /**
     * 其它类型名
     */
    @Column(name = "OTHER_TYPE_NAME", length = 50)
    private String otherTypeName;

    /**
     * 其它类型值
     */
    @Column(name = "OTHER_TYPE_VALUE", length = 200)
    private String otherTypeValue;

    /**
     * 备注
     */
    @Column(name = "DESCRIPTION", length = 200)
    private String description;

    /**
     * 联系机制类型
     */
    @Column(name = "TYPE", length = 50)
    @Enumerated(value = EnumType.STRING)
    private ContactMechanismType type;

    /**
     * 联系机制目的
     */
    @Column(name = "PURPOSE", length = 50)
    @Enumerated(value = EnumType.STRING)
    protected ContactMechanismPurpose purpose;

    /**
     * 格式化输出
     */
    public String format() {
        switch (this.type) {
            case OTHER:
                return "(" + this.otherTypeName + ")" + this.otherTypeValue;
            case EMAIL:
            case QQ:
            case MSN:
                return this.otherTypeValue;
            default:
                return "[" + this.type + "]-" + this.description;
        }
    }

    public String getOtherTypeName() {
        return otherTypeName;
    }

    public void setOtherTypeName(String otherTypeName) {
        this.otherTypeName = otherTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ContactMechanismType getType() {
        return type;
    }

    public void setType(ContactMechanismType type) {
        this.type = type;
    }

    public String getOtherTypeValue() {
        return otherTypeValue;
    }

    public void setOtherTypeValue(String otherTypeValue) {
        this.otherTypeValue = otherTypeValue;
    }

    public ContactMechanismPurpose getPurpose() {
        return purpose;
    }

    public void setPurpose(ContactMechanismPurpose purpose) {
        this.purpose = purpose;
    }

}
