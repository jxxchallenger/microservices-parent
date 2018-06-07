package com.hkbea.data.xml;

import java.util.Set;

public class State {

	private Long id;
	
	private String name;
	
	private String code;

	private Set<City> cities;
	
	public State(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	public State(Long id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
}
