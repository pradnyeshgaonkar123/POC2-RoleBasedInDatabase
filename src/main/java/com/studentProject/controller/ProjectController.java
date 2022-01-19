package com.studentProject.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.studentProject.model.Project;
import com.studentProject.model.Student;
import com.studentProject.repository.ProjectRepository;
import com.studentProject.repository.StudentRepository;

@RestController
public class ProjectController {
	@Autowired
	private ProjectRepository projectRepository ;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/project/{studId}")
	public List<Project> findByStudentId(@PathVariable Long studId){
		return projectRepository.findByStudentId(studId);
	}
	
	
	@GetMapping("/project/all")
	public List<Project> allProjects(){
		return projectRepository.findAll();
	}
	
	
	

	@PostMapping("/project/add/{studId}")
	public Project createProject(@PathVariable Long studId, @Valid @RequestBody Project project) {
		return studentRepository.findById(studId).map(student -> {
			project.setStudent(student);
			return  projectRepository.save(project);
		}).orElseThrow(null);
	}
	
	
	
	
}
