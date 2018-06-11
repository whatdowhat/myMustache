package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Member")
public class Member {

	@Id
	@Column(name="SEQ")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="NAME")
	private String userName;
	
	@Column(name="AGE")
	private int age;

	@Transient
	private String departName;
	
	
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_SEQ")	
	private Department department;
	


	public String getDepartName() {
		if(this.department!=null)
			return this.department.getDepartName();
		
		return "";
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	@JsonIgnore
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(int id, String userName, int age) {
		super();
		this.id = id;
		this.userName = userName;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", userName=" + userName + ", age=" + age + ", department=" + department.getDepartName() + "]";
	}

	



}
