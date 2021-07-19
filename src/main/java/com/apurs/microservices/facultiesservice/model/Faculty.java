package com.apurs.microservices.facultiesservice.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "faculty" database table.
 * 
 */
@Entity
@Table(name="\"faculty\"")
@NamedQuery(name="Faculty.findAll", query="SELECT f FROM Faculty f")
public class Faculty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"id\"")
	private int id;

	@Column(name="\"address\"")
	private String address;

	@Column(name="\"name\"")
	private String name;

	public Faculty() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}