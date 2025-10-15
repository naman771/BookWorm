package com.comrade.booksapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {

	@Id
	@Column(length =50)
	private String name;

	@Override
	public String toString() {
		return "Author[Name="+ name+"]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
