package com.covid.self.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "languages_language")
public class Language {
	
	@Id
	private int id;
	private String name;
	private String slug;
	private Boolean published;
	private int sort_order;
	public Language(int id, String name, String slug, Boolean published, int sort_order) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.published = published;
		this.sort_order = sort_order;
	}
	public Language() {
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
	
	
}
