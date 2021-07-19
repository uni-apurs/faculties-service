package com.apurs.microservices.facultiesservice.service;

import java.util.Collection;

import com.apurs.microservices.facultiesservice.model.Faculty;

public interface FacultyService {
	public abstract Collection<Faculty> findAll();
	public abstract Faculty findOne(Integer id);
	public abstract Faculty insert(Faculty faculty);
	public abstract boolean update(Faculty faculty);
	public abstract boolean delete(Integer id);
}
