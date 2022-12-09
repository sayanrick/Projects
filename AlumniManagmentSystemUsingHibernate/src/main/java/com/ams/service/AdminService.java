package com.ams.service;

import java.util.List;

import com.ams.dto.AdminDTO;
import com.ams.dto.AlumniDTO;
import com.ams.dto.DepartmentDTO;
import com.ams.entity.Admin;
import com.ams.exception.GlobalException;

public interface AdminService {

	void createAdmin(Admin admin);

	List<AlumniDTO> fetchAlumni(String adusername, String adpassword) throws GlobalException;
	
	List<DepartmentDTO> fetchDepartment(String adusername, String adpassword) throws GlobalException;
	
	AdminDTO changePassword(String adusername, String adpassword, Admin admin) throws GlobalException;
	
	void deleteAdmin(String adusername, String adpassword);
	
	void deleteAlumni(String adusername, String adpassword, int alroll);
	
	
}
