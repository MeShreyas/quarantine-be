package com.covid.self.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="assessment_quizresponse")
public class AssesmentQuizResponse {

	@Id
	private int id;
	private String value;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="question_id",referencedColumnName = "id")
	private AssesmentQuestion questionId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="quiz_id",referencedColumnName = "id")
	private AssesmentQuiz quizId;
	
	
	public AssesmentQuizResponse(int id, String value, AssesmentQuestion questionId, AssesmentQuiz quizId) {
		super();
		this.id = id;
		this.value = value;
		this.questionId = questionId;
		this.quizId = quizId;
	}
	
	
	public AssesmentQuizResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public AssesmentQuestion getQuestion_id() {
		return questionId;
	}
	public void setQuestion_id(AssesmentQuestion questionId) {
		this.questionId = questionId;
	}
	public AssesmentQuiz getQuiz_id() {
		return quizId;
	}
	public void setQuiz_id(AssesmentQuiz quizId) {
		this.quizId = quizId;
	}
	
	
	
}
