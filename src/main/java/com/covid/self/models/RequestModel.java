package com.covid.self.models;

import java.util.List;

public class RequestModel {

	private List<String> underlying;
	private List<String> symptoms;
	private List<String> addSymptoms;
	private Double ageLTE;
	private Double ageGTE;
	private List<String> conditions;
	private List<String> distict;
	private List<String> risk;
	private List<String> travelHistory;
	private List<String> progress;
	private List<String> temperature;
	private List<String> gender;
	private Long fromDate;
	private Long toDate;

	public RequestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestModel(List<String> underlying, List<String> symptoms, List<String> addSymptoms, Double ageLTE,
			Double ageGTE, List<String> conditions, List<String> distict, List<String> risk, List<String> travelHistory,
			List<String> progress, List<String> temperature, List<String> gender, Long fromDate, Long toDate) {
		super();
		this.underlying = underlying;
		this.symptoms = symptoms;
		this.addSymptoms = addSymptoms;
		this.ageLTE = ageLTE;
		this.ageGTE = ageGTE;
		this.conditions = conditions;
		this.distict = distict;
		this.risk = risk;
		this.travelHistory = travelHistory;
		this.progress = progress;
		this.temperature = temperature;
		this.gender = gender;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public List<String> getUnderlying() {
		return underlying;
	}

	public void setUnderlying(List<String> underlying) {
		this.underlying = underlying;
	}

	public List<String> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<String> symptoms) {
		this.symptoms = symptoms;
	}

	public List<String> getAddSymptoms() {
		return addSymptoms;
	}

	public void setAddSymptoms(List<String> addSymptoms) {
		this.addSymptoms = addSymptoms;
	}

	public Double getAgeLTE() {
		return ageLTE;
	}

	public void setAgeLTE(Double ageLTE) {
		this.ageLTE = ageLTE;
	}

	public Double getAgeGTE() {
		return ageGTE;
	}

	public void setAgeGTE(Double ageGTE) {
		this.ageGTE = ageGTE;
	}

	public List<String> getConditions() {
		return conditions;
	}

	public void setConditions(List<String> conditions) {
		this.conditions = conditions;
	}

	public List<String> getDistict() {
		return distict;
	}

	public void setDistict(List<String> distict) {
		this.distict = distict;
	}

	public List<String> getRisk() {
		return risk;
	}

	public void setRisk(List<String> risk) {
		this.risk = risk;
	}

	public List<String> getTravelHistory() {
		return travelHistory;
	}

	public void setTravelHistory(List<String> travelHistory) {
		this.travelHistory = travelHistory;
	}

	public List<String> getProgress() {
		return progress;
	}

	public void setProgress(List<String> progress) {
		this.progress = progress;
	}

	public List<String> getTemperature() {
		return temperature;
	}

	public void setTemperature(List<String> temperature) {
		this.temperature = temperature;
	}

	public List<String> getGender() {
		return gender;
	}

	public void setGender(List<String> gender) {
		this.gender = gender;
	}

	public Long getFromDate() {
		return fromDate;
	}

	public void setFromDate(Long fromDate) {
		this.fromDate = fromDate;
	}

	public Long getToDate() {
		return toDate;
	}

	public void setToDate(Long toDate) {
		this.toDate = toDate;
	}

}
