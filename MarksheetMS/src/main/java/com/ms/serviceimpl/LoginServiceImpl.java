package com.ms.serviceimpl;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ms.dao.LoginDao;
import com.ms.daoimpl.LoginDaoimpl;
import com.ms.dto.AdminDto;
import com.ms.dto.StudentDto;
import com.ms.entity.Admin;
import com.ms.entity.Students;
import com.ms.exception.GlobalException;
import com.ms.service.LoginService;
import com.ms.util.Converter;

public class LoginServiceImpl implements LoginService {
	// declaring globally so each method can have access of these objects
	Converter converter = new Converter();
	LoginDao loginDao = new LoginDaoimpl();
	private static final Logger logger = LogManager.getLogger(AdminServiceImpl.class);

	@Override
	public AdminDto adminLogin(Integer loginId, String password) throws GlobalException {
		Admin admin = loginDao.adminLogin(loginId, password);
		logger.info("Admin logged in Successfully " + admin + " and time is " + new java.util.Date());

		// converting to DTO
		AdminDto adminDto = converter.EntitytoDTO_Admin(admin);
		// null validation and returning
		return Optional.of(adminDto).orElseThrow(() -> new GlobalException("Admin does not exists"));
	}

	@Override
	public StudentDto studentLogin(Integer sroll, String password) throws GlobalException {
		Students students = loginDao.studentLogin(sroll, password);
		logger.info("Student logged in Successfully " + students + " and time is " + new java.util.Date());

		// converting to DTO
		StudentDto studentDto = converter.EntitytoDTO_Students(students);
		// null validation and returning
		return Optional.of(studentDto).orElseThrow(() -> new GlobalException("Student does not exists"));
	}

}
