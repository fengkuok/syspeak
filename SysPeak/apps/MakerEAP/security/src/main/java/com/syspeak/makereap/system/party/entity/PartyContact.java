package com.syspeak.makereap.system.party.entity;

import com.syspeak.makereap.common.entity.base.UUIDModel;
import com.syspeak.makereap.common.model.Period;
import com.syspeak.makereap.system.contact.entity.ContactMechanism;

import javax.persistence.*;
import java.util.Date;

/**
 * Party 联系方式
 */
@Entity
@Table(name = "T_PARTY_CONTACT")
public class PartyContact extends UUIDModel {

    private static final long serialVersionUID = 1L;

    /**
     * Party
     */
    @OneToOne
    @JoinColumn(name = "PARTY_ID")
    private Party party;

    /**
     * 联系机制
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTACT_ID")
    private ContactMechanism contact;

    /**
     * 时间范围
     */
    @Embedded
    private Period period;

    /**
     * 显示顺序
     */
    @Column(name = "SEQUENCE")
    private Integer sequence;

    public PartyContact() {
    }

    public PartyContact(Party party, ContactMechanism contact) {
        this.party = party;
        this.contact = contact;
        this.period = new Period(new Date(), null);
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public ContactMechanism getContact() {
        return contact;
    }

    public void setContact(ContactMechanism contact) {
        this.contact = contact;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

}
