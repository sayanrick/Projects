package com.springcrud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springcrud.entity.Customer;
import com.springcrud.service.CustomerService;

@RestController()
public class UserController {
	@Autowired
	private CustomerService us;
	
	// save user in DB table using rest API PostMapping
	@PostMapping("/saveUser")
	public ResponseEntity<Customer> saveUser(@Valid @RequestBody Customer user) {
		return new ResponseEntity<Customer>(us.saveUser(user), HttpStatus.CREATED);
		
	}
	
	// fetch user details from DB table using rest API GetMapping
	@GetMapping("/getAllUser")
	public List<Customer> getAll() {
		return us.getAllUsers();
		
	} 
	
	
	// fetch user details from DB table using rest API GetMapping based on id
	@GetMapping("/getU/{uid}")
	public ResponseEntity<Customer> getU(@PathVariable("uid") int uid) {
		return new ResponseEntity<Customer>(us.getUserById(uid), HttpStatus.OK);
		
	}
	 
	// update user details in DB table using rest API PutMapping based on id
	@PutMapping("/updateU/{uid}")
	public ResponseEntity<Customer> updateUser(@PathVariable("uid") int uid, @RequestBody Customer user) {
		return new ResponseEntity<Customer>(us.updateUserById(user, uid), HttpStatus.OK);
		
	}	
	
	// delete user details in DB table using rest API DeleteMapping based on id
	@DeleteMapping("/deleteU/{uid}")
	public ResponseEntity<String> deleteUser(@PathVariable("uid") int uid) {
		us.deleteUserById(uid);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		
	}
	
	@GetMapping("/getFn/{ufname}")
	public List<Customer> getFname(@PathVariable String ufname) {
		return us.getFname(ufname);
		
	}
	@GetMapping("/getLn/{ulname}")
	public List<Customer> getLname(@PathVariable String ulname) {
		return us.getLname(ulname);
		
	}
	@GetMapping("/getPh/{uphone}")
	public Customer getPhone(@PathVariable long uphone) {
		return us.getPhone(uphone);
		
	}
	
}

