package com.syspeak.makereap.system.party.entity;

/**
 * 证件类型
 *
 *
 */
public enum CredentialsType {

	P01("居民身份证","公安机关")
	,P02("学生证","学校")
	,P03("临时居民身份证","公安机关");

	CredentialsType( String name,String org ){
		this.name = name;
		this.org = org;
	}
	
	public static final CredentialsType[] frequentlyUsed( ){
		return new CredentialsType[]{
			P01,P03
		};
	}
	
	private String name;
	
	private String org;

	public String getName() {
		return name;
	}

	public String getOrg() {
		return org;
	}
	
	public String toString(){
		return this.name;
	}
}
