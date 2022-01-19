package com.studentProject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import lombok.Data;

@Entity
@Table(name = "POC2StudentsDB")
@Data

public class Student {
	@Id
	@Column(name = "student_id")//for creation of database only
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	
	@NotNull
	@Size(max = 120)
	@Column(unique = true)
	private String email;
//	
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "student")
//	private List<Project> projects = new ArrayList<Project>();


	
	
	
	

}
