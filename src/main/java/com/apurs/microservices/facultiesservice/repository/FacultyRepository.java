package com.apurs.microservices.facultiesservice.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apurs.microservices.facultiesservice.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
	Collection<Faculty> findByAddressContainingIgnoreCase(String address);
	Collection<Faculty> findByNameContainingIgnoreCase(String name);
}
