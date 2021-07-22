package com.apurs.microservices.facultiesservice.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.apurs.microservices.facultiesservice.dto.FacultyCreateDTO;
import com.apurs.microservices.facultiesservice.dto.FacultyDTO;
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
	public List<FacultyDTO> findAll() {
		List<Faculty> faculties = facultyRepository.findAll();
		List<FacultyDTO> dtos = new ArrayList<FacultyDTO>();
		
		for (Faculty faculty : faculties)
			dtos.add(modelMapper.map(faculty, FacultyDTO.class));
		
		return dtos;
	}

	@Override
	public FacultyDTO findOne(Integer id) {
		Faculty faculty = facultyRepository.getById(id);
		return modelMapper.map(faculty, FacultyDTO.class);
	}

	@Override
	public FacultyDTO insert(FacultyCreateDTO faculty) {
		Faculty createFaculty = modelMapper.map(faculty, Faculty.class);
		createFaculty = facultyRepository.save(createFaculty);
		return modelMapper.map(createFaculty, FacultyDTO.class);
	}

	@Override
	public FacultyDTO update(FacultyUpdateDTO faculty) {
		if (!facultyRepository.existsById(faculty.getId()))
			return null;
		
		Faculty tempFaculty = facultyRepository.getById(faculty.getId());
		Faculty updatedFaculty = modelMapper.map(faculty, Faculty.class);
		updatedFaculty.setCreatedAt(tempFaculty.getCreatedAt());
		updatedFaculty = facultyRepository.save(updatedFaculty);
		
		return modelMapper.map(updatedFaculty, FacultyDTO.class);
	}

	@Override
	public boolean delete(Integer id) {
		if (!facultyRepository.existsById(id))
			return false;
		
		facultyRepository.deleteById(id);
		return true;
	}

	@Override
	public List<FacultyDTO> findAllFacultiesByName(String name) {
		List<Faculty> faculties = facultyRepository.findByNameContainingIgnoreCase(name);
		List<FacultyDTO> dtos = new ArrayList<FacultyDTO>();
		for (Faculty faculty : faculties)
			dtos.add(modelMapper.map(faculty, FacultyDTO.class));
		
		return dtos;
	}

}
