package com.covid.self.repos;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.covid.self.models.AssesmentQuiz;
import com.covid.self.models.AssesmentQuizResponse;

public interface AssesmentQuizRepo extends PagingAndSortingRepository<AssesmentQuizResponse, Integer> {
	
	List<AssesmentQuizResponse> findByQuizId(AssesmentQuiz quizId);
	
	//AssesmentQuestion findByQuestionId();
		
}
