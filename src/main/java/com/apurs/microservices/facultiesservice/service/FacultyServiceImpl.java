package com.apurs.microservices.facultiesservice.service;

import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.apurs.microservices.facultiesservice.dto.FacultyCreateDTO;
import com.apurs.microservices.facultiesservice.dto.FacultyUpdateDTO;
import com.apurs.microservices.facultiesservice.model.Faculty;
import com.apurs.microservices.facultiesservice.repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService {

	private FacultyRepository facultyRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public FacultyServiceImpl(FacultyRepository facultyRepository) {
		this.facultyRepository = facultyRepository;
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Override
	public Collection<Faculty> findAll() {
		return facultyRepository.findAll();
	}

	@Override
	public Faculty findOne(Integer id) {
		return facultyRepository.getById(id);
	}

	@Override
	public Faculty insert(FacultyCreateDTO faculty) {
		Faculty createFaculty = modelMapper.map(faculty, Faculty.class);
		return facultyRepository.save(createFaculty);
	}

	@Override
	public boolean update(FacultyUpdateDTO faculty) {
		if (!facultyRepository.existsById(faculty.getId()))
			return false;
		
		Faculty tempFaculty = facultyRepository.getById(faculty.getId());
		Faculty updatedFaculty = modelMapper.map(faculty, Faculty.class);
		updatedFaculty.setCreatedAt(tempFaculty.getCreatedAt());
		facultyRepository.save(updatedFaculty);
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
