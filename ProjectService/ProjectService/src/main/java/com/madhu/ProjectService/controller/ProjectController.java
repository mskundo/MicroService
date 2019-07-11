package com.madhu.ProjectService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.madhu.ProjectService.entity.Project;
import com.madhu.ProjectService.model.ProjectRecord;
import com.madhu.ProjectService.service.ProjectService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/projectmanager/projects")
public class ProjectController { 
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/saveProject")
	public ProjectRecord saveProject(@RequestBody ProjectRecord projectRecord){
		return projectService.saveProject(projectRecord);
	}
	
	@GetMapping("/getProjects")
    public List<Project> getAllProjectRecords() {
    	return projectService.findAllProjects();
    }
	
	@PutMapping("/updateProject/{id}")
	public Project updateProject(@RequestBody Project project, @PathVariable ("id") Long projectId){
		return projectService.updateProject(project, projectId);
	}
	
	@PutMapping("/deleteProject/{id}")
	public String deleteProject(@PathVariable ("id") Long projectId){
		return projectService.deleteProject(projectId);
	}
	
	private static String SERVICE = "http://user-service/projectmanager/user/getuser/";

	@GetMapping("/getProjectDetailForUser/{id}")
	public String getProjectDetailForUser(@PathVariable("id") Long id) {
		
			System.out.println("inside get project");
		
		String response = restTemplate.exchange(SERVICE + id, HttpMethod.GET, null,
				 new ParameterizedTypeReference<String>() {
				 }).getBody();

		System.out.println("Response Received as " + response);

		return "Employee id -  " + id + " \n Employee Details " + response;
	}
	
	@GetMapping("/getProjectDetail")
	public List<ProjectRecord> getProjectDetail() {
		return projectService.findProjects();
	}
}
	

