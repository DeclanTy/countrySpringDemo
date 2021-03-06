package com.bae.country.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.country.domain.Country;
@Service
public class CountryService {
//public interface CountryService
	private List<Country> countries = new ArrayList<>();

	public Country createCountry(Country country) {

		countries.add(country);
		Country created = this.countries.get(this.countries.size() - 1);
		return created;
	}

	public List<Country> getAllCountries() {
		return this.countries;
	}

	public Country getCountry(Integer id) {
		Country getCountry = countries.get(id);
		return getCountry;
	}

	public Country replaceCountry(Integer id, Country newCountry) {

		

		return newCountry;
	}

	public void removeCountry(Integer id) {
		this.countries.remove(id.intValue());

	}
}