package com.example.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class DemoApplicationService {

	@Test
	void contextLoads() {
	}

	@InjectMocks
	StarWarApiservice starWarApiservice;

	@Mock
	RestTemplate restTemplate;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void getAllStartship() {
		Mockito.when(restTemplate.getForEntity("", Object.class))
				.thenReturn(new ResponseEntity(Object.class, HttpStatus.OK));
		List<Object> obj = new ArrayList<>();
		starWarApiservice.getAllStarship();
	}

}
