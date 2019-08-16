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

import com.example.model.Telephone;
import com.example.repository.ITelephono;


@RestController
@RequestMapping("/telephone")
public class TelephoneController {
	private static Logger LOG = LoggerFactory.getLogger(TelephoneController.class);
	
	@Autowired
	private ITelephono repo;
	
	
	@GetMapping({"/", "/{id}"})
	public List<Telephone> getTelephones(@PathVariable(required = false) String id){
		List<Telephone> retVal = new ArrayList<Telephone>();
		if(id != null) {
			int idP = Integer.parseInt(id);
			retVal = repo.findByIdEmployee(idP);						
		}else {
			retVal = repo.findAll();
		}		
		return retVal;
	}
	

	@PostMapping("/")
	public ResponseEntity<List<Telephone>> add(@RequestBody List<Telephone> eXpList){
		ResponseEntity<List<Telephone>> retVal = null;
		List<Telephone> retValList;
		if(eXpList != null && !eXpList.isEmpty()){
			retValList = new ArrayList<Telephone>();
				for(Telephone eXp: eXpList) {
					retValList.add(repo.save(eXp));
				}
				retVal = new ResponseEntity<>(retValList,HttpStatus.OK);
			    LOG.info("telefonos correctamemnte al user => obj: " + eXpList);
		}	
		return retVal;
	}

}
