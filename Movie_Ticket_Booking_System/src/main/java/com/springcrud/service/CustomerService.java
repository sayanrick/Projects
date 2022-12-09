package com.springcrud.service;

import java.util.List;

import com.springcrud.entity.Customer;

// abstract method for performing CRUD on user entity
public interface CustomerService {

	// saving details of user entity
	Customer saveUser(Customer user);
	
	// getting all details of user
	List<Customer> getAllUsers();
	
	// getting details of user based on uid
	Customer getUserById(int uid);
	
	// getting details of user based of uid & update mentioned details
	Customer updateUserById(Customer user, int uid);
	
	// getting details of user based of uid & delete mentioned details
	void deleteUserById(int uid);
	
	List<Customer> getFname(String ufname);
	
	List<Customer> getLname(String ulname);
	
	Customer getPhone(long uphone);
	
}
