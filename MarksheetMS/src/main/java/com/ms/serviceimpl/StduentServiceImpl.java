package com.ms.serviceimpl;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ms.dao.StudentsDao;
import com.ms.daoimpl.StudentsDaoimpl;
import com.ms.dto.StudentDto;
import com.ms.entity.Students;
import com.ms.exception.GlobalException;
import com.ms.service.StudentService;
import com.ms.util.Converter;

public class StduentServiceImpl implements StudentService {
	// declaring globally so each method can have access of these objects
	Converter converter = new Converter();
	StudentsDao studentsDao = new StudentsDaoimpl();
	private static final Logger logger = LogManager.getLogger(AdminServiceImpl.class);

	@Override
	public void studentRegistration(Students student) {
		studentsDao.studentRegistration(student);
		logger.info("Student registered successfully " + " and creation time is " + new java.util.Date());

	}

	@Override
	public StudentDto fetchStudent(int sroll) throws GlobalException {
		Students students = studentsDao.fetchStudent(sroll);
		logger.info("Student data fetched " + " and time is " + new java.util.Date());

		// converting to DTO
		StudentDto adminDTO = converter.EntitytoDTO_Students(students);

		// null validation and returning
		return Optional.of(adminDTO).orElseThrow(() -> new GlobalException("Department does not exists"));
	}

	@Override
	public void addStudentIssues(int sroll, String issue) {
		studentsDao.addStudentIssues(sroll, issue);
		logger.info("Student issues added successfully " + " and creation time is " + new java.util.Date());

	}

}
