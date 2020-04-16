package com.covid.self.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assessment_question")
public class AssesmentQuestion {
	
	@Id
	private int id;
	private String name;
	private String slug;
	private String type;
	private Boolean published;
	private int sort_order;
	private Boolean translation_only;
	
	public AssesmentQuestion(int id, String name, String slug, String type, Boolean published, int sort_order,
			Boolean translation_only) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.type = type;
		this.published = published;
		this.sort_order = sort_order;
		this.translation_only = translation_only;
	}
	
	public AssesmentQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getPublished() {
		return published;
	}
	public void setPublished(Boolean published) {
		this.published = published;
	}
	public int getSort_order() {
		return sort_order;
	}
	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
	}
	public Boolean getTransalation_only() {
		return translation_only;
	}
	public void setTransalation_only(Boolean translation_only) {
		this.translation_only = translation_only;
	}
	
	
	
	
}
