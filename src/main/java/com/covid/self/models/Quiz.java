package com.covid.self.models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "quizdata")
public class Quiz {

	@Id
	private UUID id;
	private String ipAddress;
	private String phone;
	private String name;
	private float age;
	private String gender;
	private List<String> symptoms;
	private List<String> additionalSymptoms;
	private String exposureHistory;
	private String temperature;
	private String progress;
	private String risk;
	private String location;
	private List<String> underLyingConditions;
	private String pincode;
	private String language;
	private Date createdAt;
	private Date modifiedAt;

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quiz(UUID id, String phone, String name, float age, String gender, List<String> symptoms,
			List<String> additionalSymptoms, String exposureHistory, String temperature, String progress, String risk,
			String location, List<String> underLyingConditions, String pincode, String language) {
		super();
		this.id = id;
		this.phone = phone;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.symptoms = symptoms;
		this.additionalSymptoms = additionalSymptoms;
		this.exposureHistory = exposureHistory;
		this.temperature = temperature;
		this.progress = progress;
		this.risk = risk;
		this.location = location;
		this.underLyingConditions = underLyingConditions;
		this.pincode = pincode;
		this.language = language;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<String> symptoms) {
		this.symptoms = symptoms;
	}

	public List<String> getAdditionalSymptoms() {
		return additionalSymptoms;
	}

	public void setAdditionalSymptoms(List<String> additionalSymptoms) {
		this.additionalSymptoms = additionalSymptoms;
	}

	public String getExposureHistory() {
		return exposureHistory;
	}

	public void setExposureHistory(String exposureHistory) {
		this.exposureHistory = exposureHistory;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<String> getUnderLyingConditions() {
		return underLyingConditions;
	}

	public void setUnderLyingConditions(List<String> underLyingConditions) {
		this.underLyingConditions = underLyingConditions;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", ipAddress=" + ipAddress + ", phone=" + phone + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", symptoms=" + symptoms + ", additionalSymptoms=" + additionalSymptoms
				+ ", exposureHistory=" + exposureHistory + ", temperature=" + temperature + ", progress=" + progress
				+ ", risk=" + risk + ", location=" + location + ", underLyingConditions=" + underLyingConditions
				+ ", pincode=" + pincode + ", language=" + language + ", createdAt=" + createdAt + ", modifiedAt="
				+ modifiedAt + "]";
	}




}
