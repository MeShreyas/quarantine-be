package com.covid.self;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.covid.self.models.AssesmentQuestion;
import com.covid.self.models.AssesmentQuiz;
import com.covid.self.models.AssesmentQuizResponceChoices;
import com.covid.self.models.AssesmentQuizResponse;
import com.covid.self.models.Quiz;
import com.covid.self.models.Risk;
import com.covid.self.models.filters.AgeData;
import com.covid.self.repos.AssesmentQuizRepo;
import com.covid.self.repos.AssesmentQuizResponseChoicesRepo;
import com.covid.self.repos.AssesmentRepo;
import com.covid.self.repos.QuizRepo;
import com.covid.self.services.ESQueryBuilder;
import com.google.gson.Gson;

@Service
public class QuizService {

	@Autowired
	QuizRepo quizRepo;

	@Autowired
	AssesmentRepo assesRepo;

	@Autowired
	AssesmentQuizRepo assesQuizRepo;

	@Autowired
	AssesmentQuizResponseChoicesRepo assesQuizResponseChoicesRepo;
	
	@Autowired
	ESQueryBuilder esQuery;
	
	
	// TODO Need to create a service to run this method at fixed frequency
	@Scheduled(cron="0 0 * * * *")
	public void fetchDataForPopulation() {
		Pageable pageable = PageRequest.of(0, 5);
		while (true) {
			Page<AssesmentQuiz> page = assesRepo.findAll(pageable);
			List<AssesmentQuiz> quizes = page.getContent();
			for (AssesmentQuiz quiz : quizes) {
				Quiz q = new Quiz();
				q.setId(quiz.getId());
				q.setIpAddress(quiz.getIp_address());
				q.setCreatedAt(quiz.getCreated_ts());
				q.setModifiedAt(quiz.getModified_ts());
				q.setName(quiz.getName());
				q.setPhone(quiz.getPhone());
				q.setPincode(quiz.getPincode());
				
				Gson gson = new Gson();
			    Risk risk = gson.fromJson(quiz.getResult(), Risk.class);
			    q.setRisk(risk.getRisk());
				q.setLanguage(quiz.getLanguage_id().getName());
				q.setAdditionalSymptoms(new ArrayList<String>());
				q.setSymptoms(new ArrayList<String>());
				q.setUnderLyingConditions(new ArrayList<String>());

				List<AssesmentQuizResponse> quizResponse = assesQuizRepo.findByQuizId(quiz);
				for (AssesmentQuizResponse qR : quizResponse) {
					AssesmentQuestion question = qR.getQuestion_id();

					if (qR.getValue().isEmpty()) {

						

						List<AssesmentQuizResponceChoices> choices = assesQuizResponseChoicesRepo
								.findByQuizresponseId(qR);

						for (AssesmentQuizResponceChoices c : choices) {
							switch (question.getName().toUpperCase()) {
							case "AGE":
								q.setAge(Integer.parseInt(c.getQuestionchoice_id().getText()));
								break;
							case "GENDER":
								q.setGender(c.getQuestionchoice_id().getText());
								break;
							case "TEMPERATURE":
								q.setTemperature(c.getQuestionchoice_id().getText());
								break;
							case "SYMPTOMS":
								q.getSymptoms().add(c.getQuestionchoice_id().getText());
								break;
							case "ADDITIONAL SYMPTOMS":
								q.getAdditionalSymptoms().add(c.getQuestionchoice_id().getText());
								break;
							case "EXPOSUREHISTORY":
								q.setExposureHistory(c.getQuestionchoice_id().getText());
								break;
							case "UNDERLYING CONDITIONS":
								q.getUnderLyingConditions().add(c.getQuestionchoice_id().getText());
								break;
							case "PROGRESS":
								q.setProgress(c.getQuestionchoice_id().getText());
							}
//							op.add(c.getQuestionchoice_id().getText());
						}

					} else {
						q.setAge(Integer.parseInt(qR.getValue()));

					}

				}
								
				quizRepo.save(q);

			}

			if (!page.hasNext()) {
				break;
			}
			pageable = page.nextPageable();
		}
		
		Map<String,Object> t = new HashMap<String,Object>();
		t.put("AGE", new AgeData(0d,30d));
		

	}

}
