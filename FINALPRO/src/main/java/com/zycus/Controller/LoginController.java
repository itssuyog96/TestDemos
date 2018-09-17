package com.zycus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zycus.entity.User;
import com.zycus.service.SurveyServiceImpl;

public class LoginController {

	@Autowired
	private SurveyServiceImpl SurveyServiceImpl;




	public String findByid(@RequestBody  User user)
	{

		SurveyServiceImpl.registerUser(user);
		return "User record created successfully";
		
		
	}
	
}
