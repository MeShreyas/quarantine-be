package com.covid.self.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.covid.self.models.AssesmentQuiz;

public interface AssesmentRepo extends PagingAndSortingRepository<AssesmentQuiz, String> {

}
