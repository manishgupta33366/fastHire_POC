package com.nga.xtendhr.utility;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * ErrorHandlerController Controller
 * Controller to handle any 404 not found error or any other endpoint related error
 * 
 * @author	:	Manish Gupta  
 * @email	:	manish.g@ngahr.com
 * @version	:	0.0.1
 */

@RestController
public class ErrorHandlerController implements ErrorController {

	private static final String errorMessage = "Please check the url!";

	@RequestMapping(value = "/error")
	public String error() {
		return errorMessage;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
