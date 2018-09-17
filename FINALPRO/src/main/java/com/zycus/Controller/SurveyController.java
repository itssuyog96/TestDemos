
package com.zycus.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zycus.entity.Question;
import com.zycus.entity.Survey;
import com.zycus.entity.User;
import com.zycus.entity.response;
import com.zycus.service.*;

@RestController
@RequestMapping("/Survey/*")
public class SurveyController {
	
	@Autowired
	private SurveyServiceImpl SurveyServiceImpl;
	
	
	
	
	@RequestMapping(value = "/newUser", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain") 



	public String add(@RequestBody  User user)
	{

		SurveyServiceImpl.registerUser(user);
		return "User record created successfully";
		
		
	}
	
	
	
	/*@RequestMapping(value = "/newSurvey", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain") 



	public String add(@RequestBody  Survey survey)
	{

		SurveyServiceImpl.registerSurvey(survey);
		return "Survey record created successfully";
	}

	
	@RequestMapping(value = "/newQuestion", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain") 



	public String add(@RequestBody  Question question)
	{

		SurveyServiceImpl.registerQuestion(question);
		return "Question record created successfully";
	}

	
	@RequestMapping(value = "/newResponse", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain") 



	public String add(@RequestBody  response response)
	{

		SurveyServiceImpl.registerresponse(response);
		return "response record created successfully";
	}
*/
	
/*	
	
@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = "application/json")
	
	public Iterable<Customer> getAllCustomers() 
	{
		
		
		return shoppingService.getRegisterdCustomers();
	}

@RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json")

public Iterable<Product> getAllProducts() 
{
	
	
	return shoppingService.getRegisterdProducts();
}

*/

}
