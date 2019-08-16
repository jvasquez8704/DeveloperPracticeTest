package com.example.api;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Project;
import com.example.repository.IProject;


@RestController
@RequestMapping("/project")
public class ProjectController {
	private static Logger LOG = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private IProject repo;
	
	
	@GetMapping({"/", "/{id}"})	
	public List<Project> getProjects(@PathVariable(required = false) String id){				
		return repo.findAll();
	}
	

	@PostMapping
	public ResponseEntity<Project> insertar(@RequestBody Project prj){
		ResponseEntity<Project> retVal = null;
		
			if(repo.save(prj) != null){
				retVal = new ResponseEntity<>((Project) repo.save(prj),HttpStatus.CREATED);
				LOG.info("Se ingreso el Project correctamemnte => obj: " + prj);
			}	
		
		return retVal;
	}
}
