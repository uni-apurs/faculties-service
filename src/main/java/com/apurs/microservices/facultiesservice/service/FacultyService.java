package com.apurs.microservices.facultiesservice.service;

import java.util.Collection;

import com.apurs.microservices.facultiesservice.dto.FacultyCreateDTO;
import com.apurs.microservices.facultiesservice.dto.FacultyUpdateDTO;
import com.apurs.microservices.facultiesservice.model.Faculty;

public interface FacultyService {
	public abstract Collection<Faculty> findAll();
	public abstract Faculty findOne(Integer id);
	public abstract Faculty insert(FacultyCreateDTO faculty);
	public abstract boolean update(FacultyUpdateDTO faculty);
	public abstract boolean delete(Integer id);
}
