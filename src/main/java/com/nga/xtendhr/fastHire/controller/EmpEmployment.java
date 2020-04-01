package com.nga.xtendhr.fastHire.controller;

import java.io.IOException;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nga.xtendhr.fastHire.POJO.Detail;
import com.nga.xtendhr.fastHire.POJO.Field;
import com.nga.xtendhr.fastHire.connections.HttpConnectionPOST;
import com.nga.xtendhr.fastHire.utilities.CommonFunctions;
import com.nga.xtendhr.fastHire.utilities.ConstantManager;
import com.nga.xtendhr.fastHire.utilities.URLManager;

@RestController
@RequestMapping(value = ConstantManager.genAPI)
public class EmpEmployment {

	private static final String configName = "sfconfigname";
	private static final Logger logger = LoggerFactory.getLogger(EmpEmployment.class);

	private String paramName = null;
	private String paramValue = null;
	private final String sDate = "startdate";

	private String startDate = null;
	private String firstDateWorked = null;
	private static String datePattern = "dd/MM/yyyy";

	@PostMapping(value = ConstantManager.empEmployment, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String empEmployment(@RequestBody String request, HttpServletRequest requestForSession)
			throws ParseException {
		try {
			// Extract the params and their values

			parseRequest(request);

			URLManager genURL = new URLManager(getClass().getSimpleName(), configName);
			String urlToCall = genURL.formURLToCall();
			logger.info(
					ConstantManager.lineSeparator + ConstantManager.urlLog + urlToCall + ConstantManager.lineSeparator);

			// Get details from server
			URI uri = CommonFunctions.convertToURI(urlToCall);
			HttpSession session = requestForSession.getSession(false);
			String userID = (String) session.getAttribute("userID");
			logger.error("Got UserId from session in EmpEmploiment: " + userID);
			String data = replaceKeys(userID);
			HttpConnectionPOST httpConnectionPOST = new HttpConnectionPOST(uri, URLManager.dConfiguration, data,
					EmpEmployment.class);

			String result = httpConnectionPOST.connectToServer();
			return result;
		} catch (

		Exception e) {
			return (e.getMessage());
		}
	}

	// Parse the request
	private void parseRequest(String request) throws ParseException {
		ObjectMapper mapper = new ObjectMapper();
		Detail[] detail = null;
		try {
			detail = mapper.readValue(request, Detail[].class);

			for (int i = 0; i < detail.length; i++) {
				List<Field> group = detail[i].getFields();
				for (Field field : group) {
//					logger.error("Heiii" + field.getField().getTechnicalName().toString());
					String techName = field.getField().getTechnicalName().toString();

					if (techName.toLowerCase().equals(sDate.toLowerCase())) {
						paramName = techName;
						paramValue = field.getValue().toString();

						startDate = field.getValue().toString();
						logger.debug("startdate: " + startDate);
//						logger.error(paramName.toString());
//						logger.error(paramValue.toString());

					} else if (techName.toLowerCase().equals("firstdateworked")) {
						firstDateWorked = field.getValue().toString();
						logger.debug("firstDateWorked: " + firstDateWorked);
					}
				}
			}
		} catch (IOException e) {
			logger.error(e.toString());
		}

	}

	@SuppressWarnings("unchecked")
	private String replaceKeys(String userID) {
		// String userID = ConstantManager.userID;
		JSONObject obj = new JSONObject();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date today = new Date();
		Calendar now = Calendar.getInstance();
		now.setTime(today);
		now.set(Calendar.HOUR, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.HOUR_OF_DAY, 0);

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("uri", "EmpEmployment(personIdExternal='" + userID + "',userId='" + userID + "')");
		obj.put("__metadata", jsonObj);
		logger.debug("startDate2: " + startDate);
		obj.put(paramName, dateFormatted(startDate));
		obj.put("personIdExternal", userID);
		obj.put("userId", userID);
		logger.debug("firstDateWorked2: " + firstDateWorked);
		obj.put("firstDateWorked", dateFormatted(firstDateWorked));
//		logger.error(obj.toJSONString());
		return obj.toJSONString();
	}

	private String dateFormatted(String startDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
		Date date = null;
		try {
			date = simpleDateFormat.parse(startDate);
		} catch (ParseException e) {
			logger.error(e.toString());
		}
		long epoch = date.getTime();
		return "/Date(" + epoch + ")/";
	}

}
