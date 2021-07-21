package com.apurs.microservices.facultiesservice.dto;

import java.time.ZonedDateTime;

public class FacultyCreateDTO {
	private String name;
	private String address;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	
	public FacultyCreateDTO(String name, String address) {
		super();
		this.name = name;
		this.address = address;
		this.setCreatedAt(ZonedDateTime.now());
		this.setUpdatedAt(ZonedDateTime.now());
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

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public ZonedDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
