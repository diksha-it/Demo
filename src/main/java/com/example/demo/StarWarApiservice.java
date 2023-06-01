package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StarWarApiservice {
	protected Logger logger = Logger.getLogger(StarWarApiservice.class.getName());

	private  final  String ALL_PEOPLES="https://swapi.dev/api/people";
	private final String All_PLANATS = "https://swapi.dev/api/planets";
	private final String CLASSIFICATION = "https://swapi.dev/api/films";

	@Autowired
	RestTemplate restTemplate;

	public List<Object> getAllStarship() {
		Map<String, Object> data = restTemplate.getForObject(ALL_PEOPLES, Map.class);
		List<Map<String, Object>> peopleList = (List<Map<String, Object>>) data.get("results");
		long total = 0;
		List<Object> starshipsData=new ArrayList<>();
		for (Map<String, Object> i : peopleList) {
			if(!((String) i.get("name")).equals("Luke Skywalker")) {
				List<String> starships=(List<String>) i.get("starships");
				for(String s:starships) {
				Map<String, Object> starShip = restTemplate.getForObject(s, Map.class);
				List<Map<String, Object>> tempList = (List<Map<String, Object>>) data.get("results");
				starshipsData.addAll(tempList);
				}
			}
		}
		return starshipsData;
	}

	public List<Object> getAllClassification() {
		
		Map<String, Object> data = restTemplate.getForObject(CLASSIFICATION, Map.class);
		List<Map<String, Object>> peopleList = (List<Map<String, Object>>) data.get("results");
		long total = 0;
		List<Object> speciesData=new ArrayList<>();
		for (Map<String, Object> i : peopleList) {
			if((Integer) i.get("episode_id")==1) {
				List<String> species=(List<String>) i.get("species");
				for(String s:species) {
				Map<String, Object> starShip = restTemplate.getForObject(s, Map.class);
				
					speciesData.add(starShip.get("classification"));
				
				}
			}
		}
		return speciesData;
	}

	public Long getTotalPopulation() {
		Map<String, Object> data = restTemplate.getForObject(All_PLANATS, Map.class);
		List<Map<String, Object>> planest = (List<Map<String, Object>>) data.get("results");
		long total = 0;
		for (Map<String, Object> i : planest) {
			if(!((String) i.get("population")).equals("unknown")) {
			total = total + Long.valueOf((String) i.get("population"));
			}
		}

		return total;
	}
}
