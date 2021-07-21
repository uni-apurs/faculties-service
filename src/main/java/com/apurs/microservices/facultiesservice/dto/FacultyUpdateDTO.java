package com.apurs.microservices.facultiesservice.dto;

import java.time.ZonedDateTime;

public class FacultyUpdateDTO {
	private int id;
	private String name;
	private String address;
	private ZonedDateTime updatedAt;
	
	public FacultyUpdateDTO(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.setUpdatedAt(ZonedDateTime.now());
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ZonedDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
