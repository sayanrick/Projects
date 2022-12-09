package com.ams.dao;

import java.util.List;

import com.ams.entity.Alumni;
import com.ams.entity.Department;

//DAO of department
public interface DepartmentDAO {
	
	//create
	void addDepartment(Department department);
	//read
	List<Alumni> fetchAlumnis();
	//read
	List<Alumni> fetchAlumniByDeptId(int did);
}
