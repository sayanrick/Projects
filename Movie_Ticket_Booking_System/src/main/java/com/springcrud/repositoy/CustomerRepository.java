 package com.springcrud.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springcrud.entity.Customer;

// user repository extending JpaRepository 
public interface CustomerRepository extends JpaRepository<Customer, Integer > {

	@Query("select u from Customer u where u.ufname = ?1")
	List<Customer> getFname(String ufname);
	
	@Query("select u from Customer u where u.ulname = ?1")
	List<Customer> getLname(String ulname);
	
	@Query("select u from Customer u where u.uphone = ?1")
	Customer getPhone(long uphone);
	
}
