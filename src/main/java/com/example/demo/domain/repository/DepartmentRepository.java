package com.example.demo.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer>{

	@Query("select m from Department m ")
	List<Department> findByAll();
	
	
	List<Department> findAll();
	
}
