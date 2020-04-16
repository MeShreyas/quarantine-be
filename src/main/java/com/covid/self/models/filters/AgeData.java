package com.covid.self.models.filters;

public class AgeData {
	
	private Double lte;
	private Double gte;
	
	
	public AgeData(Double gte, Double lte) {
		super();
		this.lte = lte;
		this.gte = gte;
	}
	
	public Double getLte() {
		return lte;
	}
	public void setLte(Double lte) {
		this.lte = lte;
	}
	public Double getGte() {
		return gte;
	}
	public void setGte(Double gte) {
		this.gte = gte;
	}
	
	

}
