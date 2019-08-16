package com.example.component;

import java.io.File;
import java.time.LocalDateTime;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class SchelduledTaskImpl implements IScheduledTask {
	private static Logger LOG = LoggerFactory.getLogger(SchelduledTaskImpl.class);
	
	@Autowired
	HandlerXmlImpl HandlerXmlImpl;
	
	@Scheduled(fixedRate = 4000 * 60 * 5)
	@Override
	public void loadEmployeePayroll() {	
		/*try {
			JAXBContext jc = JAXBContext.newInstance(Employees.class);
			
			Unmarshaller unmarshaller = jc.createUnmarshaller();
	        File xml = new File("C:\\personal\\newPersonal.xml");
	        Employees employees = (Employees) unmarshaller.unmarshal(xml);
			
	        LOG.info("Planilla", employees);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		LOG.info("Cargando planilla",HandlerXmlImpl.readPayroll("C:\\personal\\newPersonal.xml") );
		LOG.info("Hora: ", LocalDateTime.now() );
		
	}

}
