package com.bae.country.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.country.domain.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer > {

	//Spring auto generates all crud functionality
}
