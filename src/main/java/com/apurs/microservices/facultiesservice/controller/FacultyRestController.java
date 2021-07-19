package com.apurs.microservices.facultiesservice.controller;

import java.util.Collection;

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
import org.springframework.web.bind.annotation.RestController;

import com.apurs.microservices.facultiesservice.model.Faculty;
import com.apurs.microservices.facultiesservice.service.FacultyServiceImpl;

@RestController
@RequestMapping("/faculty")
public class FacultyRestController {

	@Autowired
	private FacultyServiceImpl facultyService;

	@GetMapping("")
	public Collection<Faculty> getFaculties() {
		return facultyService.findAll();
	}
	
	@GetMapping("/{id}")
	public Faculty getFaculty(@PathVariable("id") Integer id) {
		return facultyService.findOne(id);
	}
	
	@PostMapping("")
	public ResponseEntity<Faculty> insertFaculty(@RequestBody Faculty faculty) {
		if (facultyService.insert(faculty) != null)
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("")
	public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty) {
		if (facultyService.update(faculty))
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Faculty> deleteFaculty(@PathVariable ("id") Integer id) {
		if (facultyService.delete(id))
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
