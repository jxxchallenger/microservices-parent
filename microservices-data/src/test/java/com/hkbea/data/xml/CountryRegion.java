package com.hkbea.data.xml;

import java.util.Set;

/**
 * 国家地区
 * @author Chen
 *
 */
public class CountryRegion {

	private int id;
	
	private String name;
	
	private String code;

	private Set<State> states;
	
	public CountryRegion(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	public CountryRegion(int id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
