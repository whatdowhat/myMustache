package com.example.demo.domain.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Department;
import com.example.demo.domain.Member;

public interface MemberRepository extends CrudRepository<Member, Integer> {

	
	List<Member> findAll();
	
	Page<Member> findAllBy(Pageable pageable);
	Page<Member> findAll(Pageable pageable);
	Page<Member> findByUserNameContaining(String userName,Pageable pageable);
	
	Page<Member> findByDepartment(Department depat,Pageable pageable);
	List<Member> findByDepartment(Department depart);
	
}

