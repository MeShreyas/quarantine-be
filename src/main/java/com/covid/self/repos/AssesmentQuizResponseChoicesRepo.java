package com.covid.self.repos;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.covid.self.models.AssesmentQuizResponceChoices;
import com.covid.self.models.AssesmentQuizResponse;

public interface AssesmentQuizResponseChoicesRepo extends PagingAndSortingRepository<AssesmentQuizResponceChoices, Integer>{
	
	List<AssesmentQuizResponceChoices> findByQuizresponseId(AssesmentQuizResponse id);

}
