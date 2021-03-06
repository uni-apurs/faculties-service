package com.apurs.microservices.facultiesservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apurs.microservices.facultiesservice.dto.FacultyCreateDTO;
import com.apurs.microservices.facultiesservice.dto.FacultyDTO;
import com.apurs.microservices.facultiesservice.dto.FacultyUpdateDTO;
import com.apurs.microservices.facultiesservice.service.FacultyService;

@RestController
@RequestMapping("/faculties")
public class FacultyRestController {

	@Autowired
	private FacultyService facultyService;

	@GetMapping("")
	public List<FacultyDTO> getFaculties(@RequestParam(required = false) String name) {
		if (name != null)
			return facultyService.findAllFacultiesByName(name);
		
		return facultyService.findAll();
	}
	
	@GetMapping("/{id}")
	public FacultyDTO getFaculty(@PathVariable("id") Integer id) {
		return facultyService.findOne(id);
	}
	
	@PostMapping("")
	public ResponseEntity<FacultyDTO> insertFaculty(@RequestBody FacultyCreateDTO faculty) {
		if (facultyService.insert(faculty) != null)
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("")
	public ResponseEntity<FacultyDTO> updateFaculty(@RequestBody FacultyUpdateDTO faculty) {
		if (facultyService.update(faculty) != null)
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<FacultyDTO> deleteFaculty(@PathVariable ("id") Integer id) {
		if (facultyService.delete(id))
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
