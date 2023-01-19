package com.springboot.ams.service;

import java.util.List;

import com.springboot.ams.entity.Admin;
import com.springboot.ams.entity.Alumni;
import com.springboot.ams.entity.Department;

//business logic class for admin
public interface AdminService { // service class

	// creating admin
	Admin createAdmin(Admin admin);

	// fetching all alumnis
	List<Alumni> fetchAlumnis();

	// fetching all departments
	List<Department> fetchDepartments();

	// fetching alunmni by its id
	Alumni fetchAlumniByRoll(long alroll);
	
	// verify admin
	Admin verifyAdmin(String username, String password);

	// updating admin
	Admin updateAdmin(String username, Admin admin);
	
	// updating existing alumni details
	Alumni updateAlumni(long alroll, Alumni alumni);

	// delete by username
	void deleteAdmin(String username);

	// delete by roll no.
	void deleteAlumni(Long roll);

}
