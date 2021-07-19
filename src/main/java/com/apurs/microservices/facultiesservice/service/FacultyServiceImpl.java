package com.apurs.microservices.facultiesservice.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.apurs.microservices.facultiesservice.model.Faculty;
import com.apurs.microservices.facultiesservice.repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService {

	private FacultyRepository facultyRepository;
	
	public FacultyServiceImpl(FacultyRepository facultyRepository) {
		this.facultyRepository = facultyRepository;
	}
	
	@Override
	public Collection<Faculty> findAll() {
		return facultyRepository.findAll();
	}

	@Override
	public Faculty findOne(Integer id) {
		return facultyRepository.getOne(id);
	}

	@Override
	public Faculty insert(Faculty faculty) {
		if (!facultyRepository.existsById(faculty.getId())) {
			return facultyRepository.save(faculty);
		}
		return null;
	}

	@Override
	public boolean update(Faculty faculty) {
		if (!facultyRepository.existsById(faculty.getId())) {
			return false;
		}
		facultyRepository.save(faculty);
		return true;
	}

	@Override
	public boolean delete(Integer id) {
		if (!facultyRepository.existsById(id))
			return false;
		facultyRepository.deleteById(id);
		return true;
	}

}
