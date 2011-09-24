package com.syspeak.makereap.system.party.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * person
 *
 *
 */
@Entity
@Table( name="T_PARTY_PERSON" )
@PrimaryKeyJoinColumn(name="id") 
public class Person extends Party{
	
	private static final long serialVersionUID = 1L;
	
	private static final SimpleDateFormat SEQUENCE_SDF = new SimpleDateFormat("yyMM");

	/**
	 * gender enum
	 */
	public enum Gender{
		MALE("男")			//male
		,FEMALE("女");		//female
		
		private String value;
		
		Gender( String value ){
			this.value = value;
		}

		public String getValue() {
			return value;
		}
		
		public String toString(){
			return this.value;
		}
	}
	
	@Override
	public String getSequenceKey() {
		return SEQUENCE_SDF.format( new Date() );
	}
	
	public int getSequenceLength() {
		return 3;
	}
	
	public void preInsert( ){
		//do nothing
	}
	
	/**
	 * 婚姻状况
	 */
	public enum MaritalStatus{
		UNKNOWN("未知")			//未知
		,SINGLE("单身")			//单身
		,MARRIED("已婚")			//已婚
		,SEPARATED("离异")		//分居、离婚
		,WIDOWED("丧偶");		//丧偶
		
		private String value;
		
		MaritalStatus( String value ){
			this.value = value;
		}

		public String getValue() {
			return value;
		}
		
		public String toString(){
			return this.value;
		}
	}
	
	/**
	 * 教育水平
	 */
	public enum EducationLevel{
		MANDATORY_SCHOOLING("义务教育")		//义务教育
		,HIGH_SCHOOL("高中")					//高中
		,VOCATIONAL_SCHOOL("职业学校")		//职业学校
		,JUNIOR_COLLEGE("专科")				//专科
		,UNDERGRADUATE("本科")				//本科
		,MASTER("研究生")					//研究生
		,PHD("博士")							//博士
		,OTHER("其它");						//其它
		
		private String value;
		
		EducationLevel( String value ){
			this.value = value;
		}

		public String getValue() {
			return value;
		}
		
		public String toString(){
			return this.value;
		}
	}
		
	/**
	 * first name
	 */
	@Column( name="FIRST_NAME" )
	protected String firstName;
	
	/**
	 * last name
	 */
	@Column( name="LAST_NAME" )
	protected String lastName;
	
	/**
	 * 证件类型
	 */
	@Column( name="CREDENTIALS_TYPE",length=50 )
	protected CredentialsType credentialsType;
	
	/**
	 * 证件号
	 */
	@Column( name="IDENTITY_CARD_NUMBER" )
	protected String identityCardNumber;
	
	/**
	 * 最高学历
	 */
	@Column( name="DEGREE",length=50 )
	protected EducationLevel degree;
	
	/**
	 * 称呼
	 */
	@Column( name="TITLE",length=20 )
	protected String title;
	
	/**
	 * 别名
	 */
	@Column( name="NICKNAME",length=100 )
	protected String nickname;
	
	/**
	 * 性别
	 */
	@Column( name="GENDER",length=20 )
	@Enumerated(value=EnumType.STRING)
	protected Gender gender;
	
	/**
	 * 生日
	 */
	@Column( name="BIRTHDAY" )
	@Temporal(TemporalType.DATE)
	protected Date birthday;
	
	/**
	 * 婚姻状况
	 */
	@Column( name="MARITAL_STATUS",length=20 )
	@Enumerated(value=EnumType.STRING)
	protected MaritalStatus maritalStatus;
	
	/**
	 * 全名
	 */
	public String getFullName( ){
		return lastName + ' ' + firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdentityCardNumber() {
		return identityCardNumber;
	}

	public void setIdentityCardNumber(String identityCardNumber) {
		this.identityCardNumber = identityCardNumber;
	}

	public CredentialsType getCredentialsType() {
		return credentialsType;
	}

	public void setCredentialsType(CredentialsType credentialsType) {
		this.credentialsType = credentialsType;
	}

	public EducationLevel getDegree() {
		return degree;
	}

	public void setDegree(EducationLevel degree) {
		this.degree = degree;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@Override
	public String toString() {
		return "Person [id=" + getIdentity() +  ", birthday=" 
				+ birthday + ", firstName=" + firstName
				+ ", gender=" + gender + ", identityCardNumber="
				+ identityCardNumber + ", lastName=" + lastName + ", nickname="
				+ nickname + ", title=" + title + "]";
	}	
	
	 public Person clone(){
		 return (Person)super.clone();
	}
}
