package com.hkbea.data.xml;

import java.util.Set;

/**
 * 国家地区
 * @author Chen
 *
 */
public class CountryRegion {

	private Long id;
	
	private String name;
	
	private String code;

	private Set<State> states;
	
	public CountryRegion(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	public CountryRegion(Long id, String name, String code) {
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

	public Set<State> getStates() {
		return states;
	}

	public void setStates(Set<State> states) {
		this.states = states;
	}
}
