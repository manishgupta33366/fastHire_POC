package com.nga.xtendhr.fastHire.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nga.xtendhr.fastHire.POJO.Detail;
import com.nga.xtendhr.fastHire.POJO.Field;
import com.nga.xtendhr.fastHire.utilities.ConstantManager;

@RestController
@RequestMapping(value = ConstantManager.genAPI)
public class Sample {

	private static final Logger logger = LoggerFactory.getLogger(Sample.class);
	private final String email = "emailaddress";
	
	private String paramName = null;
	private String paramValue = null;

	@PostMapping(value = "/sample")
	public String getUserInfo(@RequestBody String request) {
		logger.error("Inside");
				
		ObjectMapper mapper = new ObjectMapper();
		request = request.substring(1, request.length() - 1);
		
		logger.error("Inside 1");
		
		Detail detail = null;
		try {
			detail = mapper.readValue(request, Detail.class);
		} catch (IOException e) {
			logger.error(e.toString());
		}
		
		logger.error("Inside 2");
		List<Field> group = detail.getFields();
		logger.error("Inside 3");
		for (Field field : group) {
			String name = field.getField().getTechnicalName().toString();
			if (name.toLowerCase().contains(email.toLowerCase())) {
				paramName = name;
				paramValue = field.getValue().toString();
				logger.error(paramName.toString());
				logger.error(paramValue.toString());
				break;
			}
		}		
		logger.error("Inside 4");
		return paramName + " : " + paramValue;
	}

}
