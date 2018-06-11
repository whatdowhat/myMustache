package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Department")
public class Department {

	@Id
	@Column(name="DEPARTMENT_SEQ")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="NAME")
	private String departName;
	
	@Column(name="REMARK")
	private String remark;
	

	@OneToMany(fetch = FetchType.EAGER,mappedBy="department")
	private List<Member> members = new ArrayList<Member>();
	
	public List<Member> getMembers() {
//		if(this.members==null) {
//			
//			return new ArrayList<Member>();
//			
//		}
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departName=" + departName + ", remark=" + remark + ", members=" + members
				+ "]";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	
}
