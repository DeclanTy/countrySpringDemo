package com.bae.country.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.country.domain.Country;
import com.bae.country.repo.CountryRepo;
// public interface countryServiceDB implements CountryService{
@Service
public class CountryServiceDB {
	
	
	private CountryRepo repo;
	
	@Autowired
	public CountryServiceDB(CountryRepo repo) {
		super();
		this.repo = repo;
	}

	public Country createCountry(Country country) {
		Country created = this.repo.save(country);
		return created;
	}

	public List<Country>getAllCountries(){
		return this.repo.findAll(); // SELECT * from country
	}
	public Country getCountry(Integer id) {
		return this.repo.findById(id).get();
	}
 
	public Country replaceCountry(Integer id,Country newCountry) {
		Country existing=this.repo.getById(id);
		existing.setName(newCountry.getName());
		existing.setPopulation(newCountry.getPopulation());
		existing.setLocation(newCountry.getLocation());
		existing.setSize(newCountry.getSize());
		Country updated = this.repo.save(existing);
	    return updated;
	}

	public void removeCountry(Integer id) {
		this.repo.deleteById(id);
	}
	

}
