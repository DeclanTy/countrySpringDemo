package com.bae.country;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.bae.country.domain.Country;

import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts= {"classpath:tableSchema.sql",
		"classpath:country-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class CountryControllerIntegrationTest {
	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception{
		Country testCountry = new Country( "Portugal",6000000,"Western Europe",400000);
		String testCountryAsJSON= this.mapper.writeValueAsString(testCountry);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testCountryAsJSON);
		
		Country testCreatedCountry=new Country(2,"Portugal",6000000,"Western Europe",400000);
		String testCreatedCountryAsJSON=this.mapper.writeValueAsString(testCreatedCountry);
		ResultMatcher checkStatus =status().is(201);
		ResultMatcher checkBody=content().json(testCreatedCountryAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
		
	}
	@Test
	void testCreate2() throws Exception{
		Country testCountry = new Country( "Sudan",26000000,"Africa",2500000);
		String testCountryAsJSON= this.mapper.writeValueAsString(testCountry);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testCountryAsJSON);
		
		Country testCreatedCountry=new Country(2,"Sudan",26000000,"Africa",2500000);
		String testCreatedCountryAsJSON=this.mapper.writeValueAsString(testCreatedCountry);
		ResultMatcher checkStatus =status().is(201);
		ResultMatcher checkBody=content().json(testCreatedCountryAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
		
	}
	@Test
	void testGetAll()throws Exception{
		List<Country>testCountries=List.of(new Country(1,"Argentina",310000,"South America",250000));
		String json=this.mapper.writeValueAsString(testCountries);
		
		RequestBuilder req = get("/getAll");
		
		ResultMatcher checkStatus=status().isOk();
		ResultMatcher checkBody=content().json(json);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	 //public 
	void testGetUsingId()throws Exception{
		Country country=new Country(1,"Argentina",310000,"South America",250000);
		String testCountryAsJSON= this.mapper.writeValueAsString(country);
		
		RequestBuilder req=get("/get/1").contentType(MediaType.APPLICATION_JSON).content(testCountryAsJSON);
		
		ResultMatcher checkStatus=status().is(200);
		ResultMatcher checkBody=content().json(testCountryAsJSON);
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
	
	}
	
	@Test
    void testRemoveTeam() throws Exception {
        RequestBuilder req = delete("/remove/1");
        ResultMatcher checkStatus = status().isNoContent();

        this.mvc.perform(req).andExpect(checkStatus);
	}
	@Test 
	void replaceUsingId()throws Exception{
		Country country = new Country(1,"France",62000000,"Europe",300000);
		String testCountryAsJSON = this.mapper.writeValueAsString(country);
		RequestBuilder req =put("/replace/1").contentType(MediaType.APPLICATION_JSON).content(testCountryAsJSON);
		
		ResultMatcher checkStatus = status().is(202);
		ResultMatcher checkBody = content().json(testCountryAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
		
	}
}