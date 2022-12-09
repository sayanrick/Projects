package com.ams.dao;

import java.util.List;

import com.ams.entity.Admin;
import com.ams.entity.Alumni;
import com.ams.entity.Department;

public interface AdminDAO {
	
	void createAdmin(Admin admin);
	
	List<Alumni> fetchAlumni(String adusername, String adpassword);
	
	List<Department> fetchDepartment(String adusername, String adpassword);
	
	Admin changePassword(String adusername, String adpassword, Admin admin);
	
	void deleteAdmin(String adusername, String adpassword);
	
	void deleteAlumni(String adusername, String adpassword, int alroll);
	
}
