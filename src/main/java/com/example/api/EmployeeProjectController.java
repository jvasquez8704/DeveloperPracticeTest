package com.example.api;

import java.util.ArrayList;
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
import com.example.model.Employee_Project;
import com.example.model.Project;
import com.example.repository.IEmployee_Project;

@RestController
@RequestMapping("/employee_project")
public class EmployeeProjectController {
	private static Logger LOG = LoggerFactory.getLogger(Employee_Project.class);
	
	@Autowired
	private IEmployee_Project repo;
	
	@GetMapping({"/", "/{id}"})
	public List<Employee_Project> getEmpProjects(@PathVariable(required = false) String id){
		List<Employee_Project> retVal = null;		
		if(id != null) {
			int idP = Integer.parseInt(id);
			retVal = repo.findByIdEmployee(idP);					
		}else {
			retVal = repo.findAll();			
		}
		return retVal;
	}

	@PostMapping("/")
	public ResponseEntity<List<Employee_Project>> add(@RequestBody List<Employee_Project> eXpList){
		ResponseEntity<List<Employee_Project>> retVal = null;
		List<Employee_Project> retValList;
		if(eXpList != null && !eXpList.isEmpty()){
			retValList = new ArrayList<Employee_Project>();
				for(Employee_Project eXp: eXpList) {
					retValList.add(repo.save(eXp));
				}
				retVal = new ResponseEntity<>(retValList,HttpStatus.OK);
			LOG.info("Projectos correctamemnte al user => obj: " + eXpList);
		}	
		return retVal;
	}

}
