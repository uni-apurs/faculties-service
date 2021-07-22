package com.apurs.microservices.facultiesservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apurs.microservices.facultiesservice.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
	List<Faculty> findByAddressContainingIgnoreCase(String address);
	List<Faculty> findByNameContainingIgnoreCase(String name);
}
