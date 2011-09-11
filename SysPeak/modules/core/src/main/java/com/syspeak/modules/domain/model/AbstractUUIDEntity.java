package com.syspeak.modules.domain.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.NaturalId;

@MappedSuperclass
public class AbstractUUIDEntity {
	@NaturalId(mutable=true) 
	@Column(length=36)
	private String magicKey_;
	
	/**
	 * Sets the magic key for the instance
	 */
	public AbstractUUIDEntity() {
		magicKey_ = UUID.randomUUID().toString();
	}

	/**
	 * @return the magicKey
	 */
	public String getMagicKey() {
		return magicKey_;
	}

	/**
	 * @param magicKey the magicKey to set
	 */
	public void setMagicKey(String magicKey) {
		magicKey_ = magicKey;
	}
}
