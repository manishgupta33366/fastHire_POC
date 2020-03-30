package com.nga.xtendhr.fastHire.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nga.xtendhr.fastHire.connections.HttpConnectionGET;
import com.nga.xtendhr.fastHire.utilities.CommonFunctions;
import com.nga.xtendhr.fastHire.utilities.ConstantManager;
import com.nga.xtendhr.fastHire.utilities.URLManager;

@RestController
@RequestMapping(value = ConstantManager.genAPI)
public class VacantPositions {

	private static final String configName = "sfconfigname";
	private static final Logger logger = LoggerFactory.getLogger(VacantPositions.class);

	@GetMapping(value = ConstantManager.vacantPositions, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getVacantPositions(@RequestParam(value="vacant",required = true) String vacant,
			@RequestParam(value="company",required=true) String company, @RequestParam(value="department",required=true) String department,
			@RequestParam(value="incumbent",required=false) String incumbent) {
		
		Map<String,String> queryParams = new HashMap<>();
		queryParams.put("company", company);
		queryParams.put("incumbent", incumbent);
		queryParams.put("vacant", vacant);
		String dep =  department.replace(" ", "%20");
		queryParams.put("department", dep.replace(",", "%2C"));
		URLManager genURL = new URLManager(queryParams,getClass().getSimpleName(), configName);
		String urlToCall = genURL.formURLToCall();
		logger.info(ConstantManager.lineSeparator + ConstantManager.urlLog + urlToCall + ConstantManager.lineSeparator);

		// Get details from server
		URI uri = CommonFunctions.convertToURI(urlToCall);
		HttpConnectionGET httpConnectionGET = new HttpConnectionGET(uri, URLManager.dConfiguration,
				VacantPositions.class);
		String result = httpConnectionGET.connectToServer();

		return result;
	}
}
