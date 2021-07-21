package com.apurs.microservices.facultiesservice.model;

import java.time.ZonedDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="\"faculty\"")
@SequenceGenerator(name = "faculty_id_seq", initialValue = 1, allocationSize = 1)
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "faculty_id_seq")
	@Column(name="\"id\"")
	private int id;
	
	@Column(name="\"name\"")
	private String name;
	
	@Column(name="\"address\"")
	private String address;
	
	@Column(name="\"createdAt\"")
	private ZonedDateTime createdAt;
	
	@Column(name="\"updatedAt\"")
	private ZonedDateTime updatedAt;
	
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
