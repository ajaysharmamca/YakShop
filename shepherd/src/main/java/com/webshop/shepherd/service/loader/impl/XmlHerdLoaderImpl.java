package com.webshop.shepherd.service.loader.impl;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.webshop.shepherd.common.AppConstants;
import com.webshop.shepherd.dvo.Herd;
import com.webshop.shepherd.service.loader.HerdLoader;

@Service
@Primary
public class XmlHerdLoaderImpl implements HerdLoader {
	
	private Herd herd = null;
	
	@PostConstruct
	private void initHerd() {
		JAXBContext context;
		
		try {
			context = JAXBContext.newInstance(Herd.class);
			// get variables from our XML file, created before
			Unmarshaller um = context.createUnmarshaller();
			herd = ((Herd) um.unmarshal(Herd.class.getClassLoader()
					.getResourceAsStream(AppConstants.INPUT_XML)));
	
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Herd getHerd() {
		return herd;
	}
	
}
