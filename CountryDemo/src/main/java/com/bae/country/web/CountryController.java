package com.bae.country.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.country.domain.Country;

import com.bae.country.service.CountryServiceDB;

@RestController // tells spring its a controller
				// REST compliant
public class CountryController {
	private CountryServiceDB service;



	public CountryController(CountryServiceDB service) {
		super();
		this.service = service;
	}
	@PostMapping("/create") //201
	public ResponseEntity createCountry(@RequestBody Country country) {

		Country created = this.service.createCountry(country);
		System.out.println(created);
		ResponseEntity<Country>response = new ResponseEntity<Country>(created,HttpStatus.CREATED);
		return response;
	}
	@GetMapping("/getAll") //200
	public ResponseEntity<List<Country>> getAllCountries() {
		return ResponseEntity.ok(this.service.getAllCountries());
	}

	@GetMapping("/get/{id}") //200
	public Country getCountry(@PathVariable Integer id) {

		return this.service.getCountry(id);
	}
	@PutMapping("/replace/{id}") //202
	public ResponseEntity<Country> replaceCountry(@PathVariable Integer id,@RequestBody Country newCountry) {
		Country body = this.service.replaceCountry(id, newCountry);
		ResponseEntity<Country>response = new ResponseEntity<Country>(body,HttpStatus.ACCEPTED);
		return response;
	}
	@DeleteMapping("/remove/{id}") //204
	public ResponseEntity<?> removeCountry(@PathVariable Integer id) {
		this.service.removeCountry(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
