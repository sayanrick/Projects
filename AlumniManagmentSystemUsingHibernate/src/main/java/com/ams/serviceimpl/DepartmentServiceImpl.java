package com.ams.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ams.dao.DepartmentDAO;
import com.ams.daoimpl.DepartmentDaoImpl;
import com.ams.dto.AlumniDTO;
import com.ams.entity.Alumni;
import com.ams.entity.Department;
import com.ams.exception.GlobalException;
import com.ams.service.DepartmentService;
import com.ams.util.Converter;

public class DepartmentServiceImpl implements DepartmentService {
	
	//declaring globally so each method can have access of these objects
	Converter converter = new Converter();
	DepartmentDAO deptDao = new DepartmentDaoImpl();
	private static Logger logger = LogManager.getLogger(DepartmentServiceImpl.class);

	@Override
	public void addDepartment(Department department) {
		deptDao.addDepartment(department);
		logger.info("new department created " + department + " and creation time is " + new java.util.Date());
	}

	@Override
	public List<AlumniDTO> fetchAlumnis() throws GlobalException{
		List<Alumni> alumni = deptDao.fetchAlumnis();
		logger.info("Alumni data fetched " + alumni + " and time is " + new java.util.Date());
		
		//converting list of department into list of departmentDTO
		List<AlumniDTO> alumniDTO = alumni.stream().map(x->converter.EntitytoDTO_Alumni(x)).collect(Collectors.toList());
				
		// null validation
		return Optional.of(alumniDTO).orElseThrow(() -> new GlobalException("Alumni does not exists"));
	}

	@Override
	public List<AlumniDTO> fetchAlumniByDeptId(int did) throws GlobalException{
		List<Alumni> alumni = deptDao.fetchAlumniByDeptId(did);
		logger.info("Alumni data fetched " + alumni + " and time is " + new java.util.Date());
		
		//converting list of department into list of departmentDTO
		List<AlumniDTO> alumniDTO = alumni.stream().map(x->converter.EntitytoDTO_Alumni(x)).collect(Collectors.toList());
				
		// null validation
		return Optional.of(alumniDTO).orElseThrow(() -> new GlobalException("Alumni does not exists"));
	}

//	@Override
//	public DepartmentDTO fetchDepartment(int did) throws GlobalException {
//		Department dept = deptDao.fetchDepartment(did);
//		logger.info("department data fetched " + dept + " and time is " + new java.util.Date());
//		
//		//converting list of Department into list of DepartmentDTO
//		DepartmentDTO deptDTO = converter.EntitytoDTO_Dept(dept);
//				
//		// null validation and returning
//		return Optional.of(deptDTO).orElseThrow(() -> new GlobalException("Alumni does not exists"));
//	}

}