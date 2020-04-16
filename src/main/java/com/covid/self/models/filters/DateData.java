package com.covid.self.models.filters;

public class DateData {
	
	private Long fromDate;
	private Long toDate;
	
	public DateData(Long fromDate, Long toDate) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
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
