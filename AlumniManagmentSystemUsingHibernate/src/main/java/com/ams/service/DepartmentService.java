package com.ams.service;

import java.util.List;

import com.ams.dto.AlumniDTO;
import com.ams.entity.Department;
import com.ams.exception.GlobalException;

public interface DepartmentService {
	
	//create
	void addDepartment(Department department);
	//read
	List<AlumniDTO> fetchAlumnis() throws GlobalException;
	//read
	List<AlumniDTO> fetchAlumniByDeptId(int did) throws GlobalException;
}
