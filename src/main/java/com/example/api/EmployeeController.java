package com.example.api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.Employee;
import com.example.repository.IEmployee;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private static Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private IEmployee repo;
	
	
	@GetMapping({"/", "/{id}"})
	public List<Employee> getEmployees(@PathVariable(required = false) String id){
		List<Employee> retVal = new ArrayList<Employee>();
		if(id != null) {
			int idP = Integer.parseInt(id);
			Optional<Employee> e = repo.findById(idP);
			if(e.isPresent()) {
				retVal.add(e.get());
			}			
		}else {
			retVal = repo.findAll();
		}		
		return retVal;
	}
	

	@PostMapping
	public ResponseEntity<Employee> insertar(@RequestBody Employee emp){
		ResponseEntity<Employee> retVal = null;
		
		if(emp.getEnrollday()!=null && !emp.getFirstname().equals("")){
			Employee e = repo.save(emp);
			if(e != null){
				retVal = new ResponseEntity<>(e,HttpStatus.CREATED);
				LOG.info("Se ingreso el empleado correctamemnte => obj: " + e);
			}
		}
		
		return retVal;
	}
	
	@PutMapping
	public void modificar(@RequestBody Employee emp){
		if(repo.save(emp) != null){
			LOG.info("Se ingreso el empleado correctamemnte => obj: " + emp);
		}else {
			LOG.error("Hubo un error al actualizar empleado => obj: " + emp);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		 repo.deleteById(id);
		LOG.info("Se elimino el empleado con ID: " + id);
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		File convertFile = new File("C:\\personal\\"+file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
	}
	

}
