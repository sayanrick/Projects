package com.springcrud.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcrud.entity.Customer;
import com.springcrud.exception.UserNotFoundException;
import com.springcrud.repositoy.CustomerRepository;
import com.springcrud.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository urepo;
	 
	//saving user details using save() of JPARepository
	@Override
	public Customer saveUser(Customer user) {

//		String message = null;
//		urepo.save(user);
//		if(user != null) {
//			message = "user saved";
//		}
//		return message;
		return urepo.save(user);
	}
	
	// fetching all user details using findAll() of JPARepository 
	@Override
	public List<Customer> getAllUsers() {
		
		return urepo.findAll();
	}
	
	// fetching user details based on id
	@Override
	public Customer getUserById(int uid) {
		
		return urepo.findById(uid).orElseThrow(() -> new UserNotFoundException("User Not Found!"));
	}
	
	// fetching user details based on id using findById() of JpaRepository, if not found throw exception
	// and update any contact details of user
	@Override
	public Customer updateUserById(Customer user, int uid) {
		Customer newuser = urepo.findById(uid).orElseThrow(() -> new UserNotFoundException("User Not Found!"));
		
		// updated value
		newuser.setUfname(user.getUfname());
		newuser.setUlname(user.getUlname());
		newuser.setUphone(user.getUphone());
		newuser.setUemail(user.getUemail());
		urepo.save(newuser);
		return newuser;
	}
	
	// fetching user details based on id using findById() of JpaRepository, if not found throw exception
	// and delete enter user id
	@Override
	public void deleteUserById(int uid) {
		urepo.findById(uid).orElseThrow(() -> new UserNotFoundException("No user exists in table"));
		urepo.deleteById(uid);
		
//		String message = null;
//		
//		Optional<User> user = urepo.findById(uid);
//		
//		if(user.isPresent()) {
//			urepo.deleteById(uid);
//			message = new String ("deleted successfully");
//		}
//		else {
//			throw new UserNotFoundException("No user exists in table");
//		}
//		return message;
	}

	@Override
	public List<Customer> getFname(String ufname) {
		return urepo.getFname(ufname);
	}

	@Override
	public List<Customer> getLname(String ulname) {
		return urepo.getLname(ulname);
	}

	@Override
	public Customer getPhone(long uphone) {
		return urepo.getPhone(uphone);
	}
	
	
}
