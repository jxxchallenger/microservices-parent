package io.jxxchallenger.data.xml;

public class Region {

	private int id;
	
	private String name;
	
	private String code;
	
	private int parentId;

	public Region(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	public Region(int id, String name, String code) {
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

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
}
