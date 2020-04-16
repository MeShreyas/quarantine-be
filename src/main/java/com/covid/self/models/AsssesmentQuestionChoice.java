package com.covid.self.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assessment_questionchoice")
public class AsssesmentQuestionChoice {
	
	@Id
	private int id;
	private String text;
	private int sort_order;
	private int question_id;
	private String apollo_id;
	private String icon;
	public AsssesmentQuestionChoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AsssesmentQuestionChoice(int id, String text, int sort_order, int question_id, String apollo_id, String icon) {
		super();
		this.id = id;
		this.text = text;
		this.sort_order = sort_order;
		this.question_id = question_id;
		this.apollo_id = apollo_id;
		this.icon = icon;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getSort_order() {
		return sort_order;
	}
	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getApollo_id() {
		return apollo_id;
	}
	public void setApollo_id(String apollo_id) {
		this.apollo_id = apollo_id;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
