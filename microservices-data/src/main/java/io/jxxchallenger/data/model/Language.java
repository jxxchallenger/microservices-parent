package io.jxxchallenger.data.model;

public class Language {

	private Integer lcId;
	
	private String name;
	
	private String code;

	
	public Language() {
		super();
		
	}

	public Language(Integer lcId, String name, String code) {
		super();
		this.lcId = lcId;
		this.name = name;
		this.code = code;
	}

	public Integer getLcId() {
		return lcId;
	}

	public void setLcId(Integer lcId) {
		this.lcId = lcId;
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
	
}
