package com.covid.self.repos;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.covid.self.models.Quiz;

public interface QuizRepo extends ElasticsearchRepository<Quiz, String>{

}
