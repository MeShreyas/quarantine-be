package com.covid.self.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import com.covid.self.models.Quiz;
import com.covid.self.models.filters.AgeData;
import com.covid.self.models.filters.DateData;


@Service
public class ESQueryBuilder {
	
	
	@Autowired
	ElasticsearchRestTemplate esTemplate;
	
	
	public List<Quiz> getAll(Map<String,Object> filters){
		
		BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
		SortBuilder<FieldSortBuilder> sorting = SortBuilders.fieldSort("createdAt").order(SortOrder.ASC);
		
		for (String key:filters.keySet()) {
			switch(key) {
			case "AGE":
				AgeData ad = (AgeData)filters.get(key);
				RangeQueryBuilder ageFilter = QueryBuilders.rangeQuery("age").gte(ad.getGte()).lte(ad.getLte());
				queryBuilder.filter(ageFilter);
				break;
			case "DATE":
				DateData dd = (DateData)filters.get(key);
				RangeQueryBuilder dateFilter = QueryBuilders.rangeQuery("createdAt").gte(dd.getFromDate()).lte(dd.getToDate());
				queryBuilder.filter(dateFilter);
				break;
			case "RISK":
				BoolQueryBuilder riskBuilder = QueryBuilders.boolQuery();
				List<String> riskList = (ArrayList)filters.get(key);
				for(String risk : riskList) {
					riskBuilder.should(QueryBuilders.matchPhraseQuery("risk", risk));
				}
				riskBuilder.minimumShouldMatch(1);
				queryBuilder.must(riskBuilder);
				break;
			case "SYMPTOMS":
				BoolQueryBuilder symptomBuilder = QueryBuilders.boolQuery();
				List<String> symptomList = (ArrayList)filters.get(key);
				for(String symptom : symptomList) {
					symptomBuilder.should(QueryBuilders.matchPhraseQuery("symptoms", symptom));
				}
				symptomBuilder.minimumShouldMatch(1);
				queryBuilder.must(symptomBuilder);
				break;
			case "ADDSYMPTOMS":
				BoolQueryBuilder addsymptomBuilder = QueryBuilders.boolQuery();
				List<String> addsymptomList = (ArrayList)filters.get(key);
				for(String addsymptom : addsymptomList) {
					addsymptomBuilder.should(QueryBuilders.matchPhraseQuery("additionalSymptoms", addsymptom));
				}
				addsymptomBuilder.minimumShouldMatch(1);
				queryBuilder.must(addsymptomBuilder);
				break;
			case "UNDERLYING":
				BoolQueryBuilder underlyingBuilder = QueryBuilders.boolQuery();
				List<String> underlyingList = (ArrayList)filters.get(key);
				for(String underlying : underlyingList) {
					underlyingBuilder.should(QueryBuilders.matchPhraseQuery("underLyingConditions", underlying));
				}
				underlyingBuilder.minimumShouldMatch(1);
				queryBuilder.must(underlyingBuilder);
				break;
			case "TEMPERATURE":
				BoolQueryBuilder tempBuilder = QueryBuilders.boolQuery();
				List<String> tempList = (ArrayList)filters.get(key);
				for(String temp : tempList) {
					tempBuilder.should(QueryBuilders.matchPhraseQuery("temperature", temp));
				}
				tempBuilder.minimumShouldMatch(1);
				queryBuilder.must(tempBuilder);
				break;
			case "PROGRESS":
				BoolQueryBuilder progressBuilder = QueryBuilders.boolQuery();
				List<String> progressList = (ArrayList)filters.get(key);
				for(String progress : progressList) {
					progressBuilder.should(QueryBuilders.matchPhraseQuery("progress", progress));
				}
				progressBuilder.minimumShouldMatch(1);
				queryBuilder.must(progressBuilder);
				break;
			case "GENDER":
				BoolQueryBuilder genderBuilder = QueryBuilders.boolQuery();
				List<String> genderList = (ArrayList)filters.get(key);
				for(String gender : genderList) {
					genderBuilder.should(QueryBuilders.matchPhraseQuery("gender", gender));
				}
				genderBuilder.minimumShouldMatch(1);
				queryBuilder.must(genderBuilder);
				break;
			case "EXPOSURE":
				BoolQueryBuilder exposureBuilder = QueryBuilders.boolQuery();
				List<String> exposureList = (ArrayList)filters.get(key);
				for(String exposure : exposureList) {
					exposureBuilder.should(QueryBuilders.matchPhraseQuery("exposureHistory", exposure));
				}
				exposureBuilder.minimumShouldMatch(1);
				queryBuilder.must(exposureBuilder);
				break;
			
			}
				
		}

		NativeSearchQuery finalQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).withSort(sorting).build();
		
		SearchHits<Quiz> quizes = esTemplate.search(finalQuery,Quiz.class);
		
		List<Quiz> t = new ArrayList<Quiz>();
		for (SearchHit<Quiz> h : quizes.toList()) {
			Quiz q = (Quiz) h.getContent();
			System.out.println(q.getAge());
			System.out.println(q.getCreatedAt());
			t.add(q);
		}
		
		return t;
	}
	
	
}
