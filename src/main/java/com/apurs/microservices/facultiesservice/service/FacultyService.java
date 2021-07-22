package com.apurs.microservices.facultiesservice.service;

import java.util.Collection;

import com.apurs.microservices.facultiesservice.dto.FacultyCreateDTO;
import com.apurs.microservices.facultiesservice.dto.FacultyDTO;
import com.apurs.microservices.facultiesservice.dto.FacultyUpdateDTO;

public interface FacultyService {
	public abstract Collection<FacultyDTO> findAll();
	public abstract FacultyDTO findOne(Integer id);
	public abstract FacultyDTO insert(FacultyCreateDTO faculty);
	public abstract FacultyDTO update(FacultyUpdateDTO faculty);
	public abstract boolean delete(Integer id);
	
	public abstract Collection<FacultyDTO> findAllFacultiesByName(String name);
}
