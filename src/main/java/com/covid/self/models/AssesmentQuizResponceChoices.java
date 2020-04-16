package com.covid.self.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="assessment_quizresponse_choices")
public class AssesmentQuizResponceChoices {

	@Id
	private int id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="quizresponse_id",referencedColumnName = "id")
	private AssesmentQuizResponse quizresponseId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="questionchoice_id",referencedColumnName = "id")
	private AsssesmentQuestionChoice questionchoice_id;
	
	
	public AssesmentQuizResponceChoices(int id, AssesmentQuizResponse quizresponseId,
			AsssesmentQuestionChoice questionchoice_id) {
		super();
		this.id = id;
		this.quizresponseId = quizresponseId;
		this.questionchoice_id = questionchoice_id;
	}
	public AssesmentQuizResponceChoices() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AssesmentQuizResponse getQuizresponse_id() {
		return quizresponseId;
	}
	public void setQuizresponse_id(AssesmentQuizResponse quizresponseId) {
		this.quizresponseId = quizresponseId;
	}
	public AsssesmentQuestionChoice getQuestionchoice_id() {
		return questionchoice_id;
	}
	public void setQuestionchoice_id(AsssesmentQuestionChoice questionchoice_id) {
		this.questionchoice_id = questionchoice_id;
	}
	
	
	
}
