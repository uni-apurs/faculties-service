package com.apurs.microservices.facultiesservice.service;

import java.util.List;

import com.apurs.microservices.facultiesservice.dto.FacultyCreateDTO;
import com.apurs.microservices.facultiesservice.dto.FacultyDTO;
import com.apurs.microservices.facultiesservice.dto.FacultyUpdateDTO;

public interface FacultyService {
	public abstract List<FacultyDTO> findAll();
	public abstract FacultyDTO findOne(Integer id);
	public abstract FacultyDTO insert(FacultyCreateDTO faculty);
	public abstract FacultyDTO update(FacultyUpdateDTO faculty);
	public abstract boolean delete(Integer id);
	
	public abstract List<FacultyDTO> findAllFacultiesByName(String name);
}
