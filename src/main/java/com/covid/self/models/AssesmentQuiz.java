package com.covid.self.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assessment_quiz")
public class AssesmentQuiz {
	@Id
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	private UUID id;
	private Date created_ts;
	private Date modified_ts;
	private String ip_address;
	private Float latitude;
	private Float longitude;
	private String phone;
	private String result;
	private String pincode;
	private String address_1;
	private String address_2;
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="language_id",referencedColumnName = "id")
	private Language language_id;
	
	
	public AssesmentQuiz(UUID id, Date created_ts, Date modified_ts, String ip_address, Float latitude,
			Float longitude, String phone, String result, String pincode, String address_1, String address_2, String name,
			Language language_id) {
		super();
		this.id = id;
		this.created_ts = created_ts;
		this.modified_ts = modified_ts;
		this.ip_address = ip_address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.phone = phone;
		this.result = result;
		this.pincode = pincode;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.name = name;
		this.language_id = language_id;
	}
	public AssesmentQuiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Date getCreated_ts() {
		return created_ts;
	}
	public void setCreated_ts(Date created_ts) {
		this.created_ts = created_ts;
	}
	public Date getModified_ts() {
		return modified_ts;
	}
	public void setModified_ts(Date modified_ts) {
		this.modified_ts = modified_ts;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getAddress_1() {
		return address_1;
	}
	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}
	public String getAddress_2() {
		return address_2;
	}
	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Language getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(Language language_id) {
		this.language_id = language_id;
	}

	
	
}
