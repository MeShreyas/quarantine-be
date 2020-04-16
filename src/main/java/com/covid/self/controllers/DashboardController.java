package com.covid.self.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.covid.self.QuizService;
import com.covid.self.models.AssesmentQuiz;
import com.covid.self.models.AssesmentQuizResponceChoices;
import com.covid.self.models.AssesmentQuizResponse;
import com.covid.self.models.Quiz;
import com.covid.self.models.RequestModel;
import com.covid.self.models.filters.AgeData;
import com.covid.self.models.filters.DateData;
import com.covid.self.repos.AssesmentQuizRepo;
import com.covid.self.repos.AssesmentQuizResponseChoicesRepo;
import com.covid.self.repos.AssesmentRepo;
import com.covid.self.repos.QuizRepo;
import com.covid.self.services.ESQueryBuilder;

@RestController
public class DashboardController {
	
	@Autowired
	QuizRepo quizRepo;
	
	@Autowired
	AssesmentRepo assesRepo;
	
	@Autowired
	AssesmentQuizRepo assesQuizRepo;
	
	@Autowired
	AssesmentQuizResponseChoicesRepo assesQuizResponseRepo;
	
	@Autowired
	QuizService qSerivce;
	
	@Autowired
	ESQueryBuilder esQuery;
	
	
	@PostMapping("/search")
	public List<Quiz> searchQuizes(@RequestBody RequestModel searchParams) {
		
		Map<String,Object> searchCriteria = new HashMap<String,Object>();
		
		if(searchParams.getAddSymptoms()!=null && !searchParams.getAddSymptoms().isEmpty()) {
			searchCriteria.put("ADDSYMPTOMS",searchParams.getAddSymptoms());
		}
		
		if(searchParams.getSymptoms()!=null && !searchParams.getSymptoms().isEmpty()) {
			searchCriteria.put("SYMPTOMS",searchParams.getSymptoms());
		}
		
		if(searchParams.getUnderlying() !=null && !searchParams.getUnderlying().isEmpty()) {
			searchCriteria.put("UNDERLYING",searchParams.getUnderlying());
		}
		
		if(searchParams.getTemperature()!=null && !searchParams.getTemperature().isEmpty()) {
			searchCriteria.put("TEMPERATURE",searchParams.getTemperature());
		}
		
		if(searchParams.getDistict()!=null && !searchParams.getDistict().isEmpty()) {
			searchCriteria.put("DISTRICT",searchParams.getDistict());
		}
		
		if(searchParams.getProgress()!=null && !searchParams.getProgress().isEmpty()) {
			searchCriteria.put("PROGRESS",searchParams.getProgress());
		}
		
		if(searchParams.getGender()!=null && !searchParams.getGender().isEmpty()) {
			searchCriteria.put("GENDER",searchParams.getGender());
		}
		
		if(searchParams.getRisk()!=null && !searchParams.getRisk().isEmpty()) {
			searchCriteria.put("RISK",searchParams.getRisk());
		}
		
		if(searchParams.getTravelHistory()!=null && !searchParams.getTravelHistory().isEmpty()) {
			searchCriteria.put("EXPOSURE",searchParams.getTravelHistory());
		}
		
		if(!(searchParams.getAgeGTE()!=null && searchParams.getAgeLTE()!=null && searchParams.getAgeGTE().isNaN() && searchParams.getAgeLTE().isNaN())) {
			searchCriteria.put("AGE", new AgeData(searchParams.getAgeGTE(),searchParams.getAgeLTE()));
		}
		
		
		searchCriteria.put("DATE", new DateData(searchParams.getFromDate(),searchParams.getToDate()));
		
		
		return esQuery.getAll(searchCriteria);
		
	}
	
	
	
	@PostMapping("/")
	public Quiz createQuizResponse(@RequestBody Quiz quizResponse) {
		Quiz qr = quizRepo.save(quizResponse);
		System.out.println(qr);
		return qr;
	}
	
	@GetMapping("/")
	public Iterable<AssesmentQuiz> fetchQuiz() {
		return assesRepo.findAll();
	}
	
	@GetMapping("/quiz")
	public Page<AssesmentQuiz> fetchQuizResponse() {
		qSerivce.fetchDataForPopulation();
		Pageable pageable = PageRequest.of(0, 10);
		return assesRepo.findAll(pageable);

	}
	
	@GetMapping("/quizResponse")
	public Iterable<AssesmentQuizResponceChoices> fetchQuizResponseRes(){
		return assesQuizResponseRepo.findAll();
	}

}
