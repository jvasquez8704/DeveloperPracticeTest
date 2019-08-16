package com.example.component;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HandlerXmlImpl implements IHandleXml{
	private static Logger LOG = LoggerFactory.getLogger(SchelduledTaskImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> readPayroll(String absolutePath) {
		List<Employee> retVal = new ArrayList<Employee>();
		
		try {
			JAXBContext jc = JAXBContext.newInstance(Employees.class);
			
			Unmarshaller unmarshaller = jc.createUnmarshaller();
	        File xml = new File(absolutePath);
	        retVal = ((Employees) unmarshaller.unmarshal(xml)).getEmployee();
			
	        //List<Employee> emps =  (List<Employee>) employees.getEmployees();
	        //LOG.error("Planilla para insertar => " + employees.getEmployee());
	        
	      
	        
		} catch (JAXBException e) {
			LOG.error("Planilla" + e);
			e.printStackTrace();
		}
		
		return retVal;
	}
	

}
