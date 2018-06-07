package com.hkbea.data.xml;

import java.util.Set;

public class City {

	private Long id;
	
	private String name;
	
	private String code;

	private Set<Region> regions;
	
	public City(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	public City(Long id, String name, String code) {
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

	public Set<Region> getRegions() {
		return regions;
	}

	public void setRegions(Set<Region> regions) {
		this.regions = regions;
	}
	
}
