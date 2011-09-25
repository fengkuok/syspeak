package com.syspeak.makereap.system.contact.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 电话
 */
@Entity
@DiscriminatorValue("TelephoneNumber")
//@Table( name="T_CONTACT_TELEPHONENUMBER")
public class TelephoneNumber extends ContactMechanism {

    private static final long serialVersionUID = 6395136445849961584L;

    /**
     * 国家号
     */
    private String countryCode;

    /**
     * 区号
     */
    private String areaCode;

    /**
     * 号码
     */
    private String contactNumber;

    /**
     * 附加号(分机)
     */
    private String extCode;

    /**
     * 寻找人
     */
    private String askForName;

    public String format() {
        switch (getType()) {
            case TELEPHONE:
            case FAX:
                return (countryCode == null ? "" : countryCode + "-")
                        + (areaCode == null ? "" : areaCode + "-") + contactNumber
                        + (extCode == null ? "" : "-" + extCode);
            case MOBILE:
                return (countryCode == null ? "" : "(" + countryCode + ")") + this.contactNumber;
            default:
                return super.format();
        }
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getExtCode() {
        return extCode;
    }

    public void setExtCode(String extCode) {
        this.extCode = extCode;
    }

    public String getAskForName() {
        return askForName;
    }

    public void setAskForName(String askForName) {
        this.askForName = askForName;
    }
}
