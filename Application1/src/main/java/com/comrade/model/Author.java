package com.comrade.model;

public class Author {
	private String name;

	@Override
	public String toString() {
		return "Author [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
