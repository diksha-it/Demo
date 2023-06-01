package com.example.demo;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@InjectMocks
	StarApicontroller starApicontroller;

	@Mock
	StarWarApiservice starWarApiservice;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void getAllStartship()
	{
		
		List<Object> obj =new ArrayList<>();
		when(starWarApiservice.getAllStarship()).thenReturn(obj);

		starApicontroller.getAllStarship();
	}
	
	@Test
	public void getAllClassification()
	{
		
		List<Object> obj =new ArrayList<>();
		obj.add("test1s");
		when(starWarApiservice.getAllClassification()).thenReturn(obj);

		starApicontroller.getAllClassification();
	}
	
	@Test
	public void getTotalPopulation()
	{
		
		
		when(starWarApiservice.getTotalPopulation()).thenReturn(100L);

		starApicontroller.getTotalPopulation();
	}

}
