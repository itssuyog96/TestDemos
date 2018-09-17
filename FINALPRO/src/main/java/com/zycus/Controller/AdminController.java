package com.zycus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zycus.entity.User;
import com.zycus.service.SurveyServiceImpl;

public class AdminController {
	
	
	@Autowired
	private SurveyServiceImpl SurveyServiceImpl;
	
	@RequestMapping(value = "/newAdmin", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain") 



	public String add(@RequestBody  User user)
	{

		SurveyServiceImpl.registerUser(user);
		return "User record created successfully";
		
		
	}

}
