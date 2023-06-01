package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StarApicontroller {
	
	@Autowired
	private StarWarApiservice starWarApiservice;
	
	@RequestMapping(value = "/list-starship", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Object>> getAllStarship() {
		return new ResponseEntity<>(starWarApiservice.getAllStarship(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/classification", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Object>> getAllClassification() {
		return new ResponseEntity<>(starWarApiservice.getAllClassification(), HttpStatus.OK);
	}
	@RequestMapping(value = "/total-population", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Long> getTotalPopulation() {
		return new ResponseEntity<>(starWarApiservice.getTotalPopulation(), HttpStatus.OK);
	}
}
