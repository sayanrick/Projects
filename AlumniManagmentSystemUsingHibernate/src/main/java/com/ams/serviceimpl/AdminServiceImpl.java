package com.ams.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ams.dao.AdminDAO;
import com.ams.daoimpl.AdminDaoImpl;
import com.ams.dto.AdminDTO;
import com.ams.dto.AlumniDTO;
import com.ams.dto.DepartmentDTO;
import com.ams.entity.Admin;
import com.ams.entity.Alumni;
import com.ams.entity.Department;
import com.ams.exception.GlobalException;
import com.ams.service.AdminService;
import com.ams.util.Converter;

public class AdminServiceImpl implements AdminService {

	//declaring globally so each method can have access of these objects
	Converter converter = new Converter();
	AdminDAO adminDao = new AdminDaoImpl();						// instantiating Polymorphic Dao
	private static final Logger logger = LogManager.getLogger(AdminServiceImpl.class);
	
	@Override
	public void createAdmin(Admin admin) {
		adminDao.createAdmin(admin);
		logger.info("new admin A/c created " + admin + " and creation time is " + new java.util.Date());
	}

	@Override
	public List<AlumniDTO> fetchAlumni(String adusername, String adpassword) throws GlobalException {
		List<Alumni> alumni = adminDao.fetchAlumni(adusername, adpassword);
		logger.info("alumni data fetched " + alumni + " and time is " + new java.util.Date());
		
		//converting list of department into list of departmentDTO
		List<AlumniDTO> alumniDTO = alumni.stream().map(x->converter.EntitytoDTO_Alumni(x)).collect(Collectors.toList());
				
		// null validation
		return Optional.of(alumniDTO).orElseThrow(() -> new GlobalException("Alumni does not exists"));
	}

	@Override
	public List<DepartmentDTO> fetchDepartment(String adusername, String adpassword) throws GlobalException {
		List<Department> dept = adminDao.fetchDepartment(adusername, adpassword);
		logger.info("department data fetched " + dept + " and time is " + new java.util.Date());
		
		//converting list of department into list of departmentDTO
		List<DepartmentDTO> deptDTO = dept.stream().map(x->converter.EntitytoDTO_Dept(x)).collect(Collectors.toList());
		
		// null validation and returning
		return Optional.of(deptDTO).orElseThrow(() -> new GlobalException("Department does not exists"));
	}

	@Override
	public AdminDTO changePassword(String adusername, String adpassword, Admin admin) throws GlobalException{
		Admin updateAdmin =adminDao.changePassword(adusername, adpassword, admin);
		logger.info("admin password updated " + updateAdmin + " and time is " + new java.util.Date());
		
		//convetring to DTO
		AdminDTO adminDTO = converter.EntitytoDTO_Admin(updateAdmin);
		// null validation and returning
		return Optional.of(adminDTO).orElseThrow(() -> new GlobalException("Admin does not exists"));
	}

	@Override
	public void deleteAdmin(String adusername, String adpassword) {
		adminDao.deleteAdmin(adusername, adpassword);
		logger.info(adusername +"admin account deleted and time is " + new java.util.Date());
	}

	@Override
	public void deleteAlumni(String adusername, String adpassword, int alroll) {
		adminDao.deleteAlumni(adusername, adpassword, alroll);
		logger.info(alroll +"alumni account deleted and time is " + new java.util.Date());
	}

//	@Override
//	public void deleteDepartment(String adusername, String adpassword, int did) {
//		adminDao.deleteDepartment(adusername, adpassword, did);
//		logger.info(did +"Department deleted and time is " + new java.util.Date());
//	}

}