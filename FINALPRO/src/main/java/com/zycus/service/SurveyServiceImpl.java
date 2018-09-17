package com.zycus.service;



import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.zycus.entity.*;
import com.zycus.repository.*;

@Service
@Transactional
public class SurveyServiceImpl{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private surveyRepository surveyrepository;
	
	@Autowired
	private questionRepository questionrepository;
	
	@Autowired
	private responseRepository responserepository;
	
	
	/* (non-Javadoc)
	 * @see com.zycus.service.ShoppingService#registerCustomer(com.zycus.entity.Customer)
	 */
	@CacheEvict(value="user.cache",allEntries=true)
	public void registerUser(User user)
	{
		userRepository.save(user);
	}
	
	
	public void placeOrder(User user)//DTO-DATA TRANSFER OBJECT= OrderDTO
	{
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.zycus.service.ShoppingService#registerProduct(com.zycus.entity.Product)
	 
	@CacheEvict(value="survey.cache",allEntries=true)
	public void registerSurvey(Survey survey)
	{
		surveyrepository.save(survey);
	}
	
	 (non-Javadoc)
	 * @see com.zycus.service.ShoppingService#registerOrder(com.zycus.entity.Order)
	 
	@CacheEvict
	public void registerQuestion(Question question)
	{
		questionrepository.save(question);
	}
	
	
	 (non-Javadoc)
	 * @see com.zycus.service.ShoppingService#registerOrder(com.zycus.entity.Order)
	 
	@CacheEvict
	public void registerresponse(response response)
	{
		responserepository.save(response);
	}
	*/
	
	
	
	
	
/*
	@Cacheable(value="customer.cache")
	public Iterable<Customer> getRegisterdCustomers()
	{
		return customerRepository.findAll();
	}
	@Cacheable(value="product.cache")
	public Iterable<Product> getRegisterdProducts()
	{
		return productRepository.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.zycus.service.ShoppingService#placeOrder(com.zycus.DTO.OrderDTO)
	 */
	/*
	public void placeOrder(OrderDTO orderDTO)//DTO-DATA TRANSFER OBJECT= OrderDTO
	{
		
		int customerId=orderDTO.getCustomerId();
		Map<Integer,Integer> cart=orderDTO.getCart();
		
		Customer customer=(customerRepository.findById(orderDTO.getCustomerId())).get();
		
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
		
		Order order=new Order();
		order.setId(1);
		order.setDate(dtf);
		order.setCustomer(customer);
		
		Set<LineItem> lineItems=new HashSet<LineItem>();
		
		for(Map.Entry<Integer, Integer> entry:cart.entrySet())
		{
			int productId=entry.getKey();
			int quantity=entry.getValue();
		
		
		
		Product product=productRepository.findById(productId).get();
		product.setQuantity(product.getQuantity()-quantity);
		productRepository.save(product);
		
		LineItem lineitem=new LineItem();
		lineitem.setOrder(order);
		lineitem.setProduct(product);
		lineitem.setQuantity(quantity);
		lineItems.add(lineitem);
		
		
		
		}
		
		order.setLineItems(lineItems);
		orderRepository.save(order);
		
		
		
	}
	*/
}
