package com.springboot.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ams.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
	//custom crud method
	Admin findByAdusernameAndAdpassword(String username, String password);
}
