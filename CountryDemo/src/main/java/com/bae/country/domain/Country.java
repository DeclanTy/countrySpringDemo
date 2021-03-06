package com.bae.country.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // flags class as a table to sping Data
public class Country {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer population;
	private String location;
	private Integer size;

	public Country(Integer id, String name, Integer population, String location, Integer size) {
		super();
		this.id = id;
		this.name = name;
		this.population = population;
		this.location = location;
		this.size = size;
	}
	
	
	public Country(String name, Integer population, String location, Integer size) {
		super();
		this.name = name;
		this.population = population;
		this.location = location;
		this.size = size;
	}
public Country() {
	// TODO Auto-generated constructor stub
}

	public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Country [name=" + name + ", population=" + population + ", location=" + location + ", size=" + size
				+ "]";
	}
	
	
}



